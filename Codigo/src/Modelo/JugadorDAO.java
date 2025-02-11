package Modelo;

import java.util.ArrayList;

public class JugadorDAO {
    private ArrayList<Jugador> jugadores;
    public JugadorDAO() {
        jugadores = new ArrayList<>();
    }
    public void agregarJugador(Jugador j) {
        jugadores.add(j);
    }
}
