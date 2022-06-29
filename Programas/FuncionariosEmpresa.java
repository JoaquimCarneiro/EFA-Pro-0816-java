package Programas;

import java.util.ArrayList;
import java.util.List;

public class FuncionariosEmpresa {
    protected List<Funcionario> listaDeFuncionarios = new ArrayList<>();

    public FuncionariosEmpresa() {
    }

    public FuncionariosEmpresa(List<Funcionario> listaDeFuncionarios) {
        this.listaDeFuncionarios = listaDeFuncionarios;
    }

    /* Procura na lista por funcionario e adiciona se este não existir na lista
    * devolve um booleano para se utilizado no main*/
    public boolean addFuncionario(int id, String nome, double salario){
        if (procuraFuncionarioLista(id)){
            return false;
        }else {
            Funcionario novoFuncionario = new Funcionario(id, nome, salario);
            listaDeFuncionarios.add(novoFuncionario);
            return  true;
        }
    }

    /* procura pelo id na lista, se o id existir devolve true
     * caso contrário não encontrou o funcionario e por isso dvolve false */
    protected boolean procuraFuncionarioLista(int id){
        for (Funcionario item : listaDeFuncionarios) {
            if (item.getId() == id){
                return true;
            }
        }
        return false;
    }


    public String toString(){
        String string = "Lista de funcionário\n";
        for (Funcionario item: listaDeFuncionarios) {
            string += "ID: " + item.getId() + ", " +
                    "Nome: " + item.getNome() + ", " +
                    "Salário: " + item.getSalario() + "\n";
        }
        return string;
    }
}
