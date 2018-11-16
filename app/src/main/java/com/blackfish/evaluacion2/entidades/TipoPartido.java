package com.blackfish.evaluacion2.entidades;

public class TipoPartido {

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
