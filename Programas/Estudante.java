package Programas;

public class Estudante {
    public String nome;
    public double nota1;
    public double nota2;
    public double nota3;

    protected double valorTrim1 = 30;
    protected double valorTrim2 = 35;
    protected double valorTrim3 = 35;

    protected double percentagemMinima = 60;

    public Estudante(String nome, double trimestre1, double trimestre2, double trimestre3){
        this.nome = nome;
        this.nota1 = trimestre1;
        this.nota2 = trimestre2;
        this.nota3 = trimestre3;
    }

    public double notaFinal(){
        return (nota1 * valorTrim1 / 100) + (nota2 * valorTrim2 / 100) + (nota3 * valorTrim3 / 100);
    }

    public double pontosEmFalta(){
        double notaFinal = notaFinal();
        double pontosEmFalta;
        if (notaFinal < percentagemMinima){
            pontosEmFalta = percentagemMinima - notaFinal;
        }else{
            pontosEmFalta = 0;
        }
        return pontosEmFalta;
    }


    public String toString() {
        if(pontosEmFalta() > 0){
            return "O aluno " + nome + " está reprovado com a nota final de " + notaFinal() + ".\nO aluno necessita de " + pontosEmFalta() + " pontos percentuais para ser aprovado.";
        }else {
            return "O aluno " + nome + " está aprovado com a nota final de " + notaFinal();
        }
    }
}
