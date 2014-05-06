/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal;

/**
 *
 * @author Abraham
 */
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.Clip;
import javax.sound.sampled.AudioSystem;
import java.io.IOException;
import java.net.URL;

public class SoundClip {

    private AudioInputStream sample;
    private Clip clip;
    private boolean looping = false;
    private int repeat = 0;
    private String filename = "";

    public SoundClip() {

        try {

            clip = AudioSystem.getClip();
        } catch (LineUnavailableException e) {

            System.out.println("Error en " + e.toString());
        }
    }

    //@param  filename es para saber el nombre del archivo de sonido de tipo <code>string</code>
    public SoundClip(String filename) {

        this();
        load(filename);
    }

   //@param  looping es para reproducir el sonido en un cliclo y es de tipo <code>boolean</code>
    public void setLooping(boolean looping) {

        this.looping = looping;
    }

   //@param  repeat es para que se repita el sonido y es de tipo <code>int</code>
    public void setRepeat(int repeat) {

        this.repeat = repeat;
    }

    //@param  filename es para saber el nombre del archivo de sonido de tipo <code>string</code>
    public void setFilename(String filename) {

        this.filename = filename;
    }

    public Clip getClip() {

        return clip;
    }

    public boolean getLooping() {

        return looping;
    }

    public int getRepeat() {

        return repeat;
    }

    public String getFilename() {

        return filename;
    }
    
  //@param  filename es para saber el nombre del archivo de sonido de tipo <code>string</code>
    private URL getURL(String filename) {

        URL url = null;
        try {

            url = this.getClass().getResource(filename);
        } catch (Exception e) {

            System.out.println("Error en " + e.toString());
        }
        return url;
    }

    public boolean isLoaded() {
        return (boolean) (sample != null);
    }
    
 //@param  audiofile es para cargar el archivo de sonido <code>string</code>
    public boolean load(String audiofile) {

        try {
            setFilename(audiofile);
            sample = AudioSystem.getAudioInputStream(getURL(filename));
            clip.open(sample);
            return true;
        } catch (IOException e) {

            System.out.println("Error en " + e.toString());
            return false;
        } catch (UnsupportedAudioFileException e) {

            System.out.println("Error en " + e.toString());
            return false;
        } catch (LineUnavailableException e) {

            System.out.println("Error en " + e.toString());
            return false;
        }
    }

    public void play() {
        if (!isLoaded()) {
            return;
        }
        clip.setFramePosition(0);
        if (looping) {
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        } else {
            clip.loop(repeat);
        }
    }

    public void play2() {
        if (!isLoaded()) {
            return;
        } else {
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        }
    }

    public void stop() {
        clip.stop();
    }

    public void restart() {
        clip.setFramePosition(0);
    }
}
