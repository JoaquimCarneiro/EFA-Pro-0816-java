package Aulas;

import Programas.SalarioFuncionario;
import com.java.FuncoesUi;
import Programas.produto;
import Programas.triangulo;
import Programas.retangulo;
import Programas.Estudante;
import Programas.calculador;
import Programas.CambioMoeda;
import Programas.ContaBancaria;

import java.util.Scanner;

public class Aula03 {
    public Aula03(String titulo){
        int opcao;
        String[] opcoesMenu = {"Comparar a àrea de dois triangulos",
                                "Gestão de produto",
                                "Quadrado",
                                "Salario do funcionário",
                                "Nota do aluno", "Esfera",
                                "Cambio de dolares",
                                "Gestão de conta bancária"};
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
                    do {
                        FuncoesUi.clearConsole();
                        FuncoesUi.Titulo(opcoesMenu[0], 70, '#', 0, 2);

                        triangulo triangulo1, triangulo2;

                        triangulo1 = CriaTrianguloValido("Insira os lados do triangulo 1:");
                        System.out.println("A área do primeiro triangulo é " + triangulo1.area + "!");

                        FuncoesUi.Separador('-', 70, 2,1);

                        triangulo2 = CriaTrianguloValido("Insira os lados do triangulo 2:");
                        System.out.println("A área do segundo triangulo é " + triangulo2.area + "!");

                        FuncoesUi.Separador('-', 70, 2,1);

                        if (triangulo1.area > triangulo2.area){
                            System.out.println("O triangulo 1 é maior do que o triangulo 2!");
                        } else if (triangulo1.area < triangulo2.area) {
                            System.out.println("O triangulo 2 é maior do que o triangulo 1!");
                        }else {
                            System.out.println("Os triangulos são iguais e tem a area de " + triangulo1.area + "!");
                        }

                        FuncoesUi.Separador('#', 70, 2, 1);
                    }while (FuncoesUi.repetir("Repetir Calculos?", "s", "n"));
                    break;

                case 2:

                    do {
                        /* FALTA CADEIA DE PÁGINAS */
                        Scanner entrada = new Scanner(System.in);

                        int qtd, operacao, qtdProduto;
                        String[] subMenu = {"comprar", "Vender", "Alterar Preço"};
                        double novoPreco, valorProduto;

                        FuncoesUi.clearConsole();
                        FuncoesUi.Titulo(opcoesMenu[1], 70, '#', 0, 2);

                        System.out.print("Digite o nome do artigo: ");
                        String nomeProduto = entrada.next();

                        valorProduto = FuncoesUi.VerificaDouble("Digite o valor do produto", "Twm que introduzir um numero real");
                        qtdProduto = FuncoesUi.VerificaInt("Digite a quantidade de produto", "Twm que introduzir um numero inteiro");

                        produto novoProduto = new produto(nomeProduto, valorProduto,qtdProduto);


                        System.out.println("\n");
                        System.out.println(novoProduto);
                        System.out.println("\n");


                        do {
                            boolean fazerOperacoes = FuncoesUi.repetir("Realizar Operações?", "s", "n");
                            if (!fazerOperacoes){
                                FuncoesUi.Separador('#', 70,1,0);
                                break;
                            }
                            FuncoesUi.clearConsole();
                            FuncoesUi.Titulo(opcoesMenu[1] + " - " + novoProduto.getNome(), 70, '#', 0, 2);

                            System.out.println(novoProduto);

                            operacao = FuncoesUi.Menu(
                                    "Comprar/Vender/Alterar preço",
                                    subMenu, "Que operação deseja realizar",
                                    "operação inválida",
                                    70,
                                    '+');

                            switch (operacao){
                                case 1:
                                    qtd = FuncoesUi.VerificaInt("Qual foi a quantidade de " + novoProduto.getNome() + " adequiridas?", "Introduza um numero inteiro");
                                    novoProduto.adicionarProduto(qtd);
                                    break;

                                case 2:
                                    qtd = FuncoesUi.VerificaInt("Qual foi a quantidade de " + novoProduto.getNome() + " vendidos/as?", "Introduza um numero Inteiro");
                                    novoProduto.removerProduto(qtd);
                                    break;

                                case 3:
                                    novoPreco = FuncoesUi.VerificaDouble("Qual é o novo Preço do artigo", "Introduza um numero");
                                    novoProduto.setPreco(novoPreco);
                                    break;

                                default:
                                    System.out.println("A sair...");
                            }

                            FuncoesUi.Separador('-', 70, 2, 1);
                        }while (operacao != 0 /*&& FuncoesUi.repetir("Fazer outra operação", "s", "n")*/);


                    }while (FuncoesUi.repetir("Deseja Criar outro produtto", "s", "n"));
                    break;

                case 3:
                    do {
                        FuncoesUi.clearConsole();
                        FuncoesUi.Titulo(opcoesMenu[2], 70, '#', 0, 2);

                        // falta pedir dados ao utilizador

                        retangulo retangulo = new retangulo(5.6, 7.2);
                        System.out.println("O retangulo tem:" +
                                "\n\ta area " + String.format("%.2f", retangulo.area()) +
                                "\n\to perímetro " + String.format("%.2f", retangulo.perimetro()) +
                                "\n\ta diagonal de " + String.format("%.2f", retangulo.diagonal()));

                        FuncoesUi.Separador('#', 70, 2, 1);
                    }while (FuncoesUi.repetir("Repetir Calculos?", "s", "n"));
                    break;

                case 4:
                    do {
                        FuncoesUi.clearConsole();
                        FuncoesUi.Titulo(opcoesMenu[3], 70, '#', 0, 2);

                        System.out.print("Nome do funcionário: ");
                        String nome = new Scanner(System.in).next();
                        double salarioBruto  = FuncoesUi.VerificaDouble("Salário bruto", "Tem que introduzir um numero real.");
                        double imposto  = FuncoesUi.VerificaDouble("valor do imposto ", "Tem que introduzir um numero real.");

                        SalarioFuncionario funcionario = new SalarioFuncionario(nome, salarioBruto, imposto);
                        System.out.println("O funcionário " + funcionario.nome + " tem o salário bruto " + funcionario.salarioBruto + "€");
                        System.out.println("\tO salário líquido é de " + funcionario.salarioLiquido() + "€\n");
                        if(FuncoesUi.repetir("Aumentar funcionário?", "s", "n")){
                            double aumento = FuncoesUi.VerificaDouble("valor do aumento (em percentagem)", "Tem que introduzir um numero real.");

                            funcionario.aumentarSalario(aumento);
                            System.out.printf("""
                                                O funcionário foi aumentado em %.2f ficando com o:\s
                                                \tordenado bruto de %.2f€ e
                                                \tordenado líquido de %.2f€""", aumento, funcionario.salarioBruto, funcionario.salarioLiquido());

                        }

                        FuncoesUi.Separador('#', 70, 2, 1);
                    }while (FuncoesUi.repetir("Repetir Calculos?", "s", "n"));
                    break;

                case 5:
                    do {
                        FuncoesUi.clearConsole();
                        FuncoesUi.Titulo(opcoesMenu[4], 70, '#', 0, 2);

                        System.out.print("Introduza o nome do Aluno: ");
                        String nome =  new Scanner(System.in).next();
                        double nota1, nota2, nota3;
                        int sistemaBase = 100; // sistema base (0-100 ou 0-20 por exemplo): escala de notas
                        boolean controle = false;

                        do {
                            if(controle){
                                System.out.println("Valor fora dos limites, introduza um valor entre 0 e " + sistemaBase);
                            }
                            nota1 = FuncoesUi.VerificaDouble("Insira a nota do primeiro trimestre: ", "Tem que inserir um numero");
                            controle = true;
                        }while (nota1 < 0 || nota1 > sistemaBase);

                        controle = false;
                        do {
                            if(controle){
                                System.out.println("Valor fora dos limites, introduza um valor entre 0 e " + sistemaBase);
                            }
                            nota2 = FuncoesUi.VerificaDouble("Insira a nota do segundo trimestre: ", "Tem que inserir um numero");
                            controle = true;
                        }while (nota2 < 0 || nota2 > sistemaBase);

                        controle = false;
                        do {
                            if(controle){
                                System.out.println("Valor fora dos limites, introduza um valor entre 0 e " + sistemaBase);
                            }
                            nota3 = FuncoesUi.VerificaDouble("Insira a nota do terceiro trimestre: ", "Tem que inserir um numero");
                            controle = true;
                        }while (nota3 < 0 || nota3 > sistemaBase);


                        Estudante estudante = new Estudante(nome, nota1,nota2,nota3);
                        System.out.println(estudante);

                        FuncoesUi.Separador('#', 70, 2, 1);

                    }while (FuncoesUi.repetir("Repetir Calculos?", "s", "n"));
                    break;

                case 6:
                    do {
                        FuncoesUi.clearConsole();
                        FuncoesUi.Titulo(opcoesMenu[5], 70, '#', 0, 2);

                        double raio = FuncoesUi.VerificaDouble("Insira o valor do raio que o parta", "Tem que inserir um numero real...");
                        System.out.printf("O perímetro do circulo com o raio %.2f é de %.2f\n", raio, calculador.perimetroCirculo(raio));
                        System.out.printf("A area do círculo com o raio %.2f é de %.2f\n", raio, calculador.areaCirculo(raio));
                        System.out.printf("O volume da esfera com o raio %.2f é de %.2f", raio, calculador.volume(raio));


                        FuncoesUi.Separador('#', 70, 2, 1);
                    }while (FuncoesUi.repetir("Repetir Calculos?", "s", "n"));
                    break;

                case 7:
                    do {
                        FuncoesUi.clearConsole();
                        FuncoesUi.Titulo(opcoesMenu[6], 70, '#', 0, 2);

                        double qtdDolars = FuncoesUi.VerificaDouble("Quantos dolares pretende trocar","Tem que inserir um numero real...");
                        double cambioDolars = FuncoesUi.VerificaDouble("Insira a taxa de cambio do dolar","Tem que inserir um numero real...");
                        System.out.printf("O valor a pagar é %.2f€", CambioMoeda.conversão(qtdDolars, cambioDolars));

                        FuncoesUi.Separador('#', 70, 2, 1);
                    }while (FuncoesUi.repetir("Repetir Calculos?", "s", "n"));
                    break;

                case 8:
                    do {
                        FuncoesUi.clearConsole();
                        FuncoesUi.Titulo(opcoesMenu[7], 70, '#', 0, 2);

                        int numeroConta = FuncoesUi.VerificaInt("Introduza o numero de conta", "Tem que introduzir um numero inteiro");
                        Scanner entrada = new Scanner(System.in);
                        // nome
                        System.out.print("Introduza o nome: ");
                        String nome = entrada.next();

                        // Deposito inicial? função repetir faz pregunta e devolve um boleano consoante a resposta
                        boolean depositarInicio = FuncoesUi.repetir("Deseja fazer um depósito inicial?", "s", "n");
                        ContaBancaria novaConta;

                        if (depositarInicio){
                            // pedir o valor do deposito
                            double deposito = FuncoesUi.VerificaDouble("Introduza o valor de depósito inicial", "Tem de introduzir um numero");
                            //criar conta com deposito inicial
                            novaConta = new ContaBancaria(numeroConta, nome, deposito);
                        }else{
                            novaConta = new ContaBancaria(numeroConta, nome);

                        }

                        FuncoesUi.Separador('#', 70, 2, 1);
                        int operacao;
                        double fundos;
                        do {
                            FuncoesUi.clearConsole();
                            FuncoesUi.Titulo("Conta corrente", 70, '#', 0, 2 );
                            System.out.println(novaConta);
                            String[] operacoesBancarias = {
                                    "Adicionar fundos",
                                    "Levantamentos",
                                    };
                            operacao = FuncoesUi.Menu(
                                    "Operações bancárias",
                                    operacoesBancarias,
                                    "Operação a realizar",
                                    "Opção inválida",
                                    70,
                                    '-');

                            /* FALTA O SWITCH */

                            switch (operacao){
                                case 1:
                                    FuncoesUi.clearConsole();
                                    FuncoesUi.Titulo(operacoesBancarias[0], 70, '#', 0, 2 );
                                    fundos = FuncoesUi.VerificaDouble("Introduza valor", "Tem que introduzir um numero real.");
                                    novaConta.setSaldo(fundos);
                                    break;

                                case 2:
                                    FuncoesUi.clearConsole();
                                    FuncoesUi.Titulo(operacoesBancarias[1], 70, '#', 0, 2 );
                                    fundos = FuncoesUi.VerificaDouble("Introduza valor", "Tem que introduzir um numero real.");
                                    novaConta.setSaldo(-fundos);
                                    break;

                                default:
                                    System.out.println("A sair...");
                            }



                        }while (operacao != 0);

                    }while (FuncoesUi.repetir("Criar nova conta?", "s", "n"));
                    break;

                default:
                    System.out.println("a voltar ao menu anterior");
                    break;
            }
        }while (opcao != 0);
    }
    public triangulo CriaTrianguloValido(String pergunta){
        double lado1, lado2, lado3;
        triangulo novoTriangulo;
        boolean controle = false;
        do{
            if (controle){
                System.out.println("Lados do triangulo Inválido, introduza novamente:");
            }else{
                System.out.println(pergunta);
            }
            lado1 = FuncoesUi.VerificaDouble("\tInsira o Primeiro lado", "Tem que inserir um numero");
            lado2 = FuncoesUi.VerificaDouble("\tInsira o Segundo lado", "Tem que inserir um numero");
            lado3 = FuncoesUi.VerificaDouble("\tInsira o Terceiro lado", "Tem que inserir um numero");
            novoTriangulo = new triangulo(lado1,lado2,lado3);
            controle = true;
        }while (Double.isNaN(novoTriangulo.area));
        return novoTriangulo;
    }
}
