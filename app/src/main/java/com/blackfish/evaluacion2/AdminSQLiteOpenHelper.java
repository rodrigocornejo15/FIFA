package com.blackfish.evaluacion2;
import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

import com.blackfish.evaluacion2.utilidades.Utilidades;

public class AdminSQLiteOpenHelper extends SQLiteOpenHelper {


    public AdminSQLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Utilidades.CREAR_TABLA_EQUIPOS);
        db.execSQL(Utilidades.CREAR_TABLA_JUGADORES);
        db.execSQL(Utilidades.CREAR_TABLA_PARTIDOS);
        db.execSQL(Utilidades.CREAR_TABLA_TIPO_PARTIDO);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + Utilidades.TABLA_EQUIPOS);
        db.execSQL("DROP TABLE IF EXISTS " + Utilidades.TABLA_JUGADORES);
        db.execSQL("DROP TABLE IF EXISTS " + Utilidades.TABLA_PARTIDOS);
        db.execSQL("DROP TABLE IF EXISTS " + Utilidades.TABLA_TIPO_PARTIDO);
    }
}
