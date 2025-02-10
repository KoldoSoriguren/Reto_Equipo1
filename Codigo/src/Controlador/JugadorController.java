package Controlador;

import Modelo.JugadorDAO;

public class JugadorController {
    private JugadorDAO  jugadorDAO;

    public JugadorController(JugadorDAO jugadorDAO) {
        this.jugadorDAO = jugadorDAO;
    }

}
