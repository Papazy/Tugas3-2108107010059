package com.example.userform;

import androidx.appcompat.app.AppCompatActivity;


import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText nama;
        EditText nim;
        EditText jurusan;
        Button simpanBtn;
        // mengambil R
        nama = findViewById(R.id.nama);
        nim = findViewById(R.id.nim);
        jurusan = findViewById(R.id.jurusan);
        simpanBtn = findViewById(R.id.simpanButton);simpanBtn.setOnClickListener(new View.OnClickListener (){
            public void onClick(View v){
                String snama = nama.getText().toString();
                String snim = nim.getText().toString();
                String sjurusan = jurusan.getText().toString();

//                simpanDataKeXML(snama, snim, sjurusan);

                // Membersihkan area edittext
                nama.setText("");
                nim.setText("");
                jurusan.setText("");

                Toast.makeText(MainActivity.this, "Data Berhasil Disimpan", Toast.LENGTH_SHORT).show();
            }
        });
    }
    void simpanDataKeXML(String nama, String nim, String jurusan ) {
        // Mendapatkan Resources di file terkait
        Resources rsc = getResources();

        // Mendapatkan resources ID
        int rscId = rsc.getIdentifier("strings", "xml", getPackageName());

        // Membuka file strings.xml
        InputStream ins = rsc.openRawResource(rscId);

        // Membaca isi file
        StringBuilder strbd = new StringBuilder();
        byte [] buffer = new byte[1024];
        int bytesRead ;
        try{
            while((bytesRead = ins.read(buffer)) != -1){
                strbd.append(new String(buffer, 0, bytesRead));
            }

        }catch (IOException e){
            e.printStackTrace();
        }

        try{
            ins.close();
        }catch (IOException e){
            e.printStackTrace();
        }

        // Menambahkan data baru
        strbd.insert(strbd.indexOf("</resources>"),
                "    <string name=\"nama_user\">" + nama + "</string>\n"+
                    "    <string name=\"nim_user\">"+nim+ "</string>\n"+
                    "    <string name=\"jurusan_user\">"+jurusan+"</string>\n"
                );

        //Membuka file untuk ditulis
        OutputStream out = null;
        try {
            out = new FileOutputStream(new File(getResources().getString(R.string.file_name)));
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }

        // Menulis
        try{
            out.write(strbd.toString().getBytes());
        } catch (IOException e){
            e.printStackTrace();
        }

        try{
            out.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}