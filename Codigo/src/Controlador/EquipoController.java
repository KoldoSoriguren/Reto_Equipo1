package Controlador;

import Modelo.EquipoDAO;
import Modelo.JugadorDAO;

public class EquipoController {
    private EquipoDAO eqiopoDAO;

    public EquipoController(EquipoDAO eqiopoDAO) {
        this.eqiopoDAO = eqiopoDAO;
    }
}
