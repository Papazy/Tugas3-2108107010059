package com.example.userform;


import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Viewmahasiswa extends AppCompatActivity
{
    private ArrayList<MahasiswaModal> listMHSModal;
    private DBHelper dbHelper;
    private MahasiswaRVAdapter mahasiswaRVAdapter;
    private RecyclerView mahasiswaRV;


    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_mahasiswa);

        listMHSModal = new ArrayList<>();
        dbHelper = new DBHelper(Viewmahasiswa.this);

        listMHSModal = dbHelper.bacaDataMHS();
        mahasiswaRVAdapter = new MahasiswaRVAdapter(listMHSModal, Viewmahasiswa.this);
        mahasiswaRV = findViewById(R.id.idRVMahasiswa);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(Viewmahasiswa.this, RecyclerView.VERTICAL, false);
        mahasiswaRV.setLayoutManager(linearLayoutManager);

        mahasiswaRV.setAdapter(mahasiswaRVAdapter);
    }
}
