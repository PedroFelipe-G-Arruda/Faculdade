
package visao.baixaestoque;

import java.util.ArrayList;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

public class TableModelBaixaProduto implements TableModel {

    private ArrayList<ArrayList> tabelaDados;
    
    private TableModelBaixaProduto() {
        this.tabelaDados = new ArrayList<ArrayList>();
    }
    
    public TableModelBaixaProduto(ArrayList tabelaDados){
        this.tabelaDados = tabelaDados;
    }

    public int getRowCount() {
        if(this.tabelaDados != null)
            return this.tabelaDados.size();
        else
            return 0;
    }

    public int getColumnCount() {
        if(this.tabelaDados != null)
            return 3;
        else
            return 0;
    }

    public String getColumnName(int columnIndex) {
        if (columnIndex == 0) return "Codigo";
        if (columnIndex == 1) return "Nome";
        if (columnIndex == 2) return "Estoque";
        return null;
    }

    public Class<?> getColumnClass(int columnIndex) {
        return Object.class;
    }

    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        return (tabelaDados.get(rowIndex)).get(columnIndex);
    }

    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
    }

    public void addTableModelListener(TableModelListener l) {
    }

    public void removeTableModelListener(TableModelListener l) {
    }

}
