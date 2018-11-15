package com.blackfish.evaluacion2;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.blackfish.evaluacion2.utilidades.Utilidades;

public class AdminSQLiteOpenHelper extends SQLiteOpenHelper {


    public AdminSQLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase BaseDeDatos) {
        //BaseDeDatos.execSQL("create table jugadores(id_jugador int primary key autoincrement, nombre String, apellido String, id_equipo int, foreign key (id_equipo) references equipos(id_equipo))");
        //BaseDeDatos.execSQL("create table equipos(id_equipo int primary key autoincrement, nombre String)");
        //BaseDeDatos.execSQL("create table juegan(id_juegan int primary key autoincrement, id_partido int, id_equipo_local int, id_partido_visita int, fecha date)");
        //BaseDeDatos.execSQL("create table partidos(id_partido int primary key autoincrement, tipo_partido int)");
        //BaseDeDatos.execSQL("create table tipos_partidos(id_tipo int primary key autoincrement, nombre String)");
        BaseDeDatos.execSQL(Utilidades.CREAR_TABLA_EQUIPOS);
        BaseDeDatos.execSQL(Utilidades.CREAR_TABLA_JUGADORES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase BaseDeDatos, int versionAntigua, int versionNueva) {
        BaseDeDatos.execSQL("DROP TABLE IF EXISTS "+Utilidades.TABLA_EQUIPOS);
        BaseDeDatos.execSQL("DROP TABLE IF EXISTS "+Utilidades.TABLA_JUGADORES);
        onCreate(BaseDeDatos);
    }
}
