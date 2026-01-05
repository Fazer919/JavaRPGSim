package rpggame;

import java.util.HashMap;
import java.util.Map;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

public class SoundManager {

    private static final Map<String, MediaPlayer> cache = new HashMap<>();

    public static void play(String resourcePath) {

        MediaPlayer player = cache.get(resourcePath);

        if (player == null) {
            Media media = new Media(SoundManager.class.getResource(resourcePath).toExternalForm());
            player = new MediaPlayer(media);
            cache.put(resourcePath, player);
        }

        player.stop();
        player.seek(Duration.ZERO);
        player.play();
    }
}