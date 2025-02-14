package Modelo;

import javax.swing.*;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Optional;

public class JugadorDAO {
    private final ArrayList<Jugador> listaJugadores;
    EquipoDAO equipoDAO = new EquipoDAO();

    public JugadorDAO() {
        listaJugadores = new ArrayList<>();
    }

    public void agregarJugador(Jugador j) {
        listaJugadores.add(j);
    }

    public ArrayList<Jugador> getListaJugadores() {
        return listaJugadores;
    }

    public String eliminarJugador(String cod) {
        String mensaje;

        Optional<Jugador> jugador = listaJugadores.stream().filter(jugadorABuscar -> jugadorABuscar.getDni().equals(cod)).findFirst();
        if (jugador.isPresent()) {
            listaJugadores.remove(jugador.get());
            equipoDAO.eliminarJugador(jugador.get(), jugador.get().getEquipo().getCodEquipo());
            mensaje = "Jugador eliminado";
        } else {
            mensaje = "No existe el jugador";
        }
        return mensaje;
    }

    public Jugador mostrarJugador(String cod) {
        Jugador j;

        Optional<Jugador> jugador = listaJugadores.stream().filter(jugadorABuscar -> jugadorABuscar.getDni().equals(cod)).findFirst();
        if (jugador.isPresent()) {
            j = jugador.get();
        } else {
            j = null;
        }
        return j;
    }

    public Roles modirole(String cod, String valor, String propiedad) {
        Roles rol = null;

        propiedad.toUpperCase();
        switch (valor) {
            case "DUELISTA": {
                rol = Roles.DUELISTA;
            }
            break;
            case "INICIADOR": {
                rol = Roles.INICIADOR;
            }
            break;
            case "CONTROLADOR": {
                rol = Roles.CENTINELA;
            }
            break;
            case "CENTINELA": {
                rol = Roles.CONTROLADOR;
            }
            break;
        }
        return rol;
    }

    public LocalDate modifech() {
        try {
            boolean error = false;
            do {
                DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                String fecha = JOptionPane.showInputDialog("Ingrese la fecha de nacimiento del jugador (dd/mm/yyyy)");
                LocalDate fechaInicio = LocalDate.parse(fecha, formato);

                return fechaInicio;
            } while (!error);

        } catch (DateTimeException e) {
            JOptionPane.showMessageDialog(null, "Fecha incorrecta");
        }
        return null;

    }
}
