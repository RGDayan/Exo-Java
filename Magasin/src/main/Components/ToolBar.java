package main.Components;

import javax.swing.*;

/**
 * Composant ToolBar personnalisé
 */
public class ToolBar extends JToolBar {

    public JButton btnLibrairie;
    public JButton btnDiscographie;

    /**
     * Constructeur de la ToolBar
     */
    public ToolBar() {
        btnLibrairie = new JButton("Librairie");
        this.add(btnLibrairie);

        btnDiscographie = new JButton("Discographie");
        this.add(btnDiscographie);
    }

}
