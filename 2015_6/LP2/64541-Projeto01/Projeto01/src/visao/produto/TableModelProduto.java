
package visao.produto;

import java.util.ArrayList;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

public class TableModelProduto implements TableModel {

    private ArrayList<ArrayList> tabelaDados;
    
    private TableModelProduto() {
        this.tabelaDados = new ArrayList<ArrayList>();
    }
    
    public TableModelProduto(ArrayList tabelaDados){
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
            return 7;
        else
            return 0;
    }

    public String getColumnName(int columnIndex) {
        if (columnIndex == 0) return "Codigo";
        if (columnIndex == 1) return "Nome";
        if (columnIndex == 2) return "Estoque";
        if (columnIndex == 3) return "Vlr. Compra";
        if (columnIndex == 4) return "% Margem";
        if (columnIndex == 5) return "% Promoção";
        if (columnIndex == 6) return "Vlr. Venda";
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
