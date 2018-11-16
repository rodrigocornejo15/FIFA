package com.blackfish.evaluacion2;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.blackfish.evaluacion2.entidades.Equipos;
import com.blackfish.evaluacion2.entidades.TipoPartido;
import com.blackfish.evaluacion2.utilidades.Utilidades;

import java.util.ArrayList;

public class RegistrarPartido extends AppCompatActivity {

    Spinner sp1, sp2;
    EditText et1, et2;
    ArrayList<String> listaEquipos;
    ArrayList<Equipos> equipos;
    ArrayList<String> listaTipo;
    ArrayList<TipoPartido> partido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_partido);

        sp1 = (Spinner)findViewById(R.id.spEquipoGana);
        sp2 = (Spinner)findViewById(R.id.spTipo);
        et1 = (EditText)findViewById(R.id.etCantidadGoles);
        et2 = (EditText)findViewById(R.id.etFecha);

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();

        cargarSpinner();
        //cargarTablas();

        ArrayAdapter<String> adap = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listaEquipos);
        //ArrayAdapter<CharSequence> adapTipo = ArrayAdapter.createFromResource(this, R.array.tipo_partidos, android.R.layout.simple_spinner_item);
        ArrayAdapter<String> adapTipo = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listaTipo);
        adap.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapTipo.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp1.setAdapter(adap);
        sp2.setAdapter(adapTipo);
        db.close();
    }


    public void cargarSpinner(){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion", null, 1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();

        Equipos datos = null;
        TipoPartido tp = null;
        equipos = new ArrayList<Equipos>();
        partido = new ArrayList<TipoPartido>();
        Cursor c = BaseDeDatos.rawQuery("SELECT * FROM "+Utilidades.TABLA_EQUIPOS, null);
        Cursor t = BaseDeDatos.rawQuery("SELECT * FROM "+Utilidades.TABLA_TIPO_PARTIDO, null);
        while (c.moveToNext())
        {
            datos = new Equipos();
            //tp = new TipoPartido();
            datos.setNombre(c.getString(1));
            //tp.setTipoPartido(c.getString(1));
            equipos.add(datos);
            //partido.add(tp);
        }
        while (t.moveToNext()){
            tp = new TipoPartido();
            tp.setTipoPartido(t.getString(1));
            partido.add(tp);
        }
        obtenerLista();
    }

    private void obtenerLista() {
        listaEquipos = new ArrayList<>();
        listaTipo = new ArrayList<>();
        listaEquipos.add("Equipo Ganador");
        listaTipo.add("Tipo Partido");
        for (int i = 0; i < equipos.size(); i++) {
            listaEquipos.add(equipos.get(i).getNombre());
        }
        for (int j = 0; j < partido.size(); j++){
            listaTipo.add(partido.get(j).getTipoPartido());
        }

    }

    //Método Boton Salir
    public void salir(View view) {
        Intent salir = new Intent(this, MainActivity.class);
        startActivity(salir);
    }

        //Metodo boton registrar partido

    public void registrarPartido(View view){
            SQLiteOpenHelper conn = new AdminSQLiteOpenHelper(this, "administracion", null, 1);
            SQLiteDatabase BaseDeDatos = conn.getWritableDatabase();

            if(sp1.getSelectedItemId()!=0 && sp2.getSelectedItemId()!=0 && !et1.getText().toString().isEmpty() && !et2.getText().toString().isEmpty())
            {
                ContentValues registro = new ContentValues();
                registro.put(Utilidades.CAMPO_EQUIPO_GANA, sp1.getSelectedItemId());
                registro.put(Utilidades.CAMPO_TIPO, sp2.getSelectedItemId());
                registro.put(Utilidades.CAMPO_GOLES, et1.getText().toString());
                registro.put(Utilidades.CAMPO_FECHA, et2.getText().toString());

                Long resultadopartido = BaseDeDatos.insert(Utilidades.TABLA_PARTIDOS, Utilidades.CAMPO_ID_P, registro);

                sp1.setSelection(0);
                sp2.setSelection(0);
                et1.setText("");
                et2.setText("");
                Toast.makeText(this, "Registro "+ resultadopartido +" exitoso", Toast.LENGTH_LONG).show();
                BaseDeDatos.close();

            }
            else
            {
                Toast.makeText(this, "Debes ingresar nombre y tipo de equipo", Toast.LENGTH_LONG).show();
            }
        }

    /*public void cargarTablas(){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion", null, 1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();
        ContentValues registro = new ContentValues();
        Cursor c = BaseDeDatos.rawQuery("SELECT COUNT (*) FROM "+Utilidades.TABLA_TIPO_PARTIDO, null);
        if ( c!=null){
            c.moveToFirst();
            if (c.getInt(0)==0){
                for(int i=1; i<=3; i++){
                    registro.put(Utilidades.CAMPO_NOMBRE_TIPO, "Partido"+(i)+"");
                }

            }
        }
        BaseDeDatos.close();
    }*/
    }
