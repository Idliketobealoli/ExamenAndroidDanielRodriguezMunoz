package com.example.examenandroiddanielrodriguezmunoz;

import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private EditText personName, nota1, nota2, nota3;
    private Button add, listar;
    private AlumnoRecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = AlumnoRecyclerAdapter.getInstance();

        personName = findViewById(R.id.editTextTextPersonName);
        nota1 = findViewById(R.id.EditTextNota1);
        nota2 = findViewById(R.id.editTextNota2);
        nota3 = findViewById(R.id.editTextNota3);
        add = findViewById(R.id.buttonAdd);
        listar = findViewById(R.id.buttonListar);

        add.setOnClickListener(v -> {
            Alumno alumn = new Alumno();
            if (!personName.getText().toString().isEmpty()) {
                alumn.setName(personName.getText().toString());
            } else alumn.setName("Nombre no definido");
            if (!nota1.getText().toString().isEmpty()) {
                alumn.setNota1(Integer.parseInt(nota1.getText().toString()));
            } else alumn.setNota1(0);
            if (!nota2.getText().toString().isEmpty()) {
                alumn.setNota2(Integer.parseInt(nota2.getText().toString()));
            } else alumn.setNota2(0);
            if (!nota3.getText().toString().isEmpty()) {
                alumn.setNota3(Integer.parseInt(nota3.getText().toString()));
            } else alumn.setNota3(0);
            adapter.addNewAlumno(alumn);
        });

        listar.setOnClickListener(v -> {
            Intent intent = new Intent(this, ListadoActivity.class);
            startActivity(intent);
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.action_go_listado) {
            Intent intent = new Intent(this, ListadoActivity.class);
            startActivity(intent);
        }
        return false;
    }
}