package engine;

import javax.swing.*;
import java.awt.*;

public class GameObject {

    // per second
    private int accelerationX = 0;
    private int accelerationY = 0;

    private int x = 0;
    private int y = 0;

    private Image image;

    public GameObject(Image image) {
        this.image = image;
    }

    public GameObject(int x, int y, Image image) {
        this.x = x;
        this.y = y;
        this.image = image;
    }

    public Image getImage() {
        return image;
    }

    public void setAccelerationX(int accelerationX) {
        this.accelerationX = accelerationX;
    }

    public void setAccelerationY(int accelerationY) {
        this.accelerationY = accelerationY;
    }

    public void paint(int ticks, int gravity, Graphics g) {
        int nextX = x + (accelerationX/ticks);
        int nextY = y + (accelerationY/ticks);

        if (nextY > 400) {
            nextY = 400;
        }

        g.drawImage(image, nextX, nextY, null);

        accelerationY -= (gravity / ticks);
        x = nextX;
        y = nextY;
    }
}
