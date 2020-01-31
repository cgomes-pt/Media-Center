/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mediacenter;
 
import java.sql.SQLException;
import mediacenter.DAO.categoriaUserDAO;



public class categoriauser {

    private categoriaUserDAO categorias;
    
    
    public categoriauser() {
        categorias = new categoriaUserDAO();
    }
    
    public void atualizaCategoria(String username, Integer idMusica, Integer idClass) throws SQLException {
        if(categorias.verificaJaExiste(username, idMusica)) {
            categorias.atualizaCategoria(username, idMusica, idClass);
        }
        else {
            categorias.insere(username, idMusica, idClass);
        }
    }
}
