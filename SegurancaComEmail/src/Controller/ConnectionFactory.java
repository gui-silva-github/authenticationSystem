/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

public class ConnectionFactory {
    
    public static Connection con = null;
    
    public static void Conectar(){
        
        String url = "jdbc:mysql://localhost/login";
        String user = "root";
        String pass = "";
        
        System.out.println("Connecting to the database...");
        
        try{
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            con = DriverManager.getConnection(url, user, pass);
            
            System.out.println("Connected to the database successfully!");
            
        } catch (ClassNotFoundException e){
            System.out.println("Connected to the database successfully!");
        }
        
        catch (SQLException erro){
            
            System.out.println("An error has occurred in the program, contact the developer and give the following error:" + erro );
            throw new RuntimeException(erro);
            
        }
        
    }
    
    public static void Desconectar(){
        try{
            con.close();
            con = null;
            System.out.println("Closed connection to the database!");
        } catch (SQLException e){
            System.out.println("Error closing connection to database!");
        }
    }
    
}
