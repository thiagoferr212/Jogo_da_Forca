package entity;

import java.util.HashSet;
import java.util.Set;

import DAO.PalavraDAO;

public class Palavras {
    
    private Set<String> listaDePalavras;
    private String categoria;
    private PalavraDAO pala;
    
    public Palavras() {
        this.listaDePalavras = new HashSet<>();
        this.pala = new PalavraDAO();
        adicionarPalavras();
    }
    public Set<String> getListaDePalavras() {
        return listaDePalavras;
    }
    
    public String getCategoria() {
        return categoria;
    }
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void adicionarPalavras(){
        pala.buscarPalavra();

        listaDePalavras.addAll(pala.palavrasDaTabelaMap.keySet());
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
