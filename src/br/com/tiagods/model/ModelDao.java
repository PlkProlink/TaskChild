/*
 * Todos direitos reservados a Tiago Dias de Souza
 * www.github.com/tiagods
 */
package br.com.tiagods.model;

import br.com.tiagods.factory.ConnectionFactory;
import static br.com.tiagods.view.Menu.jTextArea1;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class ModelDao {
    StringBuilder builder = new StringBuilder();
    Connection con;
    
    private Connection getCon(){
        return this.con=new ConnectionFactory().getConnection();
    }
    
    public boolean gravaLog(Model model, ModelLog log){
        try {
             String sql= "insert into rotinas (SITUACAO,QUANTIDADE,TAMANHO,"
                + "QUANTIDADE_RESTANTE,TAMANHO_RESTANTE,TEMPO) values "
                + "(?,?,?,?,?,?)";
            con=null;
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setString(1, log.getStatusSync());
            ps.setString(2, log.getElementos()+"");
            ps.setString(3, log.getTamanhoElementos());
            ps.setString(4, log.getElementosRestantes()+"");
            ps.setString(5, log.getTamanhoRestante());
            ps.setString(6, log.getTempoTotal());
            if(ps.executeUpdate()>0){
                buscarUltimo(model, log);
            }
            return true;
        } catch (SQLException ex) {
            return false;
        } finally{try{con.close();}catch(SQLException e){}}
    }
    private void buscarUltimo(Model model, ModelLog log){
        try {
            String sql= "select max(ID) as ID from rotinas";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if(rs!=null){
                if(rs.next()){
                    int codigo = rs.getInt(1);
                    inserirDetalhes(model, log, codigo);
                }
            }
        } catch (SQLException ex) {
        } finally{try{con.close();}catch(SQLException e){}}
    }
    private void inserirDetalhes(Model model, ModelLog log, int codigo){
        List<String> hora = new ArrayList<>();
        List<String> detalhes = new ArrayList<>();
        hora = log.getHora();
        detalhes = log.getDescricao();
        getCon();
        try{
            for(int i = 0; i<hora.size(); i++){
                String sql = "insert into detalhes_rotinas (ID_ROTINA, HORA, DETALHES) values (?,?,?)";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setInt(1, codigo);
                ps.setString(2, hora.get(i));
                ps.setString(3, detalhes.get(i));
                ps.executeUpdate();
            }
        } catch (SQLException ex) {
        } finally{try{con.close();}catch(SQLException e){}}
    }
}

