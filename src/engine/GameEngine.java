package engine;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

public class GameEngine extends Frame {
    private int ticks = 30;
    private List<GameObject> objects = new ArrayList<>();
    private Toolkit t = Toolkit.getDefaultToolkit();

    Image backgroundImage;
    int width;
    int height;

    public GameEngine(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public GameEngine(int width, int height, Image backgroundImage) {
        this.width = width;
        this.height = height;
        this.backgroundImage = backgroundImage;
    }

    public void start() {
        setVisible(true);
        setSize(width, height);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        new Thread(() -> {
            while (true) {
                sleep(1000 / ticks);
                t.sync();
                repaint();
            }
        }).start();

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                for (GameObject object : objects) {
                    object.onKeyPress(e);
                }
            }
        });
    }

    @Override
    public void paint(Graphics g) {
        if(backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, null);
        }

        for (GameObject object : objects) {
            object.paint(g);
        }
    }

    private void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void add(GameObject object) {
        this.objects.add(object);
    }
}
