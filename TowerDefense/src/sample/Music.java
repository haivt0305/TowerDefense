package sample;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;

public class Music {
    public static String bg = "bg.mp3";
    public static Media bgMedia = new Media(new File(bg).toURI().toString());
    public static MediaPlayer bgMediaPlayer = new MediaPlayer(bgMedia);

    public static String shooting = "shooting.mp3";
    public static Media shootingMedia = new Media(new File(shooting).toURI().toString());
    public static MediaPlayer shootingMediaPlayer = new MediaPlayer(shootingMedia);

    public static String gameover = "gameover.mp3";
    public static Media gameoverMedia = new Media(new File(gameover).toURI().toString());
    public static MediaPlayer gameoverMediaPlayer = new MediaPlayer(gameoverMedia);

    public void Music() {}

}
