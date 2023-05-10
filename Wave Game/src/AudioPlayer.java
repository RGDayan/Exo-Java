import javafx.scene.media.AudioClip;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public abstract class AudioPlayer {
    public static Map<String, AudioClip> soundMap = new HashMap<>();
    public static Map<String, AudioClip> musicMap = new HashMap<>();

    public static void chargementAudioClip(){
        try{
            addSound("Click", "res/click.wav", soundMap, 0.5f);
            addSound("LaserShot", "res/laserShot.wav", soundMap, 0.2f);
            addSound("Music", "res/invasion.wav", musicMap, 0.5f);
        }catch (Exception ex){
            throw new RuntimeException(ex);
        }
    }

    private static void addSound(String key, String url, Map<String, AudioClip> map, Float volume){
        File fichierAudio = new File(url);
        AudioClip clip = new AudioClip(fichierAudio.toURI().toString());
        clip.setVolume(volume);

        if (key.equals("Music"))
            clip.setCycleCount(AudioClip.INDEFINITE);

        map.put(key, clip);
    }

    public static AudioClip getMusic() {
        return musicMap.get("Music");
    }

    public static AudioClip getSound(String key){
        return soundMap.get(key);
    }
}
