package ar.edu.unju.fi.ejercicio06.interfaces.funcionales;

@FunctionalInterface
public interface Converter<T, R> {
    R convert(T t);

    
    static <T> boolean isNotNull(T t) {
        return t != null;
    }
    
    default void mostrarObjeto(R r) {
        System.out.println("Objeto" + r.toString());
    }

}