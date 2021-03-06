package Programas;

public class ContaBancaria {
    protected int numeroConta;
    protected String titular;
    protected double saldo = 0;

    protected final double taxa = 5;

    public ContaBancaria(){

    }
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

    public void setSaldo(double movimento) {
        if (movimento >= 0){
            this.saldo += movimento;
        }else {
            this.saldo -= taxa + movimento;
        }

    }

    public String toString() {
        return  "Numero de Conta: " + numeroConta + '\n' +
                "Titular: '" + titular + "\'\n" +
                "Tipo de Conta: Normal\n" +
                "saldo: " + saldo + "€\n" ;
    }
}
