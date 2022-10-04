import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.security.Key;

public class KeyInput extends KeyAdapter {
    private final Handler handler;
    private final boolean[] keyDown = new boolean[4];

    public KeyInput(Handler handler) {
        this.handler = handler;
        keyDown[0] = false;
        keyDown[1] = false;
        keyDown[2] = false;
        keyDown[3] = false;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        for (GameObject tempObject: handler.objects) {
            if (tempObject.getId() == ID.Player){
                switch (key) {
                    case KeyEvent.VK_Z -> {
                        tempObject.setVelY(-5);
                        keyDown[0] = true;
                    }
                    case KeyEvent.VK_S -> {
                        tempObject.setVelY(5);
                        keyDown[1] = true;
                    }
                    case KeyEvent.VK_Q -> {
                        tempObject.setVelX(-5);
                        keyDown[2] = true;
                    }
                    case KeyEvent.VK_D -> {
                        tempObject.setVelX(5);
                        keyDown[3] = true;
                    }
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
            if (tempObject.id == ID.Player){
                switch (key) {
                    case KeyEvent.VK_Z, KeyEvent.VK_S -> {
                        keyDown[0] = false;
                        keyDown[1] = false;
                    }
                    case KeyEvent.VK_D, KeyEvent.VK_Q -> {
                        keyDown[2] = false;
                        keyDown[3] = false;
                    }
                }
                if (!keyDown[0] && !keyDown[1]) tempObject.setVelY(0);
                if (!keyDown[2] && !keyDown[3]) tempObject.setVelX(0);
            }
        }
    }
}
