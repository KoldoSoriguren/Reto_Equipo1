package Modelo;

import java.util.ArrayList;
import java.util.Optional;

public class JugadorDAO {
    private final ArrayList<Jugador> listaJugadores;

    public JugadorDAO() {
        listaJugadores = new ArrayList<>();
    }

    public void agregarJugador(Jugador j) {
        listaJugadores.add(j);
    }

    public String eliminarJugador(String cod) {
        String mensaje;

        Optional<Jugador> jugador = listaJugadores.stream().filter(jugadorABuscar -> jugadorABuscar.getCodJugador().equals(cod)).findFirst();
        if (jugador.isPresent()) {
            listaJugadores.remove(jugador.get());
            mensaje = "Jugador eliminado";
        }else {
            mensaje = "No existe el jugador";
        }
        return mensaje;

    }

    public Jugador mostrarJugador(String cod) {
        Jugador j;

        Optional<Jugador> jugador = listaJugadores.stream().filter(jugadorABuscar -> jugadorABuscar.getCodJugador().equals(cod)).findFirst();
        if (jugador.isPresent()) {
            j = jugador.get();
        }else{
            j = null;
        }
        return j;
    }

    public String modJugador(String cod, String valor, String propiedad){
        Optional<Jugador> jugador = listaJugadores.stream().filter(jugadorABuscar -> jugadorABuscar.getCodJugador().equals(cod)).findFirst();
        if (jugador.isPresent()) {

        }
        return null; // Temporal, WIP
    }
}
