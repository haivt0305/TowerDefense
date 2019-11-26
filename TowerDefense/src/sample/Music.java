package sample;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;

public class Music {
    public static String bg = "bg.mp3";
    public static Media bgMedia = new Media(new File(bg).toURI().toString());
    public static MediaPlayer bgMediaPlayer = new MediaPlayer(bgMedia);

    public static String normal = "normal.mp3";
    public static Media normalMedia = new Media(new File(normal).toURI().toString());
    public static MediaPlayer normalMediaPlayer = new MediaPlayer(normalMedia);

    public static String machine = "machine.mp3";
    public static Media machineMedia = new Media(new File(machine).toURI().toString());
    public static MediaPlayer machineMediaPlayer = new MediaPlayer(machineMedia);

    public static String sniper = "sniper.mp3";
    public static Media sniperMedia = new Media(new File(sniper).toURI().toString());
    public static MediaPlayer sniperMediaPlayer = new MediaPlayer(sniperMedia);

    public static String gameover = "gameover.mp3";
    public static Media gameoverMedia = new Media(new File(gameover).toURI().toString());
    public static MediaPlayer gameoverMediaPlayer = new MediaPlayer(gameoverMedia);

    public void Music() {}

}
