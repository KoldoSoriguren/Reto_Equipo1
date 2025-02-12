package Controlador;

import Modelo.EnfrentamientoDAO;
import Modelo.EquipoDAO;
import Modelo.Jornada;
import Modelo.JornadaDAO;

import javax.swing.*;

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

    public void mostrarJornadas() {
        jornadaDAO.mostrarJornadas();
    }
}
