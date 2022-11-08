import java.awt.*;
import java.awt.event.MouseEvent;

/**
 * Écran de GameOver
 */
public class End extends CustomMouseAdapter{
    private final HUD hud;
    public int finalScore;

    public End(WaveGame game, HUD hud) {
        super(game);
        this.hud = hud;
    }

    /**
     * Affichage de l'écran de fin
     * @param g Graphics : Outil de dessein graphique
     */
    public void render(Graphics g){
        Font fnt = new Font("arial", Font.BOLD, 50);
        Font fnt2 = new Font("arial", Font.BOLD, 30);
        Font fnt3 = new Font("arial", Font.BOLD, 20);

        g.setFont(fnt);
        g.setColor(Color.WHITE);
        g.drawString("Game Over", 180,50);

        g.setFont(fnt3);
        g.setColor(Color.WHITE);
        g.drawString("You lost with the score of : " + finalScore, 100,200);

        g.setFont(fnt2);
        g.setColor(Color.WHITE);
        g.drawRect(210,350,200,64);
        g.drawString("Try Again", 240,390);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (WaveGame.gameState != WaveGame.STATE.End)
            return;

        int mx = e.getX();
        int my = e.getY();

        if (mouseOver(mx, my, 210,350,200,64))
            WaveGame.gameState = WaveGame.STATE.Menu;

    }
}
