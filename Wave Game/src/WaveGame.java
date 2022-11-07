import java.awt.*;
import java.awt.image.BufferStrategy;

public class WaveGame extends Canvas implements Runnable {

    public static final int WIDTH = 640, HEIGHT = WIDTH/12 *9;
    private final Menu menu;
    private final Handler handler;
    private final HUD hud;
    private final Spawner spawner;
    private boolean running;
    private Thread thread;
    public Help help;

    public enum STATE {
        Menu,
        Help,
        Game
    }

    public STATE gameState = STATE.Menu;

    public WaveGame() {
        handler = new Handler();
        this.addKeyListener(new KeyInput(handler));

        menu = new Menu(this, handler);
        this.addMouseListener(menu);

        help = new Help(handler);

        new Window(WIDTH, HEIGHT, "Wave Game",  this);
        this.requestFocus();

        hud = new HUD();
        spawner = new Spawner(handler, hud);
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
        handler.tick();
        if (gameState == STATE.Game){
            hud.tick();
            spawner.tick();
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
        handler.render(g);

        if (gameState == STATE.Game)
            hud.render(g);
        else if (gameState == STATE.Menu )
            menu.render(g);
        else if (gameState == STATE.Help)
            help.render(g);

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
}