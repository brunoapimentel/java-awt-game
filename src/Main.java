import engine.GameEngine;
import engine.GameObject;

import javax.swing.*;
import java.awt.*;

public class Main extends Frame {

    private Main() {
        ImageIcon ii = new ImageIcon("src/mario.jpg");
        GameObject mario = new GameObject(20, 400, ii.getImage());
        mario.setAccelerationY(-100);

        GameEngine gameEngine = new GameEngine();
        gameEngine.add(mario);
        gameEngine.start();
    }

    public static void main(String[] args) {
        Main main = new Main();
    }
}
