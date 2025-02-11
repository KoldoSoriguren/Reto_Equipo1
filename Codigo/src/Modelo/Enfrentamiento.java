package Modelo;

import java.time.LocalTime;

public class Enfrentamiento {
    private String codEnfrentamiento;
    private String string;
    private LocalTime hora;
    private Equipo equipo1;
    private Equipo equipo2;

    public Enfrentamiento() {
    }

    public Enfrentamiento(String codEnfrentamiento, Equipo equipo1, Equipo equipo2, LocalTime hora) {
        this.codEnfrentamiento = codEnfrentamiento;
        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
        this.hora = hora;
    }

    public String getCodEnfrentamiento() {
        return codEnfrentamiento;
    }

    public void setCodEnfrentamiento(String codEnfrentamiento) {
        this.codEnfrentamiento = codEnfrentamiento;
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

    public Equipo getEquipo1() {
        return equipo1;
    }

    public void setEquipo1(Equipo equipo1) {
        this.equipo1 = equipo1;
    }

    public Equipo getEquipo2() {
        return equipo2;
    }

    public void setEquipo2(Equipo equipo2) {
        this.equipo2 = equipo2;
    }

    public String toString(){
        return equipo1.getNombreEquipo() + " vs " + equipo2.getNombreEquipo() + " Hora: " + hora;
    }
}
