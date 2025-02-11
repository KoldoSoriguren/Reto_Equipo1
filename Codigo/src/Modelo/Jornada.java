package Modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Jornada {
    private String codJornada;
    private String resultado;
    private Date fechaJornada;
    private Competicion competicion;
    private List<Enfrentamiento> ListaEnfrentamientos;

    public Jornada() {
    }

    public Jornada(String cod_jornada, Date fecha_jornada, String resultado) {
        this.codJornada = cod_jornada;
        this.fechaJornada = fecha_jornada;
        this.resultado = resultado;
    }

    public Jornada(String codJornada, LocalDate fecha) {
        this.codJornada = codJornada;
        this.fechaJornada = fechaJornada;
        this.ListaEnfrentamientos = new ArrayList<>();
    }

    public void addEnfrentamiento(Enfrentamiento enfrentamiento) {
        ListaEnfrentamientos.add(enfrentamiento);
    }

//  Getter and Setter
    public String getCod_jornada() {
        return codJornada;
    }

    public void setCod_jornada(String cod_jornada) {
        this.codJornada = cod_jornada;
    }

    public Date getFecha_jornada() {
        return fechaJornada;
    }

    public void setFecha_jornada(Date fecha_jornada) {
        this.fechaJornada = fecha_jornada;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public List<Enfrentamiento> getListaEnfrentamientos() {
        return ListaEnfrentamientos;
    }

    public void setListaEnfrentamientos(List<Enfrentamiento> listaEnfrentamientos) {
        ListaEnfrentamientos = listaEnfrentamientos;
    }

    public String mostrarJornada() {
        StringBuilder sb = new StringBuilder("Jornada ").append(codJornada).append(" - Fecha: ").append(fechaJornada).append("\n");
        for (Enfrentamiento e : ListaEnfrentamientos) {
            sb.append("- ").append(e).append("\n");
        }
        return sb.toString();
    }
}
