package Programas;

public class ContaBancariaEmpresa extends ContaBancaria{
    private double limiteEmprestimo;

    //passar logica da superclass
    public ContaBancariaEmpresa() {
        super();
    }

    public ContaBancariaEmpresa(int numeroConta, String titular, double saldo, double limiteEmprestimo) {
        super(numeroConta, titular, saldo);
        this.limiteEmprestimo = limiteEmprestimo;
    }

    public ContaBancariaEmpresa(int numeroConta, String titular, double limiteEmprestimo) {
        super(numeroConta, titular);
        this.limiteEmprestimo = limiteEmprestimo;
    }

    /* Get */
    public double getLimiteEmprestimo() {
        return limiteEmprestimo;
    }

    /* Set */
    public void setLimiteEmprestimo(double limiteEmprestimo) {
        this.limiteEmprestimo = limiteEmprestimo;
    }

    /* metodos */
    /* this makes no f sense */
    /* */
    public void emprestimo(double quantia){
        if(quantia > 0 && quantia <= limiteEmprestimo){
            setSaldo(quantia);
            saldo -= taxa;
        }else {
            System.out.println("Operação inválida!");
        }
    }

    @Override
    public String toString() {
        return  "Numero de Conta: " + numeroConta + "\n" +
                "Titular: '" + titular + '\'' + "\n" +
                "Tipo de Conta: Empresarial\n" +
                "Saldo: " + saldo + "\n" +
                "Limite de Emprestimo: " + limiteEmprestimo + "\n" ;
    }
}
