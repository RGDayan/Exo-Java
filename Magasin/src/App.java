import Controller.MainWindow_Controller;
import View.MainWindow;

/**
 * Application à lancer
 */
public class App {
    /** Controller de la vue principale */
    private static MainWindow_Controller mw_Controller;
    /** Vue principale */
    private static MainWindow mainWindow;

    /**
     * Point d'entrée de l'application
     * @param args agruments passées lorsqu'on l'appelle d'une commande
     */
    public static void main(String[] args){
        mainWindow = new MainWindow();
        mw_Controller = new MainWindow_Controller(mainWindow);
    }
}
