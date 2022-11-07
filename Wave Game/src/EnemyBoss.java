import java.awt.*;
import java.util.Random;

public class EnemyBoss extends GameObject{

    private final Handler handler;
    private Random r = new Random();
    private int timer = 80;
    private int timer2 = 50;

    public EnemyBoss(float x, float y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;
    }

    @Override
    public void tick() {
        x += velX;
        y += velY;

        if (timer <= 0)
            velY = 0;
        else
            timer--;

        if (timer <= 0)
            timer2--;

        if (timer <= 0){
            if (velX == 0)
                velX = 2;

            if (velX > 0)
                velX += 0.005f;

            if (velX < 0)
                velX -=0.005f;

            velX = WaveGame.clamp(velX, -10, 10);
            int spawn = r.nextInt(10);

            if (spawn == 0)
                handler.addObject(new EnemyBossBullet(
                        (int) x, (int) y, ID.BasicEnemy, handler
                ));
        }

        if (x <= 0 || x >= WaveGame.WIDTH - 96)
            velX *= -1;
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.darkGray);
        g.fillRect((int) x, (int) y, 64, 64);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y, 64, 64);
    }
}
