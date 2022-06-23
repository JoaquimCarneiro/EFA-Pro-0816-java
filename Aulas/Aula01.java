package Aulas;

import com.java.FuncoesUi;

public class Aula01 {
    public Aula01(String titulo){
        int opcao;
        String[] opcoesMenu = {"Manipular Strings", "Usar Math"};
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
                    manipularStrings();
                    FuncoesUi.Separador('#', 70, 2, 1);
                    FuncoesUi.continuar("Continuar?", "s");
                    break;

                case 2:
                    FuncoesUi.clearConsole();
                    FuncoesUi.Titulo(opcoesMenu[1], 70, '#', 0, 2);
                    UsarMath();
                    FuncoesUi.Separador('#', 70, 2, 1);
                    FuncoesUi.continuar("Continuar?", "s");
                    break;

                default:
                    System.out.println("a voltar ao menu anterior");
                    break;
            }
        }while (opcao != 0);
    }
    public void manipularStrings(){
        String original = "              abcde FGHIJ ABC abc DEFG ";

        System.out.println("Original: " + original );
        /* Para maiusculas */
        String upper = original.toUpperCase();
        System.out.println("Original to uppercase: " + upper);
        /* Para minúsculas */
        String lower = original.toLowerCase();
        System.out.println("Original to lower: " + lower);
        /* limpar espaços no inicio e fim*/
        String trim = original.trim();
        System.out.println("Original trimmed: " + trim);
        /* subsrtings */
        String novaString = original.trim();
        novaString = novaString.substring(novaString.indexOf(" "), novaString.lastIndexOf(" "));
        System.out.println("Substring: " + novaString);
        /*  */
        String replace = original.replace('a', 'y');
        System.out.println("Replace char in Original: " + replace);
        String[] betore = trim.split(" ");
        System.out.println("Replace char in Original: " + betore[1]);
    }
    public void UsarMath(){
        double numero=40;
        double raizQuadrada = Math.sqrt(numero);

        System.out.printf("A raiz quadrada de %.2f é %.2f\n",numero , raizQuadrada);
    }
}
