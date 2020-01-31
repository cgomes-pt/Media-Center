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
import java.util.List;
import mediacenter.categoria;
import mediacenter.connector;

public class categoriaglobalDAO {
      connector con ;
      
      
      public categoriaglobalDAO() {
          con = new connector();
      }
      
      
      public ArrayList<categoria> getCategorias() throws SQLException {
          ArrayList<categoria> resultado = new ArrayList<>();
          
          Connection coneccao = con.connect();
        
          PreparedStatement ps = coneccao.prepareStatement("select * from categoriaglobal");
          ResultSet rs = ps.executeQuery();
          
          while(rs.next()) {
              resultado.add(new categoria(rs.getString("name"), rs.getInt("id")));
          }
          
         rs.close();
         connector.close(coneccao);
          
          return resultado;
      }
      
      public String idCategoria(Integer id) throws SQLException {
          String resultado = new String();
          
          Connection coneccao = con.connect();
        
          PreparedStatement ps = coneccao.prepareStatement("select * from categoriaglobal where id = ?");
          ps.setInt(1,id);
          ResultSet rs = ps.executeQuery();
          
          if (rs.next()) resultado = rs.getString("name");
          
         rs.close();
         connector.close(coneccao);
          
          return resultado;
      }
      
      
      
}
