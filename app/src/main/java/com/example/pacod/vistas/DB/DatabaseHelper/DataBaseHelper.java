package com.example.pacod.vistas.DB.DatabaseHelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.provider.BaseColumns;

import com.example.pacod.vistas.DB.Contract.Photo_Contract;

/**
 * Created by pacod on 18/10/2017.
 */

public class DataBaseHelper extends SQLiteOpenHelper {

    private static final String NOMBRE_BASE_DATOS = "photo_school.db";

    private static final int VERSION_ACTUAL = 1;
    private final Context contexto;


    interface Referencias {

       /* String ID_CABECERA_PEDIDO = String.format("REFERENCES %s(%s) ON DELETE CASCADE",
                Tablas.CABECERA_PEDIDO, ContratoPedidos.CabecerasPedido.generarIdCabeceraPedido());

        String ID_PRODUCTO = String.format("REFERENCES %s(%s)",
                Tablas.PRODUCTO, ContratoPedidos.Productos.generarIdProducto());*/




    }
    public DataBaseHelper(Context contexto) {
        super(contexto, NOMBRE_BASE_DATOS, null, VERSION_ACTUAL);
        this.contexto = contexto;
    }

    interface Tablas {
        String CURSANDO = "cursando";
        String MATERIA = "materia";
        String PHOTO = "photo";
        String USUARIO= "usuario";

    }


    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
        if (!db.isReadOnly()) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                db.setForeignKeyConstraintsEnabled(true);
            } else {
                db.execSQL("PRAGMA foreign_keys=ON");
            }
        }
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(String.format("CREATE TABLE %s ( %s INTEGER PRIMARY KEY AUTOINCREMENT," +
                        "%s TEXT NOT NULL UNIQUE,%s TEXT NOT NULL,%s TEXT NOT NULL UNIQUE,%s TEXT NOT NULL UNIQUE,%s TEXT NOT NULL UNIQUE,%s TEXT NOT NULL UNIQUE)",
                Tablas.PHOTO, BaseColumns._ID,
                Photo_Contract.Photos.PATH , Photo_Contract.Photos.FECHA,Photo_Contract.Photos.ID_CURSANDO,
                Photo_Contract.Photos.ID_USUARIO,Photo_Contract.Photos.ID_MATERIA));


        db.execSQL(String.format("CREATE TABLE %s ( %s INTEGER PRIMARY KEY AUTOINCREMENT," +
                        "%s TEXT NOT NULL UNIQUE,%s TEXT NOT NULL UNIQUE)",
                Tablas.MATERIA, BaseColumns._ID, Photo_Contract.Materia.NOMBRE,Photo_Contract.Materia.DESCRIPCION));

        db.execSQL(String.format("CREATE TABLE %s ( %s TEXT NOT NULL UNIQUE," +
                        "%s TEXT NOT NULL UNIQUE,%s TEXT NOT NULL,%s TEXT NOT NULL)",
                Tablas.MATERIA, Photo_Contract.Usuario.ID_USUARIO, Photo_Contract.Usuario.NOMBRE,Photo_Contract.Usuario.CONTRA,
                Photo_Contract.Usuario.CORREO));

        db.execSQL(String.format("CREATE TABLE %s ( %s TEXT NOT NULL UNIQUE," +
                        "%s TEXT NOT NULL UNIQUE,%s TEXT NOT NULL UNIQUE,%s TEXT NOT NULL UNIQUE,%s TEXT NOT NULL UNIQUE,%s TEXT NOT NULL UNIQUE"+
                "%s TEXT NOT NULL UNIQUE,%s TEXT NOT NULL UNIQUE)",
                Tablas.MATERIA, Photo_Contract.Cursando.ID_CURSANDO, Photo_Contract.Cursando.ID_USUARIO,Photo_Contract.Cursando.ID_MATERIA,
                Photo_Contract.Cursando.NOMBRE,Photo_Contract.Cursando.DESCRIPCION,Photo_Contract.Cursando.HORARIO,
                Photo_Contract.Cursando.HORA_ENTRADA,Photo_Contract.Cursando.HORARIO_SALIDA));



    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {


        db.execSQL("DROP TABLE IF EXISTS " + Tablas.CURSANDO);
        db.execSQL("DROP TABLE IF EXISTS " + Tablas.MATERIA);
        db.execSQL("DROP TABLE IF EXISTS " + Tablas.PHOTO);
        db.execSQL("DROP TABLE IF EXISTS " + Tablas.USUARIO);


        onCreate(db);


    }







}
