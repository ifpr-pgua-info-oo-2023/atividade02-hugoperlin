import java.util.Scanner;
import java.util.Random;

public class JogoJokenpo {

    static final int PEDRA = 1;
    static final int PAPEL = 2;
    static final int TESOURA = 3;

    static int contadorVitoriasJogador = 0;
    static int contadorVitoriasComputador = 0;

    static String verificarResultado(int opcaoJogador, int opcaoComputador){
        if (opcaoJogador == opcaoComputador) {
            return "Empate!!!";
        } else if (opcaoJogador == PEDRA && opcaoComputador == TESOURA) {
            contadorVitoriasJogador += 1;
            return "Jogador Ganhou!!";
        } else if (opcaoJogador == PAPEL && opcaoComputador == PEDRA) {
            contadorVitoriasJogador += 1;
            return "Jogador ganhou!!";
        } else if (opcaoJogador == TESOURA && opcaoComputador == PAPEL) {
            
            contadorVitoriasJogador = contadorVitoriasJogador + 1;
            return "Jogador ganhou!!";
        } else {
            contadorVitoriasComputador += 1;
            return "Computador ganhou!!";
        }
    }

    public static void main(String[] args) {

        int opcaoJogador;
        int opcaoComputador;
        Scanner teclado = new Scanner(System.in);
        Random rand = new Random();

        int numeroRodadas;
        int contadorRodadas = 0;

        int[] contOpcoesJogador = new int[3];
        int[] contOpcoesComputador = new int[3];



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
            } while (opcaoJogador != PEDRA && opcaoJogador != PAPEL && opcaoJogador != TESOURA);
            // }while(opcaoJogador < 1 || opcaoJogador>3)


            contOpcoesJogador[opcaoJogador-1] = 
                          contOpcoesJogador[opcaoJogador-1] + 1;

            //contOpcoesJogador[opcaoJogador-1] ++;
            
            opcaoComputador = rand.nextInt(3) + 1;

            contOpcoesComputador[opcaoComputador-1] +=1 ;

            String resultado = verificarResultado(opcaoJogador, opcaoComputador);

            System.out.println(resultado);

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
        System.out.println("\tPedras:" + contOpcoesJogador[0] +
                " Papel: " + contOpcoesJogador[1] +
                " Tesoura: " + contOpcoesJogador[2]);
        System.out.println("Computador:");
        System.out.println("\tPedras:" + contOpcoesComputador[0] +
                " Papel: " + contOpcoesComputador[1] +
                " Tesoura: " + contOpcoesComputador[2]);

    }

}