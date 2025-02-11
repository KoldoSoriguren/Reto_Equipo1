package Modelo;

import java.util.ArrayList;
import java.util.List;

public class EquipoDAO {
    private final List<Equipo> equipos;

    public EquipoDAO() {
        this.equipos = new ArrayList<>();
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
