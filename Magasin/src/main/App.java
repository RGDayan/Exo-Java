package main;

import main.Controller.MainWindow_Controller;
import main.View.MainWindow;

/**
 * Application à lancer
 */
public class App {
    /** Main.Controller de la vue principale */
    public static MainWindow_Controller mw_Controller;
    /** Vue principale */
    public static MainWindow mainWindow;

    /**
     * Point d'entrée de l'application
     * @param args arguments passés lorsqu'on l'appelle d'une commande
     */
    public static void main(String[] args){
        mainWindow = new MainWindow();
        mw_Controller = new MainWindow_Controller(mainWindow);
    }
}
