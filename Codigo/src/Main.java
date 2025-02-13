import Controlador.*;
import Modelo.*;

import javax.swing.*;
import java.util.Arrays;

public class Main {

    private static JugadorController jugadorController;
    private static EquipoController equipoController;
    private static JornadaController jornadaController;
    private static CompeticionController competicionController;
    private static EnfrentamientoController enfrentamientoController;

    private static JugadorDAO jugadorDAO;
    private static EquipoDAO equipoDAO;
    private static JornadaDAO jornadaDAO;
    private static CompeticionDAO competicionDAO;
    private static EnfrentamientoDAO enfrentamientoDAO;

    public static void main(String[] args) {
        try {
            crearObjetos();
            menu();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public static void crearObjetos() {
        equipoDAO = new EquipoDAO();
        equipoController = new EquipoController(equipoDAO);

        jugadorDAO = new JugadorDAO();
        jugadorController = new JugadorController(jugadorDAO, equipoDAO);

        competicionDAO = new CompeticionDAO();
        competicionController = new CompeticionController(competicionDAO);

        enfrentamientoDAO = new EnfrentamientoDAO();
        enfrentamientoController = new EnfrentamientoController(enfrentamientoDAO);

        jornadaDAO = new JornadaDAO();
        jornadaController = new JornadaController(jornadaDAO, equipoDAO, enfrentamientoDAO);
    }

    public static void menu() {
        boolean terminar = false;

        String[] menuOptsRoles = {
                "Administrador", "Usuario", "Cerrar programa"
        };

        String[] menuOptsTipoAdmin = {
                "CRUD", "Cerrar Etapa", "Generar Calendario", "Introducir resultados", "Ver todos los informes"
        };

        String[] menuOptsCrudAdmin = {
                "Jugadores", "Equipos", "Modificar Enfrentamiento", "Jornada", "Competición"
        };

        String[] menuOptsCrudOptsJugador = {
                "Alta Jugador", "Baja Jugador", "Modificación Jugador", "Mostrar Jugador"
        };

        String[] menuOptsCrudOptsEquipo = {
                "Alta Equipo", "Baja Equipo", "Modificación Equipo", "Mostrar Equipo"
        };

        String[] menuOptsCrudOptsJornada = {
                "Borrar Jornada", "Modificar Jornada", "Mostrar Jornadas"
        };

        String[] menuOptsCrudOptsCompeticion = {
                "Nueva Competición", "Borrar Competición", "Modificar Competición", "Mostrar Competición"
        };

        String[] menuOptsTipoUsuario = {
                "Visualizar equipos con sus jornadas", "Visualizar resultados"
        };

        do {
            String opcionStr = (String) JOptionPane.showInputDialog(null, "Selecciona tu usuario",
                    "Menú", JOptionPane.QUESTION_MESSAGE, null, menuOptsRoles, menuOptsRoles[0]);

            if (opcionStr != null) {
                int opcion = Arrays.asList(menuOptsRoles).indexOf(opcionStr);

                switch (opcion) {
                    case 0: { // Menu para Admin
                        String opcionStr0 = (String) JOptionPane.showInputDialog(null, "Selecciona una opción",
                                "Menú - Administrador", JOptionPane.QUESTION_MESSAGE, null, menuOptsTipoAdmin, menuOptsTipoAdmin[0]);

                        if (opcionStr0 != null) {
                            int opcion0 = Arrays.asList(menuOptsTipoAdmin).indexOf(opcionStr0);

                            switch (opcion0) {
                                case 0: { // CRUD
                                    String opcionStr01 = (String) JOptionPane.showInputDialog(null, "Selecciona una opción",
                                            "Menú - Administrador - CRUD", JOptionPane.QUESTION_MESSAGE, null, menuOptsCrudAdmin, menuOptsCrudAdmin[0]);

                                    if (opcionStr01 != null) {
                                        int opcion01 = Arrays.asList(menuOptsCrudAdmin).indexOf(opcionStr01);

                                        switch (opcion01) {
                                            case 0: {
                                                String opcionStr010 = (String) JOptionPane.showInputDialog(null, "Selecciona una opción",
                                                        "Menú - Administrador - CRUD - Jugador", JOptionPane.QUESTION_MESSAGE, null, menuOptsCrudOptsJugador, menuOptsCrudOptsJugador[0]);

                                                if (opcionStr010 != null) {
                                                    int opcion010 = Arrays.asList(menuOptsCrudOptsJugador).indexOf(opcionStr010);

                                                    switch (opcion010) {
                                                        case 0 ->
                                                                jugadorController.altaValidarDatosJugador(); // Alta jugador
                                                        case 1 ->
                                                                jugadorController.eliminarJugador(); // Eliminar jugador
                                                        case 2 ->
                                                                jugadorController.modificarJugador(); // Modificar jugador
                                                        case 3 -> jugadorController.mostrarJugador(); // Mostrar jugador
                                                    }
                                                }
                                            }
                                            break;
                                            case 1: {
                                                String opcionStr011 = (String) JOptionPane.showInputDialog(null, "Selecciona una opción",
                                                        "Menú - Administrador - CRUD - Equipo", JOptionPane.QUESTION_MESSAGE, null, menuOptsCrudOptsEquipo, menuOptsCrudOptsEquipo[0]);

                                                if (opcionStr011 != null) {
                                                    int opcion011 = Arrays.asList(menuOptsCrudOptsEquipo).indexOf(opcionStr011);

                                                    switch (opcion011) {
                                                        case 0: {
                                                            equipoController.altaValidarDatosEquipo(); // Alta equipo
                                                        }
                                                        break;
                                                        case 1: {
                                                            equipoController.borrar(); // Baja equipo
                                                        }
                                                        break;
                                                        case 2: {
                                                            equipoController.modificar(); // Modificar equipo
                                                        }
                                                        break;
                                                        case 3: {
                                                            equipoController.mostrar(); // Mostrar equipo
                                                        }
                                                        break;
                                                    }
                                                }
                                            }
                                            break;
                                            case 2: {
                                                enfrentamientoController.modificar(); // Modificar Enfrentamiento
                                            }
                                            break;
                                            case 3: {
                                                String opcionStr013 = (String) JOptionPane.showInputDialog(null, "Selecciona una opción",
                                                        "Menú - Administrador - CRUD - Jornada", JOptionPane.QUESTION_MESSAGE, null, menuOptsCrudOptsJornada, menuOptsCrudOptsJornada[0]);

                                                if (opcionStr013 != null) {
                                                    int opcion013 = Arrays.asList(menuOptsCrudOptsJornada).indexOf(opcionStr013);

                                                    switch (opcion013) {
                                                        case 0 -> jornadaController.borrarJornada(); // Borrar Jornada
                                                        case 1 -> jornadaController.modificarJornada(); // Modificar Jornada
                                                        case 2 -> jornadaController.mostrarJornadas(); // Mostrar Jornadas
                                                    }
                                                }
                                            }
                                            break;
                                            case 4: {
                                                String opcionStr011 = (String) JOptionPane.showInputDialog(null, "Selecciona una opción",
                                                        "Menú - Administrador - CRUD - Competición", JOptionPane.QUESTION_MESSAGE, null, menuOptsCrudOptsCompeticion, menuOptsCrudOptsCompeticion[0]);

                                                if (opcionStr011 != null) {
                                                    int opcion011 = Arrays.asList(menuOptsCrudOptsCompeticion).indexOf(opcionStr011);

                                                    switch (opcion011) {
//                                                        case 0 -> // Nueva Competición
//                                                        case 1 -> // Borrar Competición
//                                                        case 2 -> // Modificar Competición
//                                                        case 3 -> // Mostrar Competición
                                                    }
                                                }
                                            }
                                            break;
                                        }
                                    }
                                }break;
//                                case 1: {} // Cerrar Etapa
                                case 2: {
                                  jornadaController.generarJornada(); // Generar Calendario
                                }break;
                                case 3: {
                                    enfrentamientoController.agregarResultados(); // Introducir Resultados
                                }
//                                case 4: {} // Ver todos los informes
                            }
                        }
                    }
                    break;
                    case 1: { // Menu para usuario
                        String opcionStr1 = (String) JOptionPane.showInputDialog(null, "Selecciona una opción",
                                "Menú - Cliente", JOptionPane.QUESTION_MESSAGE, null, menuOptsTipoUsuario, menuOptsTipoUsuario[0]);

                        if (opcionStr1 != null) {
                            int opcion1 = Arrays.asList(menuOptsTipoUsuario).indexOf(opcionStr1);

//                            switch (opcion2) {
//                                case 0 -> // Visualizar equipo con sus jornadas
//                                case 1 -> // Visualizar resultados
//                            }
                        }
                    }
                    break;
                    case 2: {
                        terminar = true;
                    }
                    break;
                    default: {
                        JOptionPane.showMessageDialog(null, "Opción no válida");
                    }
                }
            } else {
                terminar = true;
            }
        } while (!terminar);
    }
}