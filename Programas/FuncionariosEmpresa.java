package Programas;

import java.util.ArrayList;
import java.util.List;

public class FuncionariosEmpresa {

    protected String nomeDaEmpresa;
    protected List<Funcionario> listaDeFuncionarios = new ArrayList<>();

    public FuncionariosEmpresa(String nome) {
        this.nomeDaEmpresa = nome;
    }

    public FuncionariosEmpresa(String nome, List<Funcionario> listaDeFuncionarios) {
        this.nomeDaEmpresa = nome;
        this.listaDeFuncionarios = listaDeFuncionarios;
    }

    /* getter */
    public String getNomeDaEmpresa() {
        return nomeDaEmpresa;
    }

    /***** Metodos *****/
    /* Procura na lista por funcionario e adiciona se este não existir na lista
    * devolve um booleano para ser utilizado no main*/
    public boolean addFuncionario(int id, String nome, double salario){
        if (procuraFuncionarioLista(id)){
            return false;
        }else {
            Funcionario novoFuncionario = new Funcionario(id, nome, salario);
            listaDeFuncionarios.add(novoFuncionario);
            return  true;
        }
    }

    public boolean delFuncionário(int id) {
        if (!procuraFuncionarioLista(id)) {
            return false;
        } else {
            for (int i = 0; i < listaDeFuncionarios.size(); i++) {
                if (listaDeFuncionarios.get(i).getId() == id){
                    //System.out.println(item.getId());
                    listaDeFuncionarios.remove(i);
                }
            }
            return true;
        }
    }

    /* procura pelo id na lista, se o id existir devolve true
     * caso contrário não encontrou o funcionario e por isso dvolve false */
    public boolean procuraFuncionarioLista(int id){
        for (Funcionario item : listaDeFuncionarios) {
            if (item.getId() == id){
                return true;
            }
        }
        return false;
    }

    public void aumentaFuncionarioLista(int id, double percentagem){
        for (int i = 0; i < listaDeFuncionarios.size(); i++) {
            if (listaDeFuncionarios.get(i).getId() == id){
                //System.out.println(item.getId());
                listaDeFuncionarios.get(i).aumentarSalario(percentagem);
            }
        }
    }

    public String toString(){
        String string = "Lista de funcionários\n";
        for (Funcionario item: listaDeFuncionarios) {
            string += "ID: " + item.getId() + ", " +
                    "Nome: " + item.getNome() + ", " +
                    "Salário: " + item.getSalario() + "\n";
        }
        return string;
    }
}
