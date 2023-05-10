import java.awt.*;
import java.util.Random;

public class EnemyBossBullet extends GameObject{

    private final Handler handler;
    Random r = new Random();

    public EnemyBossBullet(float x, float y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;
        velX = (r.nextInt(5- -5)+-5);
        velY = 5;

        AudioPlayer.getSound("LaserShot").play();
    }

    @Override
    public void tick() {
        x += velX;
        y += velY;

        if (y >= WaveGame.HEIGHT)
            handler.removeObject(this);

        handler.addObject(new Trail((int) x, (int) y, ID.Trail, Color.gray, 8, 8, 0.02f, handler));
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.gray);
        g.fillRect((int) x, (int) y, 8, 8);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y, 8, 8);
    }
}
