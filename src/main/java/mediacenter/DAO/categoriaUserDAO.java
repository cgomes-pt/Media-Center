/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mediacenter.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import mediacenter.connector;



public class categoriaUserDAO {
    connector con ;
    
    public categoriaUserDAO () {
                con = new connector();

    }

    public void insere(String username, Integer idMusica, Integer idClass) throws SQLException {
        
        Connection coneccao = con.connect();
        
        PreparedStatement ps = coneccao.prepareStatement("INSERT INTO categoriauser values(?,?,?)");
        ps.setString(1, username);
        ps.setInt(2, idMusica);
        ps.setInt(3, idClass);
     
        ps.executeUpdate();
        connector.close(coneccao);
    }
    
    public boolean verificaJaExiste(String username, Integer idMusica) throws SQLException {
        Connection coneccao = con.connect();
        PreparedStatement ps = coneccao.prepareStatement("SELECT username, idMusica from categoriauser where username = ? and idMusica = ?");
        ps.setString(1, username);
        ps.setInt(2, idMusica);
        ResultSet rs = ps.executeQuery();
        boolean resultado = rs.next();
        rs.close();
        connector.close(coneccao);
        
        return resultado;
    }
    
    public void atualizaCategoria(String username, Integer idMusica, Integer idClass) throws SQLException {
                
        Connection coneccao = con.connect();
        PreparedStatement ps = coneccao.prepareStatement("UPDATE categoriauser SET idClass = ? WHERE username = ? and idMusica = ?");
        ps.setInt(1,idClass);
        ps.setString(2, username);
        ps.setInt(3, idMusica);
        ps.executeUpdate();
        
        connector.close(coneccao);
    }


    
}
