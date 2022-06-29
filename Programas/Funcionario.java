package Programas;

public class Funcionario {
    private int id;
    private String nome;
    private double salario;

    Funcionario(int id, String nome, double salario){
        this.id = id;
        this.nome = nome;
        this.salario = salario;
    }

    /* GETTER */
    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public double getSalario() {
        return salario;
    }

    /* SETTER */

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    /***** Metodos *****/

    public void aumentarSalario(double percentagem){
        this.salario += this.salario*percentagem/100;
    }
}

