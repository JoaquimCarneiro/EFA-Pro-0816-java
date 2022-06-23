package com.java;

import java.io.IOException;
import java.util.Scanner;

public class FuncoesUi {

    /******* Elementos UI *******/

    /* Menus Genéricos */
    public static int Menu(
            String titulo,
            String[] opcoes,
            String pergunta,
            String msgErro,
            int tamanhoLinha,
            char carDelimitador
    ){
        int opcao;
        boolean controle = false;
        Titulo(titulo, tamanhoLinha, carDelimitador, 0, 1);
        Separador('-', tamanhoLinha, 1, 0);
        for (int i = 0; i < opcoes.length; i++) {
            System.out.printf("\t[%d] - %s\n", i + 1, opcoes[i]);
        }
        Separador('-', tamanhoLinha, 1, 0);
        System.out.print("\t[0] - Sair\n");
        Separador(carDelimitador, tamanhoLinha, 1, 1);
        do {
            if (controle){
                System.out.printf(msgErro + ", ");
            }
            opcao = VerificaInt(pergunta, msgErro);
            controle = true;
        }while (opcao < 0 || opcao > opcoes.length);
        return opcao;
    }
    /* Criação de títulos */
    public static void Titulo(String titulo, int tamanhoLinha, char carDelimitador, int quebraAntes, int quebraApos){
        Separador(carDelimitador, tamanhoLinha, 1, quebraAntes);
        //System.out.printf(titulo);
        centrarString(titulo, tamanhoLinha, carDelimitador);
        Separador(carDelimitador, tamanhoLinha, quebraApos, 1);
    }

    /* Separador */
    public static void Separador(char carDelimitador, int tamanhoLinha, int quebraApos, int quebraAntes){
        if (quebraAntes > 0){
            for (int k = 0; k < quebraAntes; k++){
                System.out.print("\n");
            }
        }
        for (int i = 0; i < tamanhoLinha; i++){
            System.out.printf("%S", carDelimitador);
        }
        if (quebraApos > 0){
            for (int j = 0; j < quebraApos; j++){
                System.out.print("\n");
            }
        }
    }

    public static void centrarString(String texto, int tamanhoLinha, char carDelimitador){
        int espacamento = (tamanhoLinha-2-texto.length());
        System.out.print(carDelimitador);
        for (int i = 0; i < espacamento / 2; i++){
            System.out.print(" ");
        }
        System.out.printf(texto);
        for (int i = 0; i < espacamento / 2; i++){
            System.out.print(" ");
        }
        if (espacamento % 2 != 0){
            System.out.print(" ");
        }
        System.out.print(carDelimitador);
    }
    public static void clearConsole()
    {
        // funciona só no terminal mas corretamente
        try{
            String os = System.getProperty("os.name");
            if (os.contains("Windows")){
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            }else {
                new ProcessBuilder("sh", "-c", "clear").inheritIO().start().waitFor();
            }
        }catch(IOException | InterruptedException ex) {
            System.out.println("clear só é visivel em linha de comandos");
        }
    }

    /* Continuar */
    public static void continuar(String pergunta, String opcao){
        System.out.printf("%s (%s): ", pergunta, opcao);
        Scanner entrada = new Scanner(System.in);
        while (!entrada.nextLine().equals(opcao)){
            System.out.printf("Valor errado... %s (%s): ", pergunta, opcao);
        }
    }

    public static boolean repetir(String pergunta, String repetir, String continuar){
        System.out.printf("%s (%s/%s): ", pergunta, repetir, continuar);
        Scanner entrada = new Scanner(System.in);
        String teste;
        boolean controle = false;
        do {
            if (controle){
                System.out.printf("Opção errada... %s (%s/%s): ", pergunta, repetir, continuar);
            }
            teste = entrada.nextLine();
            controle = true;
        }while (!teste.equals(repetir) && !teste.equals(continuar));
        if (teste.equals(repetir)){
            return true;
        }else {
            return false;
        }

    }

    /******* Verificação de input *******/
    /* Faz pergunta e devolve String */
    public static String fazPergunta(String pergunta){
        System.out.printf("%s: ", pergunta);
        Scanner entrada = new Scanner(System.in);
        String out = entrada.nextLine();
        return out;
    }

    /* Faz uma pergunta e verifica se a resposta é um número */
    public static int VerificaInt(String pergunta, String msgErro){
        System.out.printf(pergunta + ": ");
        Scanner entrada = new Scanner(System.in);

        while (!entrada.hasNextInt()){
            System.out.printf(msgErro + ", " + pergunta + ": ");
            entrada.next();
        }
        return entrada.nextInt();
    }

    public static double VerificaDouble(String pergunta, String msgErro){
        System.out.printf(pergunta + ": ");
        Scanner entrada = new Scanner(System.in);
        while (!entrada.hasNextDouble()){
            System.out.printf(msgErro + ", " + pergunta + ": ");
            entrada.next();
        }
        return entrada.nextDouble();
    }
}
