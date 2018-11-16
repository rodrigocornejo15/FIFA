package com.blackfish.evaluacion2.entidades;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.blackfish.evaluacion2.AdminSQLiteOpenHelper;

public class TipoPartido{

    Integer idTipoPartido;
    String tipoPartido;

    public TipoPartido() {
    }

    public TipoPartido(Integer idTipoPartido, String tipoPartido) {
        this.idTipoPartido = idTipoPartido;
        this.tipoPartido = tipoPartido;
    }

    public Integer getIdTipoPartido() {
        return idTipoPartido;
    }

    public void setIdTipoPartido(Integer idTipoPartido) {
        this.idTipoPartido = idTipoPartido;
    }

    public String getTipoPartido() {
        return tipoPartido;
    }

    public void setTipoPartido(String tipoPartido) {
        this.tipoPartido = tipoPartido;
    }
}
