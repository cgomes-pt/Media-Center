/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mediacenter;

import mediacenter.DAO.MediaDAO;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Rengar
 */
public class mediaManagement {
    private MediaDAO media;
    
    public mediaManagement() {
        media = new MediaDAO();
    }
    
    
    public Media getMedia(String name, String formato) throws SQLException {
        Media resultado = media.getMedia(name, formato);
        return resultado;
    }
    
    public Map<String,Media> getListaMedia() throws SQLException {
        Map<String,Media> resultado = new HashMap<>(media.mediaMap());
       
        return resultado;
    }
    
    
    public Map<String,Media> getMediaAutor(String name) throws SQLException {
       
        Map<String,Media> resultado = new HashMap<>(media.getMediaAutor(name));
        return resultado;
    }
    
    public boolean verificaSeJaExiste(String name, String formato) throws SQLException {
        return media.contemMedia(name, formato);
    }
    
    public boolean verificaExisteMediaUser(String name, Integer id) throws SQLException {
        return media.contemMediaUser(name, id);
    }
    
    public void insereMedia(Media m) throws SQLException {
        media.insereMedia(m);
    }
    
    
    
}
