package Modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EquipoDAO {
    private final ArrayList<Equipo> equipos;

    public EquipoDAO() {
        this.equipos = new ArrayList<>();
    }

    public ArrayList<Equipo> getEquipos() {
        return equipos;
    }

    public void insertar(Equipo equipo){
        equipos.add(equipo);
    }
  
    public void borrar(Equipo opcionElegida){
        equipos.remove(opcionElegida);
    }
  
    public List<Equipo> obtenerEquipos() {
        return equipos;
    }
}
