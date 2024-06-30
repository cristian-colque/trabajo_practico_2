package ar.edu.unju.fi.ejercicio05.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio01.model.Producto;
import ar.edu.unju.fi.ejercicio05.interfaces.Pago;
import ar.edu.unju.fi.ejercicio05.model.PagoEfectivo;
import ar.edu.unju.fi.ejercicio05.model.PagoTarjeta;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Producto> productos = new ArrayList<>();

        // Precargar 15 productos
        for (int i = 1; i <= 15; i++) {
            productos.add(new Producto("Producto" + i, i * 10.0, i % 2 == 0));
        }

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

                    System.out.println("Seleccione los productos (ingrese -1 para terminar):");
                    while (true) {
                        int seleccion = scanner.nextInt();
                        if (seleccion == -1) break;

                        Producto producto = productos.get(seleccion - 1);
                        if (producto.isEstado()) {
                            productosComprados.add(producto);
                            montoTotal += producto.getPrecio();
                        } else {
                            System.out.println("Producto no disponible.");
                        }
                    }

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
