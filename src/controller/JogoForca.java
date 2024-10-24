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

    
    
    public JogoForca() {
        this.palavraAleatoria = palavraAleatoriaForca();
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

    public void adicionarLetraNaPalavra(String inputUsuario){

        List<String> listaLetrasUtilizadas = new ArrayList<>();

        if(palavraAleatoriaForca().contains(inputUsuario)){
            palavraEmProgresso[palavraAleatoriaForca().indexOf(inputUsuario)] = inputUsuario;
            listaLetrasUtilizadas.add(inputUsuario);
        }
        else{
            listaLetrasUtilizadas.add(inputUsuario);
        }

        for(int i = 0; i < palavraAleatoriaForca().length(); i++){
            System.out.print(palavraEmProgresso[i]);
        }
    }

    public static void main(String[] args) {
        JogoForca jg = new JogoForca();

    }

}
