package com.blackfish.evaluacion2;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.provider.Telephony;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.blackfish.evaluacion2.entidades.*;
import com.blackfish.evaluacion2.utilidades.Utilidades;

import java.util.ArrayList;
import java.util.List;

public class ListarPartidos extends AppCompatActivity {

    /*private ArrayList<Partidos> partidos;
    private ArrayList<String> listaPartidos;
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

            Partidos datos = null;
            partidos = new ArrayList<Partidos>();
            SQLiteDatabase BaseDeDatos = conn.getWritableDatabase();
            Cursor c = BaseDeDatos.rawQuery("SELECT * FROM Partidos",null);
            if(c.moveToFirst()){
                do{
                    datos = new Partidos();
                    datos.setFecha(c.getString(4));
                    partidos.add(datos);//(new Jugadores(c.getString(0)));
                }while(c.moveToNext());
            }
        }
        String[] arreglo = new String[partidos.size()];
        for (int i =0; i<arreglo.length; i++){
            arreglo[i] = partidos.get(i).getFecha();
        }
        ArrayAdapter<String> tabla = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arreglo);
        lista.setAdapter(tabla);
    }
}*/
    private ArrayList<Partidos> partidos;
    private ArrayList<String> listaPartidos;
    private ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_equipo);
        lista= (ListView) findViewById(R.id.lvMostrarEquipo);

        Llenado();
        ArrayAdapter<String> tabla = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listaPartidos);
        lista.setAdapter(tabla);
    }

    public void Llenado() {
        SQLiteOpenHelper conn = new AdminSQLiteOpenHelper(this, "administracion", null, 1);

            Partidos datos = null;
            partidos = new ArrayList<Partidos>();
            SQLiteDatabase BaseDeDatos = conn.getWritableDatabase();
        Cursor c = BaseDeDatos.rawQuery("SELECT * FROM "+Utilidades.TABLA_EQUIPOS+","+Utilidades.TABLA_PARTIDOS
                +" WHERE "+Utilidades.CAMPO_ID+ "=" +Utilidades.CAMPO_ID_P+"" , null);
            //Cursor c = BaseDeDatos.rawQuery("SELECT * FROM "+Utilidades.TABLA_PARTIDOS, null);

            while (c.moveToNext()) {
                Equipos equipo = new Equipos();
                TipoPartido tipo = new TipoPartido();
                datos = new Partidos();
                datos.setIdPartido(c.getInt(0));
                equipo.setId_equipo(c.getInt(1));
                datos.setIdEquipoGana(equipo);
                tipo.setIdTipoPartido(c.getInt(2));
                datos.setIdTipo(tipo);
                datos.setGoles(c.getInt(3));
                datos.setFecha(c.getString(4));
                partidos.add(datos);
            }
            cargarLista();
/*Cursor t = BaseDeDatos.rawQuery("SELECT * FROM "+Utilidades.TABLA_EQUIPOS+","+Utilidades.TABLA_PARTIDOS
                        +" WHERE "+Utilidades.CAMPO_ID+ "=" +partidos.get(i).getIdEquipoGana()+"" , null);*/
    }

    private void cargarLista(){
        listaPartidos = new ArrayList<String>();

        for (int i =0; i<partidos.size(); i++){

            listaPartidos.add("Id Partido "+partidos.get(i).getIdPartido()+" Equipo Ganador "
                    +partidos.get(i).getIdEquipoGana().getNombre()+" Id Tipo Partido "
                    +partidos.get(i).getIdTipo().getTipoPartido()+" Goles "
                    +partidos.get(i).getGoles()+" Fecha "
                    +partidos.get(i).getFecha());
        }

    }
}