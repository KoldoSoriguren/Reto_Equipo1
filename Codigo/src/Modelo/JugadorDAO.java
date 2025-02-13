package Modelo;

import Controlador.EquipoController;

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
            equipoDAO.eliminarJugador(jugador.get(), jugador.get().getEquipo().getCodEquipo());
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
        String mensaje="";
        Optional<Jugador> jugador = listaJugadores.stream().filter(jugadorABuscar -> jugadorABuscar.getCodJugador().equals(cod)).findFirst();
        propiedad.toUpperCase();
        if (jugador.isPresent()) {
            switch (propiedad) {
                case "NOMBRE":{

                    jugador.get().setNombre(valor);
                    mensaje = "Jugador actualizado";
                }break;
                case "NICKNAME":{

                    jugador.get().setNickname(valor);
                    mensaje = "Jugador actualizado";
                }break;
                case "APELLIDO":{

                    jugador.get().setApellido(valor);
                    mensaje = "Jugador actualizado";
                }break;
                case "SUELDO":{
                    Double salario= Double.valueOf(valor);
                    jugador.get().setSueldo(salario);
                    mensaje = "Jugador actualizado";
                }break;
                case "NACIONALIDAD":{
                    jugador.get().setNacionalidad(valor);
                    mensaje = "Jugador actualizado";
                }break;
                case "ROL":{
                    Roles rol= modirole(cod,valor,propiedad);
                    jugador.get().setRol(rol);
                    mensaje = "Jugador actualizado";
                }break;
                case "EQUIPO":{
                        equipoDAO.eliminarJugador(jugador.get(),valor);
                        jugador.get().setEquipo(equipoDAO.obtenerEquipo(valor));
                        equipoDAO.añadirJugador(jugador.get(),valor);
                        if (jugador.get().getEquipo() == null) {
                            mensaje = "Equipo no encontrado tu jugador se declarara como agente libre";
                        }


                }break;
                case "FECHANACIMIENTO":{
                    jugador.get().setFechaNacimiento(modifech());
                    mensaje = "Jugador actualizado";
                }break;
            }
        }else{
            mensaje = "No existe el jugador";
        }
        return mensaje;
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
