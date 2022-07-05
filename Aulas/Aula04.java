package Aulas;

import Programas.*;
import com.java.FuncoesUi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Aula04 {
    public Aula04(String titulo){
        int opcao;
        String[] opcoesMenu = {"Altura média", "Produto", "Pensão", "Listas", "Funcionários", "Contas bancarias"};
        do {
            FuncoesUi.clearConsole();
            opcao = FuncoesUi.Menu(
                    titulo,
                    opcoesMenu,
                    "Insira uma opção",
                    "Opção inválida",
                    70,
                    '#'
            );

            switch (opcao) {
                case 1:
                    FuncoesUi.clearConsole();
                    FuncoesUi.Titulo(opcoesMenu[0], 70, '#', 0, 2);
                    int numPessoas = FuncoesUi.VerificaInt("Quantas pessoas constituem o grupo?", "Tem que inserir um numero inteiro");
                    double[] alturas = new double[numPessoas];
                    double soma = 0;

                    int i = 0;
                    while (i < numPessoas){
                        alturas[i] = FuncoesUi.VerificaDouble("Altura da pessoa " + (i+1), "Tem que inserir um numero real.");
                        soma += alturas[i];
                        i++;
                    }

                    double media = soma / numPessoas;

                    System.out.printf("A média de alturas é de %.2f", media);

                    FuncoesUi.Separador('#', 70, 2, 1);
                    FuncoesUi.continuar("Continuar?", "s");
                    break;

                case 2:
                    FuncoesUi.clearConsole();
                    FuncoesUi.Titulo(opcoesMenu[1], 70, '#', 0, 2);


                    Scanner entrada = new Scanner(System.in);
                    int numProdutos = FuncoesUi.VerificaInt("Quantos produtos deseja inserir", "Tem que inserir um numero inteiro");

                    CriarProduto[] produtos = new CriarProduto[numProdutos];
                    double somaPrecos = 0;

                    for (int j = 0; j < numProdutos; j++){
                        System.out.printf("Insira nome do produto %d: ", j+1);
                        String nomeProduto = entrada.next();
                        double precoProduto = FuncoesUi.VerificaDouble("Qual é o preço do produto "+nomeProduto,"Tem que inserir um numero real");
                        somaPrecos += precoProduto;
                        produtos[j] = new CriarProduto(nomeProduto, precoProduto);
                    }

                    System.out.printf("A média de preços é %.2f", somaPrecos / numProdutos);
                    FuncoesUi.Separador('#', 70, 2, 1);
                    FuncoesUi.continuar("Continuar?", "s");
                    break;

                case 3:
                    FuncoesUi.clearConsole();
                    FuncoesUi.Titulo(opcoesMenu[2], 70, '#', 0, 2);

                    System.out.println("Criar Nova pensão:");
                    String nomePensao = FuncoesUi.fazPergunta("\tIntroduza o nome da pensão");
                    int numQuartos = FuncoesUi.VerificaInt("\tIntroduza a quantidade de quartos", "Tem que introduzir um numero inteiro.");

                    Pensao novaPensao = new Pensao(nomePensao, numQuartos);

                    int menuPensao;
                    String[] opcoesPensao = {"Listar quartos", "Checkin", "Checkout"};
                    do {
                        FuncoesUi.clearConsole();

                        FuncoesUi.Titulo("Dados da Pensão", 70, '#', 0, 2);
                        System.out.println(novaPensao.info());
                        menuPensao = FuncoesUi.Menu(
                                "Operações",
                                opcoesPensao,
                                "Insira uma opção",
                                "Opção inválida",
                                70,
                                '+'
                        );
                        switch (menuPensao){
                            case 1:
                                FuncoesUi.clearConsole();
                                FuncoesUi.Titulo("Listar quartos", 70, '-',0, 2);
                                System.out.println(novaPensao.listaQuartos());
                                FuncoesUi.continuar("Continuar", "s");
                                break;
                            case 2:
                                FuncoesUi.clearConsole();
                                FuncoesUi.Titulo("Checkin", 70, '-',0, 2);
                                //falta verificação de que existem quartos disponíveis
                                //falta verificação da quantidade de quartos relativamente ao numero de quartos disponíveis
                                int numCheckin = FuncoesUi.VerificaInt("Quantos quartos para fazer checkin", "tem que introduzir um numero inteiro");
                                int quarto;
                                boolean controle = false;
                                for (int j = 0; j < numCheckin; j++){
                                    FuncoesUi.Separador('-',70,  1, 1);
                                    String nomeCliente = FuncoesUi.fazPergunta("Introduza o nome do cliente " + (j+1));
                                    String emailCliente = FuncoesUi.fazPergunta("Introduza o email do cliente " + (j+1));

                                    do {
                                        if (controle){
                                            System.out.println("Numero de quarto ocupado ou inválido");
                                        }
                                        quarto = FuncoesUi.VerificaInt("Introduza o quarto", "Tem que introduzir um numero inteiro");

                                        controle = true;
                                    }while (quarto < 0 || quarto > numQuartos || novaPensao.getQuartos()[quarto] != null);
                                    controle = false;
                                    PensaoCliente novocliente = new PensaoCliente(nomeCliente, emailCliente);
                                    novaPensao.setQuartos(novocliente, quarto);
                                }
                                break;
                            case 3:
                                FuncoesUi.clearConsole();
                                FuncoesUi.Titulo("Checkout", 70, '-',0, 2);
                                boolean controleOut = false;
                                int delQuarto;
                                do {
                                    if (controleOut){
                                        System.out.println("Numero de quarto não ocupado ou inválido");
                                    }
                                    delQuarto = FuncoesUi.VerificaInt("Introduza o quarto", "Tem que introduzir um numero inteiro");
                                    controleOut = true;
                                    if (delQuarto == -1){
                                        break;
                                    }
                                }while (delQuarto < 0 || delQuarto > numQuartos || novaPensao.getQuartos()[delQuarto] == null);
                                if (delQuarto != -1){
                                    novaPensao.delQuartos(delQuarto);
                                }

                                break;
                            case 0:
                                System.out.println("a sair...");
                                break;
                        }

                    }while (menuPensao != 0);

                    FuncoesUi.Separador('#', 70, 2, 1);
                    break;

                case 4:
                    FuncoesUi.clearConsole();
                    FuncoesUi.Titulo(opcoesMenu[3], 70, '#', 0, 2);

                    List <String> lista = new ArrayList<>();

                    lista.add("Maria");
                    lista.add("Pedro");
                    lista.add("Rui");
                    lista.add("Ana");

                    lista.add(2, "marco");

                    System.out.println("A lista tem " + lista.size() + " items.");

                    for (String item : lista){
                        System.out.println("\t" + item);
                    }
                    FuncoesUi.Separador('#', 70, 2, 1);
                    lista.remove("Ana");
                    lista.remove(1);
                    lista.removeIf(x->x.charAt(0) == 'M');

                    System.out.println("A lista tem " + lista.size() + " items.");

                    for (String item : lista){
                        System.out.println("\t" + item);
                    }

                    FuncoesUi.Separador('#', 70, 2, 1);
                    FuncoesUi.continuar("Continuar?", "s");
                    break;

                case 5:
                    FuncoesUi.clearConsole();
                    FuncoesUi.Titulo(opcoesMenu[4], 70, '#', 0, 2);

                    /* Criar empresa e adicionar funcionários adicionais */
                    String nomeEmpresa = FuncoesUi.fazPergunta("Digite o nome da empresa");
                    FuncionariosEmpresa novaEmpresa = new FuncionariosEmpresa(nomeEmpresa);
                    int qtdFuncionarios = FuncoesUi.VerificaInt("Quantos Funcionários iniciais deseja adicionar", "tem que inserir um numero inteiro");

                    for (int ctrl = 0; ctrl < qtdFuncionarios; ctrl++){
                        // Função local
                        pedirAdicionarFuncionario(novaEmpresa);
                    }
                    FuncoesUi.clearConsole();
                    int menuEmpresa;

                    do {
                        String[] opcoesEmpresa = {"Adicionar funcionário", "Remover funcionário", "Aumentar funcionário", "Listar funcionários"};
                        menuEmpresa = FuncoesUi.Menu(
                                novaEmpresa.getNomeDaEmpresa() + " - Operações",
                                opcoesEmpresa,
                                "Insira uma opção",
                                "Opção inválida",
                                70,
                                '-');

                        switch (menuEmpresa) {
                            case 1:
                                FuncoesUi.clearConsole();
                                FuncoesUi.Titulo(opcoesEmpresa[0], 70, '-',0, 2);
                                // Função local
                                pedirAdicionarFuncionario(novaEmpresa);
                                break;
                            case 2:
                                FuncoesUi.clearConsole();
                                FuncoesUi.Titulo(opcoesEmpresa[1], 70, '-',0, 2);
                                int delFuncionario;
                                boolean funcionario = true;
                                do {
                                    if(!funcionario){
                                        System.out.println("Funcionário não existe");
                                    }
                                    delFuncionario = FuncoesUi.VerificaInt("Id do funcionário a remover (-1 para sair)", "Tem que inserir um numero inteiro");
                                    funcionario = novaEmpresa.procuraFuncionarioLista(delFuncionario);
                                }while (!funcionario && delFuncionario != -1);
                                novaEmpresa.delFuncionário(delFuncionario);
                                break;
                            case 3:
                                FuncoesUi.clearConsole();
                                FuncoesUi.Titulo(opcoesEmpresa[2], 70, '-',0, 2);
                                int aumentarFuncionario;
                                boolean controlefuncionario = true;
                                do {
                                    if(!controlefuncionario){
                                        System.out.println("Funcionário não existe");
                                    }
                                    aumentarFuncionario = FuncoesUi.VerificaInt("Id do funcionário a aumentar (-1 para sair)", "Tem que inserir um numero inteiro");
                                    controlefuncionario = novaEmpresa.procuraFuncionarioLista(aumentarFuncionario);
                                }while (!controlefuncionario && aumentarFuncionario != -1);
                                double percentagem = FuncoesUi.VerificaDouble("Insira a percentagem a aumentar", "Tem que inserir um numero real");
                                novaEmpresa.aumentaFuncionarioLista(aumentarFuncionario,percentagem);
                                break;
                            case 4:
                                FuncoesUi.clearConsole();
                                FuncoesUi.Titulo(opcoesEmpresa[3], 70, '-',0, 2);
                                System.out.println(novaEmpresa);
                                FuncoesUi.continuar("Continuar?", "s");
                                break;
                            case 0:
                                break;
                        }
                    }while (menuEmpresa != 0);


                    FuncoesUi.Separador('#', 70, 2, 1);
                    break;

                case 6:
                    FuncoesUi.clearConsole();
                    FuncoesUi.Titulo(opcoesMenu[5], 70, '#', 0, 2);

                    ContaBancaria conta = new ContaBancaria(1, "Joaquim Carneiro", 1000);
                    ContaBancariaEmpresa contaEmpresa = new ContaBancariaEmpresa(2001, "IEFP", 20000, 100);

                    //upcasting
                    ContaBancaria conta1 = contaEmpresa;
                    ContaBancaria conta2 = new ContaBancariaEmpresa(2002, "BCP", 5.0E10, 50000);

                    //Downcasting
                    ContaBancariaEmpresa conta3 = (ContaBancariaEmpresa) conta2;

                    System.out.println(conta);
                    System.out.println(contaEmpresa);
                    System.out.println(conta1);
                    System.out.println(conta2);
                    System.out.println(conta3);

                    ContaBancaria contaPoupanca = new ContaBancariaPoupanca(1, "Joaquim Carneiro", 1000, 5);
                    System.out.println("Conta Poupança ");
                    System.out.println(contaPoupanca);

                    System.out.println("Conta Poupança - remover 10 ");
                    contaPoupanca.setSaldo(-10);

                    System.out.println(contaPoupanca);

                    FuncoesUi.Separador('#', 70, 2, 1);
                    FuncoesUi.continuar("Continuar?", "s");
                    break;

                /*case 2:
                    FuncoesUi.clearConsole();
                    FuncoesUi.Titulo(opcoesMenu[1], 70, '#', 0, 2);

                    FuncoesUi.Separador('#', 70, 2, 1);
                    FuncoesUi.continuar("Continuar?", "s");
                    break;*/
                default:
                    System.out.println("a voltar ao menu anterior");
                    break;
            }
        }while (opcao != 0);
    }

    /* pede dados do funcionário, cria funcionario e adiciona-o à empresa */
    private void pedirAdicionarFuncionario(FuncionariosEmpresa empresa){
        int id;
        String nome;
        double salario;
        boolean controle = false;

        /* Perguntar e verificar que funcionário não existe na lista */
        do {
            if (controle){
                System.out.println("Funcionário já existe.");
            }
            id = FuncoesUi.VerificaInt("Digite o numero de funcionario", "Tem que inserir um numero inteiro");
            controle = empresa.procuraFuncionarioLista(id);

        }while (controle);
        /* pedir resto dos dados */
        nome = FuncoesUi.fazPergunta("Digite o nome do funcionario");
        salario = FuncoesUi.VerificaDouble("Introduza o salário do funcionario", "Tem que introduzir um numero real.");
        /* adicionar funcionario */
        empresa.addFuncionario(id, nome, salario);
        FuncoesUi.Separador('-', 70, 1, 0);
    }
}
