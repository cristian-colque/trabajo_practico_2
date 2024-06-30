package ar.edu.unju.fi.ejercicio06.main;

import ar.edu.unju.fi.ejercicio06.interfaces.funcionales.Converter;
import ar.edu.unju.fi.ejercicio06.model.FelinoDomestico;
import ar.edu.unju.fi.ejercicio06.model.FelinoSalvaje;

public class Main {
    public static void main(String[] args) {
        // Ejemplo de conversión de FelinoDomestico a FelinoSalvaje
        FelinoDomestico garfield = new FelinoDomestico("Garfield", (byte) 45, 12f);
        Converter<FelinoDomestico, FelinoSalvaje> converter = x -> new FelinoSalvaje(x.getNombre(), x.getEdad(), x.getPeso());

        FelinoSalvaje felino1 = converter.convert(garfield);
        converter.mostrarObjeto(felino1);

        System.out.println();

        // Ejemplo de conversión de FelinoSalvaje a FelinoDomestico
        FelinoSalvaje tannerSalvaje = new FelinoSalvaje("Tanner", (byte) 20, 186f);
        if (Converter.isNotNull(tannerSalvaje)) {
            Converter<FelinoSalvaje, FelinoDomestico> reverseConverter = x -> new FelinoDomestico(x.getNombre(), x.getEdad(), x.getPeso());

            FelinoDomestico tannerDomestico = reverseConverter.convert(tannerSalvaje);
            reverseConverter.mostrarObjeto(tannerDomestico);
        } else {
            System.out.println("El objeto a convertir es nulo.");
        }
    }
}
