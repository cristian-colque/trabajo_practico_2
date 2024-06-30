package ar.edu.unju.fi.ejercicio05.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio01.model.Producto;
import ar.edu.unju.fi.ejercicio01.model.Producto.Categoria;
import ar.edu.unju.fi.ejercicio01.model.Producto.OrigenFabricacion;
import ar.edu.unju.fi.ejercicio05.interfaces.Pago;
import ar.edu.unju.fi.ejercicio05.model.PagoEfectivo;
import ar.edu.unju.fi.ejercicio05.model.PagoTarjeta;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Producto> productos = new ArrayList<>();

        productos.add(new Producto("P001", "Smartphone XYZ", 25000, OrigenFabricacion.ARGENTINA, Categoria.TELEFONIA, true));
        productos.add(new Producto("P002", "Laptop ABC", 55000, OrigenFabricacion.CHINA, Categoria.INFORMATICA, true));
        productos.add(new Producto("P003", "Microondas 123", 12000, OrigenFabricacion.BRASIL, Categoria.ELECTROHOGAR, true));
        productos.add(new Producto("P004", "Taladro 456", 8000, OrigenFabricacion.URUGUAY, Categoria.HERRAMIENTAS, true));
        productos.add(new Producto("P005", "Smartwatch DEF", 15000, OrigenFabricacion.ARGENTINA, Categoria.TELEFONIA, true));
        productos.add(new Producto("P006", "Tablet GHI", 22000, OrigenFabricacion.CHINA, Categoria.INFORMATICA, true));
        productos.add(new Producto("P007", "Heladera JKL", 45000, OrigenFabricacion.BRASIL, Categoria.ELECTROHOGAR, true));
        productos.add(new Producto("P008", "Aire Acondicionado MNO", 35000, OrigenFabricacion.URUGUAY, Categoria.ELECTROHOGAR, true));
        productos.add(new Producto("P009", "Impresora PQR", 18000, OrigenFabricacion.ARGENTINA, Categoria.INFORMATICA, true));
        productos.add(new Producto("P010", "Cámara Digital STU", 20000, OrigenFabricacion.CHINA, Categoria.TELEFONIA, true));
        productos.add(new Producto("P011", "Licuadora VWX", 7500, OrigenFabricacion.BRASIL, Categoria.ELECTROHOGAR, true));
        productos.add(new Producto("P012", "Televisor YZA", 30000, OrigenFabricacion.URUGUAY, Categoria.ELECTROHOGAR, true));
        productos.add(new Producto("P013", "Consola de Videojuegos BCD", 40000, OrigenFabricacion.ARGENTINA, Categoria.INFORMATICA, true));
        productos.add(new Producto("P014", "Monitor EFG", 17000, OrigenFabricacion.CHINA, Categoria.INFORMATICA, true));
        productos.add(new Producto("P015", "Aspiradora HIJ", 11000, OrigenFabricacion.BRASIL, Categoria.HERRAMIENTAS, true));

     
        while (true) {
            System.out.println("Menú de opciones:");
            System.out.println("1 – Mostrar productos");
            System.out.println("2 – Realizar compra");
            System.out.println("3 – Salir");

            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    for (Producto producto : productos) {
                        System.out.println(producto);
                    }
                    break;
                case 2:
                    List<Producto> productosComprados = new ArrayList<>();
                    double montoTotal = 0.0;

                    System.out.println("Seleccione los productos (ingrese 0 para terminar):");
                   
                    boolean compra = false;
                    while (true) {
                        int seleccion = scanner.nextInt(); 
                        if (seleccion == 0) break;

                        Producto producto = productos.get(seleccion - 1);
                        if (producto.isEstado()) {
                            productosComprados.add(producto);
                            montoTotal += producto.getPrecioUnitario();
                            compra = true;
                        } else {
                            System.out.println("Producto no disponible.");
                        }
                    }
                    if (compra) {
	                    System.out.println("Seleccione la forma de pago:");
	                    System.out.println("1 – Pago efectivo");
	                    System.out.println("2 – Pago con tarjeta");
	
	                    int metodoPago = scanner.nextInt();
	                    Pago pago;
	
	                    if (metodoPago == 1) {
	                        pago = new PagoEfectivo();
	                    } else {
	                        System.out.println("Ingrese el número de tarjeta:");
	                        String numeroTarjeta = scanner.next();
	                        pago = new PagoTarjeta(numeroTarjeta);
	                    }
	
	                    pago.realizarPago(montoTotal);
	                    pago.imprimirRecibo();
                    }
                    break;
                case 3:
                    System.out.println("Saliendo...");
                    return;
                default:
                    System.out.println("Opción no válida.");
            }
            
        }
        
    }
}
