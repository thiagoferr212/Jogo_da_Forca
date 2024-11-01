package DAO;

import java.util.HashMap;
import java.util.Map;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import conexao.Conexao;

public class PalavraDAO {

    public Map<String, String> palavrasDaTabelaMap = new HashMap<>();

    public void buscarPalavra(){

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultset = null;
        
        try{
            connection = Conexao.getConexao();
            String sql = "SELECT * FROM palavras";
            statement = connection.prepareStatement(sql);
            resultset = statement.executeQuery();

            while (resultset.next()) {
                String palavra = resultset.getString("palavra");
                String categoria = resultset.getString("categoria");

                palavrasDaTabelaMap.put(palavra, categoria);
            }

        }
        catch(SQLException e){
            e.printStackTrace();
        }

        finally{
            try{
                if(resultset != null) resultset.close();
                if(statement != null) statement.close();
                if (connection != null) connection.close();
            }
            catch(SQLException e){
                e.printStackTrace();
            }
        }

    }
    
}
