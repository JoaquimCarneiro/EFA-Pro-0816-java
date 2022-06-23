package Programas;

public class CambioMoeda {
    public static final double imposto = 6;

    public static double conversão(double quantidade, double valorDolar){
        return (quantidade + (quantidade*imposto/100)) * valorDolar;
    }
}
