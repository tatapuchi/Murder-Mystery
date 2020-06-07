package com.mygdx.game.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.mygdx.game.utilities.scene2d.CustomActor;
import com.mygdx.game.utilities.scene2d.FontActor;

public class Dialogue {

    private static Texture dialogueBox = new Texture("HUD/Dialogue-Box.png");
    private static Texture blackBox = new Texture("HUD/Black.png");
    private static TextureRegion dialogueRegion = new TextureRegion(dialogueBox);
    private static TextureRegion blackRegion = new TextureRegion(blackBox);
    private static final CustomActor blackActor = new CustomActor(blackRegion, 8500, 8500, -1500, -1500);
    private static final CustomActor dialogueActor = new CustomActor(dialogueRegion, 2500, 150, 0, 0);
    private static final FontActor font = new FontActor("", "Font/font.ttf", 16, false);
    private static final FontActor death = new FontActor("", "Font/font.ttf", 32, false);
    private static int i = 0;
    private static boolean finish = false;
    public static int progress = 0;
    public static boolean p1, p2, p3, p4, p5, p6 = false;

    private Dialogue() {
    }

    public static void addDialogue(Stage stage) {
        stage.addActor(dialogueActor);
        stage.addActor(font);
        stage.addActor(blackActor);
        stage.addActor(death);
        dialogueActor.setVisible(false);
        death.setVisible(false);
        blackActor.setVisible(false);
        font.setVisible(false);
        font.setPosition(30, 140);
        death.setPosition(450, Gdx.graphics.getHeight() / 2);
    }

    public static void activateDialogue() {
        dialogueActor.setVisible(true);
        font.setVisible(true);
    }

    public static void deactivateDialogue() {
        dialogueActor.setVisible(false);
        font.setVisible(false);
    }

    public static void deactivateBlackout() {
        blackActor.setVisible(false);
        death.setVisible(false);
    }

    public static void blackout() {
        if (progress == 1) {
            death.setText("Barney has been killed");
            if (!p1) {
                death.setVisible(true);
                blackActor.setVisible(true);
            }
        }

    }


    public static void setText(String text) {
        font.setText(text);
    }

    public static void progression() {
    }

    public static void reset() {
    }


}
