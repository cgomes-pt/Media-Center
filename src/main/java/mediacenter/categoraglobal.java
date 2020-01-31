/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mediacenter;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import mediacenter.DAO.categoriaglobalDAO;

public class categoraglobal {

    private categoriaglobalDAO categorias;

    public categoraglobal() {
        categorias = new categoriaglobalDAO();
    }

    public String[] categoriasLista() throws SQLException {
        
        ArrayList<categoria> categoriasL = categorias.getCategorias();
        ArrayList<String> temp = new ArrayList<>();
        for (categoria c : categoriasL) {
            temp.add(c.getNome());
        }
        
        String[] resultado = temp.toArray(new String[0]);

        return resultado;
    }
    
    public ArrayList<categoria> getTodasCategorias() throws SQLException {
        return categorias.getCategorias();
    }
    
    public categoria getCategoria(String name) {
        try {
            ArrayList<categoria> lista = categorias.getCategorias();
            for (categoria c : lista) {
                if (c.getNome().equals(name)) return c;
            }
        } catch (SQLException ex) {
            Logger.getLogger(categoraglobal.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
        
    }
    
    
}
