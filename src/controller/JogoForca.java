package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import model.Palavras;

public class JogoForca {
    
    private String imputUsuario;
    
    Palavras palavras = new Palavras();
    
    public String getImputUsuario() {
        return imputUsuario;
    }
    public void setImputUsuario(String imputUsuario) {
        this.imputUsuario = imputUsuario;
    }
    
    public void verificarLetra (String imputUsuario){
        List<String> listaLetrasCertas = new ArrayList<>();
        List<String> listaLetrasUtilizadas = new ArrayList<>();
        Set<String> listaPalavras = palavras.getListaDePalavras();

        for(String p : listaPalavras){
            if(p.contains(imputUsuario)){
                listaLetrasCertas.add(imputUsuario);
                listaLetrasUtilizadas.add(imputUsuario);
            }
            else{
                listaLetrasUtilizadas.add(imputUsuario);
            }
        }
    }
}
