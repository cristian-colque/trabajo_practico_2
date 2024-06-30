package ar.edu.unju.fi.ejercicio04;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;
import ar.edu.unju.fi.ejercicio04.constantes.Posicion;
import ar.edu.unju.fi.ejercicio04.model.Jugador;

public class Main {
    static ArrayList<Jugador> jugadores = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;
        do {
            System.out.println("1 – Alta de jugador");
            System.out.println("2 – Mostrar todos los jugadores");
            System.out.println("3 – Modificar la posición de un jugador");
            System.out.println("4 – Eliminar un jugador");
            System.out.println("5 – Salir");
            System.out.print("Seleccione una opción: ");

            try {
                opcion = scanner.nextInt();
                scanner.nextLine();
                switch (opcion) {
                    case 1:
                        altaJugador();
                        break;
                    case 2:
                        mostrarJugadores();
                        break;
                    case 3:
                        modificarPosicion();
                        break;
                    case 4:
                        eliminarJugador();
                        break;
                    case 5:
                        System.out.println("Saliendo del programa...");
                        break;
                    default:
                        System.out.println("Opción no válida.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Por favor, ingrese un número válido.");
                scanner.nextLine(); 
                opcion = 0; 
            }

        } while (opcion != 5);

        scanner.close();
    }

    public static void altaJugador() {
        System.out.print("Ingrese nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese apellido: ");
        String apellido = scanner.nextLine();
        System.out.print("Ingrese fecha de nacimiento (yyyy-MM-dd): ");
        LocalDate fechaNacimiento = LocalDate.parse(scanner.nextLine());
        System.out.print("Ingrese nacionalidad: ");
        String nacionalidad = scanner.nextLine();
        System.out.print("Ingrese estatura: ");
        double estatura = scanner.nextDouble();
        System.out.print("Ingrese peso: ");
        double peso = scanner.nextDouble();
        scanner.nextLine(); 
        System.out.print("Ingrese posición (DELANTERO, MEDIO, DEFENSA, ARQUERO): ");
        String posicionStr = scanner.nextLine().toUpperCase();
        Posicion posicion = Posicion.valueOf(posicionStr);

        Jugador jugador = new Jugador(nombre, apellido, fechaNacimiento, nacionalidad, estatura, peso, posicion);
        jugadores.add(jugador);
        System.out.println("Jugador añadido correctamente.");
    }

    public static void mostrarJugadores() {
        if (jugadores.isEmpty()) {
            System.out.println("No hay jugadores registrados.");
        } else {
            System.out.println("Jugadores:");
            for (Jugador jugador : jugadores) {
                System.out.println(jugador);
            }
        }
    }

    public static void modificarPosicion() {
        if (jugadores.isEmpty()) {
            System.out.println("No hay jugadores registrados.");
            return;
        }

        System.out.print("Ingrese nombre del jugador: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese apellido del jugador: ");
        String apellido = scanner.nextLine();

        boolean encontrado = false;
        for (Jugador jugador : jugadores) {
            if (jugador.getNombre().equalsIgnoreCase(nombre) && jugador.getApellido().equalsIgnoreCase(apellido)) {
                System.out.print("Ingrese nueva posición (DELANTERO, MEDIO, DEFENSA, ARQUERO): ");
                String posicionStr = scanner.nextLine().toUpperCase();
                Posicion nuevaPosicion = Posicion.valueOf(posicionStr);
                jugador.setPosicion(nuevaPosicion);
                System.out.println("Posición modificada correctamente.");
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("Jugador no encontrado.");
        }
    }

    public static void eliminarJugador() {
        if (jugadores.isEmpty()) {
            System.out.println("No hay jugadores registrados.");
            return;
        }

        System.out.print("Ingrese nombre del jugador: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese apellido del jugador: ");
        String apellido = scanner.nextLine();

        Iterator<Jugador> iter = jugadores.iterator();
        boolean encontrado = false;
        while (iter.hasNext()) {
            Jugador jugador = iter.next();
            if (jugador.getNombre().equalsIgnoreCase(nombre) && jugador.getApellido().equalsIgnoreCase(apellido)) {
                iter.remove();
                System.out.println("Jugador eliminado correctamente.");
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("Jugador no encontrado.");
        }
    }
}