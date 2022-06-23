package Programas;

public class CriarProduto {
    private String nome;
    private double preco;

    /* CONSTRUTOR */

    public CriarProduto(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }


    /* GET SET */
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
}
