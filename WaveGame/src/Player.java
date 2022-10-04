import java.awt.*;

public class Player extends GameObject{
    private final Handler handler;
    public Player(int x, int y, ID id, Handler h) {
        super(x, y, id);
        this.handler = h;
    }

    public void tick() {
        x += velX;
        y += velY;

        x = WaveGame.clamp(x, 0, WaveGame.WIDTH -48);
        y = WaveGame.clamp(y, 0, WaveGame.HEIGHT -72);

        collision();
    }

    public void render(Graphics g){
        g.setColor(Color.BLUE);
        g.fillRect(x, y, 32, 32);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(x, y, 32, 32);
    }

    public void collision(){
        for (GameObject tempObject : handler.objects) {
            if (tempObject.getId() == ID.BasicEnemy){
                if (getBounds().intersects(tempObject.getBounds())){
                    HUD.HEALTH -=2;
                }
            }
            if (tempObject.getId() == ID.FastEnemy){
                if (getBounds().intersects(tempObject.getBounds())){
                    HUD.HEALTH -=1;
                }
            }
            if (tempObject.getId() == ID.SmartEnnemy){
                if (getBounds().intersects(tempObject.getBounds())){
                    HUD.HEALTH -=3;
                }
            }
        }
    }
}
