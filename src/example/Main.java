package example;

import engine.AssetLoader;
import engine.GameEngine;

public class Main {
    public static void main(String[] args) {
        Mario mario = new Mario(20, 418);
        GameEngine gameEngine = new GameEngine(600, 600, AssetLoader.getImage("bg.jpg"));
        gameEngine.add(mario);
        gameEngine.start();
    }
}
