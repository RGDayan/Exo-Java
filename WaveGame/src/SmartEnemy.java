import java.awt.*;

public class SmartEnemy extends GameObject {
    private Handler handler;
    private GameObject player;

    public SmartEnemy(int x, int y, ID id, Handler h) {
        super(x, y, id);
        this.handler = h;

        for (int i = 0; i < handler.objects.size(); i++) {
            if (handler.objects.get(i).getId() == ID.Player)
                player = handler.objects.get(i);
        }
    }

    @Override
    public void tick() {
        x += velX;
        y += velY;

        float diffX = x - player.getX() -8;
        float diffY = y - player.getY() -8;
        float distance = (float)Math.sqrt((x - player.getX()) * (x-player.getX()) + (y - player.getY()) * (y - player.getY()));
        velX = (int) ((-1.0 / distance) * diffX);
        velY = (int) ((-1.0 / distance) * diffY);

        if (player.getY() <= 0 || y >= WaveGame.HEIGHT - 56) velY *= -1;
        if (player.getX() <= 0 || x >= WaveGame.WIDTH - 32) velX *= -1;

        handler.addObject(new Trail(x, y, ID.Trail, Color.ORANGE, 16, 16, 0.02f, handler));
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.ORANGE);
        g.fillRect(x, y, 16, 16);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(x, y, 16, 16);
    }
}
