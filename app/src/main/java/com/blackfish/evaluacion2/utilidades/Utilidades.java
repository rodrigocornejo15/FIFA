package com.blackfish.evaluacion2.utilidades;

public class Utilidades {

    //Constantes campos tabla equipos
    public static final String TABLA_EQUIPOS = "equipos";
    public static final String CAMPO_ID = "id_equipo";
    public static final String CAMPO_NOMBRE = "nombre";

    public static final String CREAR_TABLA_EQUIPOS = "CREATE TABLE "
            + TABLA_EQUIPOS +" ("
            + CAMPO_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, "
            + CAMPO_NOMBRE + " TEXT)";

    //Constantes campos tabla Jugadores
    public static final String TABLA_JUGADORES = "jugadores";
    public static final String CAMPO_ID_J = "id_jugador";
    public static final String CAMPO_NOMBRE_J = "nombre_j";
    public static final String CAMPO_APELLIDO_J = "apellido_j";
    public static final String CAMPO_ID_EQUIPO_J = "id_equipo_j";

    public static final String CREAR_TABLA_JUGADORES = "CREATE TABLE "
            + TABLA_JUGADORES + "("
            + CAMPO_ID_J + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, "
            + CAMPO_NOMBRE_J + " TEXT, "
            + CAMPO_APELLIDO_J + " TEXT, "
            + CAMPO_ID_EQUIPO_J + " INTEGER,"
            + " FOREIGN KEY("+CAMPO_ID_EQUIPO_J+") REFERENCES "+TABLA_EQUIPOS+"("+CAMPO_ID+"));";

    public static final String TABLA_TIPO_PARTIDO = "tipo_partido";
    public static final String CAMPO_ID_TIPO = "id_tipo";
    public static final String CAMPO_NOMBRE_TIPO = "nombre";

    public static final String CREAR_TABLA_TIPO_PARTIDO = "CREATE TABLE "
            + TABLA_TIPO_PARTIDO + "("
            + CAMPO_ID_TIPO + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, "
            + CAMPO_NOMBRE_TIPO + " TEXT)";

    public static final String LLENAR_TABLA_TIPO_PARTIDO = "INSERT INTO "+TABLA_TIPO_PARTIDO
            + "("+CAMPO_NOMBRE_TIPO+") VALUES"
            + "('Partido 1'),('Partido 2'),('Partido 3'),('Semifinal 1'), ('Semifinal 2'), ('Final')";

    //Constantes campos tabla Partidos
    public static final String TABLA_PARTIDOS = "partidos";
    public static final String CAMPO_ID_P = "id_partido";
    public static final String CAMPO_EQUIPO_GANA = "idEquipoGana";
    public static final String CAMPO_TIPO = "tipo";
    public static final String CAMPO_GOLES ="goles";
    public static final String CAMPO_FECHA = "fecha";

    public static final String CREAR_TABLA_PARTIDOS = "CREATE TABLE "
            + TABLA_PARTIDOS + "("
            + CAMPO_ID_P + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, "
            + CAMPO_EQUIPO_GANA + " INTEGER, "
            + CAMPO_TIPO + " INTEGER, "
            + CAMPO_GOLES + " INTEGER, "
            + CAMPO_FECHA + " TEXT , "
            + "FOREIGN KEY("+CAMPO_EQUIPO_GANA+") REFERENCES "+TABLA_EQUIPOS+"("+CAMPO_ID+"), "
            + "FOREIGN KEY("+CAMPO_TIPO+") REFERENCES "+TABLA_TIPO_PARTIDO+"("+CAMPO_ID_TIPO+"));";



}

