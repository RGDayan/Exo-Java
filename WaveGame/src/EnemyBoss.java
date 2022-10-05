import java.awt.*;

public class EnemyBoss extends GameObject {
    private final Handler handler;
    private int timer = 80;
    private int timer2 = 50;

    public EnemyBoss(float x, float y, ID id, Handler h) {
        super(x, y, id);
        this.handler = h;

        velX = 0;
        velY = 2;
    }

    @Override
    public void tick() {
        x += velX;
        y += velY;

        timer--;
        if (timer <= 0 )
            velY = 0;
        else
            timer--;

        if (timer <= 0)
            timer2--;

        if (timer <= 0)
            if (velX == 0)
                velX =2;

        if (x <= 0 || x >= WaveGame.WIDTH -78) velX *= -1;

        handler.addObject(new Trail(x, y, ID.Trail, Color.BLACK, 64, 64, 0.1f, handler));
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect((int)x, (int)y, 64, 64);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int)x, (int)y, 64, 6496);
    }
}
