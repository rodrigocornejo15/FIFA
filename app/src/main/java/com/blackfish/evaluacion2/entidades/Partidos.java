package com.blackfish.evaluacion2.entidades;


import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.blackfish.evaluacion2.AdminSQLiteOpenHelper;
import com.blackfish.evaluacion2.utilidades.Utilidades;

public class Partidos {

    private Integer idPartido;
    private Equipos idEquipoLocal;
    private Equipos idEquipoVisita;
    private String tipo;

    public Partidos() {
    }

    public Partidos(Integer idPartido, Equipos idEquipoLocal, Equipos idEquipoVisita, String tipo) {
        this.idPartido = idPartido;
        this.idEquipoLocal = idEquipoLocal;
        this.idEquipoVisita = idEquipoVisita;
        this.tipo = tipo;
    }

    public Integer getIdPartido() {
        return idPartido;
    }

    public void setIdPartido(Integer idPartido) {
        this.idPartido = idPartido;
    }

    public Equipos getIdEquipoLocal() {
        return idEquipoLocal;
    }

    public void setIdEquipoLocal(Equipos idEquipoLocal) {
        this.idEquipoLocal = idEquipoLocal;
    }

    public Equipos getIdEquipoVisita() {
        return idEquipoVisita;
    }

    public void setIdEquipoVisita(Equipos idEquipoVisita) {
        this.idEquipoVisita = idEquipoVisita;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}

