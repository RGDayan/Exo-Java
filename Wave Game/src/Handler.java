import java.awt.*;
import java.util.LinkedList;

public class Handler {
    LinkedList<GameObject> objects = new LinkedList<>();

    @SuppressWarnings("ForLoopReplaceableByForEach")
    public void tick(){
        int size = objects.size();
        for (int i = 0; i < size; i++) {
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
        objects.clear();
        if (WaveGame.gameState != WaveGame.STATE.End)
            addObject(new Player(WaveGame.WIDTH/2, WaveGame.HEIGHT/2, ID.Player, this));
    }
}

