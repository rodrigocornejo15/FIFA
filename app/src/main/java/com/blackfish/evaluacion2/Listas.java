package com.blackfish.evaluacion2;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;


import com.blackfish.evaluacion2.entidades.Jugadores;
import com.blackfish.evaluacion2.utilidades.Utilidades;

import java.util.ArrayList;
import java.util.List;

public class Listas extends AppCompatActivity {
    private ArrayList<Jugadores> jugadores;
    private ArrayList<String> listaJugadores;
    private ListView lista;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_equipo);
        lista= (ListView) findViewById(R.id.lvMostrarEquipo);
        Llenado();
    }

    public void Llenado()
    {
        SQLiteOpenHelper conn = new AdminSQLiteOpenHelper(this, "administracion", null, 1);
        if(conn!=null){

            Jugadores datos = null;
            jugadores = new ArrayList<Jugadores>();
            SQLiteDatabase BaseDeDatos = conn.getWritableDatabase();
            Cursor c = BaseDeDatos.rawQuery("SELECT * FROM Jugadores",null);
            if(c.moveToFirst()){
                do{
                    datos = new Jugadores();
                    datos.setNombre_j(c.getString(1));
                    jugadores.add(datos);//(new Jugadores(c.getString(0)));
                }while(c.moveToNext());
            }
        }
        String[] arreglo = new String[jugadores.size()];
        for (int i =0; i<arreglo.length; i++){
            arreglo[i] = jugadores.get(i).getNombre_j();
        }
        ArrayAdapter<String> tabla = new ArrayAdapter<String>(Listas.this, android.R.layout.simple_list_item_1, arreglo);
        lista.setAdapter(tabla);
    }
}

