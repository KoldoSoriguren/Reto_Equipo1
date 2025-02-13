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
    private final EquipoDAO equipoDAO;

    public JugadorController(JugadorDAO jugadorDAO, EquipoDAO equipoDAO) {
        this.jugadorDAO = jugadorDAO;
        this.equipoDAO = equipoDAO;
    }

    public void altaValidarDatosJugador(){
        Equipo equipo;
        Roles roles= null;
        String[] optsRoles = {
                "DUELISTA", "INICIADOR", "CONTROLADOR", "CENTINELA"
        };

        String codJugador = solicitarDatos("codJugador","Ingrese el dni del jugador","^[0-9]{8}[A-Z]$");
        String nombre = solicitarDatos("nombre","Ingrese el nombre del jugador","^[A-Z][a-z]*$");
        String apellido = solicitarDatos("apellido","Ingrese el apellido del jugador","^[A-Z][a-z]*$");
        String nacionalidad = solicitarDatos("nacionalidad","Ingrese el nacionalidad del jugador","^[A-Z][a-z]*$");
        LocalDate fechaNac = formatearFecha(solicitarDatos("fechaNac","Ingrese el fecha del nacimiento dd/MM/yyyy","^[0-9]{2}/[0-9]{2}/[0-9]{4}"));
        String nickname = solicitarDatos("nickname","Ingrese el nickname del jugador", "^[A-Z][a-z]*$");
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
            String codi = JOptionPane.showInputDialog("Ingresa el código de equipo que le quieres insertar al jugador");
             equipo = equipoDAO.obtenerEquipo(codi);

            if (equipo == null) {
                JOptionPane.showMessageDialog(null, "El equipo no existe");

            }else{
                error = false;
            }
        }while (error);

        double sueldo = Double.parseDouble(solicitarDatos("sueldo", "Ingrese el sueldo del jugador", "^[0-9]+(\\.[0-9]{1,2})?$"));

        Jugador j = new  Jugador(codJugador,nombre,apellido,nacionalidad,fechaNac,nickname,roles,sueldo, equipo);
        equipoDAO.agregarJugador(j);
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
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String nuevoDato;

        String cod = JOptionPane.showInputDialog("Ingrese el código del jugador");
        propiedad = JOptionPane.showInputDialog("Ingrese la propiedad del jugador que quieres cambiar");
        boolean error = true;
        double sal;

        do {
            nuevoDato = JOptionPane.showInputDialog("Ingrese el nuevo dato");
            propiedad.toLowerCase();

             switch(propiedad){
                 case "nombre":{
                     if(nuevoDato.matches("^[A-Z][a-z]*$")){
                         error=false;
                     }else{
                         JOptionPane.showMessageDialog(null,"Nombre no valido");
                     }
                 }break;

                 case "nickname":{
                     if (nuevoDato.isEmpty()){
                         JOptionPane.showMessageDialog(null,"El nickname del jugador no puede ser vació");
                     }else{
                         error=false;
                     }
                 } break;

                 case "apellido":{
                     if(nuevoDato.matches("^[A-Z][a-z]*$")){
                         error=false;
                     }else{
                         JOptionPane.showMessageDialog(null,"Apellido no valido");
                     }
                 } break;

                 case "nacionalidad":{
                     if(nuevoDato.matches("^[A-Z][a-z]*$")){
                         error=false;
                     }else{
                         JOptionPane.showMessageDialog(null,"Nacionalidad no valida");
                     }

                 } break;

                 case "fechaNacimiento":{
                     if (nuevoDato.matches(String.valueOf(formatter))){
                         error=false;
                     }else{
                         JOptionPane.showMessageDialog(null,"La fecha no es valida");
                     }
                 } break;

                 case "role": {
                     if (nuevoDato.equalsIgnoreCase("duelista") ||
                             propiedad.equalsIgnoreCase("controlador") ||
                             propiedad.equalsIgnoreCase("iniciador") ||
                             propiedad.equalsIgnoreCase("centinela"))
                     {
                     error=false;

                     }else{
                         JOptionPane.showMessageDialog(null,"Rol no valido");
                     }
                 } break;

                 case "sueldo":{
                    if (nuevoDato.matches("^[A-Z][a-z]*$")){
                        sal=Double.parseDouble(nuevoDato);
                        if (sal>1184.00){
                            error=false;
                        }else{
                            JOptionPane.showMessageDialog(null,"Sueldo menor al salario mínimo");
                        }
                    }else{
                        JOptionPane.showMessageDialog(null,"Formato de sueldo no valido");
                    }
                 } break;

                 case "equipo":{
                     if (nuevoDato.matches("^[0-9]{4}$")){
                         error=false;
                     }else {
                         JOptionPane.showMessageDialog(null,"No es valido el código de ese equipo");
                     }
                 } break;
             }

        }while(error);

        String mensaje = jugadorDAO.modJugador(cod, propiedad, nuevoDato);

        JOptionPane.showMessageDialog(null, mensaje);
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
