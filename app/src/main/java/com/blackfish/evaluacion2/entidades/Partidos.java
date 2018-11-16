package com.blackfish.evaluacion2.entidades;


import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.blackfish.evaluacion2.AdminSQLiteOpenHelper;
import com.blackfish.evaluacion2.utilidades.Utilidades;

public class Partidos {

    private Integer idPartido;
    private Equipos idEquipoGana;
    private TipoPartido idTipo;
    private Integer goles;
    private String fecha;

    public Partidos() {
    }

    public Partidos(Integer idPartido, Equipos idEquipoGana, TipoPartido idTipo, Integer goles, String fecha) {
        this.idPartido = idPartido;
        this.idEquipoGana = idEquipoGana;
        this.idTipo = idTipo;
        this.goles = goles;
        this.fecha = fecha;
    }

    public Integer getIdPartido() {
        return idPartido;
    }

    public void setIdPartido(Integer idPartido) {
        this.idPartido = idPartido;
    }

    public Equipos getIdEquipoGana() {
        return idEquipoGana;
    }

    public void setIdEquipoGana(Equipos idEquipoGana) {
        this.idEquipoGana = idEquipoGana;
    }

    public TipoPartido getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(TipoPartido idTipo) {
        this.idTipo = idTipo;
    }

    public Integer getGoles() {
        return goles;
    }

    public void setGoles(Integer goles) {
        this.goles = goles;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}

