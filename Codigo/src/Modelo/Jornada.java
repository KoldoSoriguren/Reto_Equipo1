package Modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Jornada {
    private String codJornada;
    private String resultado;
    private LocalDate fechaJornada;
    private Competicion competicion;
    private List<Enfrentamiento> ListaEnfrentamientos;

    public Jornada() {
    }

    public Jornada(String cod_jornada, LocalDate fechaJornada, String resultado) {
        this.codJornada = cod_jornada;
        this.fechaJornada = fechaJornada;
        this.resultado = resultado;
    }

    public Jornada(String codJornada, LocalDate fechaJornada) {
        this.codJornada = codJornada;
        this.fechaJornada = fechaJornada;
        this.ListaEnfrentamientos = new ArrayList<>();
    }

    public void addEnfrentamiento(Enfrentamiento enfrentamiento) {
        ListaEnfrentamientos.add(enfrentamiento);
    }

//  Getter and Setter
    public String getCodJornada() {
        return codJornada;
    }

    public void setCodJornada(String cod_jornada) {
        this.codJornada = cod_jornada;
    }

    public LocalDate getFechaJornada() {
        return fechaJornada;
    }

    public void setFechaJornada(LocalDate fecha_jornada) {
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
