import java.awt.*;

public class FastEnemy extends GameObject {
    private final Handler handler;
    public FastEnemy(float x, float y, ID id, Handler h) {
        super(x, y, id);
        this.handler = h;
        velX = 2;
        velY = 9;
    }

    @Override
    public void tick() {
        x += velX;
        y += velY;

        if (y <= 0 || y >= WaveGame.HEIGHT - 56) velY *= -1;
        if (x <= 0 || x >= WaveGame.WIDTH - 32) velX *= -1;

        handler.addObject(new Trail(x, y, ID.Trail, Color.CYAN, 16, 16, 0.02f, handler ));
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.CYAN);
        g.fillRect((int)x, (int)y, 16, 16);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int)x, (int)y, 16, 16);
    }
}
