import java.awt.*;

public class SmartEnemy extends GameObject {
    private final Handler handler;
    private GameObject player;

    public SmartEnemy(float x, float y, ID id, Handler h) {
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

        if (diffX > 0)
            velX = -1;
        else if (diffX < 0)
            velX = 1;

        if (diffY > 0)
            velY = -1;
        else if (diffY < 0)
            velY = 1;

        handler.addObject(new Trail(x, y, ID.Trail, Color.ORANGE, 16, 16, 0.02f, handler));
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.ORANGE);
        g.fillRect((int)x, (int)y, 16, 16);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int)x, (int)y, 16, 16);
    }
}
