package main.Components;

import main.Model.Livre;

import javax.swing.table.AbstractTableModel;
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

    private final List<Livre> data;

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

        switch (columnIndex) {
            case 0 -> value = livre.getReference();
            case 1 -> value = livre.getDesignation();
            case 2 -> value = livre.getPrix();
            case 3 -> value = livre.getIsbn();
            case 4 -> value = livre.getNbPage();
            case 5 -> value = livre.getAuteur().getNom_plume();
        }

        return value;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return switch (columnIndex) {
            case 0, 1, 3, 5 -> String.class;
            case 2, 4 -> Integer.class;
            default -> null;
        };
    }

    public Livre getLivreAt(int row){
        return data.get(row);
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }
}
