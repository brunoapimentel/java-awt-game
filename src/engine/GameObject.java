package engine;

import java.awt.*;
import java.awt.event.KeyEvent;

public abstract class GameObject {
    private Image image;
    protected int x;
    protected int y;

    public void onKeyPress(KeyEvent e) {
    }

    public GameObject(int x, int y, Image image) {
        this.x = x;
        this.y = y;
        this.image = image;
    }

    public void paint(Graphics g) {
        g.drawImage(image, x, y, null);
    }
}
