import java.util.Scanner;
import java.util.Random;

public class JogoJokenpo {

    public static void main(String[] args) {

        int opcaoJogador;
        int opcaoComputador;
        int jogarNovamente = 1;
        Scanner teclado = new Scanner(System.in);
        Random rand = new Random();

        while (jogarNovamente == 1) {
            System.out.println("Digite uma opção (1-pedra;2-papel;3-tesoura):");
            opcaoJogador = teclado.nextInt();

            opcaoComputador = rand.nextInt(3)+1;

            if(opcaoJogador == opcaoComputador){
                System.out.println("Empate!!!");
            }else if(opcaoJogador == 1 && opcaoComputador==3){
                System.out.println("Jogador Ganhou!!");
            }else if(opcaoJogador == 2 && opcaoComputador==1){
                System.out.println("Jogador ganhou!!");
            }else if(opcaoJogador == 3 && opcaoComputador==2){
                System.out.println("Jogador ganhou!!");
            }else{
                System.out.println("Computador ganhou!!");
            }

            System.out.println("Jogar novamente? (1-sim; 0-não)");
            jogarNovamente = teclado.nextInt();
            
        }

    }

}