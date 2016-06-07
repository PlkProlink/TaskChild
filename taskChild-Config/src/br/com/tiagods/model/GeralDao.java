/*
 * Todos direitos reservados a Tiago Dias de Souza
 * www.github.com/tiagods
 */
package br.com.tiagods.model;

import br.com.tiagods.factory.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Tiago
 */
public class GeralDao {
    
    private Connection con;
    public ResultSet resultset;
    
    public void buscar(String sql){
        try{
            generic(sql);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Falha ao carregar dados da Tabela 1");
        }
    }
    public void listarGeral(){
        try{
            generic("SELECT * FROM ROTINAS order by ID desc");
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Falha ao carregar dados da Tabela 1");
        }
    }
    public void generic(String sql) throws SQLException{
        con = new ConnectionFactory().getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        resultset = ps.executeQuery();
    }
    
    public void fechar(){
        try {
            con.close();
        } catch (SQLException ex) {
        }
    }
}
