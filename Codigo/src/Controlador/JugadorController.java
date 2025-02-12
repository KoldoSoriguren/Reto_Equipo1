package Controlador;

import Excepcion.DatoNoValido;
import Modelo.*;

import javax.swing.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JugadorController {
    private final JugadorDAO jugadorDAO;
    public JugadorController(JugadorDAO jugadorDAO) {
        this.jugadorDAO = jugadorDAO;
    }

    public void altaValidarDatosJugador(){
        EquipoDAO equipoDAO = new EquipoDAO();
        Equipo equip;
        String[] optsRoles = {
                "DUELISTA", "INICIADOR", "CONTROLADOR", "CENTINELA"
        };
        Roles roles= null;
        String codJugador = solicitarDatos("codJugador","Ingrese el dni del jugador","^[0-9]{8}[A-Z]$");
        String nombre = solicitarDatos("nombre","Ingrese el nombre del jugador","^[A-Z][a-z]*$");
        String apellido = solicitarDatos("apellido","Ingrese el apellido del jugador","^[A-Z][a-z]*$");
        String nacionalidad = solicitarDatos("nacionalidad","Ingrese el nacionalidad del jugador",null);
        LocalDate fechaNac = formatearFecha(solicitarDatos("fechaNac","Ingrese el fecha del nacimiento dd/MM/yyyy",null));
        String nickname = solicitarDatos("nickname","Ingrese el nickname del jugador", null);
        String opcionStr = (String) JOptionPane.showInputDialog(null, "Selecciona rol",
                "Menú", JOptionPane.QUESTION_MESSAGE, null, optsRoles, optsRoles[0]);

        if (opcionStr != null) {
            int opcion = Arrays.asList(optsRoles).indexOf(opcionStr);

            switch (opcion) {
                case 0 -> roles=Roles.DUELISTA;
                case 1 -> roles=Roles.INICIADOR;
                case 2 -> roles=Roles.CONTROLADOR;
                case 3 -> roles=Roles.CENTINELA;
            }
        }

        boolean error = true;
        do {
            String codi =JOptionPane.showInputDialog("Ingresa el codigo de equipo que le quieres insertar al jugador");
             equip=equipoDAO.obtenerEquipo(codi);
            if (equip == null) {
                JOptionPane.showMessageDialog(null, "El equipo no existe");
            }else{
                error = false;
            }

        }while (error);


        double sueldo = Double.parseDouble(solicitarDatos("sueldo", "Ingrese el sueldo del jugador", "^[0-9]+(\\.[0-9]{1,2})?$"));

        Jugador j = new  Jugador(codJugador,nombre,apellido,nacionalidad,fechaNac,nickname,roles,sueldo,equip);
        equipoDAO.añadirjugador(j,j.getEquipo().getCodEquipo());
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
        String propiedad;
        String cod = JOptionPane.showInputDialog("Ingrese el código del jugador");
        boolean error=true;
        do {
            propiedad = JOptionPane.showInputDialog("Ingrese la propiedad del jugador que quieres cambiar");
            if(propiedad.equalsIgnoreCase("duelista")||propiedad.equalsIgnoreCase("controlador")||propiedad.equalsIgnoreCase("iniciador")||propiedad.equalsIgnoreCase("centinela")){
                error=false;
            }
        }while(error);

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
