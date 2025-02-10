package Controlador;

import Modelo.CompeticionDAO;

public class CompeticionController {
    private CompeticionDAO competicionDAO;

    public CompeticionController(CompeticionDAO competicionDAO) {
        this.competicionDAO = competicionDAO;
    }
}
