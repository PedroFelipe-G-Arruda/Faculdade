package visao.produto;

import java.util.List;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import vo.ProdutoVO;

public class TableModelProduto implements TableModel {

    private List<ProdutoVO> tabelaDados;

    public TableModelProduto(List<ProdutoVO> tabelaDados) {
        this.tabelaDados = tabelaDados;
    }

    public int getRowCount() {
        if (this.tabelaDados != null) {
            return this.tabelaDados.size();
        } else {
            return 0;
        }
    }

    public int getColumnCount() {
        if (this.tabelaDados != null) {
            return 8;
        } else {
            return 0;
        }
    }

    public String getColumnName(int columnIndex) {
        if (columnIndex == 0) {
            return "Codigo";
        }
        if (columnIndex == 1) {
            return "Nome";
        }
        if (columnIndex == 2) {
            return "Estoque";
        }
        if (columnIndex == 3) {
            return "Compra";
        }
        if (columnIndex == 4) {
            return "Margem";
        }
        if (columnIndex == 5) {
            return "Promoção";
        }
        if (columnIndex == 6) {
            return "Grupo";
        }
        if (columnIndex == 7) {
            return "Venda";
        }
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
            return (tabelaDados.get(rowIndex)).getCodigo();
        } else if (columnIndex == 1) {
            return (tabelaDados.get(rowIndex)).getNome();
        } else if (columnIndex == 2) {
            return (tabelaDados.get(rowIndex)).getEstoque();
        } else if (columnIndex == 3) {
            return (tabelaDados.get(rowIndex)).getPrecoCompra();
        } else if (columnIndex == 4) {
            return (tabelaDados.get(rowIndex)).getMargemLucro();
        } else if (columnIndex == 5) {
            return (tabelaDados.get(rowIndex)).getPromocao();
        } else if (columnIndex == 6) {
            return (tabelaDados.get(rowIndex)).getGrupo();
        } else if (columnIndex == 7) {
            return (tabelaDados.get(rowIndex)).getVenda();
        } else {
            return null;
        }
    }

    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
    }

    public void addTableModelListener(TableModelListener l) {
    }

    public void removeTableModelListener(TableModelListener l) {
    }
}
