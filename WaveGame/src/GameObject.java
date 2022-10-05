import java.awt.*;

public abstract class GameObject {
    protected float x, y;
    protected double velX, velY;
    protected ID id;

    public GameObject(float x, float y, ID id) {
        this.x = x;
        this.y = y;
        this.id = id;
    }

    public abstract void tick();
    public abstract void render(Graphics g);

    public float getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }

    public double getVelX() {
        return velX;
    }
    public void setVelX(int velX) {
        this.velX = velX;
    }

    public double getVelY() {
        return velY;
    }
    public void setVelY(int velY) {
        this.velY = velY;
    }

    public ID getId() {
        return id;
    }
    public void setId(ID id) {
        this.id = id;
    }

    public abstract Rectangle getBounds();
}
