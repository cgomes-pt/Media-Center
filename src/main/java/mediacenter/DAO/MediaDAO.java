/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mediacenter.DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.Set;
import java.sql.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import mediacenter.Media;
import mediacenter.connector;
/**
 *
 * @author Rengar
 */
public class MediaDAO {
    
    
    private connector con ;
    
    
    public MediaDAO() {
        con = new connector();
    }
    
    
    public boolean contemMedia(String name, String formato) throws SQLException {
        
        Connection coneccao = con.connect();
        
        PreparedStatement ps = coneccao.prepareStatement("SELECT * FROM media WHERE nome = ?");
        ps.setString(1,name);
        
        ResultSet rs = ps.executeQuery();
        
        boolean resultado = rs.next();
        connector.close(coneccao);
        
        return resultado;
    }
    
    public Map<String,Media> getMediaAutor(String name) throws SQLException {
        Connection coneccao = con.connect();
        
        PreparedStatement ps = coneccao.prepareStatement("SELECT * FROM media WHERE autor = ?");
        ps.setString(1,name);
        
        ResultSet rs = ps.executeQuery();
        Map<String,Media> resultado = new HashMap<>();
        while(rs.next()) {
            Media media = new Media();
            media.setNome(rs.getString("nome"));
            media.setTempo(rs.getString("tempo"));
            media.setAutor(rs.getString("autor"));
            media.setTamanho(rs.getString("tamanho"));
            media.setFormato(rs.getString("formato"));
            media.setDiretoria(rs.getString("diretoria"));
            media.setUploadedBy(rs.getString("uploadedBy"));
            media.setAdded(rs.getString("added"));
            media.setCategoria(rs.getString("categoria"));
            resultado.put(rs.getString("nome"),media);
        }
        
        connector.close(coneccao);
        
        return resultado;
    }
    
    
    
    public Media getMedia(String name, String formato) throws SQLException {
        Media resultado = new Media();
        Connection coneccao = con.connect();
        
        PreparedStatement ps = coneccao.prepareStatement("SELECT * FROM media WHERE nome = ? and formato = ?");
        ps.setString(1,name);
        ps.setString(2,formato);
        
        ResultSet rs = ps.executeQuery();
        
        if (rs.next()) {
            
            resultado.setID(rs.getInt("id"));
            resultado.setNome(rs.getString("nome"));
            resultado.setTempo(rs.getString("tempo"));
            resultado.setAutor(rs.getString("autor"));
            resultado.setTamanho(rs.getString("tamanho"));
            resultado.setFormato(rs.getString("formato"));
            resultado.setDiretoria(rs.getString("diretoria"));
            resultado.setUploadedBy(rs.getString("uploadedBy"));
            resultado.setAdded(rs.getString("added"));
            resultado.setCategoria(rs.getString("categoria"));
        }
        
        connector.close(coneccao);
        
        return resultado;
    }
    
    public Media getMedia(Integer id) throws SQLException {
        Media resultado = new Media();
        Connection coneccao = con.connect();
        
        PreparedStatement ps = coneccao.prepareStatement("SELECT * FROM media WHERE id = ?");
        ps.setString(1,Integer.toString(id));
        ResultSet rs = ps.executeQuery();
        
        if (rs.next()) {
            resultado.setID(rs.getInt("id"));
          
            resultado.setNome(rs.getString("nome"));
            resultado.setTempo(rs.getString("tempo"));
            resultado.setAutor(rs.getString("autor"));
            resultado.setTamanho(rs.getString("tamanho"));
            resultado.setFormato(rs.getString("formato"));
            resultado.setDiretoria(rs.getString("diretoria"));
            resultado.setUploadedBy(rs.getString("uploadedBy"));
            resultado.setAdded(rs.getString("added"));
            resultado.setCategoria(rs.getString("categoria"));
            
            
        }
        connector.close(coneccao);
        
        return resultado;
    }

    public Media getMediaForUser(String username, Integer id) throws SQLException {
        Media resultado = new Media();
        Connection coneccao = con.connect();
        
        PreparedStatement ps = coneccao.prepareStatement("SELECT * from media INNER JOIN categoriauser ON media.id = categoriauser.idMusica and idMusica = ? and categoriauser.username = ?");
        ps.setString(1,Integer.toString(id));
        ps.setString(2, username);
        ResultSet rs = ps.executeQuery();
        
        if (rs.next()) {
            resultado.setID(id);
            resultado.setNome(rs.getString("nome"));
            resultado.setTempo(rs.getString("tempo"));
            resultado.setAutor(rs.getString("autor"));
            resultado.setTamanho(rs.getString("tamanho"));
            resultado.setFormato(rs.getString("formato"));
            resultado.setDiretoria(rs.getString("diretoria"));
            resultado.setUploadedBy(rs.getString("uploadedBy"));
            resultado.setAdded(rs.getString("added"));
            categoriaglobalDAO category = new categoriaglobalDAO();
            resultado.setCategoria(category.idCategoria(rs.getInt("idClass")));
            
        }
        connector.close(coneccao);
        
        return resultado;
    }

    public boolean contemMediaUser(String username, Integer id) throws SQLException {
 
        Connection coneccao = con.connect();
        
        PreparedStatement ps = coneccao.prepareStatement("SELECT * from media INNER JOIN categoriauser ON media.id = categoriauser.idMusica and idMusica = ? and categoriauser.username = ?");
        ps.setString(1,Integer.toString(id));
        ps.setString(2, username);
        ResultSet rs = ps.executeQuery();
        
        boolean resultado = rs.next();  
        
        connector.close(coneccao);
        
        return resultado;
    }
    
    
    
    
    
    
    
    
    public Map<String,Media> mediaMap() throws SQLException {
        Map<String,Media> resultado = new HashMap<>();
        
        Connection coneccao = con.connect();
        PreparedStatement ps = coneccao.prepareStatement("SELECT * FROM media");
        ResultSet rs = ps.executeQuery();
        
        while(rs.next()) {
            Media media = new Media();
            media.setNome(rs.getString("nome"));
            media.setTempo(rs.getString("tempo"));
            media.setAdded(rs.getString("added"));
            media.setCategoria(rs.getString("categoria"));
            media.setDiretoria(rs.getString("diretoria"));
            media.setFormato(rs.getString("formato"));
            media.setTamanho(rs.getString("tamanho"));
            resultado.put(rs.getString("nome"), media);
        }
        
        connector.close(coneccao);
        
        return resultado;
    }
    
    public void insereMedia(Media m) throws SQLException {
        Connection coneccao = con.connect();
        PreparedStatement ps = coneccao.prepareStatement("insert into media VALUES(?,?,?,?,?,?,?,?,?,?)");
        
        ps.setInt(1, m.getID());
        ps.setString(2,m.getNome());
        ps.setString(3,m.getTempo());
        ps.setString(4,m.getAutor());
        ps.setString(5, m.getTamanho());
        ps.setString(6,m.getFormat());
        ps.setString(7,m.getDiretoria());
        ps.setString(8,m.getUploadedBy());
        ps.setString(9,m.getAdded());
        ps.setString(10,m.getCategoria());
        
        ps.executeUpdate();
        
        connector.close(coneccao);
    }
    
 
    
    
}
