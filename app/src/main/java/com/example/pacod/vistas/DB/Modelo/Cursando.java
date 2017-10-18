package com.example.pacod.vistas.DB.Modelo;

/**
 * Created by pacod on 18/10/2017.
 */

public class Cursando {


    public String nombre;
    public String descripcion;
    public String horario;
    public String hora_entrada;
    public String hora_salida;

    public Cursando(String nombre, String descripcion, String horario, String hora_entrada, String hora_salida) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.horario = horario;
        this.hora_entrada = hora_entrada;
        this.hora_salida = hora_salida;
    }
}
