package com.blackfish.evaluacion2;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SQLiteOpenHelper conn = new AdminSQLiteOpenHelper(this, "administracion", null, 1);

    }
    public void listas(View v){
        Intent lista = new Intent(this, Listas.class);
        startActivity(lista);
    }
    //Boton registrar equipo
    public void registrarEquipo(View view)
    {
        Intent regEquipo = new Intent(this, RegistrarEquipo.class);
        startActivity(regEquipo);
    }

    //Boton registrar jugador
    public void registrarJugador(View view)
    {
        Intent regJugador = new Intent(this, RegistrarJugador.class);
        startActivity(regJugador);
    }

    //Boton registrar partido
    public void registrarPartido(View view)
    {
        Intent regPartido = new Intent(this, RegistrarPartido.class);
        startActivity(regPartido);
    }

    //Boton lista de jugadores
    public void listarJugadores(View view)
    {
        Intent listarJugadores = new Intent(this, ListarJugadores.class);
        startActivity(listarJugadores);
    }

    //Boton lista de partidos
    public void listarPartidos(View view)
    {
        Intent listarPartidos = new Intent(this, ListarPartidos.class);
        startActivity(listarPartidos);
    }


}
