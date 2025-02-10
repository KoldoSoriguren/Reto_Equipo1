package Modelo;

import java.util.Date;

public class Jornada {
    private String cod_jornada;
    private String resultado;
    private Date fecha_jornada;

    public Jornada() {
    }

    public Jornada(String cod_jornada, Date fecha_jornada, String resultado) {
        this.cod_jornada = cod_jornada;
        this.fecha_jornada = fecha_jornada;
        this.resultado = resultado;
    }

    public String getCod_jornada() {
        return cod_jornada;
    }

    public void setCod_jornada(String cod_jornada) {
        this.cod_jornada = cod_jornada;
    }

    public Date getFecha_jornada() {
        return fecha_jornada;
    }

    public void setFecha_jornada(Date fecha_jornada) {
        this.fecha_jornada = fecha_jornada;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }
}
