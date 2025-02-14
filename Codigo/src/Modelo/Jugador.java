package Modelo;

import Excepcion.DatoNoValido;

import java.time.LocalDate;

public class Jugador {
    private String dni;
    private String nombre;
    private String apellidos;
    private String nacionalidad;
    private LocalDate fechaNacimiento;
    private String nickname;
    private Roles rol;
    private double sueldo;
    private Equipo equipo;

    public Jugador(String codJugador, String nombre, String apellido, String nacionalidad, LocalDate fechaNacimiento,
                   String nickname, Roles rol, double sueldo, Equipo equipo) {
        this.dni = codJugador;
        this.nombre = nombre;
        this.apellidos = apellido;
        this.nacionalidad = nacionalidad;
        this.fechaNacimiento = fechaNacimiento;
        this.nickname = nickname;
        this.rol = rol;
        this.sueldo = sueldo;
        this.equipo = equipo;
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
    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
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

    public double setSueldo(double sueldo) {
        try {
            if (sueldo >= 1184)
                this.sueldo = sueldo;
            else
                throw new DatoNoValido("El sueldo no puede ser inferior al SMI (1184 €)");
        } catch (DatoNoValido e) {
            this.sueldo = sueldo;
        }
        return sueldo;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }
}
