/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mediacenter;

/**
 *
 * @author Rengar
 */
public class playlists {
    
    private Integer id;
    private String username;
    private String nomePlayList;
    
    public playlists() {
        
        id = 0;
        username ="";
        nomePlayList ="";
    }
    
    public playlists (Integer id1, String username1, String nomePlayList1) {
        id = id1;
        username = username1;
        nomePlayList = nomePlayList1;
    }
    
    
    public Integer getPlayListID() {
        return id;
    }
    
    public String getUsername() {
        return username;
    }
    
    public String getPlayListName() {
        return nomePlayList;
    }
    
    public void setPlayListID(Integer id1) {
        id = id1;
    }
    
    public void setUsername (String username1) {
        username = username1;
    }
    
    public void setPlayListName(String name) {
        nomePlayList = name;
    }
    
    
    
    
    
    
    
    
    
}
