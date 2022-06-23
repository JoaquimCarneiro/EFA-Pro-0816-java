package com.java;

import Aulas.Aula01;
import Aulas.Aula02;
import Aulas.Aula03;
import Aulas.Aula04;

import java.util.Locale;

public class Main {

    public static void main(String[] args) {
        // System.out.println(Locale.getDefault());
        
        int opcao;
        String[] opcoesMenu = {"Aula 01/02 - Strings/Math ", "Aula 03/04 - Condições/loops", "Aula 05/06 - Objetos", "Aula 07/08 - Vetores"};
        do {
            FuncoesUi.clearConsole();
            opcao = FuncoesUi.Menu(
                    "Exercícios Java",
                    opcoesMenu,
                    "Insira uma opção",
                    "Opção inválida",
                    70,
                    '#'
            );

            switch (opcao) {
                case 1:
                    new Aula01(opcoesMenu[0]);
                    break;

                case 2:
                    new Aula02(opcoesMenu[1]);
                    break;

                case 3:
                    new Aula03(opcoesMenu[2]);
                    break;

                case 4:
                    new Aula04(opcoesMenu[3]);
                    break;

                default:
                    System.out.println("... bye, Bye ...");
                    break;
            }
        }while (opcao != 0);
    }
}