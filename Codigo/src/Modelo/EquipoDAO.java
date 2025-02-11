package Modelo;

import java.util.ArrayList;

public class EquipoDAO {

    public ArrayList<Equipo> equipos = new ArrayList<Equipo>();

    public void insertar(Equipo equipo){
        equipos.add(equipo);
    }
    public void borrar(Equipo opcion_Elejida){
        equipos.remove(opcion_Elejida);
    }

}
