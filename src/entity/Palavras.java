package entity;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Palavras {

    private Map<String, String> palavrasComCategoria = new HashMap<>(); // Palavra e sua categoria

    public void setPalavrasComCategoria(Map<String, String> palavras) {
        this.palavrasComCategoria.clear(); // Limpa antes de adicionar
        this.palavrasComCategoria.putAll(palavras); // Adiciona todas as palavras e categorias
    }

    public Set<String> getListaDePalavras() {
        return palavrasComCategoria.keySet(); // Retorna apenas as palavras
    }

    public String getCategoria(String palavra) {
        return palavrasComCategoria.get(palavra); // Retorna a categoria da palavra
    }
}
