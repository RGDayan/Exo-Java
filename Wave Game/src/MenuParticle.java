import java.awt.*;
import java.util.Random;

public class MenuParticle extends GameObject{

    protected final Handler handler;
    private final Color col;

    public MenuParticle(int x, int y, ID id, Handler h) {
        super(x, y, id);
        handler= h;
        Random r = new Random();
        velX = r.nextInt(5- -5)+-5;
        velY = r.nextInt(5- -5)+-5;

        if (velX == 0) velX += 1;
        if (velY == 0) velY += 1;

        col = new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255));
    }

    @Override
    public void tick() {
        x += velX;
        y += velY;

        if (y <= 0 || y >= WaveGame.HEIGHT-48) velY *= -1;
        if (x <= 0 || x >= WaveGame.WIDTH-24) velX *= -1;

        handler.addObject(new Trail(x, y, ID.Trail, col, 16, 16, 0.02f, handler));
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
