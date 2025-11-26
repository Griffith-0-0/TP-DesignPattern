package org.example.adapter;

public class Video implements Mp4Player {
    @Override
    public void playVideo(String mediaPath) {
        System.out.println("(MP4) Playing video: " + mediaPath);
    }

    @Override
    public void pauseVideo(String mediaPath) {
        System.out.println("(MP4) Pausing video: " + mediaPath);

    }

    @Override
    public void stopVideo(String mediaPath) {
        System.out.println("(MP4) Stopping video: " + mediaPath);

    }
}
