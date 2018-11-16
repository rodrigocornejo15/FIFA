package com.blackfish.evaluacion2;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.strictmode.SqliteObjectLeakedViolation;
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

        et2 = (EditText)findViewById(R.id.txt_equipo);
    }

    //Metodo boton registrar equipo
    public void registrarEquipo(View v)
    {
        SQLiteOpenHelper conn = new AdminSQLiteOpenHelper(this, "administracion", null, 1);
        SQLiteDatabase db = conn.getWritableDatabase();

        if(!et2.getText().toString().isEmpty()){
            ContentValues registro = new ContentValues();
            registro.put(Utilidades.CAMPO_NOMBRE, et2.getText().toString());

            Long resultado = db.insert(Utilidades.TABLA_EQUIPOS, Utilidades.CAMPO_ID, registro);

            et2.setText("");
            Toast.makeText(this, "Registro "+ resultado + "exitoso", Toast.LENGTH_LONG).show();
            db.close();
        }
        else
        {
            Toast.makeText(this, "Debes ingresar nombre de equipo", Toast.LENGTH_LONG).show();
        }

    }

    //Método Boton Salir
    public void salir(View view)
    {
        Intent salir = new Intent(this, MainActivity.class);
        startActivity(salir);
    }


}//Fin Class RegistarEquipo

