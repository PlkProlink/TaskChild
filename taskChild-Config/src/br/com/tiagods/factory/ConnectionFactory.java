/*
 * Todos direitos reservados a Tiago Dias.
 * OpenSource Project www.github.com.br/tiagods
 */
package br.com.tiagods.factory;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import javax.swing.JOptionPane;
/**
 *
 * @author Tiago
 */
public class ConnectionFactory {
    Connection con;
    
    private String driver;
    private String url;
    private String user;
    private String password;
    
    public ConnectionFactory(){
        try{
            Properties propriedades = new Properties();
            try (FileInputStream stream = new FileInputStream("db.properties")) {
                propriedades.load(stream);
                driver = propriedades.getProperty("driver");
                url = propriedades.getProperty("urlDatabase");
                user = propriedades.getProperty("user");
                password = propriedades.getProperty("password");
            }
        }catch(IOException e){
            JOptionPane.showMessageDialog(null, "Não foi encontrado o arquivo de configurações do banco de dados!");
        }
    }
    
    public Connection getConnection(){
        try {
            Class.forName(driver);
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException | ClassNotFoundException ex) {
            throw new RuntimeException();
        }
        
    }
}
