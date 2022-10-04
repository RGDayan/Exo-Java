import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.Random;

/**
 * Exécution de la fenêtre principale
 */
public class WaveGame extends Canvas implements Runnable{

    public static final int WIDTH = 640;
    public static final int HEIGHT = WIDTH / 12*9;
    private final Random r;
    private final HUD hud;
    private final Spawner spawner;
    private Thread thread;
    private boolean running = false;
    private final Handler handler;

    /**
     * Constructeur
     */
    public WaveGame(){
        handler = new Handler();
        this.addKeyListener(new KeyInput(handler));
        new Window(WIDTH, HEIGHT, "Wave Game", this);
        this.requestFocus();

        hud = new HUD();
        spawner = new Spawner(handler, hud);

        r = new Random();
        handler.addObject(new Player(WIDTH/2 - 32, HEIGHT/2 -32, ID.Player, handler));
        handler.addObject(new BasicEnemy(r.nextInt(WIDTH), r.nextInt(HEIGHT), ID.BasicEnemy, handler));
        handler.addObject(new SmartEnemy(r.nextInt(WIDTH), r.nextInt(HEIGHT), ID.SmartEnnemy, handler));
    }

    /**
     * Exécution du jeu
     * @param args Arguments
     */
    public static void main(String[] args){
        new WaveGame();
    }

    /**
     * Lancée au start de l'application
     * Informe du lancement
     */
    public synchronized  void start(){
        thread = new Thread(this);
        thread.start();
        running = true;
    }

    /**
     * Lancée à l'arrêt de l'application
     * Informe de l'arrêt de l'application
     */
    public synchronized void stop(){
        try{
            thread.join();
            running = false;
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * Override de la fonction run() de Runnable
     * Calcul les FPS et les affiche toutes les secondes
     */
    @Override
    public void run()
    {
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while(running)
        {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while(delta >=1)
            {
                tick();
                delta--;
            }
            if(running)
                render();
            frames++;

            if(System.currentTimeMillis() - timer > 1000)
            {
                timer += 1000;
//                System.out.println("FPS: "+ frames);
                frames = 0;
            }
        }
        stop();
    }

    /**
     * Déclenche un tick graphique
     */
    private void tick(){
        handler.tick();
        hud.tick();
        spawner.tick();
    }

    /**
     * Récupère le buffer graphique courant
     * Affiche un composant graphique dans la fenêtre principale
     */
    private void render(){
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            this.createBufferStrategy(3);
            return;
        }

        Graphics g = bs.getDrawGraphics();
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(0, 0, WIDTH, HEIGHT);

        handler.render(g);
        hud.render(g);

        g.dispose();
        bs.show();
    }

    public static int clamp(int var, int min, int max){
        if (var >= max) {
            return var = max;
        }else if (var <= min){
            return var = min;
        }else {
            return var;
        }
    }
}
