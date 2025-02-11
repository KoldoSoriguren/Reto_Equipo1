package Modelo;

import java.time.LocalDate;
import java.util.ArrayList;

public class Equipo {
    private String codEquipo;
    private String nombreEquipo;
    private LocalDate fecha_fun;
    private ArrayList<Jugador> jugadores;

    public Equipo() {
    }

    public Equipo(String codEquipo, String nombreEquipo, LocalDate fecha_fun, ArrayList<Jugador> jugadores) {
        this.codEquipo = codEquipo;
        this.nombreEquipo = nombreEquipo;
        this.fecha_fun = fecha_fun;
        this.jugadores = jugadores;
    }

    public String getCodEquipo() {
        return codEquipo;
    }

    public void setCodEquipo(String codEquipo) {
        this.codEquipo = codEquipo;
    }

    public String getNombreEquipo() {
        return nombreEquipo;
    }

    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }

    public LocalDate getFecha_fun() {
        return fecha_fun;
    }

    public void setFecha_fun(LocalDate fecha_fun) {
        this.fecha_fun = fecha_fun;
    }

    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(ArrayList<Jugador> jugadores) {
        this.jugadores = jugadores;
    }
}