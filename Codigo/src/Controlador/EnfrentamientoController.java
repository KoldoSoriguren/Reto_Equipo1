package Controlador;

import Modelo.Enfrentamiento;
import Modelo.EnfrentamientoDAO;

import javax.swing.*;
import java.util.Arrays;
import java.util.List;

public class EnfrentamientoController {
    private EnfrentamientoDAO enfrentamientoDAO;

    public EnfrentamientoController(EnfrentamientoDAO enfrentamientoDAO) {
        this.enfrentamientoDAO = enfrentamientoDAO;
    }

    public void modificar() {
        
    }

    public void agregarResultados() {
        List<Enfrentamiento> lista = enfrentamientoDAO.getListaEnfrentamientos();
        if (lista.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay enfrentamientos disponibles.");
            return;
        }

        // Convertir enfrentamientos en un array.
        String[] opciones = lista.stream().map(Enfrentamiento::toString).toArray(String[]::new);

        String seleccion = (String) JOptionPane.showInputDialog(null, "Seleccione un enfrentamiento:",
                "Seleccionar Enfrentamiento", JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);

        if (seleccion != null) {
            int index = lista.indexOf(lista.stream().filter(e -> e.toString().equals(seleccion)).findFirst().orElse(null));

            if (index != -1) {
                String resultado = JOptionPane.showInputDialog("Ingrese el resultado del enfrentamiento:");
                if (resultado != null && !resultado.isEmpty()) {
                    lista.get(index).setResultado(resultado);
                    JOptionPane.showMessageDialog(null, "Resultado actualizado correctamente.");
                } else {
                    JOptionPane.showMessageDialog(null, "Debe ingresar un resultado válido.");
                }
            }
        }
    }
}
