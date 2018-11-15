package com.blackfish.evaluacion2.entidades;


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

