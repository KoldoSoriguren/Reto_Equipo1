package Controlador;

import Modelo.EquipoDAO;

import javax.swing.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Pattern;

public class EquipoController {
    private EquipoDAO equipoDAO;

    public EquipoController(EquipoDAO equipoDAO) {
        this.equipoDAO = equipoDAO;
    }

    public void altaEquipo() {
        try {
            altaDatosEquipo();

        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al dar de alta al equipo");
        }
    }

    private void altaDatosEquipo() {
        String nombreEquipo, respuesta=null, respuestaEquipo, fechaMin ="01/01/1970";
        LocalDate fechaFundado;
        int numTotalJugadores=0;
        StringBuilder datosEquipo = new StringBuilder();
        boolean respuestaBoolean, respuestaEquipoBoolean;

        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Pattern patronEquipo = Pattern.compile("^[A-Z][a-z]+$");
        LocalDate fechasEs=LocalDate.parse(fechaMin,formato);
    }
}
