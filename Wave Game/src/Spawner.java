import java.util.Random;

public class Spawner {
    protected final Handler handler;
    protected HUD hud;
    private final Random r = new Random();

    public Spawner(Handler handler, HUD hud) {
        this.handler = handler;
        this.hud = hud;
    }

    public void tick() {
        if (hud.getScore() % 500 != 0)
            return;

        var level = hud.getLevel();

        hud.setLevel(hud.getLevel() +1);

        if (level%5 == 0){
            handler.clearEnnemies();
            handler.addObject(new EnemyBoss((float)(WaveGame.WIDTH/2-64), -60, ID.EnemyBoss, handler));
        }
        else if (level%3 == 0)
            handler.addObject(new SmartEnemy(r.nextInt(WaveGame.WIDTH), r.nextInt(WaveGame.HEIGHT), ID.SmartEnemy, handler));
        else if (level%2 == 0)
            handler.addObject(new FastEnnemy(r.nextInt(WaveGame.WIDTH), r.nextInt(WaveGame.HEIGHT), ID.FastEnemy, handler));
        else
            handler.addObject(new BasicEnemy(r.nextInt(WaveGame.WIDTH), r.nextInt(WaveGame.HEIGHT), ID.BasicEnemy, handler));

    }
}
