package logica;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import DAO.PalavraDAO;
import entity.Palavras;

public class LogicaJogoForca {
    private Random random = new Random();
    private Palavras palavras = new Palavras();
    private String palavraAleatoria;
    private String[] palavraEmProgresso;
    private List<String> listaLetrasUtilizadas = new ArrayList<>();

    public LogicaJogoForca() {
        // Carrega palavras do banco de dados uma vez
        PalavraDAO.buscarPalavra(palavras);
        
        // Seleciona uma palavra aleatória
        this.palavraAleatoria = palavraAleatoriaForca().toUpperCase();
        
        // Inicializa a palavra em progresso
        this.palavraEmProgresso = new String[palavraAleatoria.length()];
        for (int i = 0; i < palavraAleatoria.length(); i++) {
            palavraEmProgresso[i] = "_";
        }
    }

    public String palavraAleatoriaForca() {
        List<String> listaPalavras = new ArrayList<>(palavras.getListaDePalavras());
        int indiceAleatorio = random.nextInt(listaPalavras.size());
        return listaPalavras.get(indiceAleatorio);
    }

    public void exibirPalavraAleatoria() {
        for (int i = 0; i < palavraAleatoria.length(); i++) {
            System.out.print(palavraEmProgresso[i] + " ");
        }
    }

    public void adicionarLetraNaPalavra(String inputUsuario) {
        inputUsuario = inputUsuario.toUpperCase();

        if (listaLetrasUtilizadas.contains(inputUsuario)) {
            System.out.println("ESTA LETRA JÁ FOI INFORMADA, DIGITE OUTRA LETRA.");
            return;
        } else {
            if (palavraAleatoria.contains(inputUsuario)) {
                for (int i = 0; i < palavraAleatoria.length(); i++) {
                    if (palavraAleatoria.charAt(i) == inputUsuario.charAt(0)) {
                        palavraEmProgresso[i] = inputUsuario;
                    }
                }
            } else {
                System.out.println("A PALAVRA NÃO CONTÉM ESTA LETRA!\n");
            }
        }

        listaLetrasUtilizadas.add(inputUsuario);
        System.out.println("LETRAS UTILIZADAS: " + listaLetrasUtilizadas);
    }

    public Random getRandom() {
        return random;
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
