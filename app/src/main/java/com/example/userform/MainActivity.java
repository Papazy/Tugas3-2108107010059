package com.example.userform;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
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

        EditText nama;
        EditText nim;
        EditText jurusan;
        Button simpanBtn, lihatBtn;
    DBHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // mengambil R
        nama = findViewById(R.id.nama);
        nim = findViewById(R.id.nim);
        jurusan = findViewById(R.id.jurusan);
        simpanBtn = findViewById(R.id.simpanButton);
        lihatBtn = findViewById(R.id.lihatButton);

        dbHelper = new DBHelper(MainActivity.this);
        simpanBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                String mhsNama = nama.getText().toString();
                String mhsNim = nim.getText().toString();
                String mhsJurusan = jurusan.getText().toString();

                if(mhsNama.isEmpty() && mhsNim.isEmpty() && mhsJurusan.isEmpty()){
                    Toast.makeText(MainActivity.this, "Mohon isi Kolomnya", Toast.LENGTH_SHORT).show();
                    return;
                }

                dbHelper.tambahMahasiswa(mhsNama,mhsNim,mhsJurusan);

                Toast.makeText(MainActivity.this, "Data Disimpan", Toast.LENGTH_SHORT).show();
                nama.setText("");
                nim.setText("");
                jurusan.setText("");
            }
        });
        lihatBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent i = new Intent(MainActivity.this, Viewmahasiswa.class);
                startActivity(i);
            }
        });
    }

}