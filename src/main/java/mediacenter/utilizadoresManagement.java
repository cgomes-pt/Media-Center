/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mediacenter;

import mediacenter.DAO.utilizadoresDAO;
import java.sql.SQLException;
import java.util.HashMap;

/**
 *
 * @author Utilizador
 */
public class utilizadoresManagement {
    private utilizadoresDAO utilizadores;
    private playlistsUserManagement pls;
    
    public utilizadoresManagement() {
        utilizadores = new utilizadoresDAO();
        pls = new playlistsUserManagement();
    }
    
    
    
    public utilizador verificaUtilizador(String username, String password) throws SQLException, PassException, UtilizadorException {
        utilizador user;
        
        if(utilizadores.verificaID(username)) {
            user = utilizadores.getUser(username);
            if(user.getPassword().equals(password)) {
               user.setPlayLists((HashMap<Integer, playlistsUser>) pls.playlistsUser(username));
              
               return user; 
            }
            else throw new PassException("Password incorreta!");
        }
        else throw new UtilizadorException("Este user não existe!");
    }
    
    
    public void changePassword(String dsa, String password) throws SQLException {
        utilizadores.novaPassword(dsa, password);
    }
    
    
}
