import java.awt.*;

public class HUD {
    public static int HEALTH = 100;
    private int greenValue = 255;
    private int score = 0;
    private int level = 1;

    public void tick(){
        HEALTH = (int)WaveGame.clamp((float)HEALTH, 0, 100);
        greenValue = (int)WaveGame.clamp((float)greenValue, 0 , 254);
        greenValue = HEALTH * 2;
        score ++;
    }

    public void render(Graphics g){
        g.setColor(new Color(75, greenValue, 0));
        g.fillRect(15, 15, (int)HEALTH*2, 32);

        g.drawString("Score: " + score, 10, 64);
        g.drawString("Level: " + level, 10, 80);
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
