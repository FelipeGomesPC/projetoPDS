/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Felipe Gomes
 */
public class ConnectioFactory {
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/projetoPDS";
    private static final String USER = "root";
    private static final String PASS = "123";
    
    public static Connection getConnection(){
        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (ClassNotFoundException | SQLException ex) {
            throw new RuntimeException("Erro na conexão", ex);
        }
    }
    
    public static void closeConnection(Connection com){
            try{
                if(com!= null)
                com.close();
            } catch (SQLException ex) {
                Logger.getLogger(ConnectioFactory.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    
    public static void closeConnection(Connection com, PreparedStatement stmt){
        closeConnection(com);
        
        try{
            stmt.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(ConnectioFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void closeConnection(Connection com, PreparedStatement stmt, ResultSet rs){
        closeConnection(com, stmt);
        
        try{
            if(rs!=null){
                rs.close();
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ConnectioFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
