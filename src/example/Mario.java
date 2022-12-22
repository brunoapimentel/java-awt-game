package example;

import engine.AssetLoader;
import engine.GameObject;

import javax.sound.sampled.Clip;
import java.awt.*;
import java.awt.event.KeyEvent;

public class Mario extends GameObject {
    private Clip jumpSound;
    private int accelerationY = 0;
    private final int gravity = 2;
    private final int groundLevel;
    private boolean isOnGround = true;

    public Mario(int x, int y) {
        super(x, y, AssetLoader.getImage("mario.png"));
        jumpSound = AssetLoader.getAudio("jump.wav");
        groundLevel = y;
    }

    @Override
    public void onKeyPress(KeyEvent e) {
        if(e.getKeyCode() != KeyEvent.VK_SPACE) {
            return;
        }

        if(isOnGround) {
            accelerationY = 30;
            jumpSound.setMicrosecondPosition(0);
            jumpSound.start();
            isOnGround = false;
        }
    }

    @Override
    public void paint(Graphics g) {
        y -= accelerationY;

        if (y >= groundLevel) {
            y = groundLevel;
            isOnGround = true;
            accelerationY = 0;
        } else {
            accelerationY -= gravity;
        }

        super.paint(g);
    }
}
