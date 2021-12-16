package com.example.examenandroiddanielrodriguezmunoz;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class AlumnoRecyclerAdapter extends RecyclerView.Adapter<AlumnoRecyclerAdapter.ViewHolder> {
    private static AlumnoRecyclerAdapter ara;
    List<Alumno> alumnos;

    private AlumnoRecyclerAdapter(List<Alumno> alumnos) {
        this.alumnos = alumnos;
    }

    public static AlumnoRecyclerAdapter getInstance() {
        if (ara == null) {
            ara = new AlumnoRecyclerAdapter(new ArrayList<>());
            return ara;
        } else return ara;
    }

    @NonNull
    @Override
    public AlumnoRecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.alumno_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AlumnoRecyclerAdapter.ViewHolder holder, int position) {
        holder.name.setText(alumnos.get(position).getName());
        holder.notaMedia.setText(calcularMedia(alumnos.get(position)));
    }

    private String calcularMedia(Alumno alumno) {
        if (!(alumno.getNota1() > 0 && alumno.getNota1() <= 10)) {
            alumno.setNota1(0);
        }
        if (!(alumno.getNota2() > 0 && alumno.getNota2() <= 10)) {
            alumno.setNota2(0);
        }
        if (!(alumno.getNota3() > 0 && alumno.getNota3() <= 10)) {
            alumno.setNota3(0);
        }
        if(alumno.getNota1() < 5 || alumno.getNota2() < 5 || alumno.getNota3() < 5) {
            return "Debe superar algun modulo.";
        } else {
            double media = ((alumno.getNota1()+alumno.getNota2()+ alumno.getNota3())/3);
            return (""+media);
        }
    }

    @Override
    public int getItemCount() {
        return alumnos.size();
    }

    public void addNewAlumno(Alumno alumno) {
        alumnos.add(alumno);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name, notaMedia;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.textViewNameAlumno);
            notaMedia = itemView.findViewById(R.id.textViewNotaMedia);
        }
    }
}
