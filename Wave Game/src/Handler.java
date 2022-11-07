import java.awt.*;
import java.util.LinkedList;

public class Handler {
    LinkedList<GameObject> objects = new LinkedList<>();

    public void tick(){
        for (int i = 0; i < objects.size(); i++) {
            var tempObject = objects.get(i);
            tempObject.tick();
        }
    }

    public void render(Graphics g){
        for (GameObject tempObject : objects) {
            tempObject.render(g);
        }
    }

    public void addObject(GameObject object){
        this.objects.add(object);
    }

    public void removeObject(GameObject object){
        this.objects.remove(object);
    }

    public void clearEnnemies(){
        for (int i = 0; i < objects.size(); i++) {
            var object = objects.get(i);
            if (object.getId() == ID.Player){
                objects.clear();
                addObject(new Player(WaveGame.WIDTH/2, WaveGame.HEIGHT/2, ID.Player, this));
            }
        }
    }
}

