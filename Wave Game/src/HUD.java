import java.awt.*;

public class HUD {
    public static float HEALTH = 100;
    public int greenValue = 255;
    private int score = 0;
    private int level = 1;
    public void tick(){
        HEALTH = WaveGame.clamp(HEALTH, 0, 100);
        greenValue = (int)WaveGame.clamp(greenValue, 0, 255);
        greenValue = (int)HEALTH*2;
        score++;
    }

    public void render(Graphics g){
        g.setColor(new Color(75, greenValue, 0));
        g.fillRect(15, 15, (int)HEALTH *2 , 32);

        g.drawString("Score : " + score, 10, 64);
        g.drawString("Level : " +  level, 10, 80);
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
