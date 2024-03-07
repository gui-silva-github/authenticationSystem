/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Functions;

import Controller.ConnectionFactory;
import Model.User;
import static Controller.ConnectionFactory.*;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;


/**
 *
 * @author guilh
 */
public class SQLUses {
    
    private String sql;
    
    private int result;
    
    public int insertUser(User user){
            
            ConnectionFactory.Conectar();
            
            sql = "INSERT INTO usuarios (nome, senha, email) VALUES (?,?,?)";
            
            try{
                
                PreparedStatement stm = con.prepareStatement(sql);
            
                stm.setString(1, user.getNome());
                stm.setString(2, user.getSenha());
                stm.setString(3, user.getEmail());

                result = stm.executeUpdate();
                
                ConnectionFactory.Desconectar();
                
            } catch(SQLException s){
                
                System.out.println(s);
                
            }
           
           return result;
            
    }
    
    public User selectUser(String email) throws SQLException{
        
        ConnectionFactory.Conectar();
        
        sql = "SELECT * FROM usuarios WHERE email = ?";
        
        User user;
        
        try {
            
            PreparedStatement psmt = con.prepareStatement(sql);
            psmt.setString(1, email);
            
            ResultSet rs = psmt.executeQuery();
            
            if (rs.next()) {
                user = new User(rs.getInt("id"), rs.getString("nome"), rs.getString("email"), rs.getString("senha"), rs.getDate("dt_cadastro"));
                con.close();
                psmt.close();
                rs.close();
                return user;
            }else{
                return null;
            }
            
        } catch (SQLException e){
            System.out.println(e);
            return null;
        }
        
    }
    
    public boolean checkUser(String email, String pass) throws SQLException{
        
        User u = selectUser(email);
        
        if (u==null){
            JOptionPane.showMessageDialog(null, "There isn't a user with this email");
            return false;
        } else {
            return u.getSenha().equals(pass);
        }
        
    }
    
}
