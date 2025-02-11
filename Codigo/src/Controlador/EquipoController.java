package Controlador;

import Excepción.DatoNoValido;
import Modelo.Equipo;
import Modelo.EquipoDAO;
import javax.swing.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EquipoController {
    private final EquipoDAO equipoDAO;

    public EquipoController() {}

    public EquipoController(EquipoDAO equipoDAO) {
        this.equipoDAO = equipoDAO;
    }

    public void insertar() {
        try {
            Equipo equipo = solicitarValidacionDeDatos();
            equipoDAO.insertar(equipo);
            JOptionPane.showMessageDialog(null, "Equipo insertado correctamente","Baja Completada", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al dar de alta al equipo","Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void modificar(ArrayList<Equipo> equipos) {
        Equipo[] opciones = equipos.toArray(new Equipo[0]);

        Equipo opcion_Elejida = (Equipo) JOptionPane.showInputDialog(null, "Elija a que equipo le quiere modificar los datos", "Modificación", JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);

        opcion_Elejida.setNombreEquipo(solicitarDato("Nombre", "Introduce el nuevo nombre del equipo", "^[A-Z][a-z]+(?:\\s[A-Z][a-z]+)*$"));
        opcion_Elejida.setFecha_fun( convertirLocalDate( solicitarDato("Fecha de fundación", "Introduce la nueva fecha de fundación del equipo", "^[A-Z][a-z]+(?:\\s[A-Z][a-z]+)*$")));

        JOptionPane.showMessageDialog(null, "Se han modificado los datos del equipo correctamente");
    }

    public void borrar() {
        Equipo[] opciones = equipos.toArray(new Equipo[0]);

        Equipo opcion_Elejida = (Equipo) JOptionPane.showInputDialog(null, "Elije a que equipo le quieres dar de baja", "Dar de Baja", JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
        equipoDAO.borrar(opcion_Elejida); equipos.remove(opcion_Elejida);

        JOptionPane.showMessageDialog(null, "Se ha dado de baja al abogado con exito", "Baja Completada", JOptionPane.INFORMATION_MESSAGE);
    }

    public void mostrar(ArrayList<Equipo> equipos) {
        JOptionPane.showMessageDialog(null, equipos);
    }


    public Equipo solicitarValidacionDeDatos() {
        String codigo = solicitarDato("Código", "Introduce el código del equipo", "^$");
        String nombre = solicitarDato("Nombre", "Introduce el nombre del equipo", "^$");
        LocalDate fecha = convertirLocalDate(solicitarDato("Fecha de fundación", "Introduce la fecha en la que se fundo el equipo", "^$"));
        return new Equipo(codigo, nombre, fecha);
    }

    public String solicitarDato(String dato, String mensaje, String expresionRegular) {
        String variable = "";
        boolean validacion;
        do {
            try {
                variable = JOptionPane.showInputDialog(mensaje);
                if (variable.isEmpty())
                    throw new DatoNoValido(dato + " es un campo obligatorio a rellenar");
                Pattern pat = Pattern.compile(expresionRegular);
                Matcher mat = pat.matcher(variable);
                if (!mat.matches())
                    throw new DatoNoValido(dato + " no se ha introducido de forma correcta");
                validacion = false;
            } catch (DatoNoValido e) {
                validacion = true;
                JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        } while (!validacion);
        return variable;
    }

    public LocalDate convertirLocalDate(String fecha) {
        DateTimeFormatter formato;
        formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return LocalDate.parse(fecha, formato);
    }
}
