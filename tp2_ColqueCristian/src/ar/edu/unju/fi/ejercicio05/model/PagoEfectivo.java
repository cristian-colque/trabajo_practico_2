package ar.edu.unju.fi.ejercicio05.model;

import java.time.LocalDate;

import ar.edu.unju.fi.ejercicio05.interfaces.Pago;

public class PagoEfectivo implements Pago {
    private LocalDate fechaPago;
    private double montoPagado;

    @Override
    public void realizarPago(double monto) {
        this.montoPagado = monto - (monto * 0.10);
        this.fechaPago = LocalDate.now();
    }

    @Override
    public void imprimirRecibo() {
        System.out.println("Fecha de pago: " + this.fechaPago);
        System.out.println("Monto pagado: " + this.montoPagado);
    }
}