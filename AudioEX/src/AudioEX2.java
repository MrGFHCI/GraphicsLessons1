//captain kesty
import java.io.*;
import java.util.*;
import javax.sound.sampled.*;

public class AudioEX2 {

    static int nLoopAmount = 1;
    // second method

    public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        File fSound = new File("your file here.wav");
        AudioInputStream sound = AudioSystem.getAudioInputStream(fSound);
        DataLine.Info info = new DataLine.Info(Clip.class, sound.getFormat());
        Clip cSong = (Clip) AudioSystem.getLine(info);
        cSong.open(sound);
        cSong.loop(nLoopAmount); // use Clip.LOOP_CONTINUOUSLY to loop forever
        cSong.stop();
        cSong.close();
    }
}
