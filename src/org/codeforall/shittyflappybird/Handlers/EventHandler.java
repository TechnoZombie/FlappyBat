package org.codeforall.shittyflappybird.Handlers;

import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.codeforall.shittyflappybird.GameObjects.Bat;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.File;
import java.io.IOException;


import static java.lang.Thread.sleep;

public class EventHandler implements KeyboardHandler, Runnable {

    // declaring background music variable
    private Clip backgroundMusic;


    // method to add background music
    public void loadAudio() {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("Resources/Sound/EvilLaugh.wav"));
            backgroundMusic = AudioSystem.getClip();
            backgroundMusic.open(audioInputStream);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    public void loadEndAudio() {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("Resources/Sound/EvilLaugh.wav"));
            backgroundMusic = AudioSystem.getClip();
            backgroundMusic.open(audioInputStream);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
        }

    @Override
    public void run() {
        while(true) {
            loadAudio();
            // Play the background music
            backgroundMusic.start();
        }
        // Stop and close the background music when the game ends
       // backgroundMusic.stop();
        //backgroundMusic.close();
    }

}