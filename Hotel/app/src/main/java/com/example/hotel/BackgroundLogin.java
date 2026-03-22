package com.example.hotel;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.Toast;

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

public class BackgroundLogin extends AsyncTask<String,Void,String> {

    Context context;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

    AlertDialog alertDialog;
    BackgroundLogin(Context ctx){
        context = ctx;
    }
    @Override
    protected String doInBackground(String... params) {
        String login_url = params[0];
        String type = params[1];
        String email = params[2];
        String password = params[3];

        try {

            URL url = new URL(login_url);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            OutputStream outputStream = httpURLConnection.getOutputStream();
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));

            String post_data = "";
            if(type.equals("loginHotel")){
                post_data = URLEncoder.encode("email", "UTF-8") + "=" + URLEncoder.encode(email, "UTF-8") + "&"
                        + URLEncoder.encode("password", "UTF-8") + "=" + URLEncoder.encode(password, "UTF-8");
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

        String emailText = MainActivity.email;
        String password = MainActivity.password;

        if(!emailText.matches(emailPattern)){
            Toast.makeText(context,"Please introduce a valid email!",Toast.LENGTH_LONG).show();
        }else if(emailText.length() == 0 ){
            Toast.makeText(context,"Please introduce a email!",Toast.LENGTH_LONG).show();
        }else if (password.length() == 0 ){
            Toast.makeText(context,"Please introduce a password",Toast.LENGTH_LONG).show();
        }else if (emailText.matches(emailPattern) && emailText.length() > 0 && result.equals("Login success") && password.length() > 0) {
            String url = "http://192.168.8.29/idUserHotel.php";
            String type = "idUserHotel";
            BackgroundIdUser backgroundWorker = new BackgroundIdUser(context);
            backgroundWorker.execute(url, type, MainActivity.password, MainActivity.email);
            Toast.makeText(context,"Authentification with succes!",Toast.LENGTH_LONG).show();
            Intent intent = new Intent(context, MenuHotel.class);
            context.startActivity(intent);
        }else{
            Toast.makeText(context,"Email or Password is wrong!",Toast.LENGTH_LONG).show();

        }

    }
    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

}
