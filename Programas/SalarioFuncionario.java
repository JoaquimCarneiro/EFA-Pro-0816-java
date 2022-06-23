package Programas;

public class SalarioFuncionario {
    public String nome;
    public double salarioBruto;
    public double imposto;

    public SalarioFuncionario(String nome, double salarioBruto, double imposto){
        this.nome = nome;
        this.salarioBruto = salarioBruto;
        this.imposto = imposto;
    }

    public double salarioLiquido(){
        return salarioBruto-(salarioBruto*imposto/100);
    }

    public void aumentarSalario(double percentagem){
        this.salarioBruto *= (percentagem/100)+1;
    }
}
