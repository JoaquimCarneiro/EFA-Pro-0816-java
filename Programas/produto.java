package Programas;

public class produto {
    private String nome;
    private double preco;
    private int quantidade;

    /* Construtores */
    public produto(String nome, double preco, int quantidade){
        this.nome = nome;
        this.preco = preco;
        this.quantidade= quantidade;
    }

    public produto(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public produto(String nome, int quantidade) {
        this.nome = nome;
        this.quantidade = quantidade;

    }

    /* Getter / Setter*/
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }


    /* ---- */
    public double ValorTotalStock(){
        return this.preco * this.quantidade;
    }

    public void removerProduto(int qtd){
        if (this.quantidade - qtd >= 0){
            this.quantidade -= qtd;
        }else{
            System.out.println("ERRO: Não existe produto suficiente em stock");
        }
    }

    public void adicionarProduto(int qtd){
        this.quantidade += qtd;
    }

    public String toString(){
        return "O produto " + nome + " tem o preço de " + String.format("%.2f", preco) + "€,  " +
                "\ncom a quantidade de " + quantidade + " em stock" +
                "\no que perfaz um total de " + String.format("%.2f", ValorTotalStock()) + "€ em Stock";
    }
}
