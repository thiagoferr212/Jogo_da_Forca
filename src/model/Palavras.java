package model;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Palavras {
    
    private Set<String> listaDePalavras;
    
    public Palavras() {
        this.listaDePalavras = new HashSet<>(Arrays.asList("Carro", "Abelha", "Livro", "Quadro", "Caneta"));
    }
    public Set<String> getListaDePalavras() {
        return listaDePalavras;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((listaDePalavras == null) ? 0 : listaDePalavras.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Palavras other = (Palavras) obj;
        if (listaDePalavras == null) {
            if (other.listaDePalavras != null)
                return false;
        } else if (!listaDePalavras.equals(other.listaDePalavras))
            return false;
        return true;
    }

    
}
