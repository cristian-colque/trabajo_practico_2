package ar.edu.unju.fi.ejercicio01.main;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio01.model.Producto;
import ar.edu.unju.fi.ejercicio01.model.Producto.Categoria;
import ar.edu.unju.fi.ejercicio01.model.Producto.OrigenFabricacion;

public class Main {
	private static ArrayList<Producto> productos = new ArrayList<>();
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);

	        int opcion;
	        do {
	            System.out.println("Menú de opciones:");
	            System.out.println("1 – Crear Producto");
	            System.out.println("2 – Mostrar productos");
	            System.out.println("3 – Modificar producto");
	            System.out.println("4 – Salir");
	            System.out.println("Elija una opción:");

	            opcion = scanner.nextInt();
	            scanner.nextLine();

	            switch (opcion) {
	                case 1:
	                    crearProducto(scanner);
	                    break;
	                case 2:
	                    mostrarProductos();
	                    break;
	                case 3:
	                    modificarProducto(scanner);
	                    break;
	                case 4:
	                    System.out.println("Saliendo del programa...");
	                    break;
	                default:
	                    System.out.println("Opción inválida. Por favor, elija una opción válida.");
	            }
	        } while (opcion != 4);
	    }

	private static void modificarProducto(Scanner scanner) {
		int valor = 0;
		System.out.println("Ingrese el codigo del producto a modificar");
		String codigo = solicitarCodigo(scanner);    
	     for (Producto producto : productos) {
	            if(producto.getCodigo().equals(codigo)) {
	            	 
	            	String descripcion = solicitarDescripcion(scanner);
	        	    producto.setDescripcion(descripcion);
	        	    double precioUnitario = solicitarPrecioUnitario(scanner);
	        	    producto.setPrecioUnitario(precioUnitario);
	        	    OrigenFabricacion origenFabricacion = solicitarOrigenFabricacion(scanner);
	        	    producto.setOrigenFabricacion(origenFabricacion);
	        	    Categoria categoria = solicitarCategoria(scanner);
	        	    producto.setCategoria(categoria);
	        	    valor = 1;
	             }
	         }
	     String mensaje = (valor == 1) ? "Producto modificado ..." : "Producto no encontrado";
	     System.out.println(mensaje);
	}
	private static void crearProducto(Scanner scanner) {
        String codigo = solicitarCodigo(scanner);
        String descripcion = solicitarDescripcion(scanner);
        double precioUnitario = solicitarPrecioUnitario(scanner);
        OrigenFabricacion origenFabricacion = solicitarOrigenFabricacion(scanner);
        Categoria categoria = solicitarCategoria(scanner);

        Producto nuevoProducto = new Producto(codigo, descripcion, precioUnitario,
                origenFabricacion, categoria);
        productos.add(nuevoProducto);
        System.out.println("Producto creado exitosamente.");
    }

    private static String solicitarCodigo(Scanner scanner) {
        System.out.print("Código: ");
        return scanner.nextLine();
    }

    private static String solicitarDescripcion(Scanner scanner) {
        System.out.print("Descripción: ");
        return scanner.nextLine();
    }

    private static double solicitarPrecioUnitario(Scanner scanner) {
        double precioUnitario = 0;
        boolean band = false;
        while (!band) {
            try {
                System.out.print("Precio unitario: ");
                precioUnitario = scanner.nextDouble();
                band = true;
            } catch (InputMismatchException e) {
                System.out.println("Error: Debes ingresar un número válido.");
                scanner.nextLine();
            }
        }
        return precioUnitario;
    }

    private static OrigenFabricacion solicitarOrigenFabricacion(Scanner scanner) {
        System.out.println("Origen de fabricación:");
        for (OrigenFabricacion origen : OrigenFabricacion.values()) {
            System.out.println((origen.ordinal() + 1) + " - " + origen);
        }
        System.out.print("Elija una opción: ");
        int origenIndex = scanner.nextInt();
        scanner.nextLine();
        return OrigenFabricacion.values()[origenIndex - 1];
    }

    private static Categoria solicitarCategoria(Scanner scanner) {
        System.out.println("Categoría:");
        for (Categoria categoria : Categoria.values()) {
            System.out.println((categoria.ordinal() + 1) + " – " + categoria);
        }
        System.out.print("Elija una opción: ");
        int categoriaIndex = scanner.nextInt();
        scanner.nextLine(); 
        return Categoria.values()[categoriaIndex - 1];
    }

    private static void mostrarProductos() {
        System.out.println("Lista de productos:");
        for (Producto producto : productos) {
            System.out.println(producto);

        }
    }
}


