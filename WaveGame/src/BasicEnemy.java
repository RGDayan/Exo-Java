import java.awt.*;

public class BasicEnemy extends GameObject {

    private Handler handler;
    public BasicEnemy(int x, int y, ID id, Handler h) {
        super(x, y, id);
        this.handler = h;
        velX = 3;
        velY = 3;
    }

    @Override
    public void tick() {
        x += velX;
        y += velY;

        if (y <= 0 || y >= WaveGame.HEIGHT - 56) velY *= -1;
        if (x <= 0 || x >= WaveGame.WIDTH - 32) velX *= -1;

        handler.addObject(new Trail(x, y, ID.Trail, Color.RED, 16, 16, 0.02f, handler ));
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(x, y, 16, 16);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(x, y, 16, 16);
    }
}
