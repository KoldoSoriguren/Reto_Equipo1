package Modelo;

import javax.swing.*;
import java.util.ArrayList;

public class CompeticionDAO {
    private ArrayList<Competicion> listaCompeticiones;
    private ArrayList<Jornada> listaJornadas;
    public CompeticionDAO() {
        listaCompeticiones = new ArrayList<>();
        listaJornadas = new ArrayList<>();
    }
    public void agregarCompeticion(Competicion competicion) {
        listaCompeticiones.add(competicion);
    }
    public void modificarCompeticion(Competicion competicion) {
        boolean continuar=true;
        while(continuar) {
            for(Competicion comp : listaCompeticiones ) {
                if(comp.getCod_compe().equals(competicion.getCod_compe())) {
                    comp.setNombre(competicion.getNombre());
                    comp.setFecha_inicia(competicion.getFecha_inicia());
                    comp.setFecha_fin(competicion.getFecha_fin());
                    comp.setEstado(competicion.getEstado());
                continuar=false;
                }
            }
        }
    }
    public void eliminarCompeticion(Competicion competicion) {
        listaCompeticiones.remove(competicion);
    }

    public Competicion buscarCompeticion(String cod) {
        for(Competicion competicion : listaCompeticiones) {
            if(competicion.getCod_compe().equals(cod)) {
                return competicion;
            }
        }
        return null;
    }
    public void listarCompeticiones() {
        StringBuilder sbCompes = new StringBuilder("Listado de competiciones:\n\n");

        for (Competicion competicion : listaCompeticiones) {
            sbCompes.append("Competición: ").append(competicion.getCod_compe()).append("\n");

            if (competicion.getListaJornadas() != null && !competicion.getListaJornadas().isEmpty()) {
                sbCompes.append("Jornadas:\n");
                for (Jornada jornada : competicion.getListaJornadas()) {
                    sbCompes.append(" - ").append(jornada.toString()).append("\n");
                }
            } else {
                sbCompes.append("Sin jornadas registradas\n");
            }

            sbCompes.append("\n");
        }
        JOptionPane.showMessageDialog(null, sbCompes.toString());
    }
    public StringBuilder listaGanador(String codigo){
        StringBuilder listaGanador = new StringBuilder();
        for (int i = 0; i < listaCompeticiones.size(); i++) {
            if (listaCompeticiones.get(i).getCod_compe().equals(codigo)) {
                listaGanador.append("Competicion ");
                listaGanador.append(listaCompeticiones.get(i).getNombre()).append("\n");
                for (int j=0; j<listaCompeticiones.get(i).getListaJornadas().size(); j++) {
                    listaGanador.append(listaCompeticiones.get(i).getListaJornadas().get(j).getCodJornada()).append("\n");
                    for (int k=0; j<listaCompeticiones.get(i).getListaJornadas().get(j).getListaEnfrentamientos().size(); k++) {
                        listaGanador.append("Enfrentamiento").append(listaCompeticiones.get(i).getListaJornadas().get(j).getListaEnfrentamientos().get(k).getCodEnfrentamiento()).append("\n");
                        listaGanador.append(listaCompeticiones.get(i).getListaJornadas().get(j).getListaEnfrentamientos().get(k).getEquipo1()).append(" vs ");
                        listaGanador.append(listaCompeticiones.get(i).getListaJornadas().get(j).getListaEnfrentamientos().get(k).getEquipo2()).append("\n");
                        listaGanador.append("Resultado").append(listaCompeticiones.get(i).getListaJornadas().get(j).getListaEnfrentamientos().get(k).getResultado()).append("\n");
                        listaGanador.append("fecha:").append(listaCompeticiones.get(i).getListaJornadas().get(j).getFechaJornada()).append("/");
                        listaGanador.append(listaCompeticiones.get(i).getListaJornadas().get(j).getListaEnfrentamientos().get(k).getHora());

                    }
                }
            }

        }


        if(listaGanador.isEmpty()) {
            listaGanador.append("No se ha encontrado la competicion");
        }
        return listaGanador;



    }

}
