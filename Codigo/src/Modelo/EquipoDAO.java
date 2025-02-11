package Modelo;

import java.util.List;

public class EquipoDAO {
    private List<Equipo> equipos;
    
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
