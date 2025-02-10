package Modelo;

import java.time.LocalDate;
import java.util.ArrayList;

public class Equipo {
    private String nombreEquipo;
    private LocalDate fecha_fun;
    private ArrayList<Jugador> jugadores;

    public Equipo() {
    }

    public Equipo(String nombreEquipo, ArrayList<Jugador> jugadores, LocalDate fecha_fun) {
        this.nombreEquipo = nombreEquipo;
        this.jugadores = jugadores;
        this.fecha_fun = fecha_fun;
    }

    public String getNombreEquipo() {
        return nombreEquipo;
    }

    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }

    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(ArrayList<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    public LocalDate getFecha_fun() {
        return fecha_fun;
    }

    public void setFecha_fun(LocalDate fecha_fun) {
        this.fecha_fun = fecha_fun;
    }
}

