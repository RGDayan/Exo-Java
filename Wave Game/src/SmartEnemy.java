import java.awt.*;

public class SmartEnemy extends GameObject{

    private final Handler handler;
    private GameObject player;

    public SmartEnemy(float x, float y, ID id, Handler h) {
        super(x, y, id);
        this.handler = h;

        int size = handler.objects.size();
        for (int i = 0; i < size; i++) {
            if (handler.objects.get(i).getId() == ID.Player)
                player = handler.objects.get(i);
        }
    }

    @Override
    public void tick() {
        x += velX;
        y += velY;

        // Si positif, alors player est en bas de l'ennemi
        float diffY = y - player.getY() - 8;
        // Si positif, alors player est à gauche de l'ennemi
        float diffX = x - player.getX() - 8;

        // Théorème de Pythagore : la somme des carrés des deux cotés d'un triangle-rectangle est égale à la somme de son hypotenuse
        float distance = (float) Math.sqrt(Math.pow((x - player.getX()), 2) + Math.pow((y - player.getY()), 2));

        velY = (-1.0f/distance) * diffY;
        velX = (-1.0f/distance) * diffX;

        if (y <= 0 || y >= WaveGame.HEIGHT-40) velY *= -1;
        if (x <= 0 || x >= WaveGame.WIDTH-28) velX *= -1;

        handler.addObject(new Trail(x, y, ID.Trail, Color.ORANGE, 16, 16, 0.02f, handler));
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.ORANGE);
        g.fillRect((int) x, (int) y, 16, 16);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y, 16, 16);
    }
}
