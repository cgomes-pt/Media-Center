/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mediacenter;

import java.util.ArrayList;
import java.util.HashMap;
import mediacenter.Media;


public class playlistsUser {
    
    private playlists pl;
    private ArrayList<Media> musicas;
    
    
    public playlistsUser() {
        pl = new playlists();
        musicas = new ArrayList<>();
        
    }
    
    public playlistsUser(playlists pl1, ArrayList<Media> musicas1) {
        pl = pl1;
        musicas = musicas1;
    }
    
    public playlists getPlayLists() {
        return pl;
    }
    
    public ArrayList<Media> getMusicas() {
        return musicas;
    }
}
