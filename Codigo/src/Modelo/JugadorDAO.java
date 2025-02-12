package Modelo;

import Excepcion.DatoNoValido;

import javax.swing.*;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Optional;

public class JugadorDAO {
    private final ArrayList<Jugador> listaJugadores;
    EquipoDAO equipoDAO= new EquipoDAO();

    public JugadorDAO() {
        listaJugadores = new ArrayList<>();
    }

    public void agregarJugador(Jugador j) {
        listaJugadores.add(j);
    }

    public String eliminarJugador(String cod) {
        String mensaje;

        Optional<Jugador> jugador = listaJugadores.stream().filter(jugadorABuscar -> jugadorABuscar.getCodJugador().equals(cod)).findFirst();
        if (jugador.isPresent()) {
            listaJugadores.remove(jugador.get());
            mensaje = "Jugador eliminado";
        }else {
            mensaje = "No existe el jugador";
        }
        return mensaje;

    }

    public Jugador mostrarJugador(String cod) {
        Jugador j;

        Optional<Jugador> jugador = listaJugadores.stream().filter(jugadorABuscar -> jugadorABuscar.getCodJugador().equals(cod)).findFirst();
        if (jugador.isPresent()) {
            j = jugador.get();
        }else{
            j = null;
        }
        return j;
    }

    public String modJugador(String cod, String valor, String propiedad){
        Optional<Jugador> jugador = listaJugadores.stream().filter(jugadorABuscar -> jugadorABuscar.getCodJugador().equals(cod)).findFirst();
        propiedad.toUpperCase();
        if (jugador.isPresent()) {
            switch (propiedad) {
                case "NOMBRE":{
                    String nombrenu = JOptionPane.showInputDialog("Ingrese el nombre del jugador");
                    jugador.get().setNombre(nombrenu);
                }break;
                case "NICKNAME":{
                    String nickname = JOptionPane.showInputDialog("Ingrese el nickname del jugador");
                    jugador.get().setNickname(nickname);
                }break;
                case "APELLIDO":{
                    String apellid=JOptionPane.showInputDialog("Ingrese el apellido del jugador");
                    jugador.get().setApellido(apellid);
                }break;
                case "SUELDO":{
                    Double sueldo=Double.parseDouble(JOptionPane.showInputDialog("Ingrese el sueldo"));
                    jugador.get().setSueldo(sueldo);
                }break;
                case "NACIONALIDAD":{
                    String nacionalidad=JOptionPane.showInputDialog("Ingrese la nacionalidad del jugador");
                    jugador.get().setNacionalidad(nacionalidad);
                }break;
                case "ROL":{
                    Roles rol= modirole(cod,valor,propiedad);
                    jugador.get().setRol(rol);
                }break;
                case "EQUIPO":{
                        String codiequip=JOptionPane.showInputDialog("Ingrese el codigo del equipo del jugador");
                        equipoDAO.eliminarjugador(jugador.get(),codiequip);
                        jugador.get().setEquipo(equipoDAO.obtenerEquipo(codiequip));
                        equipoDAO.añadirjugador(jugador.get(),codiequip);


                }break;
                case "FECHANACIMIENTO":{
                    jugador.get().setFechaNacimiento(modifech());
                }break;
            }
        }else{
            JOptionPane.showMessageDialog(null, "No existe el jugador");
        }
        return null; // Temporal, WIP
    }
    public Roles modirole(String cod, String valor, String propiedad){
       Roles rol=null;

       propiedad.toUpperCase();
       switch (valor) {
           case "DUELISTA":{
               rol=Roles.DUELISTA;
           }break;
           case "INICIADOR":{
                rol = Roles.INICIADOR;
           }break;
           case "CONTROLADOR":{
               rol = Roles.CENTINELA;
           }break;
           case "CENTINELA":{
               rol=Roles.CONTROLADOR;
           }break;
       }



       return rol;
    }
    public LocalDate modifech(){
        try {
            boolean error=false;
            do {
                DateTimeFormatter formato= DateTimeFormatter.ofPattern("dd/MM/yyyy");
                String fecha=JOptionPane.showInputDialog("Ingrese la fecha de nacimiento del jugador en dormato dd/mm/yyyy");
                LocalDate fechaInicio=LocalDate.parse(fecha, formato);

                return fechaInicio;
            }while (!error);

        }catch (DateTimeException e) {
            JOptionPane.showMessageDialog(null, "Fecha incorrecta");
        }
        return null;

    }
}
