package Programas;

public class ContaBancaria {
    private int numeroConta;
    private String titular;
    private double saldo = 0;

    private final double taxa = 5;

    public ContaBancaria(int numeroConta, String titular, double saldo) {
        this.numeroConta = numeroConta;
        this.titular = titular;
        this.saldo = saldo;
    }

    public ContaBancaria(int numeroConta, String titular) {
        this.numeroConta = numeroConta;
        this.titular = titular;
    }

    /* getter */
    public int getNumeroConta() {
        return numeroConta;
    }

    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }

    /* Setter */
    public void setTitular(String titular) {
        this.titular = titular;
    }

    public void setSaldo(double saldo) {
        if (saldo >= 0){
            this.saldo += saldo;
        }else {
            this.saldo += -taxa + saldo;
        }

    }

    public String toString() {
        return  "numeroConta: " + numeroConta + '\n' +
                "titular: " + titular + '\n' +
                "saldo: " + saldo + "€\n" ;
    }
}
