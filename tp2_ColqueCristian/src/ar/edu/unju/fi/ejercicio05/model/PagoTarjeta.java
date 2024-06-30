package ar.edu.unju.fi.ejercicio05.model;

import java.time.LocalDate;

import ar.edu.unju.fi.ejercicio05.interfaces.Pago;

public class PagoTarjeta implements Pago {
    private String numeroTarjeta;
    private LocalDate fechaPago;
    private double montoPagado;

    public PagoTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    @Override
    public void realizarPago(double monto) {
        this.montoPagado = monto + (monto * 0.15);
        this.fechaPago = LocalDate.now();
    }

    @Override
    public void imprimirRecibo() {
        System.out.println("Número de tarjeta: " + this.numeroTarjeta);
        System.out.println("Fecha de pago: " + this.fechaPago);
        System.out.println("Monto pagado: " + this.montoPagado);
    }
}





