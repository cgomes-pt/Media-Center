
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import mediacenter.Interface.login;
import mediacenter.MediaCenter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class Main {
    
    
    
    public static void main(String[] args) {
        try {
            MediaCenter mediacenter = new MediaCenter();
            login frame = new login(mediacenter);
            frame.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }
    
    
}
