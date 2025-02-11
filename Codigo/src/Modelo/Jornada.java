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
    private List<Enfrentamiento> enfrentamientos;

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
        this.enfrentamientos = new ArrayList<>();
    }

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

    public String mostrarJornada() {
        StringBuilder sb = new StringBuilder("Jornada ").append(codJornada).append(" - Fecha: ").append(fechaJornada).append("\n");
        for (Enfrentamiento e : enfrentamientos) {
            sb.append("- ").append(e).append("\n");
        }
        return sb.toString();
    }
}
