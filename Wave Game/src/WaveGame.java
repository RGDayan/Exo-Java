import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.Random;

public class WaveGame extends Canvas implements Runnable {

    public static final int WIDTH = 640, HEIGHT = WIDTH/12 *9;
    private final Handler handler;
    private final HUD hud;
    private final Spawner spawner;
    private boolean running;
    private Thread thread;
    private final Menu menu;
    public Help help;
    public End end;

    public enum STATE {
        Menu,
        Help,
        Game,
        End
    }

    public static STATE gameState = STATE.Menu;

    public WaveGame() {
        hud = new HUD();

        handler = new Handler();
        this.addKeyListener(new KeyInput(handler));

        spawner = new Spawner(handler, hud);

        menu = new Menu(this, handler);
        this.addMouseListener(menu);

        help = new Help(this);
        this.addMouseListener(help);

        end = new End(this, hud);
        this.addMouseListener(end);

        new Window(WIDTH, HEIGHT, "Wave Game",  this);
        this.requestFocus();

        spawnParticles();
    }

    public static void main(String[] args) {
        new WaveGame();
    }

    public synchronized void start(){
        thread = new Thread(this);
        thread.start();
        running = true;
    }

    @Override
    public void run() {
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000/ amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
//        int frames = 0;
        while (running){
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while (delta >= 1){
                tick();
                delta--;
            }
            if (running)
                render();
//            frames++;

            if (System.currentTimeMillis() - timer > 1000){
                timer += 1000;
//                System.out.println("FPS : " + frames);
            }
        }
        stop();
    }

    private void tick(){
        menu.tick();
        try{
            handler.tick();
        }catch (Exception e){
            e.printStackTrace();
        }

        if (gameState != STATE.Game)
            return;

        hud.tick();
        spawner.tick();

        if (HUD.HEALTH <= 0){
            HUD.HEALTH = 100;
            gameState = STATE.End;
            handler.clearEnnemies();
            spawnParticles();
        }
    }

    private void render(){
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null){
            this.createBufferStrategy(3);
            return;
        }

        Graphics g = bs.getDrawGraphics();
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, WIDTH, HEIGHT);
        try{
            handler.render(g);
        }catch (Exception e){
            e.printStackTrace();
        }

        switch (gameState) {
            case Game -> hud.render(g);
            case Menu -> menu.render(g);
            case Help -> help.render(g);
            case End -> {
                end.render(g);
                end.finalScore = hud.getScore();
            }
        }

        g.dispose();
        bs.show();
    }

    public synchronized void stop(){
        try{
            thread.join();
            running = false;
        } catch (InterruptedException ex){
            ex.printStackTrace();
        }
    }

    public static float clamp(float var, float min, float max){
        if (var >= max)
            return var = max;
        else if (var <= min)
            return var = min;
        else
            return var;
    }

    public void spawnParticles() {
        var r = new Random();
        for (int i = 0; i < 10; i++) {
            handler.addObject(new MenuParticle(
                    r.nextInt(WIDTH),
                    r.nextInt(HEIGHT),
                    ID.MenuParticle,
                    handler));
        }
    }
}