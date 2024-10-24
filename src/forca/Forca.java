package forca;

import java.util.Scanner;

import controller.JogoForca;

public class Forca {
    public static void main(String[] args) {
        
        JogoForca jg = new JogoForca();
        Scanner sc = new Scanner(System.in);

        int tentativasRestantes = 6;

        System.out.println("Adivinhe a Palavra: ");
        jg.exibirPalavraAleatoria();
        System.out.println("");
        System.out.println("");
        
        while (tentativasRestantes > 0) {
            System.out.print("Digite uma letra: ");
            String inputUsuario = sc.nextLine();

            jg.adicionarLetraNaPalavra(inputUsuario);
            System.out.println("");

            String palavraFormada = String.join(" ",jg.getPalavraEmProgresso());

            if(palavraFormada.equalsIgnoreCase(jg.getPalavraAleatoria())){
                System.out.println("Parabéns você acertou a palavra: " + jg.getPalavraAleatoria());
                break;
            }

            if(!jg.getPalavraAleatoria().contains(inputUsuario)){
                tentativasRestantes--;
            }

            System.out.println("Tentativas restantes: " + tentativasRestantes);
        }

        if(tentativasRestantes == 0){
            System.out.println("Fim de jogo, a palavra era: " + jg.getPalavraAleatoria());
        }

        sc.close();
        
    }

}
