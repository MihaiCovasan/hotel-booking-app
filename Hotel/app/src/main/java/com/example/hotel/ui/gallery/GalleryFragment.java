package com.example.hotel.ui.gallery;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.hotel.BackgroundIdUser;
import com.example.hotel.BackgroundRegister;
import com.example.hotel.MainActivity;
import com.example.hotel.R;
import com.example.hotel.Register;
import com.example.hotel.databinding.FragmentGalleryBinding;
import com.example.hotel.databinding.FragmentHomeBinding;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.ExecutionException;

public class GalleryFragment extends Fragment {
    private FragmentHomeBinding binding;
    Spinner spnPerson;
    ArrayList<String> arrayList;
    boolean first = true;
    EditText edtStartDate,edtEndDate;
    TextView txtPrice;
    Button btnRegisterRoom;
    int numberofperson;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_gallery, container, false);

        spnPerson = root.findViewById(R.id.spnPerson);
        edtEndDate = root.findViewById(R.id.edtEndDate);
        edtStartDate = root.findViewById(R.id.edtStartDate);
        txtPrice = root.findViewById(R.id.txtPrice);
        btnRegisterRoom = root.findViewById(R.id.btnRegisterRoom);

        spnPerson.setPrompt("Select person");

        edtEndDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Calendar mcurrentDate= Calendar.getInstance();
                int year = mcurrentDate.get(Calendar.YEAR);
                int month = mcurrentDate.get(Calendar.MONTH);
                int day = mcurrentDate.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog mDatePicker=new DatePickerDialog(getContext(), new DatePickerDialog.OnDateSetListener() {
                    public void onDateSet(DatePicker datepicker, int selectedYear, int selectedMonth, int selectedDay) {
                        Log.e("Date Selected", "Month: " + selectedMonth + " Day: " + selectedDay + " Year: " + selectedYear);
                        edtEndDate.setText(selectedMonth + 1 + "/" + selectedDay + "/" + selectedYear);
                        long totalPrice = numberOfDays() * 100;
                        txtPrice.setText(String.valueOf(totalPrice));
                    }
                },year, month, day);
                mDatePicker.getDatePicker().setMinDate(System.currentTimeMillis() - 1000);
                mDatePicker.setTitle("Select date");
                mDatePicker.show();
            }
        });

        edtStartDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar mcurrentDate= Calendar.getInstance();
                int year = mcurrentDate.get(Calendar.YEAR);
                int month = mcurrentDate.get(Calendar.MONTH);
                int day = mcurrentDate.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog mDatePicker=new DatePickerDialog(getContext(), new DatePickerDialog.OnDateSetListener() {
                    public void onDateSet(DatePicker datepicker, int selectedYear, int selectedMonth, int selectedDay) {
                        Log.e("Date Selected", "Month: " + selectedMonth + " Day: " + selectedDay + " Year: " + selectedYear);
                        edtStartDate.setText(selectedMonth + 1 + "/" + selectedDay + "/" + selectedYear);
                        long totalPrice = numberOfDays() * 100;
                        txtPrice.setText(String.valueOf(totalPrice));
                    }
                },year, month, day);
                mDatePicker.getDatePicker().setMinDate(System.currentTimeMillis() - 1000);
                mDatePicker.setTitle("Select date");
                mDatePicker.show();
            }
        });

        arrayList = new ArrayList<>();
        arrayList.add("1");
        arrayList.add("2");
        arrayList.add("3");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_dropdown_item, arrayList);
        spnPerson.setAdapter(arrayAdapter);

        spnPerson.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                numberofperson = Integer.parseInt(spnPerson.getSelectedItem().toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        btnRegisterRoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String url = "http://192.168.8.29/registerRoom.php";
                String type = "registerRoom";
                BackgroundRegisterRoom backgroundRegisterRoom = new BackgroundRegisterRoom(getContext());
                try {
                    backgroundRegisterRoom.execute(url, type, String.valueOf(BackgroundIdUser.idUser),edtStartDate.getText().toString(),edtEndDate.getText().toString(),txtPrice.getText().toString(),String.valueOf(numberofperson),"1").get();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });


        return root;


    }

    public Long numberOfDays(){
        long dayDifference = 0;
        try {

            Date date1;
            Date date2;

            SimpleDateFormat dates = new SimpleDateFormat("MM/dd/yyyy");

            date1 = dates.parse(edtStartDate.getText().toString());
            date2 = dates.parse(edtEndDate.getText().toString());


            long difference = Math.abs(date1.getTime() - date2.getTime());
            long differenceDates = difference / (24 * 60 * 60 * 1000);

            dayDifference = differenceDates;

        }
        catch (Exception exception) {
            Log.e("DIDN'T WORK", "exception " + exception);
        }

        return dayDifference;
    }


    public class BackgroundRegisterRoom extends AsyncTask<String,Void,String> {

        Context context;
        BackgroundRegisterRoom(Context ctx){
            context = ctx;
        }
        @Override
        protected String doInBackground(String... params) {
            String login_url = params[0];
            String type = params[1];
            String iduser = params[2];
            String startdate = params[3];
            String enddate = params[4];
            String price = params[5];
            String numberofperson = params[6];
            String checkout = params[7];

            try {

                URL url = new URL(login_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));

                String post_data = "";
                if (type.equals("registerRoom")) {
                    post_data = URLEncoder.encode("iduser", "UTF-8") + "=" + URLEncoder.encode(iduser, "UTF-8") + "&"
                            + URLEncoder.encode("startdate", "UTF-8") + "=" + URLEncoder.encode(startdate, "UTF-8") + "&"
                            + "&" + URLEncoder.encode("enddate", "UTF-8") + "=" + URLEncoder.encode(enddate, "UTF-8")
                            + "&" + URLEncoder.encode("price", "UTF-8") + "=" + URLEncoder.encode(price, "UTF-8")
                            + "&" + URLEncoder.encode("numberofperson", "UTF-8") + "=" + URLEncoder.encode(numberofperson, "UTF-8")
                            + "&" + URLEncoder.encode("checkout", "UTF-8") + "=" + URLEncoder.encode(checkout, "UTF-8");


                }


                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                String result = "";
                String line = "";
                while ((line = bufferedReader.readLine()) != null) {
                    result += line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return result;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPreExecute() {

        }

        @Override
        protected void onPostExecute(String result) {

           // Toast.makeText(context, ""+result, Toast.LENGTH_SHORT).show();

        }
        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }


    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}