package com.example.hotel;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.util.concurrent.ExecutionException;

public class Register extends AppCompatActivity {

    private EditText edtFirstName,edtLastName,edtEmail,edtPhone,edtPassword,edtCnp;
    private Button btnRegister;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    CheckBox checkBox;
    int checkGDPR = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        edtFirstName = findViewById(R.id.edtFirstName);
        edtLastName = findViewById(R.id.edtLastName);
        edtEmail = findViewById(R.id.edtEmail);
        edtPassword = findViewById(R.id.edtPassword);
        edtPhone = findViewById(R.id.edtPhoneNumber);
        btnRegister = findViewById(R.id.btnRegister);
        checkBox = findViewById(R.id.chkGDPR);
        edtCnp = findViewById(R.id.edtCnp);

            checkBox.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(Register.this);


                    builder.setMessage(getResources().getString(R.string.gdpr));


                    builder.setTitle("Alert GDPR");


                    builder.setCancelable(false);

                    builder.setPositiveButton("Yes", (DialogInterface.OnClickListener) (dialog, which) -> {
                        checkGDPR = 1;
                        dialog.cancel();
                        //finish();
                    });

                    builder.setNegativeButton("No", (DialogInterface.OnClickListener) (dialog, which) -> {
                        checkGDPR = 0;
                        checkBox.setChecked(false);
                        dialog.cancel();
                    });

                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();
                }
            });


        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String emailText =  edtEmail.getText().toString();
                if( edtEmail.getText().toString().length() == 0){
                    edtEmail.setError("Please insert Email!");
                } else if (!emailText.matches(emailPattern)){
                    edtEmail.setError("Wrong format email!");
                }else if(edtFirstName.getText().toString().length() == 0){
                    edtFirstName.setError("Please insert FirstName!");
                }else if(edtLastName.getText().toString().length() == 0){
                    edtLastName.setError("Please insert LastName!");
                }else if(edtPassword.getText().toString().length() == 0) {
                   edtPassword.setError("Please insert a password!");
                } else if(edtCnp.getText().toString().length() < 13){
                    edtCnp.setError("CNP must introduce 13 number!");
                } else if(edtCnp.getText().toString().length() > 13){
                    edtCnp.setError("CNP contains much number!");
                }else if(!checkBox.isChecked() && checkGDPR == 0){
                    Toast.makeText(getApplication(), "Please check GDPR!", Toast.LENGTH_SHORT).show();
                }
                else {
                    String firstname = edtFirstName.getText().toString();
                    String lastname = edtLastName.getText().toString();
                    String password = edtPassword.getText().toString();
                    String email = edtEmail.getText().toString();
                    String phone = edtPhone.getText().toString();
                    String cnp = edtCnp.getText().toString();

                    String url = "http://192.168.8.29/registerUser.php";
                    String type = "ckeckEmail";
                    BackgroundRegister backgroundWorker = new BackgroundRegister(Register.this);
                    try {
                       backgroundWorker.execute(url, type,email,firstname,lastname,password,phone,String.valueOf(checkGDPR),cnp).get();
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

    }
}