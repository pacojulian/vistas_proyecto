package com.example.pacod.vistas;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Calendar;

import java.util.ArrayList;
import java.util.List;

public class Courses extends AppCompatActivity {

    ListView lv_languages;


    LanguagesListAdapter list_adapter;
    private ArrayList<String> Nombre;
    private ArrayList<String> Fecha;
    private ArrayList<String> Horario;

    private EditText ed_nombre;
    private  EditText ed_fecha;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_courses);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



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



        //Picker



        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();*/

                AlertDialog.Builder mBuilder = new  AlertDialog.Builder(Courses.this);
                View mView = getLayoutInflater().inflate(R.layout.dialog_spinner,null);
                mBuilder.setTitle("Añadir Materia");
                final Spinner mSpinner =(Spinner)mView.findViewById(R.id.spinner);
                //final TextView prueba =(TextView)mView.findViewById(R.id.prueba);

                ed_nombre= (EditText)mView.findViewById(R.id.edit_nombre);



                ArrayAdapter<String> adapter = new ArrayAdapter<String>(Courses.this,
                        android.R.layout.simple_spinner_item,
                        getResources().getStringArray(R.array.horario));
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                mSpinner.setAdapter(adapter);

                 Button bFrom = (Button) mView.findViewById(R.id.button_from);
                Button bTo = (Button) mView.findViewById(R.id.button_to);
                final TextView txt_from=(TextView) mView.findViewById(R.id.txt_from);
                final TextView txt_to=(TextView) mView.findViewById(R.id.txt_to);

                //Time Picker
                bFrom.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        // TODO Auto-generated method stub
                        Calendar mcurrentTime = Calendar.getInstance();
                        int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
                        int minute = mcurrentTime.get(Calendar.MINUTE);
                        TimePickerDialog mTimePicker;
                        mTimePicker = new TimePickerDialog(Courses.this, new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                                txt_from.setText( selectedHour + ":" + selectedMinute);
                            }
                        }, hour, minute, DateFormat.is24HourFormat(Courses.this));//Yes 24 hour time

                        mTimePicker.show();
                    }
                });

                bTo.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        // TODO Auto-generated method stub
                        Calendar mcurrentTime = Calendar.getInstance();
                        int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
                        int minute = mcurrentTime.get(Calendar.MINUTE);
                        TimePickerDialog mTimePicker;
                        mTimePicker = new TimePickerDialog(Courses.this, new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                                txt_to.setText( selectedHour + ":" + selectedMinute);
                            }
                        }, hour, minute, DateFormat.is24HourFormat(Courses.this));//Yes 24 hour time

                        mTimePicker.show();
                    }
                });



                mBuilder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String v_nombre="";
                        String v_fecha="";
                        if(!mSpinner.getSelectedItem().toString().equalsIgnoreCase("Choose a day")){
                            v_nombre=ed_nombre.getText().toString();


                            if(v_nombre.isEmpty())
                            {
                                Toast.makeText(Courses.this,"Error: Algun campo esta vacio"
                                        , Toast.LENGTH_SHORT).show();
                                dialog.dismiss();
                            }

                            Toast.makeText(Courses.this,mSpinner.getSelectedItem().toString()+" "
                                    + v_nombre+" "+v_fecha, Toast.LENGTH_SHORT).show();
                            dialog.dismiss();

                        }
                        else{
                            Toast.makeText(Courses.this,"Error: Debes de seleccionar un dia"
                                    , Toast.LENGTH_SHORT).show();
                            dialog.dismiss();
                        }

                    }
                });
                mBuilder.setNegativeButton("Dismiss", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        dialog.dismiss();
                    }
                });

                mBuilder.setView(mView);
                AlertDialog dialog =mBuilder.create();
                dialog.show();



            }
        });


    }
    private void init() {



        list_adapter = new LanguagesListAdapter(Courses.this,Nombre,Fecha,Horario);
        lv_languages = (ListView) findViewById(R.id.lv_languages);

    }

}
