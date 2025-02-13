package Modelo;

import java.util.ArrayList;
import java.util.List;

public class EnfrentamientoDAO {
    private final List<Enfrentamiento> ListaEnfrentamientos;

    public EnfrentamientoDAO() {
        ListaEnfrentamientos = new ArrayList<Enfrentamiento>();
    }

    public void guardarEnfrentamientos(Enfrentamiento e){
        ListaEnfrentamientos.add(e);
    }

    public List<Enfrentamiento> getListaEnfrentamientos() {
        return ListaEnfrentamientos;
    }

    public void agregarResultados(){

    }
}
