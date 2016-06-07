/*
 * Todos direitos reservados a Tiago Dias de Souza
 * www.github.com/tiagods
 */
package br.com.tiagods.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Tiago
 */
public class ModelTabelaDetalhes extends AbstractTableModel{
private ArrayList<String[]> resultSetGeral;
    private static final String[] nomesColunas = {
        "COD", "HORA", "DETALHES",
    };
    @Override
    public String getColumnName(int quantasColunas) {
        return nomesColunas[quantasColunas];
    }
    public void setResult(ResultSet resultset) throws SQLException {
        resultSetGeral = new ArrayList<>();
        while (resultset.next()) {
            String[] linha = {
                resultset.getString(2),
                resultset.getString(3),
                resultset.getString(4),
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
    
    public void limpaTabela() {
	resultSetGeral.clear();
 	fireTableDataChanged();
    }
    
}
