package com.example.priya.saveimageexternalstorage;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.jar.Manifest;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActivityCompat.requestPermissions(MainActivity.this,
                new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGEE},1);

        Bitmap image = BitmapFactory.decodeResource(getResources(), R.drawable.userimage);

        // Path to sd card

        File path = Environment.getExternalStorageDirectory();

        // create a folder

        File dir = new File(path + "/Save/");
        dir.mkdirs();

        File file = new File(dir, "acadglid.png");

        OutputStream out = null;

        try {
            out = new FileOutputStream(file);
            image.compress(Bitmap.CompressFormat.PNG, 100, out);
            out.flush();
            out.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }}





