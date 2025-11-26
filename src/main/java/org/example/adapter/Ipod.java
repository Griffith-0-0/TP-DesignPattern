package org.example.adapter;

public class Ipod {
    private Mp3Player mp3Player;

    public Ipod() {
    }

    public Ipod(Mp3Player mp3Player) {
        this.mp3Player = mp3Player;
    }

    public void setMp3Player(Mp3Player mp3Player) {
        this.mp3Player = mp3Player;
    }

    public void playMedia(String mediaPath) {
        mp3Player.playAudio(mediaPath);
    }
    public void pauseMedia(String mediaPath) {
        mp3Player.pauseAudio(mediaPath);
    }
    public void stopMedia(String mediaPath) {
        mp3Player.stopAudio(mediaPath);
    }
}
