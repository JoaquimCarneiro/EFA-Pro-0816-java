package Programas;

public class triangulo {
    public double lado1;
    public double lado2;
    public double lado3;
    public double area;
    public double perimetro;

    public triangulo(double lado1, double lado2, double lado3) {
        this.lado1 = lado1;
        this.lado2 = lado2;
        this.lado3 = lado3;
        this.perimetro = perimetro(lado1, lado2, lado3);
        this.area = area(lado1, lado2, lado3);
    }
    public double perimetro (double lado1, double lado2, double lado3){
        return ((lado1 + lado2 + lado3));
    }

    public double area(double lado1, double lado2, double lado3){
        double per =  this.perimetro/2;
        return Math.sqrt(per*(per-lado1)*(per-lado2)*(per-lado3));
    }
}
