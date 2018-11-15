package com.blackfish.evaluacion2;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.blackfish.evaluacion2.entidades.*;
import com.blackfish.evaluacion2.utilidades.Utilidades;

import java.util.ArrayList;

public class RegistrarJugador extends AppCompatActivity {

   EditText etNombre, etApellido;
   Spinner selectEquipo;
   ArrayList<String> listaEquipos;
   ArrayList<Equipos> equipos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_jugador);

        etNombre = (EditText)findViewById(R.id.txt_nombre_jugador);
        etApellido = (EditText)findViewById(R.id.txt_apellido_jugador);
        selectEquipo = (Spinner)findViewById(R.id.spinner);

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();

        cargarEquipos();

        ArrayAdapter<String> adap = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listaEquipos);
        adap.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        selectEquipo.setAdapter(adap);
        db.close();
    }

    public void cargarEquipos(){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion", null, 1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();

        Equipos datos = null;

        equipos = new ArrayList<Equipos>();

        Cursor c = BaseDeDatos.rawQuery("SELECT * FROM "+Utilidades.TABLA_EQUIPOS, null);

        while (c.moveToNext())
        {
            datos = new Equipos();
            datos.setNombre(c.getString(1));
            equipos.add(datos);
        }
        obtenerLista();
    }

    private void obtenerLista()
    {
        listaEquipos = new ArrayList<>();
        listaEquipos.add("Seleccione");

        for(int i=0; i<equipos.size(); i++)
        {
            listaEquipos.add(equipos.get(i).getNombre());
        }

    }

    public void salir(View view){
        Intent salir = new Intent(this, MainActivity.class);
        startActivity(salir);
    }

    public void registrarJugador(View view){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion", null,1);
        SQLiteDatabase db = admin.getWritableDatabase();

        if(!etNombre.getText().toString().isEmpty() && !etApellido.getText().toString().isEmpty() && selectEquipo.getSelectedItemId()!=0){
            ContentValues registro = new ContentValues();
            registro.put(Utilidades.CAMPO_NOMBRE_J, etNombre.getText().toString());
            registro.put(Utilidades.CAMPO_APELLIDO_J, etApellido.getText().toString());
            registro.put(Utilidades.CAMPO_ID_EQUIPO_J, selectEquipo.getSelectedItemId());

            Long obtenerId = db.insert(Utilidades.TABLA_JUGADORES, Utilidades.CAMPO_ID_J, registro);

            etNombre.setText("");
            etApellido.setText("");
            selectEquipo.setSelection(0);

            Toast.makeText(this, "Registro "+obtenerId+" exitoso",Toast.LENGTH_LONG).show();
            db.close();
        }
        else{
            Toast.makeText(this, "Debe ingresar todos los datos", Toast.LENGTH_LONG).show();
        }

    }

}

