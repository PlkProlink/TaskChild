/*
 * Todos direitos reservados a Tiago Dias de Souza
 * www.github.com/tiagods
 */
package br.com.tiagods.factory;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

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
        try {
            Properties p = new Properties();
            FileInputStream file = new FileInputStream("db.properties");
            p.load(file);
            file.close();
            url = p.getProperty("urlDatabase");
            driver=p.getProperty("driver");
            user=p.getProperty("user");
            password=p.getProperty("password");
        } catch (IOException ex) {
            throw new RuntimeException();
        }
    }    
    public Connection getConnection(){
        try {
            Class.forName(driver);
            return  DriverManager.getConnection(url, user, password);
        } catch (SQLException|ClassNotFoundException ex) {
            throw new RuntimeException(ex);
        }
    }
}

