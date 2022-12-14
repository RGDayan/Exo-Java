import java.awt.*;

public class Player extends GameObject{

    protected final Handler handler;

    public Player(int x, int y, ID id, Handler h) {
        super(x, y, id);
        handler = h;
        setX(100);
    }

    @Override
    public void tick() {
        x += velX;
        y += velY;

        x = WaveGame.clamp(x, 0, (float)WaveGame.WIDTH - 48);
        y = WaveGame.clamp(y, 0, (float)WaveGame.HEIGHT - 70);

        collision();

        handler.addObject(new Trail(x, y, ID.Trail, Color.BLUE, 32, 32, 0.2f, handler));
    }

    private void collision() {

        int size = handler.objects.size();
        for (int i = 0; i < size; i++) {
            var tempObject = handler.objects.get(i);

            switch (tempObject.getId()){
                case BasicEnemy -> {
                    if (getBounds().intersects(tempObject.getBounds()))
                        HUD.HEALTH -= 2;
                }
                case FastEnemy -> {
                    if (getBounds().intersects(tempObject.getBounds()))
                        HUD.HEALTH -= 1;
                }
                case SmartEnemy -> {
                    if (getBounds().intersects(tempObject.getBounds()))
                        HUD.HEALTH -= 0.5;
                }
                case EnemyBoss -> {
                    if (getBounds().intersects(tempObject.getBounds()))
                        HUD.HEALTH = 0;
                }
            }
        }
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillRect((int)x, (int)y, 32,32);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int)x, (int)y, 32, 32);
    }
}
