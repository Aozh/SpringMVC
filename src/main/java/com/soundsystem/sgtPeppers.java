package com.soundsystem;

import org.springframework.stereotype.Component;

@Component
public class sgtPeppers implements CompactDisc {
    private String title = "sgt, Pepper's Lonely Hearts Club Band";
    private String artist = "The Beatles";

    public void play() {
        System.out.println("Playing " + title + " by " + artist);
    }
}