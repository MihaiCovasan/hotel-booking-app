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

public class BackgroundRegister extends AsyncTask<String,Void,String> {

    Context context;
    BackgroundRegister(Context ctx){
        context = ctx;
    }
    @Override
    protected String doInBackground(String... params) {
        String login_url = params[0];
        String type = params[1];
        String email = params[2];
        String firstName = params[3];
        String lastName = params[4];
        String password = params[5];
        String phone = params[6];
        String checkGDPR = params[7];
        String cnp = params[8];

        try {

            URL url = new URL(login_url);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            OutputStream outputStream = httpURLConnection.getOutputStream();
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));

            String post_data = "";
            if (type.equals("ckeckEmail")) {
                post_data = URLEncoder.encode("firstname", "UTF-8") + "=" + URLEncoder.encode(firstName, "UTF-8") + "&"
                        + URLEncoder.encode("lastname", "UTF-8") + "=" + URLEncoder.encode(lastName, "UTF-8") + "&"
                        + "&" + URLEncoder.encode("password", "UTF-8") + "=" + URLEncoder.encode(password, "UTF-8")
                        + "&" + URLEncoder.encode("email", "UTF-8") + "=" + URLEncoder.encode(email, "UTF-8")
                        + "&" + URLEncoder.encode("phone", "UTF-8") + "=" + URLEncoder.encode(phone, "UTF-8")
                        + "&" + URLEncoder.encode("gdpr", "UTF-8") + "=" + URLEncoder.encode(checkGDPR, "UTF-8")
                        + "&" + URLEncoder.encode("cnp", "UTF-8") + "=" + URLEncoder.encode(cnp, "UTF-8");


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

        Toast.makeText(context, ""+result, Toast.LENGTH_SHORT).show();
        if(result.equals("")){
            Toast.makeText(context, "Email already exist in database!", Toast.LENGTH_SHORT).show();
        }else{
            context.startActivity(new Intent(context,MainActivity.class));
        }
    }
    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }


}
