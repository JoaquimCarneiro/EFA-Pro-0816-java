package Programas;

public class retangulo {
    public double largura;
    public double altura;

    public retangulo(double largura, double altura){
        this.largura = largura;
        this.altura = altura;
    }

    public double area(){
        return altura * largura;
    }

    public double perimetro() {
        return altura + largura;
    }

    public double diagonal() {
        return Math.sqrt(Math.pow(largura, 2) + Math.pow(altura, 2));
    }
}
