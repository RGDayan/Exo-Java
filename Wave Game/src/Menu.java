import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.Random;

/**
 * Menu du jeu
 */
public class Menu extends CustomMouseAdapter {
    private final Handler handler;
    private final Random r = new Random();

    /**
     * Constructeur
     * @param game WaveGame : Instance de la fenêtre du jeu
     * @param handler Handler : Instance du gestionnaire des objets du jeu
     */
    public Menu(WaveGame game, Handler handler) {
        super(game);
        this.handler = handler;
    }

    /**
     * Affichage du menu
     * @param g Graphics : Outil de dessein graphique
     */
    public void render(Graphics g){
        Font fnt = new Font("arial", Font.BOLD, 50);
        Font fnt2 = new Font("arial", Font.BOLD, 30);

        g.setFont(fnt);
        g.setColor(Color.WHITE);
        g.drawString("Menu", 240,50);

        g.setFont(fnt2);
        g.drawRect(210,150,200,64);
        g.drawString("Play", 280,190);
        g.setColor(Color.WHITE);

        g.drawRect(210,250,200,64);
        g.drawString("Help", 280,290);
        g.setColor(Color.WHITE);

        g.drawRect(210,350,200,64);
        g.drawString("Exit", 280,390);
    }

    @Override
    public void mousePressed(MouseEvent e) {

        if (WaveGame.gameState != WaveGame.STATE.Menu)
            return;

        int mx = e.getX();
        int my = e.getY();

        if (mouseOver(mx, my, 210 , 150, 200, 64)){
            handler.objects.clear();
            WaveGame.gameState = WaveGame.STATE.Game;

            handler.addObject(new Player(WaveGame.WIDTH/2-32, WaveGame.HEIGHT/2-32, ID.Player, handler));
            handler.addObject(new BasicEnemy(r.nextInt(WaveGame.WIDTH), r.nextInt(WaveGame.HEIGHT), ID.BasicEnemy, handler));
        }

        if (mouseOver(mx, my, 210, 250, 200, 64))
            WaveGame.gameState = WaveGame.STATE.Help;

        if (mouseOver(mx, my, 210, 350, 200, 64))
            System.exit(1);
    }

}
