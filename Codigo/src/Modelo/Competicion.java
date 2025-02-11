package Modelo;

import java.util.Date;

public class Competicion {
    private String cod_compe;
    private Date fecha_compe;
    private String estado;
    private Date fecha_fin;
    private Jornada jornada;
    public Competicion() {

    }

    public Competicion(String cod_compe, Date fecha_fin, String estado, Date fecha_compe) {
        this.cod_compe = cod_compe;
        this.fecha_fin = fecha_fin;
        this.estado = estado;
        this.fecha_compe = fecha_compe;
    }

    public String getCod_compe() {
        return cod_compe;
    }

    public void setCod_compe(String cod_compe) {
        this.cod_compe = cod_compe;
    }

    public Date getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(Date fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFecha_compe() {
        return fecha_compe;
    }

    public void setFecha_compe(Date fecha_compe) {
        this.fecha_compe = fecha_compe;
    }
}
