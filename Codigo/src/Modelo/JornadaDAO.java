package Modelo;

import java.time.LocalDate;
import java.util.*;

public class JornadaDAO {
    private List<Jornada> jornadas;
    private Random rand = new Random();

    public JornadasDAO() {
        jornadas = new ArrayList<>();
    }

    public void generarJornadas(int numJornadas, List<Equipo> equipos, EnfrentamientosDAO enfrentamientosDAO) {
        for (int i = 1; i <= numJornadas; i++) {
            Jornada jornada = new Jornada("J" + i, LocalDate.now().plusDays(i));
            Set<String> enfrentados = new HashSet<>();
            LocalTime horaInicial = LocalTime.of(10, 0);

            while (jornada.enfrentamientos.size() < equipos.size() / 2) {
                Equipo e1 = equipos.get(rand.nextInt(equipos.size()));
                Equipo e2 = equipos.get(rand.nextInt(equipos.size()));

                if (!e1.equals(e2) && !enfrentados.contains(e1.getNombre() + e2.getNombre()) &&
                        !enfrentados.contains(e2.getNombre() + e1.getNombre())) {

                    Enfrentamiento enf = new Enfrentamiento("E" + i + jornada.enfrentamientos.size(), e1, e2, horaInicial);
                    jornada.addEnfrentamiento(enf);
                    enfrentamientosDAO.guardarEnfrentamiento(enf);
                    enfrentados.add(e1.getNombre() + e2.getNombre());
                    enfrentados.add(e2.getNombre() + e1.getNombre());
                    horaInicial = horaInicial.plusHours(2);
                }
            }
            jornadas.add(jornada);
        }

        mostrarJornadas();
    }

    public void mostrarJornadas() {
        StringBuilder mensajeFinal = new StringBuilder("JORNADAS GENERADAS\n\n");
        for (Jornada j : jornadas) {
            mensajeFinal.append(j.mostrarJornada()).append("\n");
        }

        JOptionPane.showMessageDialog(null, mensajeFinal.toString(), "Jornadas", JOptionPane.INFORMATION_MESSAGE);
    }
}
