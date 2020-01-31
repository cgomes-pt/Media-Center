/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mediacenter;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import mediacenter.DAO.playlistsDAO;
import mediacenter.DAO.playlistsUsersDAO;


public class playlistsUserManagement {
    
    
    private playlistsUsersDAO pls;
    private playlistsDAO playlists;
    
    
    public playlistsUserManagement() {
        pls = new playlistsUsersDAO();
        playlists = new playlistsDAO();
      
    }
    
    public Map<Integer,playlistsUser> playlistsUser(String username) throws SQLException {
        HashMap <Integer,playlistsUser> resultado = new HashMap<>();
        ArrayList<playlists> temp = playlists.getAllPlayLists(username);
        
        
        for (playlists p : temp) {
            ArrayList<Media> media = pls.teste(p.getPlayListID());
            playlistsUser novo = new playlistsUser(p,media);
            resultado.put(p.getPlayListID(), novo);
        }
        
        
        return resultado;
    }
    

    
    
    
}
