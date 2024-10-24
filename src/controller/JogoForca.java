package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


import model.Palavras;

public class JogoForca {
    
    Random random = new Random();
    Palavras palavras = new Palavras();
    private String palavraAleatoria;
    private String[] palavraEmProgresso;
    List<String> listaLetrasUtilizadas = new ArrayList<>();

    public JogoForca() {
        this.palavraAleatoria = palavraAleatoriaForca().toUpperCase();
        this.palavraEmProgresso = new String[palavraAleatoria.length()];
        for (int i = 0; i < palavraAleatoria.length(); i++) {
            palavraEmProgresso[i] = "_";
        }
    }

    

    public String palavraAleatoriaForca(){
        List<String> listaPalavras = new ArrayList<>(palavras.getListaDePalavras());
        int indiceAleatorio = random.nextInt(listaPalavras.size());
        return listaPalavras.get(indiceAleatorio);
    }

    public void exibirPalavraAleatoria (){
        for(int i = 0; i < palavraAleatoria.length(); i++){
            System.out.print(palavraEmProgresso[i] + " ");
        }
    }

    public void adicionarLetraNaPalavra(String inputUsuario){

        inputUsuario = inputUsuario.toUpperCase();

        if(listaLetrasUtilizadas.contains(inputUsuario)){
            System.out.println("Esta letra já foi informada!");
            return;
        }
        else{
            if(palavraAleatoria.contains(inputUsuario)){
                for(int i = 0; i < palavraAleatoria.length(); i++){
                    if(palavraAleatoria.charAt(i) == inputUsuario.charAt(0)){
                        palavraEmProgresso[i] = inputUsuario;
                    }
                }
            }
            else{
                System.out.println("Letra Incorreta!");
            }
        }

        listaLetrasUtilizadas.add(inputUsuario);

        exibirPalavraAleatoria();
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("Letras utilizadas: " + listaLetrasUtilizadas);
    }



    public Random getRandom() {
        return random;
    }



    public Palavras getPalavras() {
        return palavras;
    }



    public String getPalavraAleatoria() {
        return palavraAleatoria;
    }



    public String[] getPalavraEmProgresso() {
        return palavraEmProgresso;
    }



    public List<String> getListaLetrasUtilizadas() {
        return listaLetrasUtilizadas;
    }

    
}
