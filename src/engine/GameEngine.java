package engine;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

public class GameEngine extends Frame{
    private int ticks = 5;
    private List<GameObject> objects = new ArrayList<>();
    private int gravity = -10;

    private Toolkit t = Toolkit.getDefaultToolkit();

    public void start() {
        setVisible(true);
        setSize(600, 600);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        new Thread(() -> {
            while (true) {
                sleep(1000 / 30);

                t.sync();
                repaint();

            }
        }).start();
    }

    @Override
    public void paint(Graphics g) {
        for (GameObject object : objects) {
            object.paint(ticks, gravity, g);
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
