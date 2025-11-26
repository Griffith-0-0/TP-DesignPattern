package org.example.adapter;

public class Audio implements Mp3Player{
    @Override
    public void playAudio(String mediaPath) {
        System.out.println("(MP3) Playing audio: " + mediaPath);
    }

    @Override
    public void pauseAudio(String mediaPath) {
        System.out.println("(MP3) Paused audio: " + mediaPath);
    }

    @Override
    public void stopAudio(String mediaPath) {
        System.out.println("(MP3) Stopped audio: " + mediaPath);

    }
}
