package com.blackfish.evaluacion2;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.blackfish.evaluacion2.utilidades.Utilidades;

public class RegistrarEquipo extends AppCompatActivity {

    EditText et2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_equipo);

        //et1 = (EditText)findViewById(R.id.txt_id);
        et2 = (EditText)findViewById(R.id.txt_equipo);

    }

    //Método Boton Salir
    public void salir(View view)
    {
        Intent salir = new Intent(this, MainActivity.class);
        startActivity(salir);
    }

    //Metodo boton registrar equipo
    public void registrarEquipo(View view)
    {
        SQLiteOpenHelper conn = new AdminSQLiteOpenHelper(this, "administracion", null, 1);
        SQLiteDatabase BaseDeDatos = conn.getWritableDatabase();

        //AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion", null, 1);
        //SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();

        //String nombreEquipo = et1.getText().toString();

        if(!et2.getText().toString().isEmpty())
        {
            ContentValues registro = new ContentValues();
            //registro.put(Utilidades.CAMPO_ID, et1.getText().toString());
            registro.put(Utilidades.CAMPO_NOMBRE, et2.getText().toString());

            Long resultado = BaseDeDatos.insert(Utilidades.TABLA_EQUIPOS, Utilidades.CAMPO_ID, registro);

            //et1.setText("");
            et2.setText("");
            Toast.makeText(this, "Registro "+ resultado +" exitoso", Toast.LENGTH_LONG).show();
            BaseDeDatos.close();

            //Long idResultante=db.insert(Utilidades.TABLA_USUARIO,Utilidades.CAMPO_ID,values);

            //Toast.makeText(getApplicationContext(),"Id Registro: "+idResultante,Toast.LENGTH_SHORT).show();

        }
        else
        {
            Toast.makeText(this, "Debes ingresar id y nombre de equipo", Toast.LENGTH_LONG).show();
        }

    }
}//Fin Class RegistarEquipo
