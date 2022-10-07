import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {

    private Handler handler;

    public KeyInput(Handler handler) {
        this.handler = handler;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        for (GameObject tempObject: handler.objects) {
            if (tempObject.getId() == ID.Player){
                switch (key){
                    case KeyEvent.VK_Z -> tempObject.setVelY(-5);
                    case KeyEvent.VK_S -> tempObject.setVelY(5);
                    case KeyEvent.VK_Q -> tempObject.setVelX(-5);
                    case KeyEvent.VK_D -> tempObject.setVelX(5);
                }
            }
        }

        if (key == KeyEvent.VK_ESCAPE)
            System.exit(1);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        for (GameObject tempObject: handler.objects) {
            if (tempObject.getId() == ID.Player){
                switch (key){
                    case KeyEvent.VK_Z, KeyEvent.VK_S -> tempObject.setVelY(0);
                    case KeyEvent.VK_Q, KeyEvent.VK_D -> tempObject.setVelX(0);
                }
            }
        }
    }
}
