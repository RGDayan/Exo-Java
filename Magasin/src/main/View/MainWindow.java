package main.View;

import main.Components.ToolBar;

import javax.swing.*;
import java.awt.*;

/**
 * Vue Principale parente des autres vues
 */
public class MainWindow extends JFrame{

    /**
     * Constructeur par défaut
     */
    public MainWindow() throws HeadlessException {
        super("Gestion des stocks");

        //region PROPRIETIES DE LA FENÊTRE PRINCIPALE
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(800,500);
        this.setLocationRelativeTo(null);
        //endregion

        var contentPanel = (JPanel)this.getContentPane();

        // Barre de  navigation
        JToolBar toolBar = new ToolBar();
        contentPanel.add(toolBar, BorderLayout.NORTH);

        // Contenu
        JPanel content = InitializeContent();
        contentPanel.add(content, BorderLayout.CENTER);
    }

    /**
     * Initialise la vue gérée par la ToolBar
     * @return Vue par défaut
     */
    private JPanel InitializeContent(){
        return new Livre_Vue();
    }


}
