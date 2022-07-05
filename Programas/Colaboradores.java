package Programas;

public class Colaboradores {
    protected String nome;
    protected int horas;
    protected double valorHora = 20;

    public Colaboradores(String nome, int horas) {
        this.nome = nome;
        this.horas = horas;
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    public double pagamento(){
        return horas * valorHora;
    }
}
