package ar.edu.unju.fi.ejercicio02.main;

import java.util.ArrayList;
import java.util.Scanner;
import ar.edu.unju.fi.ejercicio02.constantes.Mes;
import ar.edu.unju.fi.ejercicio02.model.Efemeride;


public class Main {
    
    private static ArrayList<Efemeride> efemerides = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;

        do {
            System.out.println("1 - Crear efeméride");
            System.out.println("2 - Mostrar efemérides");
            System.out.println("3 - Eliminar efeméride");
            System.out.println("4 - Modificar efeméride");
            System.out.println("5 - Salir");
            System.out.print("Seleccione una opción: ");
            
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea después de nextInt()

            switch (opcion) {
                case 1:
                    crearEfemeride();
                    break;
                case 2:
                    mostrarEfemerides(efemerides);
                    break;
                case 3:
                    eliminarEfemeride();
                    break;
                case 4:
                    modificarEfemeride();
                    break;
                case 5:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        } while (opcion != 5);

        scanner.close(); 
    }

    public static void crearEfemeride() {
        System.out.print("Ingrese el código: ");
        int codigo = scanner.nextInt();
        
        System.out.print("Ingrese el número del mes (1-12): ");
        int mesNum = scanner.nextInt();
        while (mesNum < 1 || mesNum > 12) {
            System.out.println("Número de mes no válido. Ingrese un valor entre 1 y 12.");
            mesNum = scanner.nextInt();
        }
        Mes mes = Mes.values()[mesNum - 1];
        
        System.out.print("Ingrese el día: ");
        int dia = scanner.nextInt();
        scanner.nextLine(); 
        System.out.print("Ingrese el detalle: ");
        String detalle = scanner.nextLine();
        
        Efemeride efemeride = new Efemeride(codigo, mes, dia, detalle);
        efemerides.add(efemeride);
        System.out.println("Efeméride creada correctamente.");
    }

    public static void mostrarEfemerides(ArrayList<Efemeride> efemerides) {
        if (efemerides.isEmpty()) {
            System.out.println("No hay efemérides para mostrar.");
        } else {
            System.out.println("Efemérides:");
            for (Efemeride efemeride : efemerides) {
                System.out.println(efemeride.getCodigo() + " - " + efemeride.getMes() + " " + efemeride.getDia() + ": " + efemeride.getDetalle());
            }
        }
    }

    public static void eliminarEfemeride() {
        if (efemerides.isEmpty()) {
            System.out.println("No hay efemérides para eliminar.");
        } else {
            mostrarEfemerides(efemerides);
            System.out.print("Ingrese el código de la efeméride a eliminar: ");
            int codigo = scanner.nextInt();
            boolean eliminado = false;
            for (int i = 0; i < efemerides.size(); i++) {
                if (efemerides.get(i).getCodigo() == codigo) {
                    efemerides.remove(i);
                    eliminado = true;
                    System.out.println("Efeméride eliminada correctamente.");
                    break;
                }
            }
            if (!eliminado) {
                System.out.println("No se encontró ninguna efeméride con ese código.");
            }
        }
    }

    public static void modificarEfemeride() {
        if (efemerides.isEmpty()) {
            System.out.println("No hay efemérides para modificar.");
        } else {
            mostrarEfemerides(efemerides);
            System.out.print("Ingrese el código de la efeméride a modificar: ");
            int codigo = scanner.nextInt();
            boolean encontrado = false;
            for (Efemeride efemeride : efemerides) {
                if (efemeride.getCodigo() == codigo) {
                    System.out.println("Modificando efeméride:");
                    System.out.println("1 - Modificar código");
                    System.out.println("2 - Modificar mes");
                    System.out.println("3 - Modificar día");
                    System.out.println("4 - Modificar detalle");
                    System.out.print("Seleccione una opción: ");
                    int opcion = scanner.nextInt();
                    scanner.nextLine(); // Consumir el salto de línea después de nextInt()
                    switch (opcion) {
                        case 1:
                            System.out.print("Nuevo código: ");
                            efemeride.setCodigo(scanner.nextInt());
                            break;
                        case 2:
                            System.out.print("Nuevo número del mes (1-12): ");
                            int mesNum = scanner.nextInt();
                            while (mesNum < 1 || mesNum > 12) {
                                System.out.println("Número de mes no válido. Ingrese un valor entre 1 y 12.");
                                mesNum = scanner.nextInt();
                            }
                            efemeride.setMes(Mes.values()[mesNum - 1]);
                            break;
                        case 3:
                            System.out.print("Nuevo día: ");
                            efemeride.setDia(scanner.nextInt());
                            break;
                        case 4:
                            scanner.nextLine(); // Consumir el salto de línea después de nextInt()
                            System.out.print("Nuevo detalle: ");
                            efemeride.setDetalle(scanner.nextLine());
                            break;
                        default:
                            System.out.println("Opción no válida.");
                            break;
                    }
                    encontrado = true;
                    System.out.println("Efeméride modificada correctamente.");
                    break;
                }
            }
            if (!encontrado) {
                System.out.println("No se encontró ninguna efeméride con ese código.");
            }
        }
    }
}
