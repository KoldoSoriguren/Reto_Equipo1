package Modelo;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EquipoDAO {
    private final ArrayList<Equipo> listaEquipos;

    public EquipoDAO() {
        this.listaEquipos = new ArrayList<>();
    }
  
    public List<Equipo> obtenerEquipos() {
        return listaEquipos;
    }

    public void altaEquipo(Equipo equipo) {
        listaEquipos.add(equipo);
    }

    public void bajaEquipo(Equipo equipo) {
        listaEquipos.remove(equipo);
    }

    private Optional<Equipo> buscarEquipoPorCod(String idEquipo){
         Optional<Equipo> buscarEquip = listaEquipos.stream().filter(equipoABuscar-> equipoABuscar.getCodEquipo().equals(idEquipo)).findFirst();
         return buscarEquip;
    }

    public Equipo obtenerEquipo(String idEquipo){
        Optional<Equipo> buscarEquip = buscarEquipoPorCod(idEquipo);
        return buscarEquip.orElse(null);
    }

    public void añadirJugador(Jugador jugador, String idEquipo){
        Optional<Equipo> buscarEquip = buscarEquipoPorCod(idEquipo);
        buscarEquip.get().añadirJugador(jugador);
    }

    public void eliminarJugador(Jugador jugador, String idEquipo){
        Optional<Equipo> buscarEquip = buscarEquipoPorCod(idEquipo);
        buscarEquip.get().eliminarJugador(jugador);
    }
}

