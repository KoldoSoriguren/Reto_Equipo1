package Modelo;

import java.util.ArrayList;
import java.util.List;

public class EnfrentamientoDAO {
    private List<Enfrentamiento> enfrentamientos;
    public EnfrentamientoDAO() {
        enfrentamientos = new ArrayList<Enfrentamiento>();
    }
    public void guardarEnfrentamientos(Enfrentamiento e){
        enfrentamientos.add(e);
    }
    public List<Enfrentamiento> getEnfrentamientos() {
        return enfrentamientos;
    }
}
