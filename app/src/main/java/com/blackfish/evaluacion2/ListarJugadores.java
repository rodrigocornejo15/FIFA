package com.blackfish.evaluacion2;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import com.blackfish.evaluacion2.entidades.*;
import com.blackfish.evaluacion2.utilidades.Utilidades;

import java.util.ArrayList;

public class ListarJugadores extends AppCompatActivity {

    Spinner selEquipo;
    ListView lv;
    ArrayList<Equipos> equipos;
    ArrayList<String> listaEquipos;
    ArrayList<String> infoJugadores;
    ArrayList<Jugadores> listaJugadores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_jugadores);

        selEquipo = (Spinner)findViewById(R.id.spinner3);
        lv = (ListView)findViewById(R.id.list);

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();

        loadTeam();

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, listaEquipos);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        selEquipo.setAdapter(adapter);
        db.close();

    }

    public void loadTeam()
    {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion", null, 1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();

        Equipos datos = null;

        equipos = new ArrayList<Equipos>();

        Cursor c = BaseDeDatos.rawQuery("SELECT * FROM "+ Utilidades.TABLA_EQUIPOS, null);

        while (c.moveToNext())
        {
            datos = new Equipos();
            datos.setNombre(c.getString(1));
            equipos.add(datos);
        }
        getLista();
    }

    public void getLista()
    {
        listaEquipos = new ArrayList<>();
        listaEquipos.add("Seleccione");

        for(int i=0; i<equipos.size(); i++)
        {
            listaEquipos.add(equipos.get(i).getNombre());
        }
    }

    public void salir(View view)
    {
        Intent salir = new Intent(this, MainActivity.class);
        startActivity(salir);
    }

    public void cargarJugadores(View view)
    {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion", null, 1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();

        Long equipo = selEquipo.getSelectedItemId();
        listaJugadores = new ArrayList<Jugadores>();
        Jugadores datos = null;

        Cursor cursor = BaseDeDatos.rawQuery("SELECT * FROM "+Utilidades.TABLA_JUGADORES+
                " WHERE "+Utilidades.CAMPO_ID_EQUIPO_J+" = "+equipo,null);

        while (cursor.moveToNext())
        {
            datos = new Jugadores();
            datos.setNombre_j(cursor.getString(1));
            datos.setApellido_j(cursor.getString(2));
            listaJugadores.add(datos);
        }
        obtenerListaJ();

    }

    public void obtenerListaJ()
    {
        infoJugadores = new ArrayList<>();
        //infoJugadores.add("Seleccione");

        for(int i=0; i<listaJugadores.size(); i++)
        {
            infoJugadores.add(listaJugadores.get(i).getNombre_j());
            infoJugadores.add(listaJugadores.get(i).getApellido_j());
        }

        ArrayAdapter<String> adap = new ArrayAdapter<>(this, android.R.layout.test_list_item, infoJugadores);
        adap.setDropDownViewResource(android.R.layout.simple_list_item_1);
        lv.setAdapter(adap);

    }

}
