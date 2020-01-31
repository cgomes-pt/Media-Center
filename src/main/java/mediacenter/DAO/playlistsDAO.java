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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import mediacenter.connector;
import mediacenter.playlists;
import mediacenter.utilizador;
import mediacenter.connector;
public class playlistsDAO {
    
    
    connector con ;
    
    public playlistsDAO() {
        con = new connector();
    }
    
    
 
    
    
    public ArrayList<playlists> getAllPlayLists(String username) throws SQLException {
        ArrayList<playlists> resultado = new ArrayList<>();
        Connection coneccao = con.connect();
        
        PreparedStatement ps = coneccao.prepareStatement("select id, name from utilizadores INNER JOIN playlists ON utilizadores.username = playlists.username and utilizadores.username = ?");
        ps.setString(1,username);
        ResultSet rs = ps.executeQuery();
        
        
        while (rs.next()) { 
            playlists temporario = new playlists();
            temporario.setPlayListID(rs.getInt("id"));
            temporario.setPlayListName(rs.getString("name"));
            temporario.setUsername(username);
            resultado.add(temporario);
        }
        

        rs.close();
        connector.close(coneccao);
        
        return resultado;
        
        
    }
    
    
}
