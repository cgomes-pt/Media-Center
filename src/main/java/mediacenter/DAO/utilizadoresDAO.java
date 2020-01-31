
package mediacenter.DAO;
import mediacenter.connector;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.sql.*;
import java.util.ArrayList;
import mediacenter.connector;
import mediacenter.utilizador;

public class utilizadoresDAO {
    
    connector con ;
    
    public utilizadoresDAO() {
        con = new connector();
    }
    
    public  int adicionaUser() throws SQLException {
        
        Connection coneccao = con.connect();
        
        PreparedStatement ps = coneccao.prepareStatement("INSERT INTO utilizadores " + "VALUES ('Darius','asd','c.tcarlosantonio@gmail.com','noAvatar','Rengar','0','2019-12-02')");
        ps.executeUpdate();
        connector.close(coneccao);
            
        return 1;
    }
    
    public Set<utilizador> values() throws SQLException {
        Connection coneccao = con.connect();
        Set<utilizador> set = new HashSet<>();
        Statement stmt =coneccao.createStatement();
        ResultSet rs= stmt.executeQuery("select username, password, email, avatar, profileName, numberFriends, joined from utilizadores");
        while (rs.next()) {
            String username = rs.getString("username");
            String password = rs.getString("password");
            String email = rs.getString("email");
            String avatar = rs.getString("avatar");
            String name = rs.getString("profileName");
            int friends = rs.getInt("numberFriends");
            String joined = rs.getString("joined");
            
            utilizador novo = new utilizador(username,password,email,name,avatar,friends,joined);
            set.add(novo);
        }
        
         
        rs.close();
        connector.close(coneccao);
        return set;
    }
    
    
    
    public boolean verificaID (String id) throws SQLException {
        boolean resultado = false;
        
        Connection coneccao = con.connect();
        PreparedStatement ps = coneccao.prepareStatement("SELECT * FROM utilizadores WHERE username= ? ");
        ps.setString(1, id);
        ResultSet rs = ps.executeQuery();
        resultado = rs.next();
        connector.close(coneccao);
        return resultado;
    }
    
    
    public utilizador getUser(String id) throws SQLException {
        utilizador user = new utilizador();
        
        Connection coneccao = con.connect();
        PreparedStatement ps = coneccao.prepareStatement("SELECT * FROM utilizadores WHERE username= ? ");
        ps.setString(1, id);
        ResultSet rs = ps.executeQuery();
        
        if(rs.next()) {
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setProfileName(rs.getString("profileName"));
            user.setAvatar(rs.getString("avatar"));
            user.setNumberFriends(rs.getInt("numberFriends"));
            user.setMemberSince(rs.getString("joined"));
            
        }
        
        connector.close(coneccao);
         
        return user;
    }
    
    
    public void novaPassword (String username, String password) throws SQLException {
        
        Connection coneccao = con.connect();
        PreparedStatement ps = coneccao.prepareStatement("UPDATE utilizadores SET password = ? WHERE username = ?");
        ps.setString(1, password);
        ps.setString(2,username);
        ps.executeUpdate();
        
        connector.close(coneccao);
    }
    
}