package Programas;

public class Pensao {
    private String designacao;
    private int numQuartos;
    private int numQuartosOcupados = 0;
    PensaoCliente[] quartos;

    public Pensao(String designacao, int numQuartos) {
        this.designacao = designacao;
        this.numQuartos = numQuartos;
        this.quartos = new PensaoCliente[numQuartos];
    }

    /* GET/SET */

    //nome
    public String getDesignacao() {
        return designacao;
    }

    //numero de quarto
    public int getNumQuartos() {
        return numQuartos;
    }

    //quartos / clientes
    public PensaoCliente[] getQuartos() {
        return quartos;
    }

    public void setQuartos(PensaoCliente quartos, int quarto) {
        this.quartos[quarto] = quartos;
        this.numQuartosOcupados += 1;
    }
    //Quarto ocupados /disponíveis
    public int getNumQuartosOcupados() {
        return numQuartosOcupados;
    }

    public int getNumQuartosDisponiveis(){
        return numQuartos - numQuartosOcupados;
    }

    /* metodos extra */

    public void delQuartos(int quarto) {
        this.quartos[quarto] = null;
        this.numQuartosOcupados -= 1;
    }

    public String listaQuartos(){
        String listaQuartos = "";
        for (int i = 0; i < this.numQuartos; i++){
            if (this.quartos[i] == null){
                listaQuartos += "Quarto " + i + " - Livre\n";
                //continue;
            }else{
                listaQuartos += "Quarto " + i + "\n" + quartos[i];
            }
        }
        return listaQuartos;
    }

    @Override
    public String toString() {
        String quartosOcupados = listaQuartos();
        return  "Pensão '" + designacao + "\'\n" +
                "Numero de Quartos: " + numQuartos + "\n" +
                "Quartos Livres: " + (numQuartos-numQuartosOcupados) + "\n" +
                "Quartos Ocupados: " + numQuartosOcupados + "\n\n" + quartosOcupados;
    }

    public String info() {
        String info =  "Pensão '" + designacao + "\'\n" +
                "Numero de Quartos: " + numQuartos + "\n" +
                "Quartos Livres: " + (numQuartos-numQuartosOcupados) + "\n" +
                "Quartos Ocupados: " + numQuartosOcupados;
        return info;
    }
}
