package sample;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;

public class Music {
    String bg = "bg.mp3";
    Media bgMedia = new Media(new File(bg).toURI().toString());
    MediaPlayer bgMediaPlayer = new MediaPlayer(bgMedia);

    String shootingsound = "shootingsound.mp3";
    Media shootingsoundMedia = new Media(new File(shootingsound).toURI().toString());
    MediaPlayer shootingsoundPlayer = new MediaPlayer(shootingsoundMedia);

    String gameover = "gameover.mp3";
    Media gameoverMedia = new Media(new File(gameover).toURI().toString());
    MediaPlayer gameoverPlayer = new MediaPlayer(gameoverMedia);

    public void Music() {}

}
