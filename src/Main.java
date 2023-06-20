import java.sql.SQLOutput;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        char[][] tabuleiro = new char[6][7];//coluna:7 linha:6
        CriarTabuleiro(tabuleiro);
        MostrarTablueito(tabuleiro);
        char corPlayer = EscolhaCor(teclado);
        char corRobo = CorRobo(corPlayer);
        JogadaPlayer(teclado, tabuleiro,corPlayer);
        MostrarTablueito(tabuleiro);
        JogadaRobo(teclado, tabuleiro, corRobo);
        System.out.println("");
        MostrarTablueito(tabuleiro);

    }

    public static void CriarTabuleiro(char[][]matriz){

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] =  'B';
            }
        }

    }

    public static void MostrarTablueito(char[][] matriz){
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println( );
        }
    }

    public static char EscolhaCor(Scanner teclado){
        System.out.println("Qual cor você vai querer?\nA - Azul\nV - Vermelho");
        char cor = teclado.next().toUpperCase().charAt(0);
        if(cor == 'A'){
            System.out.println("A cor escolhida é azul");
        }
        else{
            System.out.println("A cor escolhida é vermelho");
        }
        return cor;
    }

    public static char CorRobo(char cor){

        char corRobo = ' ';

        if(cor == 'A') corRobo = 'V';
        else corRobo = 'A';

        return corRobo;
    }
    public static void JogadaPlayer(Scanner teclado,char[][] matriz, char cor ){
        System.out.println("#-#-# SUA VEZ! -#-#-#");
        System.out.println("Qual coluna você quer? (Escolha de 1 á 7)");
        int coluna = teclado.nextInt();
        coluna--;
        for(int i = 5; i >= 0;i--){
            if(matriz[i][coluna] == 'B'){
                matriz[i][coluna] = cor;
                break;
            }
        }
        System.out.println();
    }

    public static void JogadaRobo(Scanner teclado, char[][] matriz, char cor){
        System.out.print("\n#-#-# VEZ DO ROBÔ -#-#-#");
        int min = 0;
        int max = 5;
        int coluna = (int) ((int) min + (Math.random() * (max - min)));
        for(int i = 5; i >= 0;i--){
            if(matriz[i][coluna] == 'B'){
                matriz[i][coluna] = cor;
                break;
            }
        }
        System.out.println();
    }



}