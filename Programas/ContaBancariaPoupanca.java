package Programas;

public class ContaBancariaPoupanca extends ContaBancaria{
    private double taxaJuro;

    public ContaBancariaPoupanca() {
        super();
    }

    public ContaBancariaPoupanca(int numeroConta, String titular, double saldo, double taxaJuro) {
        super(numeroConta, titular, saldo);
        this.taxaJuro = taxaJuro;
    }

     /* GETTER SETTER*/

    public double getTaxaJuro() {
        return taxaJuro;
    }

    public void setTaxaJuro(double taxaJuro) {
        this.taxaJuro = taxaJuro;
    }

    /* Metodos */

    public void atualizaSaldo(){
        saldo += saldo*taxaJuro/100;
    }

    @Override
    public String toString() {
        return "ContaBancariaPoupanca{" +
                ", numeroConta=" + numeroConta +
                ", titular='" + titular + '\'' +
                "taxaJuro=" + taxaJuro +
                ", saldo=" + saldo +
                '}';
    }
}
