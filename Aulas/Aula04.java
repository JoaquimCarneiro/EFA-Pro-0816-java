package Aulas;

import Programas.CriarProduto;
import Programas.Pensao;
import Programas.PensaoCliente;
import com.java.FuncoesUi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Aula04 {
    public Aula04(String titulo){
        int opcao;
        String[] opcoesMenu = {"Altura média", "Produto", "Pensão", "listas"};
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
                                //falta a verificação de que existem quartos disponíveis
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
                    //System.out.println(novaPensao);
                    //System.out.println(novaPensao.listaQuartos());


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

                    for (String item : lista){
                        System.out.println(item);
                    }

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
}
