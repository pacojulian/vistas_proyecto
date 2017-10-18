package com.example.pacod.vistas.DB.Modelo;

/**
 * Created by pacod on 18/10/2017.
 */

public class Usuario {

    public String id_user;
    public String nombre;
    public String contra;
    public String correo;

    public Usuario(String id_user, String nombre, String contra, String correo) {
        this.id_user = id_user;
        this.nombre = nombre;
        this.contra = contra;
        this.correo = correo;
    }
}
