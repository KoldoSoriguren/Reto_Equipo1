package Modelo;

import java.time.LocalDate;
import java.util.ArrayList;

public class Equipo {
    private String codEquipo;
    private String nombreEquipo;
    private LocalDate fechaFund;
    private ArrayList<Jugador> jugadores;

    public Equipo(String codEquipo, String nombreEquipo, LocalDate fechaFund) {
        this.codEquipo = codEquipo;
        this.nombreEquipo = nombreEquipo;
        this.fechaFund = fechaFund;
    }

    public Equipo(String codEquipo, String nombreEquipo, LocalDate fechaFund, ArrayList<Jugador> jugadores) {
        this.codEquipo = codEquipo;
        this.nombreEquipo = nombreEquipo;
        this.fechaFund = fechaFund;
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

    public LocalDate getFechaFund() {
        return fechaFund;
    }

    public void setFechaFund(LocalDate fechaFund) {
        this.fechaFund = fechaFund;
    }

    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(ArrayList<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    public void altaJugador(Jugador jugador) {
        this.jugadores.add(jugador);
    }

    public void bajaJugador(Jugador jugador) {
        this.jugadores.remove(jugador);
    }

    @Override
    public String toString() {
        return "Código Equipo -> " + codEquipo + "\n " +
                "Nombre Equipo -> " + nombreEquipo + "\n " +
                "Fecha Fundación -> " + fechaFund
                ;
    }
}