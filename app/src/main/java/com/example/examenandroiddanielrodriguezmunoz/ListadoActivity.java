package com.example.examenandroiddanielrodriguezmunoz;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ListadoActivity extends AppCompatActivity {
    private AlumnoRecyclerAdapter adapter;
    private RecyclerView recyclerview;
    private LinearLayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado);

        recyclerview = findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(this);
        recyclerview.setLayoutManager(layoutManager);
        adapter = AlumnoRecyclerAdapter.getInstance();
        recyclerview.setAdapter(adapter);
    }
}