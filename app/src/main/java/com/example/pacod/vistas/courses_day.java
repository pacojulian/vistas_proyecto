package com.example.pacod.vistas;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

public class courses_day extends AppCompatActivity {

    ListView lv_languages;


    LanguagesListAdapter1 list_adapter;
    private ArrayList<String> Nombre;
    private ArrayList<String> Fecha;
    private ArrayList<String> Horario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_courses_day);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Intent intent = getIntent();
        final String v_dia = intent.getStringExtra("dia");
        getSupportActionBar().setTitle("Cursos: "+v_dia);





        Nombre = new ArrayList<String>();
        Nombre.add("Bases de Datos Avanzadas");
        Nombre.add("Graficas Computacionales");

        Fecha = new ArrayList<String>();
        Fecha.add("Lunes y Jueves");
        Fecha.add("Martes y Viernes");

        Horario = new ArrayList<String>();
        Horario.add("11:30/1:00");
        Horario.add("8:30/10:00");



        init();
        lv_languages.setAdapter(list_adapter);




    }

    private void init() {

        list_adapter = new LanguagesListAdapter1(courses_day.this,Nombre,Fecha,Horario);
        lv_languages = (ListView) findViewById(R.id.lv_languages1);

    }

}
