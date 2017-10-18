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

    public DataBaseHelper(Context contexto) {
        super(contexto, NOMBRE_BASE_DATOS, null, VERSION_ACTUAL);
        this.contexto = contexto;
    }

    interface Tablas {
        String CURSANDO = "cursando";
        String MATERIA = "MATERIA";
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
                        "%s TEXT NOT NULL UNIQUE,%s REAL NOT NULL)",
                Tablas.PHOTO, BaseColumns._ID,
                , ContratoPedidos.Productos.PRECIO));

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
