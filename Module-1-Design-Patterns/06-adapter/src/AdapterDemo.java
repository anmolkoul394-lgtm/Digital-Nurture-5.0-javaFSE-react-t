// AdapterDemo.java
// Demonstrates the Adapter Design Pattern.
// MediaPlayer is the interface our client code expects (it only knows mp3).
// AdvancedMediaPlayer is an existing/legacy interface with a DIFFERENT method signature (mp4, vlc).
// MediaAdapter "translates" between the two so the client can play ALL formats transparently.

// Target interface - what the client code expects to use.
interface MediaPlayer {
    void play(String audioType, String fileName);
}

// Existing (incompatible) interface - the "Adaptee" family.
interface AdvancedMediaPlayer {
    void playVlc(String fileName);
    void playMp4(String fileName);
}

// Concrete adaptee implementations.
class VlcPlayer implements AdvancedMediaPlayer {
    @Override
    public void playVlc(String fileName) {
        System.out.println("Playing vlc file using adapter: " + fileName);
    }

    @Override
    public void playMp4(String fileName) {
        // Does nothing - this class only knows how to play vlc
    }
}

class Mp4Player implements AdvancedMediaPlayer {
    @Override
    public void playVlc(String fileName) {
        // Does nothing - this class only knows how to play mp4
    }

    @Override
    public void playMp4(String fileName) {
        System.out.println("Playing mp4 file using adapter: " + fileName);
    }
}

// The Adapter - implements the interface the client expects (MediaPlayer),
// but internally delegates to the incompatible AdvancedMediaPlayer classes.
class MediaAdapter implements MediaPlayer {
    private AdvancedMediaPlayer advancedMusicPlayer;

    public MediaAdapter(String audioType) {
        if ("vlc".equalsIgnoreCase(audioType)) {
            advancedMusicPlayer = new VlcPlayer();
        } else if ("mp4".equalsIgnoreCase(audioType)) {
            advancedMusicPlayer = new Mp4Player();
        }
    }

    @Override
    public void play(String audioType, String fileName) {
        if ("vlc".equalsIgnoreCase(audioType)) {
            advancedMusicPlayer.playVlc(fileName);
        } else if ("mp4".equalsIgnoreCase(audioType)) {
            advancedMusicPlayer.playMp4(fileName);
        }
    }
}

// The client-facing player - supports mp3 natively, and delegates
// unknown formats (mp4, vlc) to the MediaAdapter.
class AudioPlayer implements MediaPlayer {
    @Override
    public void play(String audioType, String fileName) {
        if ("mp3".equalsIgnoreCase(audioType)) {
            System.out.println("Playing mp3 file: " + fileName);
        } else if ("mp4".equalsIgnoreCase(audioType) || "vlc".equalsIgnoreCase(audioType)) {
            // Delegate to the adapter for unsupported formats
            MediaAdapter mediaAdapter = new MediaAdapter(audioType);
            mediaAdapter.play(audioType, fileName);
        } else {
            System.out.println("Invalid media type: " + audioType + " is not supported");
        }
    }
}

public class AdapterDemo {
    public static void main(String[] args) {
        AudioPlayer audioPlayer = new AudioPlayer();

        audioPlayer.play("mp3", "song.mp3");
        audioPlayer.play("mp4", "video.mp4");
        audioPlayer.play("vlc", "movie.vlc");
    }
}
