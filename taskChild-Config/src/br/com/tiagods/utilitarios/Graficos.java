/*
 * Todos direitos reservados a Tiago Dias de Souza
 * www.github.com/tiagods
 */
package br.com.tiagods.utilitarios;

import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
/**
 *
 * @author Tiago
 */
public class Graficos {
    
    public void gerarGrafico(JPanel panel, ResultSet rs, String status){
    //String sql ="select distinct(Data_Recebimento) as Data, count(cod) as Qtde from documentos_recebidos group by Data order by Data desc limit 20";
    //String sql = "select distinct(extract(day from Data)) as Dia, Quantidade from ROTINAS group by Data order by Data desc limit 30";
    DefaultCategoryDataset barDataset = createDataset(rs);
    JFreeChart chart = ChartFactory.createBarChart(
        status, "Data de Referência", "Quantidade", barDataset,
        PlotOrientation.VERTICAL, false, true, false);
    ChartPanel chartp = new ChartPanel(chart);
    chartp.setSize(panel.getWidth(), panel.getHeight());
    chartp.setBackground(Color.red);
    chartp.setVisible(true);
    panel.removeAll();
    panel.add(chartp);
    panel.revalidate();
    panel.repaint();
  }
    private DefaultCategoryDataset createDataset(ResultSet rs) {
        DefaultCategoryDataset barDataset = new DefaultCategoryDataset();  
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM");
        if(rs!=null){
            try {
                while(rs.next()){
                    barDataset.setValue(rs.getInt(2), "Dia", sdf.format(rs.getDate(1)));
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return barDataset;
    }
}
