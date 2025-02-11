package Controlador;

import Modelo.Jugador;
import Modelo.JugadorDAO;

import javax.swing.*;
import java.util.regex.Pattern;

public class JugadorController {
    private JugadorDAO  jugadorDAO;

    public JugadorController(JugadorDAO jugadorDAO) {
        this.jugadorDAO = jugadorDAO;
    }
    public void añadirJugador() {
        Jugador j = new Jugador();
        boolean error= true;
        do {
            String codigo=JOptionPane.showInputDialog("Ingrese el codigo del jugador");
            if (codigo.matches("[a-zA-Z]\\w*")) {
                error= false;
            }else{
                JOptionPane.showMessageDialog(null, "El codigo del jugador no es valido");
            }
        }while(error);
        error=true;

        do {
            String nombre=JOptionPane.showInputDialog("Ingrese el nombre");
            if (nombre.matches("^[A-Z][a-z]+$")) {
                error= false;
            }else{
                JOptionPane.showMessageDialog(null, "El nombre del jugador no es valido");
            }
        }while(error);
        error=true;
        do {
            String nickname=JOptionPane.showInputDialog("Ingrese el nickname");

        }while(error);
    }

}
