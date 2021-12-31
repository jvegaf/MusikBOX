package me.jvegaf.musikbox.app.player;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;
import me.jvegaf.musikbox.context.tracks.domain.Track;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public final class MusicPlayer {
    private final Track currentTrack;
    private MediaPlayer mPlayer;
    public final StringProperty titleProperty;
    public final StringProperty artistProperty;
    public final ObjectProperty<Duration> currentPlayTimeProperty;
    public final ObjectProperty<Duration> totalDurationProperty;
    public final ObjectProperty<MediaPlayer.Status> statusProperty;

    public MusicPlayer() {
        this.currentTrack = null;
        this.titleProperty = new SimpleStringProperty("");
        this.artistProperty = new SimpleStringProperty("");
        this.currentPlayTimeProperty = new SimpleObjectProperty<>();
        this.totalDurationProperty = new SimpleObjectProperty<>(Duration.UNKNOWN);
        this.statusProperty = new SimpleObjectProperty<>(MediaPlayer.Status.UNKNOWN);
    }

    public void playTrack(Track track) {
        if (currentTrackChecker(track)) return;
        if (this.mPlayer != null) stopTrack();
        var path = track.location().value();
        Media media = new Media(new File(path).toURI().toString());
        this.mPlayer = new MediaPlayer(media);
        this.mPlayer.play();
        setStatusProp();
        this.titleProperty.setValue(track.title().value());
        this.artistProperty.setValue(track.artist().value());
        this.totalDurationProperty.setValue(this.mPlayer.getTotalDuration());
        setCurrentPlayTimeProp();
    }

    private void setStatusProp() {
        this.mPlayer.statusProperty().addListener((observable, oldValue, newValue) -> this.statusProperty.setValue(newValue));
    }

    private void setCurrentPlayTimeProp(){
        this.mPlayer.currentTimeProperty().addListener((observable, oldValue, newValue) -> this.currentPlayTimeProperty.setValue(newValue));
    }

    private boolean currentTrackChecker(Track track) {
        if (this.currentTrack == null) return false;
        return currentTrack.location().value().equals(track.location().value());
    }

    public void pauseTrack() {
        this.mPlayer.pause();
    }

    public void continuePlaying() {
        if (this.mPlayer.getStatus().equals(MediaPlayer.Status.PAUSED)) this.mPlayer.play();
    }

    public void seekTo(Duration value) {
        this.mPlayer.seek(value);
    }

    public void stopTrack() {
        this.mPlayer.dispose();
        this.mPlayer = null;
    }

    public MediaPlayer getMediaPlayer() {
        return this.mPlayer;
    }
}