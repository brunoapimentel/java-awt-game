package engine;

import javax.imageio.ImageIO;
import javax.sound.sampled.*;
import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;

public class AssetLoader {
    private static AssetLoader singleton;

    private String[] imagePaths = {"mario.png", "bg.jpg"};
    private String[] audioPaths = {"jump.wav"};

    private HashMap<String, Image> images = new HashMap<>();
    private HashMap<String, Clip> audios = new HashMap<>();

    public static AssetLoader getSingleton() {
        if(singleton == null) {
            try {
                singleton = new AssetLoader();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        return singleton;
    }

    AssetLoader() throws IOException, LineUnavailableException, UnsupportedAudioFileException {
        for(String path : imagePaths) {
            URL url = getClass().getClassLoader().getResource("assets/" + path);

            if(url == null) {
                throw new RuntimeException("File not found: " + path);
            }

            images.put(path, ImageIO.read(url));
        }

        for(String path : audioPaths) {
            URL url = getClass().getClassLoader().getResource("assets/" + path);

            if(url == null) {
                throw new RuntimeException("File not found: " + path);
            }

            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(url));

            audios.put(path, clip);
        }
    }

    public static Image getImage(String path) {
        return getSingleton().images.get(path);
    }

    public static Clip getAudio(String path) {
        return getSingleton().audios.get(path);
    }
}
