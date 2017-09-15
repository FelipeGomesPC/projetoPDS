/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexao.ConnectioFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.Usuario;

/**
 *
 * @author Felipe Gomes
 */
public class ProdutoDao {
    public void create(Usuario u){
        Connection com = ConnectioFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = com.prepareCall("INSERT INTO login(nome,senha) VALUES(?,?)");    
            stmt.setString(1,u.getNome());
            stmt.setString(2,u.getSenha());
            
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Salvo com sucesso");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao salvar"+ex);
        }finally{
            ConnectioFactory.closeConnection(com,stmt);
        }
    }
}
