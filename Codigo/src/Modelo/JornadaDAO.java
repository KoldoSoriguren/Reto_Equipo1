package Modelo;

import javax.swing.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

public class JornadaDAO {
    private final List<Jornada> ListaJornadas;
    private final Random rand = new Random();

    public JornadaDAO() {
        this.ListaJornadas = new ArrayList<Jornada>();
    }

    public void generarJornadas(int numJornadas, List<Equipo> equipos, EnfrentamientoDAO enfrentamientoDAO) {
        for (int i = 1; i <= numJornadas; i++) {
            Jornada jornada = new Jornada("J" + i, LocalDate.now().plusDays(i));
            Set<String> enfrentados = new HashSet<>();
            LocalTime horaInicial = LocalTime.of(10, 0);

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
            ListaJornadas.add(jornada);
        }

        mostrarJornadas();
    }

    public void mostrarJornadas() {
        StringBuilder mensajeFinal = new StringBuilder("JORNADAS GENERADAS\n\n");
        for (Jornada j : ListaJornadas) {
            mensajeFinal.append(j.mostrarJornada()).append("\n");
        }

        JOptionPane.showMessageDialog(null, mensajeFinal.toString(), "Jornadas", JOptionPane.INFORMATION_MESSAGE);
    }
}
