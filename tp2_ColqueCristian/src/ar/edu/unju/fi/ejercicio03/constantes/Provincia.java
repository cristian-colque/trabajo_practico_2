package ar.edu.unju.fi.ejercicio03.constantes;

public enum Provincia {
	
	JUJUY(673307, 53219), 
    SALTA(1448120, 155488), 
    TUCUMAN(1699196, 22524), 
    CATAMARCA(367828, 102602), 
    LA_RIOJA(331847, 89680), 
    SANTIAGO_DEL_ESTERO(874006, 136351);

    private int cantidadPoblacion;
    private int superficie;


    private Provincia(int cantidadPoblacion, int superficie) {
        this.cantidadPoblacion = cantidadPoblacion;
        this.superficie = superficie;
    }

    public int getCantidadPoblacion() {
        return cantidadPoblacion;
    }

    public void setCantidadPoblacion(int cantidadPoblacion) {
        this.cantidadPoblacion = cantidadPoblacion;
    }

    public int getSuperficie() {
        return superficie;
    }

    public void setSuperficie(int superficie) {
        this.superficie = superficie;
    }

    public double calcularDensidadPoblacional() {
        return (double) cantidadPoblacion / superficie;
    }
}
