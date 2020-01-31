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
import java.util.ArrayList;
import java.util.HashMap;
import mediacenter.Media;
import mediacenter.connector;
import mediacenter.mediaManagement;
import mediacenter.playlists;

public class playlistsUsersDAO {
    
    
    connector con ;
    
    public playlistsUsersDAO(){
        con = new connector();
    }
    
    
    public ArrayList<Media> teste(Integer idLista) throws SQLException {
        ArrayList<Media> test = new ArrayList<>();
        
        Connection coneccao = con.connect();
        PreparedStatement ps = coneccao.prepareStatement("select * from playlists_users where playlistID = ?");
        ps.setString(1, Integer.toString(idLista));
        
        ResultSet rs = ps.executeQuery();
        
        while (rs.next()) { 
            int mediaID = rs.getInt("mediaID");
            MediaDAO temporario = new MediaDAO();
            Media result = temporario.getMedia(mediaID);
             
            test.add(result);
        }
        

        rs.close();
        connector.close(coneccao);
        
        return test;
               
        
    }
    
    
    
}
