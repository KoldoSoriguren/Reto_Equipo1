package Modelo;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    public Equipo obtenerEquipo(String idEquipo){
        Optional<Equipo> buscarequip= equipos.stream().filter(equipoABuscar-> equipoABuscar.getCodEquipo().equals(idEquipo)).findFirst();
        return buscarequip.orElse(null);
    }
    public void añadirjugador( Jugador jugador, String idEquipo){
        Optional<Equipo> buscarequip= equipos.stream().filter(equipoABuscar-> equipoABuscar.getCodEquipo().equals(idEquipo)).findFirst();
        buscarequip.get().añadirJugador(jugador);


    }
}
