package com.rpg.util;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class InputManager {

    private static final Scanner scanner = new Scanner(System.in);

    // Lê um número inteiro dentro de um intervalo [min, max]
    public static int lerInteiro(String mensagem, int min, int max) {
        int valor = 0;
        boolean valido = false;

        while (!valido) {
            try {
                System.out.print(mensagem + " ");
                valor = Integer.parseInt(scanner.nextLine().trim());

                if (valor < min || valor > max) {
                    System.out.println("Valor fora do intervalo permitido (" + min + " - " + max + "). Tente novamente.");
                } else {
                    valido = true;
                }

            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Digite um número inteiro.");
            } catch (NoSuchElementException e) {
                System.out.println("Nenhuma entrada detectada. Tente novamente.");
                scanner.nextLine(); 
            }
        }

        return valor;
    }

    // Lê uma string (linha de texto)
    public static String lerString(String mensagem) {
        String entrada = "";
        boolean valido = false;

        while (!valido) {
            try {
                System.out.print(mensagem + " ");
                entrada = scanner.nextLine().trim();

                if (entrada.isEmpty()) {
                    System.out.println("⚠️ Entrada vazia. Digite algo.");
                } else {
                    valido = true;
                }

            } catch (NoSuchElementException e) {
                System.out.println("⚠️ Erro ao ler texto. Tente novamente.");
                scanner.nextLine(); // limpa o buffer
            }
        }

        return entrada;
    }

    // Lê uma resposta sim/não (s/n)
    public static boolean lerSimNao(String mensagem) {
        while (true) {
            System.out.print(mensagem + " ");
            String entrada = scanner.nextLine().trim().toLowerCase();

            if (entrada.equals("s")) {
                return true;
            } else if (entrada.equals("n")) {
                return false;
            } else {
                System.out.println("⚠️ Entrada inválida. Digite apenas 's' ou 'n'.");
            }
        }
    }

    // Espera o usuário pressionar Enter
    public static void esperarEnter(String mensagem) {
        System.out.print(mensagem);
        scanner.nextLine();
    }

    // Fecha o Scanner (chamar uma única vez ao final do programa)
    public static void fecharScanner() {
        if (scanner != null) {
            scanner.close();
        }
    }
}
