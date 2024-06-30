package ar.edu.unju.fi.ejercicio07.main;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import ar.edu.unju.fi.ejercicio01.model.Producto;
import ar.edu.unju.fi.ejercicio01.model.Producto.Categoria;


public class Main {

    private static List<Producto> productos = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Precarga de productos
        cargarProductos();

        // Menú interactivo
        int opcion;
        do {
            mostrarMenu();
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    mostrarProductosDisponibles();
                    break;
                case 2:
                    mostrarProductosFaltantes();
                    break;
                case 3:
                    incrementarPrecios();
                    break;
                case 4:
                    mostrarProductosElectrohogarDisponibles();
                    break;
                case 5:
                    ordenarProductosPorPrecioDescendente();
                    break;
                case 6:
                    mostrarNombresEnMayusculas();
                    break;
                case 7:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        } while (opcion != 7);

        scanner.close();
    }

    // Método para mostrar el menú de opciones
    private static void mostrarMenu() {
        System.out.println("\nMenú de opciones:");
        System.out.println("1 – Mostrar productos disponibles");
        System.out.println("2 – Mostrar productos no disponibles");
        System.out.println("3 – Incrementar los precios de los productos en un 20%");
        System.out.println("4 – Mostrar productos de la categoría Electrohogar disponibles");
        System.out.println("5 – Ordenar los productos por precio de forma descendente");
        System.out.println("6 - Mostrar los nombres de los productos en mayúsculas");
        System.out.println("7 - Salir");
        System.out.print("Seleccione una opción: ");
    }

    // Método para cargar los productos iniciales
    private static void cargarProductos() {
        productos.add(new Producto("001", "Lavadora", 15000.0, Categoria.ELECTROHOGAR, true));
        productos.add(new Producto("002", "Televisor", 25000.0, Categoria.TELEFONIA, true));
        productos.add(new Producto("003", "Batidora", 3000.0, Categoria.ELECTROHOGAR, false));
        productos.add(new Producto("004", "Secadora", 18000.0, Categoria.ELECTROHOGAR, true));
        productos.add(new Producto("005", "Router", 1200.0, Categoria.INFORMATICA, true));
        productos.add(new Producto("006", "Computadora", 35000.0, Categoria.INFORMATICA, true));
        productos.add(new Producto("007", "Martillo", 500.0, Categoria.HERRAMIENTAS, true));
        productos.add(new Producto("008", "Taladro", 800.0, Categoria.HERRAMIENTAS, false));
        productos.add(new Producto("009", "Plancha", 1500.0, Categoria.ELECTROHOGAR, true));
        productos.add(new Producto("010", "Microondas", 4500.0, Categoria.ELECTROHOGAR, false));
        productos.add(new Producto("011", "Teléfono", 3000.0, Categoria.TELEFONIA, true));
        productos.add(new Producto("012", "Silla", 700.0, Categoria.ELECTROHOGAR, false));
        productos.add(new Producto("013", "Mesa", 1200.0, Categoria.ELECTROHOGAR, true));
        productos.add(new Producto("014", "Impresora", 4000.0, Categoria.INFORMATICA, true));
        productos.add(new Producto("015", "Escritorio", 6000.0, Categoria.INFORMATICA, false));
    }

    // Opción 1: Mostrar productos disponibles usando Consumer
    private static void mostrarProductosDisponibles() {
        System.out.println("Productos disponibles:");
        Consumer<Producto> consumer = p -> {
            if (p.isEstado()) {
                System.out.println(p);
            }
        };
        productos.forEach(consumer);
    }

    // Opción 2: Mostrar productos no disponibles usando Predicate y filter
    private static void mostrarProductosFaltantes() {
        System.out.println("Productos no disponibles:");
        Predicate<Producto> predicate = p -> !p.isEstado();
        productos.stream()
                 .filter(predicate)
                 .forEach(System.out::println);
    }

    // Opción 3: Incrementar los precios de los productos en un 20% usando Function y map
    private static void incrementarPrecios() {
        System.out.println("Incrementando precios en un 20%:");
        Function<Producto, Producto> function = p -> {
            p.setPrecioUnitario(p.getPrecioUnitario() * 1.2);
            return p;
        };
        List<Producto> productosIncrementados = productos.stream()
                                                        .map(function)
                                                        .collect(Collectors.toList());
        productosIncrementados.forEach(System.out::println);
    }

    // Opción 4: Mostrar productos de la categoría Electrohogar disponibles usando Predicate y filter
    private static void mostrarProductosElectrohogarDisponibles() {
        System.out.println("Productos de la categoría Electrohogar disponibles:");
        Predicate<Producto> predicate = p -> p.getCategoria() == Categoria.ELECTROHOGAR && p.isEstado();
        productos.stream()
                 .filter(predicate)
                 .forEach(System.out::println);
    }

    // Opción 5: Ordenar los productos por precio de forma descendente usando sort y Comparator
    private static void ordenarProductosPorPrecioDescendente() {
        System.out.println("Productos ordenados por precio de forma descendente:");
        Comparator<Producto> comparator = Comparator.comparing(Producto::getPrecioUnitario).reversed();
        productos.stream()
                 .sorted(comparator)
                 .forEach(System.out::println);
    }

    // Opción 6: Mostrar los nombres de los productos en mayúsculas usando Function y map
    private static void mostrarNombresEnMayusculas() {
        System.out.println("Nombres de los productos en mayúsculas:");
        Function<Producto, String> function = p -> p.getDescripcion().toUpperCase();
        productos.stream()
                 .map(function)
                 .forEach(System.out::println);
    }
}
