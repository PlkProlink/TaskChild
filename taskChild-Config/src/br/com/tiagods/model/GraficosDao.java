/*
 * Todos direitos reservados a Tiago Dias.
 * OpenSource Project www.github.com.br/tiagods
 */
package br.com.tiagods.model;

import br.com.tiagods.factory.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Tiago
 */
public class GraficosDao {
    
    public ResultSet resultset;
    private Connection con;
    
    public void buscarGrafico(String sql){
        try{
            generic(sql);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Falha ao carregar dados do grafico");
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
