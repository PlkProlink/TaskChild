/*
 * Todos direitos reservados a Tiago Dias de Souza
 * www.github.com/tiagods
 */
package br.com.tiagods.utilitarios;

/**
 *
 * @author Tiago
 */
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.EventObject;
import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.EventListenerList;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
public class NovoClass {
  public static void main(String[] args) {
    JFrame frame = new TableCellRenderFrame();
    frame.show();
  }
}
/*
 * o modelo de tabela planeta especifica os valores , renderização e propriedades de edição para os dados planeta
 */
class PlanetTableModel extends AbstractTableModel {
  @Override
  public String getColumnName(int c) {
    return columnNames[c];
  }
  @Override
  public Class getColumnClass(int c) {
    return cells[0][c].getClass();
  }
  @Override
  public int getColumnCount() {
    return cells[0].length;
  }
  @Override
  public int getRowCount() {
    return cells.length;
  }
  @Override
  public Object getValueAt(int r, int c) {
    return cells[r][c];
  }
  @Override
  public void setValueAt(Object obj, int r, int c) {
    cells[r][c] = obj;
  }
  @Override
  public boolean isCellEditable(int r, int c) {
    return c == NAME_COLUMN || c == MOON_COLUMN || c == GASEOUS_COLUMN
        || c == COLOR_COLUMN;
  }
  public static final int NAME_COLUMN = 0;
  public static final int MOON_COLUMN = 2;
  public static final int GASEOUS_COLUMN = 3;
  public static final int COLOR_COLUMN = 4;
  final private Object[][] cells = {
      { "Mercury", new Double(2440), new Integer(0), Boolean.FALSE,
          Color.yellow, new ImageIcon("Mercury.gif") },
      { "Venus", new Double(6052), new Integer(0), Boolean.FALSE,
          Color.yellow, new ImageIcon("Venus.gif") },
      { "Earth", new Double(6378), new Integer(1), Boolean.FALSE,
          Color.blue, new ImageIcon("Earth.gif") },
      { "Mars", new Double(3397), new Integer(2), Boolean.FALSE,
          Color.red, new ImageIcon("Mars.gif") },
      { "Jupiter", new Double(71492), new Integer(16), Boolean.TRUE,
          Color.orange, new ImageIcon("Jupiter.gif") },
      { "Saturn", new Double(60268), new Integer(18), Boolean.TRUE,
          Color.orange, new ImageIcon("Saturn.gif") },
      { "Uranus", new Double(25559), new Integer(17), Boolean.TRUE,
          Color.blue, new ImageIcon("Uranus.gif") },
      { "Neptune", new Double(24766), new Integer(8), Boolean.TRUE,
          Color.blue, new ImageIcon("Neptune.gif") },
      { "Pluto", new Double(1137), new Integer(1), Boolean.FALSE,
          Color.black, new ImageIcon("Pluto.gif") } };
  private String[] columnNames = { "Planet", "Radius", "Moons", "Gaseous",
      "Color", "Image" };
}
class TableCellRenderFrame extends JFrame {
  public TableCellRenderFrame() {
    setTitle("TableCellRenderTest");
    setSize(300, 200);
    addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    });
    TableModel model = new PlanetTableModel();
    JTable table = new JTable(model);
    // configurar representantes e editores
    table.setDefaultRenderer(Color.class, new ColorTableCellRenderer());
    table.setDefaultEditor(Color.class, new ColorTableCellEditor());
    JComboBox moonCombo = new JComboBox();
    for (int i = 0; i <= 20; i++)
      moonCombo.addItem(new Integer(i));
    TableColumnModel columnModel = table.getColumnModel();
    TableColumn moonColumn = columnModel
        .getColumn(PlanetTableModel.MOON_COLUMN);
    moonColumn.setCellEditor(new DefaultCellEditor(moonCombo));
    // mostrar tabela
    table.setRowHeight(100);
    Container contentPane = getContentPane();
    contentPane.add(new JScrollPane(table), "Center");
  }
}
class ColorTableCellRenderer implements TableCellRenderer {
  @Override
  public Component getTableCellRendererComponent(JTable table, Object value,
      boolean isSelected, boolean hasFocus, int row, int column) {
    panel.setBackground((Color) value);
    return panel;
  }
  /*
   * painel seguinte é devolvida para todas as células , 
   * com a cor de fundo definida para o valor da cor da célula
   */
  private JPanel panel = new JPanel();
}
class ColorTableCellEditor extends ColorTableCellRenderer implements
    TableCellEditor {
  ColorTableCellEditor() { // prepara dialog
    colorChooser = new JColorChooser();
    colorDialog = JColorChooser.createDialog(null, "Planet Color", false,
        colorChooser, new ActionListener() // OK button listener
        {
            @Override
            public void actionPerformed(ActionEvent event) {
            fireEditingStopped();
          }
        }, new ActionListener() // botao cancelar
        {
            @Override
            public void actionPerformed(ActionEvent event) {
            fireEditingCanceled();
          }
        });
  }
  @Override
  public Component getTableCellEditorComponent(JTable table, Object value,
      boolean isSelected, int row, int column) { /*
    * 
    *isso é onde nós temos o valor da cor atual, 
    *armazená-lo na caixa de diálogo , caso o usuário inicia a edição
    */
    colorChooser.setColor((Color) value);
    return getTableCellRendererComponent(table, value, isSelected, true,
        row, column);
  }
  @Override
  public boolean isCellEditable(EventObject anEvent) {
    return true;
  }
  @Override
  public boolean shouldSelectCell(EventObject anEvent) { // start editing
    colorDialog.setVisible(true);
    // tell caller it is ok to select this cell
    return true;
  }
  @Override
  public void cancelCellEditing() { // editing is canceled--hide dialog
    colorDialog.setVisible(false);
  }
  @Override
  public boolean stopCellEditing() { // editing is complete--hide dialog
    colorDialog.setVisible(false);
    // tell caller is is ok to use color value
    return true;
  }
  @Override
  public Object getCellEditorValue() {
    return colorChooser.getColor();
  }
  @Override
  public void addCellEditorListener(CellEditorListener l) {
    listenerList.add(CellEditorListener.class, l);
  }
  @Override
  public void removeCellEditorListener(CellEditorListener l) {
    listenerList.remove(CellEditorListener.class, l);
  }
  protected void fireEditingStopped() {
    Object[] listeners = listenerList.getListenerList();
    for (int i = listeners.length - 2; i >= 0; i -= 2)
      ((CellEditorListener) listeners[i + 1]).editingStopped(event);
  }
  protected void fireEditingCanceled() {
    Object[] listeners = listenerList.getListenerList();
    for (int i = listeners.length - 2; i >= 0; i -= 2)
      ((CellEditorListener) listeners[i + 1]).editingCanceled(event);
  }
  private Color color;
  private JColorChooser colorChooser;
  private JDialog colorDialog;
  private EventListenerList listenerList = new EventListenerList();
  private ChangeEvent event = new ChangeEvent(this);
}
