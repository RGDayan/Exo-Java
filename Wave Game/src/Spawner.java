import java.util.Random;

public class Spawner {
    protected final Handler handler;
    protected HUD hud;
    private Random r = new Random();

    public Spawner(Handler handler, HUD hud) {
        this.handler = handler;
        this.hud = hud;
    }

    public void tick(){

        if (hud.getScore()%500 == 0){
            var level = hud.getLevel() -1;

            if (level%4 == 0)
                handler.addObject(new BasicEnemy(r.nextInt(WaveGame.WIDTH), r.nextInt(WaveGame.HEIGHT), ID.BasicEnemy, handler));
            else if (level%3 == 0)
                handler.addObject(new BasicEnemy(r.nextInt(WaveGame.WIDTH), r.nextInt(WaveGame.HEIGHT), ID.BasicEnemy, handler));
            else if (level%2 == 0)
                handler.addObject(new BasicEnemy(r.nextInt(WaveGame.WIDTH), r.nextInt(WaveGame.HEIGHT), ID.BasicEnemy, handler));
            else
                handler.addObject(new BasicEnemy(r.nextInt(WaveGame.WIDTH), r.nextInt(WaveGame.HEIGHT), ID.BasicEnemy, handler));

            hud.setLevel(hud.getLevel() +1);
        }

    }
}
