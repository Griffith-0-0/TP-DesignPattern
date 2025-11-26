package org.example.adapter;

public class Mp4toMp3Converter implements Mp3Player{
    Mp4Player mp4Player;
    public Mp4toMp3Converter(){
        this.mp4Player = mp4Player;
    }

    @Override
    public void playAudio(String mediaPath) {
        System.out.println("(MP4)"+mediaPath+"converted to MP3");
        Mp4Player mp4Player = this.mp4Player;
        mp4Player.playVideo(mediaPath);
        System.out.println("---------------------------------------------");

    }

    @Override
    public void pauseAudio(String mediaPath) {
        Mp4Player mp4Player = this.mp4Player;
        mp4Player.pauseVideo(mediaPath);
        System.out.println("------------------------------------------");

    }

    @Override
    public void stopAudio(String mediaPath) {
        Mp4Player mp4Player = this.mp4Player;
        mp4Player.stopVideo(mediaPath);
        System.out.println("-----------------------------------------");

    }

    public void setMp4Player(Mp4Player mp4Player) {
        this.mp4Player = mp4Player;
    }
}
