package Modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class Competicion {
    private String cod_compe;
    private String nombre;
    private LocalDate fecha_inicia;
    private LocalDate fecha_fin;
    private String estado;
    private ArrayList<Jornada> listaJornadas;


    public Competicion(String cod_compe,String nombre, LocalDate fecha_inicia, LocalDate fecha_fin, String estado) {
        this.cod_compe = cod_compe;
        this.nombre = nombre;
        this.fecha_inicia = fecha_inicia;
        this.fecha_fin = fecha_fin;
        this.estado = estado;
    }

    public String getCod_compe() {
        return cod_compe;
    }

    public void setCod_compe(String cod_compe) {
        this.cod_compe = cod_compe;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public LocalDate getFecha_inicia() {
        return fecha_inicia;
    }

    public void setFecha_inicia(LocalDate fecha_inicia) {
        this.fecha_inicia = fecha_inicia;
    }

    public LocalDate getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(LocalDate fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public ArrayList<Jornada> getListaJornadas() {
        return listaJornadas;
    }

    public void setListaJornadas(ArrayList<Jornada> listaJornadas) {
        this.listaJornadas = listaJornadas;
    }

    public void agregarJornada(Jornada j) {
        if(listaJornadas == null) {
            listaJornadas = new ArrayList<>();
        }
        listaJornadas.add(j);
    }
}
