package Modelo;

import java.util.List;

public class EquipoDAO {
    private List<Equipo> equipos;

    public EquipoDAO(List<Equipo> equipos) {
        this.equipos = new ArrayList();
        equipos.add(new Equipo("E1", "Team A"));
        equipos.add(new Equipo("E2", "Team B"));
        equipos.add(new Equipo("E3", "Team C"));
        equipos.add(new Equipo("E4", "Team D"));
        equipos.add(new Equipo("E5", "Team E"));
    }

    public void insertar(Equipo equipos){
        equipos.add(equipo);
    }
  
    public void borrar(Equipo opcion_Elejida){
        equipos.remove(opcion_Elejida);
    }
  
    public List<Equipo> obtenerEquipos() {
        return equipos;
    }
}
