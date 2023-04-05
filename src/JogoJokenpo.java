import java.util.Scanner;
import java.util.Random;

public class JogoJokenpo {

    public static void main(String[] args) {

        int opcaoJogador;
        int opcaoComputador;
        Scanner teclado = new Scanner(System.in);
        Random rand = new Random();

        int numeroRodadas;
        int contadorRodadas = 0;

        int contadorVitoriasJogador = 0;
        int contadorVitoriasComputador = 0;

        int contPedraJogador = 0, contPedraComputador = 0;
        int contPapelJogador = 0, contPapelComputador = 0;
        int contTesouraJogador = 0, contTesouraComputador = 0;



        do {
            System.out.println("Digite o número de rodadas (deve ser impar):");
            numeroRodadas = teclado.nextInt();
        } while ((numeroRodadas % 2 == 0) || (numeroRodadas < 3));

        while (contadorRodadas < numeroRodadas) {
            System.out.println("#######");
            System.out.println("Rodada " + (contadorRodadas + 1) + "/" + numeroRodadas);
            System.out.println("#######");

            do {
                System.out.println("Digite uma opção (1-pedra;2-papel;3-tesoura):");
                opcaoJogador = teclado.nextInt();
            } while (opcaoJogador != 1 && opcaoJogador != 2 && opcaoJogador != 3);
            // }while(opcaoJogador < 1 || opcaoJogador>3)

            switch (opcaoJogador) {
                case 1:
                    contPedraJogador += 1;
                    break;
                case 2:
                    contPapelJogador += 1;
                    break;
                case 3:
                    contTesouraJogador += 1;
                    break;
            }

            opcaoComputador = rand.nextInt(3) + 1;

            switch (opcaoComputador) {
                case 1:
                    contPedraComputador += 1;
                    break;
                case 2:
                    contPapelComputador += 1;
                    break;
                case 3:
                    contTesouraComputador += 1;
                    break;
            }

            if (opcaoJogador == opcaoComputador) {
                System.out.println("Empate!!!");
            } else if (opcaoJogador == 1 && opcaoComputador == 3) {
                System.out.println("Jogador Ganhou!!");
                contadorVitoriasJogador += 1;
            } else if (opcaoJogador == 2 && opcaoComputador == 1) {
                System.out.println("Jogador ganhou!!");
                contadorVitoriasJogador += 1;
            } else if (opcaoJogador == 3 && opcaoComputador == 2) {
                System.out.println("Jogador ganhou!!");
                contadorVitoriasJogador = contadorVitoriasJogador + 1;
            } else {
                System.out.println("Computador ganhou!!");
                contadorVitoriasComputador += 1;
            }

            contadorRodadas += 1;

        }

        if (contadorVitoriasComputador == contadorVitoriasJogador) {
            System.out.println("Deu empate em tudo!!");
        } else if (contadorVitoriasJogador > contadorVitoriasComputador) {
            System.out.println("Jogador venceu!!!");
        } else {
            System.out.println("O computador venceu!!");
        }

        System.out.println("Relatório de Escolhas:");
        System.out.println("Jogador:");
        System.out.println("\tPedras:" + contPedraJogador +
                " Papel: " + contPapelJogador +
                " Tesoura: " + contTesouraJogador);
        System.out.println("Computador:");
        System.out.println("\tPedras:" + contPedraComputador +
                " Papel: " + contPapelComputador +
                " Tesoura: " + contTesouraComputador);

    }

}