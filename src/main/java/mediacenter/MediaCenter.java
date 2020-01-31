/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mediacenter;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import mediacenter.Interface.Definicoes;



public class MediaCenter {
    private utilizador user;
    private utilizadoresManagement users;
    private mediaManagement medias;
    
    private categoraglobal categorias;
    private categoriauser categoriasUsers;

    
    public MediaCenter() {
        user = null;
        users = new utilizadoresManagement();
        medias = new mediaManagement();
        
        categorias = new categoraglobal();
        categoriasUsers = new categoriauser();
    }   
    
    
    
    public void iniciarSessao(String username, String password) throws SQLException, PassException, UtilizadorException, DadosException {
        try {
            this.user = users.verificaUtilizador(username, password);
        } catch(SQLException | PassException | UtilizadorException   e) {
            throw new DadosException(e.getMessage());
        }
    }
    
     
    
    public utilizador getUser() {
        return user;
    }
    
    public mediaManagement getMediaManagement(){
        return medias;
    }
    
    public categoraglobal getCategoriaManagement() {
        return categorias;
    }
    
    public utilizadoresManagement getUtilizadoresManagement() {
        return users;
    }
    
    public categoriauser getCategoriaUserManagement() {
        return categoriasUsers;
    }
}
