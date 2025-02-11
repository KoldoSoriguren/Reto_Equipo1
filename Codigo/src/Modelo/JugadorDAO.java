package Modelo;

import java.util.ArrayList;
import java.util.Optional;

public class JugadorDAO {
    private ArrayList<Jugador> jugadores;
    public JugadorDAO() {
        jugadores = new ArrayList<>();
    }
    public void agregarJugador(Jugador j) {
        jugadores.add(j);
    }
    public String eliminarJugador(String cod) {
        String mensaje="";
        Optional<Jugador> jug =jugadores.stream().filter(jugador -> jugador.getCodJugador().equals(cod)).findFirst();
        if (jug.isPresent()) {
            jugadores.remove(jug.get());
            mensaje="Jugador eliminado";
        }else {
            mensaje="No existe el jugador";
        }
        return mensaje;

    }
}
