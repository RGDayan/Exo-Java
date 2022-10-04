package main.Controller;

import main.View.MainWindow;

public class MainWindow_Controller {
    /** Instance de MainWindow ouverte */
    private MainWindow mainWindow;

    /**
     * Constructeur d'instanciation
     */
    public MainWindow_Controller(MainWindow m) {
        this.mainWindow = m;
        this.mainWindow.setVisible(true);
    }

}
