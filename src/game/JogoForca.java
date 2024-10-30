package game;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import logica.LogicaJogoForca;

public class JogoForca {
    public static void main(String[] args) {
        LogicaJogoForca jg = new LogicaJogoForca();
        BonecoForca boneco = new BonecoForca();
        Scanner sc = new Scanner(System.in);
        List<String> listaDeLetras = new ArrayList<>();
        
        int tentativasRestantes = 6;
        String PalavraAleatoria = jg.getPalavraAleatoria();
        
        System.out.println("===========================- JOGO DA FORCA -===========================");
        System.out.println("");
        System.out.println("ADIVINHE A PALAVRA ABAIXO: ");
        boneco.exibirBoneco(tentativasRestantes);
        jg.exibirPalavraAleatoria();
        System.out.print(" <-");
        System.out.println("");
        System.out.println("");
        System.out.println("=======================================================================");
        
        while (tentativasRestantes > 0) {
            try {
                System.out.println("");
                System.out.print("DIGITE UMA LETRA: ");
                String inputUsuario = sc.nextLine().toUpperCase();
                System.out.println("");
                
                // Verifica se o usuário digitou apenas uma letra
                if (inputUsuario.length() != 1 || !Character.isLetter(inputUsuario.charAt(0))) {
                    throw new IllegalArgumentException("POR FAVOR, DIGITE APENAS UMA LETRA!.");
                }
                
                jg.adicionarLetraNaPalavra(inputUsuario);
                System.out.println("");
                
                String palavraEmProgresso = String.join(" ", jg.getPalavraEmProgresso());
                String palavraDaForca = palavraEmProgresso.replace(" ", "");
                
                if (palavraDaForca.equalsIgnoreCase(PalavraAleatoria)) {
                    System.out.println("PARABÉNS!!! VOCÊ ACERTOU A PALAVRA: " + "'" + PalavraAleatoria + "'\n");
                    break;
                }
                
                if(!listaDeLetras.contains(inputUsuario)){
                    if (!PalavraAleatoria.contains(inputUsuario)) {
                        tentativasRestantes--;
                    }
                }

                listaDeLetras.addAll(jg.getListaLetrasUtilizadas()); 
                
                boneco.exibirBoneco(tentativasRestantes);
                jg.exibirPalavraAleatoria();
                System.out.println("");
                System.out.println("");
                
                System.out.println("TENTATIVAS RESTANTES: " + tentativasRestantes);
                System.out.println("");
                System.out.println("=======================================================================");
                System.out.println("");

                
            } catch (IllegalArgumentException e) {
                System.out.println("ERRO: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("OCORREU UM ERRO INESPERADO: " + e.getMessage());
            }
        }
        
        if (tentativasRestantes == 0) {
            System.out.println("FIM DE JOGO, A PALAVRA ERA: " + "'" + PalavraAleatoria + "'\n");
        }
        
        sc.close();
    }
}
