package com.blackfish.evaluacion2.entidades;

public class Equipos {

    private Integer id_equipo;
    private String nombre;

    public Equipos(Integer id_equipo, String nombre) {
        this.id_equipo = id_equipo;
        this.nombre = nombre;
    }

    public Equipos() {
    }

    public Integer getId_equipo() {
        return id_equipo;
    }

    public void setId_equipo(Integer id_equipo) {
        this.id_equipo = id_equipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
