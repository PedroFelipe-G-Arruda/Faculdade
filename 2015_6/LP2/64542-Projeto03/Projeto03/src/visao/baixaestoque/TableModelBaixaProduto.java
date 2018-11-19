
package visao.baixaestoque;

import java.util.List;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import vo.ProdutoVO;

public class TableModelBaixaProduto implements TableModel {

    private List<ProdutoVO> tabelaDados;
    
    public TableModelBaixaProduto(List<ProdutoVO> tabelaDados){
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
        if (columnIndex == 0) {
            return tabelaDados.get(rowIndex).getCodigo();
        } else if (columnIndex == 1) {
            return tabelaDados.get(rowIndex).getNome();
        } else if (columnIndex == 2) {
            return tabelaDados.get(rowIndex).getEstoque();
        }else
            return null;
    }

    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
    }

    public void addTableModelListener(TableModelListener l) {
    }

    public void removeTableModelListener(TableModelListener l) {
    }

}
