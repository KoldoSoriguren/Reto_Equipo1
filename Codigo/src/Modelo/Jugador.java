package Modelo;

import java.time.LocalDate;

public class Jugador {
    private String codJugador;
    private String nombre;
    private String apellido;
    private String nacionalidad;
    private LocalDate fechaNacimiento;
    private String nickname;
    private Roles rol;
    private double sueldo;
    private Equipo equipo;

    public Jugador(String codJugador, String nombre, String apellido, String nacionalidad, LocalDate fechaNacimiento,
                   String nickname, Roles rol, double sueldo) {
        this.codJugador = codJugador;
        this.nombre = nombre;
        this.apellido = apellido;
        this.nacionalidad = nacionalidad;
        this.fechaNacimiento = fechaNacimiento;
        this.nickname = nickname;
        this.rol = rol;
        this.sueldo = sueldo;
    }

    public Jugador() {
    }

    //    Funciones:
    private Roles validarRol(String rolIngresado) {
        for (Roles r : Roles.values()) {
            if (r.name().equalsIgnoreCase(rolIngresado)) {
                return r;
            }
        }
        throw new IllegalArgumentException("Rol no válido: " + rolIngresado);
    }

    //    Getter and Setter:
    public String getCodJugador() {
        return codJugador;
    }

    public void setCodJugador(String codJugador) {
        this.codJugador = codJugador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Roles getRol() {
        return rol;
    }

    public void setRol(Roles rol) {
        this.rol = rol;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }
}
