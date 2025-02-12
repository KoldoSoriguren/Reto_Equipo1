package Controlador;

import Excepcion.DatoNoValido;
import Modelo.Jugador;
import Modelo.JugadorDAO;
import Modelo.Roles;

import javax.swing.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JugadorController {
    private final JugadorDAO jugadorDAO;

    public JugadorController(JugadorDAO jugadorDAO) {
        this.jugadorDAO = jugadorDAO;
    }

    public void altaValidarDatosJugador(){
        String codJugador = solicitarDatos("codJugador","Ingrese el código del jugador","^[0-9]{8}-[A-Z]$");
        String nombre = solicitarDatos("nombre","Ingrese el nombre del jugador","^[A-Z][a-z]*$");
        String apellido = solicitarDatos("apellido","Ingrese el apellido del jugador","^[A-Z][a-z]*$");
        String nacionalidad = solicitarDatos("nacionalidad","Ingrese el nacionalidad del jugador","Copy string literal text to the clipboard");
        LocalDate fechaNac = formatearFecha(solicitarDatos("fechaNac","Ingrese el fecha del nacimiento","^[0-9]{2}/[0-9][2}/[0-9]{4}$"));
        String nickname = solicitarDatos("nickname","Ingrese el nickname del jugador","Copy string literal text to the clipboard");

        String rol = solicitarDatos("rol", "Ingrese el rol del jugador (iniciador, duelista, controlador, centinela):", "^[A-Za-z]+$");
        Roles roles = validarRol(rol);

        double sueldo = Double.parseDouble(solicitarDatos("sueldo", "Ingrese el sueldo del jugador", "^[0-9]+(\\.[0-9]{1,2})?$"));

        Jugador j = new  Jugador(codJugador,nombre,apellido,nacionalidad,fechaNac,nickname,roles,sueldo);

        jugadorDAO.agregarJugador(j);
    }

    private String solicitarDatos(String dato, String mensaje, String exprRegular){
        String variable = "";
        boolean continuar = true;

        while(continuar){
            try{
                variable = JOptionPane.showInputDialog(mensaje);

                if(variable.isEmpty()){
                    throw new DatoNoValido(dato + " es un campo obligatorio");
                }

                Pattern pattern=Pattern.compile(exprRegular);
                Matcher matcher=pattern.matcher(variable);
                if(!matcher.matches()){
                    throw new DatoNoValido(dato + " no tiene un formato adecuado");
                }

                continuar = false;

            }catch (DatoNoValido e){
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
        return variable;
    }

    public void eliminarJugador(){
        String cod = JOptionPane.showInputDialog("Ingrese el código del jugador que quieres borrar");
        String mensaje = jugadorDAO.eliminarJugador(cod);

        JOptionPane.showMessageDialog(null,mensaje);
    }
    public void mostrarJugador(){
        String cod = JOptionPane.showInputDialog("Ingrese el código del jugador que quieres ver");
        Jugador j = jugadorDAO.mostrarJugador(cod);

        if(j == null){
            JOptionPane.showMessageDialog(null,"El jugador no existe");
        }else{
            JOptionPane.showMessageDialog(null,j.toString());
        }
    }
    public void modificarJugador(){
        String cod = JOptionPane.showInputDialog("Ingrese el código del jugador");
        String propiedad = JOptionPane.showInputDialog("Ingrese la propiedad del jugador que quieres cambiar");
        String valor = JOptionPane.showInputDialog("Ingrese el valor");

        String mensaje = jugadorDAO.modJugador(cod,propiedad,valor);

    }

//    Validaciones:
    public LocalDate formatearFecha(String fecha){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return LocalDate.parse(fecha, formatter);
    }

    public Roles validarRol(String rol){
        try{
            if(rol.isEmpty()){
                throw new DatoNoValido("El rol es obligatorio");
            }
            return Roles.valueOf(rol.toUpperCase());

        }catch (DatoNoValido e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
        return null;
    }
}
