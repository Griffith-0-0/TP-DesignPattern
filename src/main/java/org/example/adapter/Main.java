package org.example.adapter;

public class Main {
    public static void main(String[] args) {
        Ipod  ipod = new Ipod();
        System.out.println("++++++++++++++++test 1++++++++++++++++");
        ipod.setMp3Player(new Audio());
        ipod.playMedia("chabMami.MP3");
        ipod.stopMedia("chabMami.MP3");
        System.out.println("++++++++++++++++test 1++++++++++++++++");

        System.out.println("++++++++++++++++test 2++++++++++++++++");
        Mp4toMp3Converter mp3toMp3Converter = new Mp4toMp3Converter();
        mp3toMp3Converter.setMp4Player(new  Video());
        ipod.setMp3Player(mp3toMp3Converter);
        ipod.playMedia("BeatIt-MichelJackson.MP4");
        ipod.stopMedia("BeatIt-MichelJackson.MP4");
        System.out.println("++++++++++++++++test 2++++++++++++++++");


    }
}
