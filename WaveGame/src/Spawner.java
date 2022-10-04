import java.util.Random;

public class Spawner {
    private final Random r = new Random();
    private Handler handler;
    private HUD hud;

    public Spawner(Handler handler, HUD hud) {
        this.handler = handler;
        this.hud = hud;

    }

    public void tick(){
        if ((hud.getScore() % 500) == 0) {
            handler.addObject(new BasicEnemy(r.nextInt(WaveGame.HEIGHT), r.nextInt(WaveGame.WIDTH), ID.BasicEnemy, handler));

            if (((hud.getScore()%500) % 2 ) == 0){
                handler.addObject(new FastEnemy(r.nextInt(WaveGame.HEIGHT), r.nextInt(WaveGame.WIDTH), ID.FastEnemy, handler));
            }

            if (((hud.getScore()%500) % 3 ) == 0){
                handler.addObject(new SmartEnemy(r.nextInt(WaveGame.HEIGHT), r.nextInt(WaveGame.WIDTH), ID.SmartEnnemy, handler));
            }
            hud.setLevel(hud.getLevel() + 1);
        }
    }
}
