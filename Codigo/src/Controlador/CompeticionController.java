package Controlador;

import Excepcion.DatoNoValido;
import Modelo.Competicion;
import Modelo.CompeticionDAO;
import Modelo.Jornada;

import javax.swing.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CompeticionController {
    private CompeticionDAO competicionDAO;

    public CompeticionController(CompeticionDAO competicionDAO) {
        this.competicionDAO = competicionDAO;
    }
    public void agregarCompeticion() {
        try{
            Competicion c=solicitarValidarDato();
            competicionDAO.agregarCompeticion(c);
            JOptionPane.showMessageDialog(null,"Competicion agregada correctamente");
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"Error al agregar Competicion");
        }

    }
    public void modificarCompeticion(){
        boolean continuar=true;
        while(continuar){
            try{
                String cod=validarDato("cod","Introduzca el código de la competicion ha modificar","^[0-9]{4}$");
                Competicion comp=competicionDAO.buscarCompeticion(cod);
                if(comp==null){
                    JOptionPane.showMessageDialog(null,"Competicion no encontrado");
                    continuar=true;
                }
                String nombre=validarDato("nombre","Introduzca el nuevo nombre de la competicion","^[A-Z][a-z]*$");
                comp.setNombre(nombre);

                LocalDate fechaInic=parsearFecha(validarDato("fechaInicio","Introduzca la nueva fecha de inicio","^[0-9]{2}/[0-9]{2}/[0-9]{4}$"));
                comp.setFecha_inicia(fechaInic);

                LocalDate fechaFin=parsearFecha(validarDato("fechaFin","Introduzca la nueva fecha de fin","^[0-9]{2}/[0-9]{2}/[0-9]{4}$"));
                comp.setFecha_fin(fechaFin);

                String estado = validarDato("Estado", "Ingrese el nuevo estado (Activo/Inactivo)", "^(Activo|Inactivo)$");
                comp.setEstado(estado);

                competicionDAO.modificarCompeticion(comp);
                JOptionPane.showMessageDialog(null,"Competicion modificada correctamente");
                continuar=false;
            }catch (Exception e){
                JOptionPane.showMessageDialog(null,"Error al modificar Competicion");
            }
        }

    }
    public void eliminarCompeticion(){
        boolean continuar=true;
        while(continuar){
            try{
                String cod=validarDato("codigo","Introduzca el codigo de la competicion ha eliminar","^[0-9]{4}");
                Competicion c=competicionDAO.buscarCompeticion(cod);
                if(c==null){
                    JOptionPane.showMessageDialog(null,"Competicion no encontrado");
                    continuar=true;
                }
                competicionDAO.eliminarCompeticion(c);
                JOptionPane.showMessageDialog(null,"Competicion eliminada correctamente");
                continuar=false;
            }catch (Exception e){
                JOptionPane.showMessageDialog(null,"Error al eliminar Competicion");
            }
        }
    }
    public void mostrarCompeticiones(){
        competicionDAO.listarCompeticiones();
    }

    public Competicion solicitarValidarDato(){
        String cod=validarDato("codigo","Introduzca el codigo de la competicion","^[0-9]{4}$");
        String nombre=validarDato("nombre","Introduzca el nombre de la competicion","^[A-Z][a-z]*$");
        LocalDate fecha_inicia=parsearFecha(validarDato("fechaInicio","Introduzca la fecha de inicio","^[0-9]{2}/[0-9]{2}/[0-9]{4}$"));
        LocalDate fecha_fin=parsearFecha(validarDato("fechaFin","Introduzca la fecha de fin","^[0-9]{2}/[0-9]{2}/[0-9]{4}$"));
        if(fecha_fin.isBefore(fecha_inicia)){
            JOptionPane.showMessageDialog(null,"La fecha fin no puede ser anterior a la inicio");
            solicitarValidarDato();
        }
        String estado = validarDato("Estado", "Ingrese el estado de la competición (Activo/Inactivo)", "^(Activo|Inactivo)$");

        return new Competicion(cod,nombre,fecha_inicia,fecha_fin,estado);
    }
    public String validarDato(String dato,String mensaje, String expresionRegular){
        String variable="";
        boolean continuar=true;
        while (continuar){
            try{
                variable=JOptionPane.showInputDialog(null,mensaje);
                if(variable.isEmpty()){
                    throw new DatoNoValido(dato+" es un campo obligatorio");
                }
                Pattern pattern = Pattern.compile(expresionRegular);
                Matcher matcher = pattern.matcher(variable);
                if(!matcher.matches()){
                    throw new DatoNoValido(dato+" no tiene un fomarto adecuado");
                }
                continuar=false;
            }catch (DatoNoValido e){
                JOptionPane.showMessageDialog(null,e.getMessage());
                continuar=true;
            }
        }
        return variable;
    }
    public LocalDate parsearFecha(String fecha){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return LocalDate.parse(fecha, dateTimeFormatter);
    }

    }

