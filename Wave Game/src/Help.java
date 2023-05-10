import java.awt.*;
import java.awt.event.MouseEvent;

/**
 * Affichage des instructions du jeu
 */
public class Help extends CustomMouseAdapter {
    /**
     * Constructeur
     * @param g WaveGame : Instance de la fenêtre du jeu
     */
    public Help(WaveGame g) {
        super(g);
    }

    /**
     * Affichage des textes
     * @param g Graphics : Outil graphique d'écriture
     */
    public void render(Graphics g){
        Font fnt = new Font("arial", Font.BOLD, 50);
        Font fnt2 = new Font("arial", Font.BOLD, 18);

        g.setFont(fnt);
        g.setColor(Color.WHITE);
        g.drawString("Help", 240,50);

        g.setFont(fnt2);
        g.drawString(
                "Use ZQSD keys to move and dodge ennemies",
                120,
                230);
        g.setColor(Color.WHITE);

        g.drawRect(210,350,200,64);
        g.drawString("Back", 280,390);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (WaveGame.gameState != WaveGame.STATE.Help)
            return;

        AudioPlayer.getSound("Click").play();

        int mx = e.getX();
        int my = e.getY();

        if (mouseOver(mx, my, 210,350,200,64))
            WaveGame.gameState = WaveGame.STATE.Menu;
    }
}
