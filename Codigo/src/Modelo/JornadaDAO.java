package Modelo;

import javax.swing.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

public class JornadaDAO {
    private final List<Jornada> listaJornadas;
    private final Random rand = new Random();

    public JornadaDAO() {
        this.listaJornadas = new ArrayList<Jornada>();
    }

    public void generarJornadas(int numJornadas, List<Equipo> equipos, EnfrentamientoDAO enfrentamientoDAO) {
        for (int i = 1; i <= numJornadas; i++) {
            LocalDate fechaJornada = LocalDate.now().plusDays(i);
            String codJornada = String.format("J-%04d", i); // Código de 4 dígitos

            Jornada jornada = new Jornada(codJornada, fechaJornada);
            Set<String> enfrentados = new HashSet<>();
            LocalTime horaInicial = LocalTime.of(9, 0);

            while (jornada.getListaEnfrentamientos().size() < equipos.size() / 2) {
                Equipo e1 = equipos.get(rand.nextInt(equipos.size()));
                Equipo e2 = equipos.get(rand.nextInt(equipos.size()));

                if (!e1.equals(e2) && !enfrentados.contains(e1.getNombreEquipo() + e2.getNombreEquipo()) &&
                        !enfrentados.contains(e2.getNombreEquipo() + e1.getNombreEquipo())) {

                    Enfrentamiento enf = new Enfrentamiento("E" + i + jornada.getListaEnfrentamientos().size(), e1, e2, horaInicial);
                    jornada.addEnfrentamiento(enf);
                    enfrentamientoDAO.guardarEnfrentamientos(enf);
                    enfrentados.add(e1.getNombreEquipo() + e2.getNombreEquipo());
                    enfrentados.add(e2.getNombreEquipo() + e1.getNombreEquipo());
                    horaInicial = horaInicial.plusHours(2);
                }
            }
            listaJornadas.add(jornada);
        }
    }

    public void eliminarJornadaPorCod(String codJornada) {
        Optional<Jornada> jornadaAEliminar = listaJornadas.stream()
                .filter(j -> j.getCodJornada().equals(codJornada))
                .findFirst();

        if (jornadaAEliminar.isPresent()) {
            listaJornadas.remove(jornadaAEliminar.get());
        }
    }


    public void mostrarJornadas() {
        StringBuilder mensajeFinal = new StringBuilder("JORNADAS GENERADAS\n");
        for (Jornada j : listaJornadas) {
            mensajeFinal.append(j.mostrarJornada()).append("\n");
        }

        JOptionPane.showMessageDialog(null, mensajeFinal.toString(), "Jornadas", JOptionPane.INFORMATION_MESSAGE);
    }

    private Optional<Jornada> buscarJornadaPorCod(String codJornada) {
        Optional<Jornada> buscarJornada = listaJornadas.stream().filter(jornadaABuscar-> jornadaABuscar.getCodJornada().equals(codJornada)).findFirst();
        return buscarJornada;
    }
}
