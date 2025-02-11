package Modelo;

import java.time.LocalTime;

public class Enfrentamiento {
    private String cod_emfrentamiento;
    private String string;
    private LocalTime hora;

    public Enfrentamiento() {
    }

    public Enfrentamiento(String cod_emfrentamiento, LocalTime hora, String string) {
        this.cod_emfrentamiento = cod_emfrentamiento;
        this.hora = hora;
        this.string = string;
    }

    public String getCod_emfrentamiento() {
        return cod_emfrentamiento;
    }

    public void setCod_emfrentamiento(String cod_emfrentamiento) {
        this.cod_emfrentamiento = cod_emfrentamiento;
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }
}
