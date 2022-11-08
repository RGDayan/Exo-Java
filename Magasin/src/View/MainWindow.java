package View;

import javax.swing.*;
import java.awt.*;

/**
 * Vue Principale parent des autres vues
 */
public class MainWindow extends JFrame{

    private JToolBar toolBar;
    private JPanel content;

    /**
     * Constructeur par défaut
     */
    public MainWindow() throws HeadlessException {
        super("Gestion des stocks");

        //region PROPRIETES DE LA FENETRE PRINCIPALE
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(800,500);
        this.setLocationRelativeTo(null);
        //endregion

        var contentPanel = (JPanel)this.getContentPane();

        // Barre de  navigation
        toolBar = InitializeToolBar();
        contentPanel.add(toolBar, BorderLayout.NORTH);

        // Contenu
        content = InitializeContent();
        contentPanel.add(content, BorderLayout.CENTER);

    }

    private JToolBar InitializeToolBar() {
        var newToolBar = new JToolBar();

        var btnLibrairie = new JButton("Librairie");
        newToolBar.add(btnLibrairie);

        var btnDiscographie = new JButton("Discographie");
        newToolBar.add(btnDiscographie);

        return newToolBar;
    }

    private JPanel InitializeContent(){
        var panel = new Livre_Vue();

        return panel;
    }


}
