package Controlador;

import Modelo.JornadaDAO;

public class JornadaController {
    private JornadaDAO jornadaDAO;

    public JornadaController(JornadaDAO jornadaDAO) {
        this.jornadaDAO = jornadaDAO;
    }

    public void generarJornada() {
        try {
            int numJornadas = Integer.parseInt(JOptionPane.showInputDialog("¿Cuántas jornadas deseas generar?"));

            jornadaDAO.generarJornadas(numJornadas, equipoDAO.obtenerEquipos(), enfrentamientosDAO);

        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
}
