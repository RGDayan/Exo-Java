import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class Help extends MouseAdapter {
    private final Handler handler;
    private final Random r = new Random();

    public Help( Handler handler) {
        this.handler = handler;
    }

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

    public void tick(){}


    @Override
    public void mousePressed(MouseEvent e) {
        int mx = e.getX();
        int my = e.getY();

//        if (mouseOver(mx, my, 210 , 150, 200, 64)){
//            game.gameState = WaveGame.STATE.Game;
//
//            handler.addObject(new Player(WaveGame.WIDTH/2-32, WaveGame.HEIGHT/2-32, ID.Player, handler));
//            handler.addObject(new BasicEnemy(r.nextInt(WaveGame.WIDTH), r.nextInt(WaveGame.HEIGHT), ID.BasicEnemy, handler));
//        }
//
//        if (mouseOver(mx, my, 210, 250, 200, 64))
//            game.gameState = WaveGame.STATE.Help;
//
//        if (mouseOver(mx, my, 210, 350, 200, 64))
//            System.exit(1);
    }

    private Boolean mouseOver(int mx, int my, int x, int y, int width, int height){
        if (mx > x && mx < x + width){
            return my > y && my < y + height;
        }else
            return false;
    }
}
