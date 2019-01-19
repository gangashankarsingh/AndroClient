package bigdatamonks.com.inaugration_nk;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.net.Socket;
import android.widget.Toast;
import java.io.*;
import java.net.InetSocketAddress;

public class MainActivity extends AppCompatActivity {

    @Override



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void connectSocket(View v)
    {

        int permissionCheck = ContextCompat.checkSelfPermission(this, Manifest.permission.INTERNET);

        if (permissionCheck != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.INTERNET}, 1);
            //Toast.makeText(getApplicationContext(), "Hey No Permission" , Toast.LENGTH_SHORT).show();
        }

        //Toast.makeText(getApplicationContext(), "Hey Permission found" , Toast.LENGTH_SHORT).show();




        TextView tv = findViewById(R.id.editText);
        String address = tv.getText().toString().trim();




        try {
            //Toast.makeText(getApplicationContext(), "Hey I was clicked" , Toast.LENGTH_SHORT).show();


            new AsyncSocket(getApplicationContext(),address,9876).execute();


        } catch (Exception e){e.printStackTrace();}


    }


}
