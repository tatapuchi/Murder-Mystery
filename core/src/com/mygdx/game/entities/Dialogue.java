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
    private static final FontActor font = new FontActor("","Font/font.ttf", 16, false);
    private static int i = 0;
    private static boolean finish = false;

    private Dialogue() {
    }

    public static void addDialogue(Stage stage){
        stage.addActor(dialogueActor);
        stage.addActor(font);

        dialogueActor.setVisible(false);
        font.setVisible(false);
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


    public static void initDialogue(final String[] strings) {
        if (!finish) {
            if (i < strings.length) {
                    Gdx.input.setInputProcessor(new InputAdapter() {
                        @Override
                        public boolean touchDown(int screenX, int screenY, int pointer, int button) {
                            Dialogue.activateDialogue();
                            Dialogue.setText(strings[i]);
                            i++;
                            return super.touchDown(screenX, screenY, pointer, button);

                        }
                    });

            } else if (i >= strings.length) {
                end();
                i = 0;
                Dialogue.deactivateDialogue();


            }

        }

    }
    public static void reset(){finish = false;}
    public static void end(){finish = true;}
    public static boolean isFinished(){return finish;}


    public static final String[] Ethan_Dialogue_1 = {
            "Ethan: Hi there, I'm Ethan. What a calm and unsuspicious train ride is it not?",
            "Ethan: Yes, nothing could go wrong on this peaceful train ride.",
            "You: Yes, I also like trains",
            "Ethan: Epic",
            ""
    };

}
