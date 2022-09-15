package Components;

import Model.Auteur;
import Model.Livre;

import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import java.util.List;

public class Livre_TableModel extends AbstractTableModel {

    private final String[] columnNames = {
            "Référence",
            "Désignation",
            "Prix",
            "ISBN",
            "Nombre de page",
            "Auteur"
    };

    private List<Livre> data;

    public Livre_TableModel(List<Livre> data) {
        this.data = data;
    }

    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        Object value = "??";
        Livre livre = data.get(rowIndex);

        switch (columnIndex){
            case 0:
                value = livre.getReference();
                break;
            case 1:
                value = livre.getDesignation();
                break;
            case 2:
                value = livre.getPrix();
                break;
            case 3:
                value = livre.getIsbn();
                break;
            case 4:
                value = livre.getNbPage();
                break;
            case 5:
                value = livre.getAuteur().getNom_plume();
                break;
        }

        return value;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        Class value;
        switch (columnIndex){
            case 0: case 1: case 3: case 5:
                value = String.class;
                break;
            case 2: case 4:
                value = Integer.class;
                break;
            default:
                value = null;
        }

        return value;
    }

    public Livre getLivreAt(int row){
        return data.get(row);
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }
}
