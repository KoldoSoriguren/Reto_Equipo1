package Controlador;

import Modelo.JornadaDAO;

public class JornadaController {
    private JornadaDAO jornadaDAO;

    public JornadaController(JornadaDAO jornadaDAO) {
        this.jornadaDAO = jornadaDAO;
    }
}
