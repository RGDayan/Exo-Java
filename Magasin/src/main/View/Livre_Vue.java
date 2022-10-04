package main.View;

import main.Components.Livre_TableModel;
import main.Model.Auteur;
import main.Model.Dvd;
import main.Model.Livre;
import main.Model.Realisateur;

import javax.swing.*;
import java.awt.*;

public class Livre_Vue extends JPanel {


    private Auteur auteur;
    private Realisateur realisateur;


    public Livre_Vue() {
        super(new BorderLayout());

        InitializeTestData();

        var table = InitializeTable();
        var scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.WEST);
    }

    private JTable InitializeTable() {

        var tableModel = new Livre_TableModel(auteur.getBibliographie());
        var table = new JTable(tableModel);

        return table;
    }

    private void InitializeTestData(){

        auteur = new Auteur("Tolkien", "John", "3 janvier 1892" ,81,"Tolkien" );

        new Livre("L001", "Le Seigneur des Anneaux - La confrérie de l'Anneau", 39,
                "LSDA001", 722, auteur);
        new Livre("L002", "Le Seigneur des Anneaux - Les deux tours", 39 ,
                "LSDA002", 597, auteur);
        new Livre("L003", "Le Seigneur des Anneaux - Le retour du roi", 39,
                "LSDA003", 722, auteur);

        realisateur = new Realisateur("Buck", "Chris", "24 février 1958", 76, "Disney");

        new Dvd("D001", "La Reine des Neiges", 10, 109, realisateur);
        new Dvd("D002", "Tarzan", 9, 88, realisateur);

    }
}
