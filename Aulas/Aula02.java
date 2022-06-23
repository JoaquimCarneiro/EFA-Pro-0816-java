package Aulas;

import com.java.FuncoesUi;

public class Aula02 {
    public Aula02(String titulo){
        int opcao;
        String[] opcoesMenu = {"Maior de 3"};
        do {
            FuncoesUi.clearConsole();
            opcao = FuncoesUi.Menu(
                    titulo,
                    opcoesMenu,
                    "Insira uma opção",
                    "Opção inválida",
                    70,
                    '#');
            switch (opcao) {
                case 1:
                    do {
                        FuncoesUi.clearConsole();
                        FuncoesUi.Titulo(opcoesMenu[0], 70, '#', 0, 2);
                        MaiorDeTres();
                        FuncoesUi.Separador('#', 70, 2, 1);
                    }while (FuncoesUi.repetir("Repetir?", "y", "n"));
                    break;

                default:
                    System.out.println("a voltar ao menu anterior");
                    break;
            }
        }while (opcao != 0);
    }

    public void MaiorDeTres(){
        int maior, numero1;

        maior = numero1 = FuncoesUi.VerificaInt("Insira o primeiro numero inteiro", "tem que introduzir um numero inteiro");
        int numero2 = FuncoesUi.VerificaInt("Insira o segundo numero inteiro", "tem que introduzir um numero inteiro");
        int numero3 = FuncoesUi.VerificaInt("Insira o terceiro numero inteiro", "tem que introduzir um numero inteiro");

        if(numero2 > maior){
            maior = numero2;
        }
        if (numero3 > maior){
            maior = numero3;
        }
        if (numero1 == numero2 && numero2 == numero3){
            System.out.printf("Os numeros são iguais: %d\n", numero1);
        }else{
            System.out.printf("O numero maior entre os numeros %d, %d e %d é %d\n", numero1, numero2, numero3, maior);
        }

    }
}
