import java.awt.event.MouseAdapter;

public abstract class CustomMouseAdapter extends MouseAdapter {
    public final WaveGame game;

    public CustomMouseAdapter(WaveGame game) {
        this.game = game;
    }

    public void tick(){}

    public Boolean mouseOver(int mx, int my, int x, int y, int width, int height){
        if (mx > x && mx < x + width){
            return my > y && my < y + height;
        }else
            return false;
    }
}
