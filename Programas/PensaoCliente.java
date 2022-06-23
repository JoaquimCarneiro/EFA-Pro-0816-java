package Programas;

public class PensaoCliente {
    private String nome;
    private String email;

    public PensaoCliente(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return  "\tNome: '" + nome + "\'\n" +
                "\tEmail: '" + email + "\'\n";
    }
}
