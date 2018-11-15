package com.blackfish.evaluacion2.utilidades;

public class Utilidades {

    //Constantes campos tabla equipos
    public static final String TABLA_EQUIPOS = "equipos";
    public static final String CAMPO_ID = "id_equipo";
    public static final String CAMPO_NOMBRE = "nombre";

    public static final String CREAR_TABLA_EQUIPOS = "CREATE TABLE " +
            ""+TABLA_EQUIPOS+" ("+CAMPO_ID+" " +
            "INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, "+CAMPO_NOMBRE+" TEXT)";

    public static final String TABLA_JUGADORES = "jugadores";
    public static final String CAMPO_ID_J = "id_jugador";
    public static final String CAMPO_NOMBRE_J = "nombre_j";
    public static final String CAMPO_APELLIDO_J = "equipos_j";
    public static final String CAMPO_ID_EQUIPO_J = "id_equipo_j";

    public static final String CREAR_TABLA_JUGADORES = "CREATE TABLE "+
            ""+TABLA_JUGADORES+"("+CAMPO_ID_J+" " +
            "INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, "+CAMPO_NOMBRE_J+" TEXT, "+
            ""+CAMPO_APELLIDO_J+" TEXT,"+CAMPO_ID_EQUIPO_J+" INTEGER, FOREIGN KEY("+CAMPO_ID_EQUIPO_J+") REFERENCES " +
            ""+TABLA_EQUIPOS+" ("+CAMPO_ID+"));";

}
