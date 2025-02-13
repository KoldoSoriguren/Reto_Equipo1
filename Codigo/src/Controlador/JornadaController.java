package Controlador;

import Modelo.EnfrentamientoDAO;
import Modelo.EquipoDAO;
import Modelo.Jornada;
import Modelo.JornadaDAO;

import javax.swing.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class JornadaController {
    private final JornadaDAO jornadaDAO;
    private final EquipoDAO equipoDAO;
    private final EnfrentamientoDAO enfrentamientoDAO;

    public JornadaController(JornadaDAO jornadaDAO, EquipoDAO equipoDAO, EnfrentamientoDAO enfrentamientoDAO) {
        this.jornadaDAO = jornadaDAO;
        this.equipoDAO = equipoDAO;
        this.enfrentamientoDAO = enfrentamientoDAO;
    }

    public void generarJornada() {
        try {
            int numJornadas = Integer.parseInt(JOptionPane.showInputDialog("¿Cuántas jornadas deseas generar?"));

            jornadaDAO.generarJornadas(numJornadas, equipoDAO.obtenerEquipos(), enfrentamientoDAO);

        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void borrarJornada() {
        try {
            String codJornada = JOptionPane.showInputDialog(null, "Escribe el código de jornada que deseas borrar");

            jornadaDAO.eliminarJornadaPorCod(codJornada);
            
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error " + e);
        }
    }

    public void modificarJornada() {
        DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        try {
            String codJornada = JOptionPane.showInputDialog(null, "Escribe el código de jornada que deseas modificar");

            LocalDate fechaModificada = LocalDate.parse(JOptionPane.showInputDialog(null, "Introduce la nueva fecha de la jornada (dd/MM/yyyy)"), formatoFecha);

            Jornada j = new Jornada(codJornada, fechaModificada);

            jornadaDAO.modificarJornadaPorCod(j);

        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error " + e);
        }
    }

    public void mostrarJornadas() {
        jornadaDAO.mostrarJornadas();
    }
}
