/*
 * Todos direitos reservados a Tiago Dias de Souza
 * www.github.com/tiagods
 */
package br.com.tiagods.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author User
 */
public class ModelTabelaGeral extends AbstractTableModel{
    private ArrayList<String[]> resultSetGeral;
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy");
    
    private static final String[] nomesColunas = {
        "COD", "DATA", "STATUS", "ARQUIVOS", "TAMANHO", "TEMPO", "ARQUIVOS PENDENTES",
    };
    public String getColumnName(int quantasColunas) {
        return nomesColunas[quantasColunas];
    }
   
    public void setResult(ResultSet resultset) throws SQLException {
        resultSetGeral = new ArrayList<String[]>();
        while (resultset.next()) {
            String[] linha = {
                resultset.getString(1),
                sdf.format(resultset.getDate(8)),
                resultset.getString(2),
                resultset.getString(3),
                resultset.getString(4),
                resultset.getString(7),
                resultset.getString(5),
            };
            resultSetGeral.add(linha);
            
        }
        fireTableStructureChanged();
    }
    public void deletarLinha(int linha) {
        resultSetGeral.remove(linha);
        fireTableRowsDeleted(linha, linha);
    }
            

    @Override
    public int getRowCount() {
        return resultSetGeral.size();
    }

    @Override
    public int getColumnCount() {
        return nomesColunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        String[] linha = resultSetGeral.get(rowIndex);
        return linha[columnIndex];
    }
}
