import java.awt.*;

public class FastEnnemy extends GameObject{

    protected final Handler handler;
    public FastEnnemy(int x, int y, ID id, Handler h) {
        super(x, y, id);
        handler= h;
        velX = 8;
        velY = 3;
    }

    @Override
    public void tick() {
        x += velX;
        y += velY;

        if (y <= 0 || y >= WaveGame.HEIGHT-48) velY *= -1;
        if (x <= 0 || x >= WaveGame.WIDTH-24) velX *= -1;

        handler.addObject(new Trail(x, y, ID.Trail, Color.CYAN, 12, 12, 0.02f, handler));
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.CYAN);
        g.fillRect((int)x, (int)y, 12, 12);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int)x, (int)y, 12, 12);
    }
}
