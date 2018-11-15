package com.blackfish.evaluacion2.entidades;


public class Jugadores {

    private Integer id_jugador;
    private String nombre_j;
    private String apellido_j;
    private Equipos id_equipo_j;

    public Jugadores(Integer id_jugador, String nombre_j, String apellido_j, Equipos id_equipo_j) {
        this.id_jugador = id_jugador;
        this.nombre_j = nombre_j;
        this.apellido_j = apellido_j;
        this.id_equipo_j = id_equipo_j;
    }

    public Jugadores() {
    }

    public Integer getId_jugador() {
        return id_jugador;
    }

    public void setId_jugador(Integer id_jugador) {
        this.id_jugador = id_jugador;
    }

    public String getNombre_j() {
        return nombre_j;
    }

    public void setNombre_j(String nombre_j) {
        this.nombre_j = nombre_j;
    }

    public String getApellido_j() {
        return apellido_j;
    }

    public void setApellido_j(String apellido_j) {
        this.apellido_j = apellido_j;
    }

    public Equipos getId_equipo_j() {
        return id_equipo_j;
    }

    public void setId_equipo_j(Equipos id_equipo_j) {
        this.id_equipo_j = id_equipo_j;
    }
}

