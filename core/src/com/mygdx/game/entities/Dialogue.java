package com.mygdx.game.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.mygdx.game.utilities.scene2d.CustomActor;
import com.mygdx.game.utilities.scene2d.FontActor;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class Dialogue{

    private static Texture dialogueBox = new Texture("HUD/Dialogue-Box.png");
    private static TextureRegion dialogueRegion = new TextureRegion(dialogueBox);
    private static final CustomActor dialogueActor = new CustomActor(dialogueRegion, 2500,150, 0,0);
    private static final FontActor font = new FontActor("hi, welcome","Font/font.ttf", 12, false);


    private Dialogue() {
    }

    public static void addDialogue(Stage stage){
        stage.addActor(dialogueActor);
        stage.addActor(font);

//        dialogueActor.setVisible(false);
//        font.setVisible(false);
        font.setPosition(30,140);
    }

    public static void activateDialogue(){
        dialogueActor.setVisible(true);
        font.setVisible(true);
    }

    public static void deactivateDialogue(){
        dialogueActor.setVisible(false);
        font.setVisible(false);
    }

    public static void setText(String text){
        font.setText(text);
    }


}
