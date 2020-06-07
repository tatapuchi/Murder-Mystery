package com.mygdx.game.entities;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.mygdx.game.management.BolbManager;
import com.mygdx.game.utilities.scene2d.CustomAnimation;
import com.mygdx.game.utilities.scene2d.FontActor;

import java.util.Random;

public class Esther implements Entity {

    public static final Esther esther = new Esther();

    private CustomAnimation body, hair, eyes, lighting, hairshine, legs;
    private int X, Y;
    BolbManager bolbManager;
    private boolean interact;
    public static int level, stage;
    public static boolean t1,t2,t3, t4, t5, t6 = false;
    private FontActor name;


    private Esther() {

        bolbManager = new BolbManager();
        bolbManager.loadCharacter();

        X = 5740;
        Y = 480;

        name = new FontActor("Esther", "Font/font.ttf", 16, false);
        name.setVisible(false);
        name.setPosition(5940, 830);
        body = new CustomAnimation(new TextureRegion(bolbManager.get(bolbManager.Body)), 3, 0.4f, 455, 382, Esther.this.X, Esther.this.Y);
        eyes = new CustomAnimation(new TextureRegion(bolbManager.get(bolbManager.Eyes)), 3, 0.4f, 455, 382, Esther.this.X, Esther.this.Y);
        lighting = new CustomAnimation(new TextureRegion(bolbManager.get(bolbManager.Lighting)), 3, 0.4f, 455, 382, Esther.this.X, Esther.this.Y);
        hair = new CustomAnimation(new TextureRegion(bolbManager.get(bolbManager.DefaultHair)), 3, 0.4f, 455, 382, Esther.this.X, Esther.this.Y);
        hairshine = new CustomAnimation(new TextureRegion(bolbManager.get(bolbManager.DefaultHairShine)), 3, 0.4f, 455, 382, Esther.this.X, Esther.this.Y);
        legs = new CustomAnimation(new TextureRegion(bolbManager.get(bolbManager.Legs)), 3, 0.4f, 455, 382, Esther.this.X, Esther.this.Y);

        body.setHSV(360, 0.24f, 0.7f);
        lighting.setHSV(345, 0.3f, 1f);
        eyes.setHSV(0, 0f, 0f);
        hair.setHSV(200, 0.7f, 1f);
        legs.setHSV(360, 0.3f, 1f);
        hairshine.setHSV(0, 0f, 1f);


    }

    public static Esther getEsther() {
        return esther;
    }

    public void update(float dt) {

        body.setPosition(Esther.this.X, Esther.this.Y);
        eyes.setPosition(Esther.this.X, Esther.this.Y);
        hair.setPosition(Esther.this.X, Esther.this.Y);
        lighting.setPosition(Esther.this.X, Esther.this.Y);
        hairshine.setPosition(Esther.this.X, Esther.this.Y);
        legs.setPosition(Esther.this.X, Esther.this.Y);
        if(Esther.getEsther().getPosition().x - Player.getPlayer().getPosition().x < 196 && Esther.getEsther().getPosition().x - Player.getPlayer().getPosition().x > - 196 &&
                Esther.getEsther().getPosition().y - Player.getPlayer().getPosition().y < 196 && Esther.getEsther().getPosition().y - Player.getPlayer().getPosition().y > - 196){
            name.setVisible(true);
            handleDialogue();

            if(Esther.getEsther().Left() && Esther.getEsther().getPostionX() - Player.getPlayer().getPostionX() > 0){
                Esther.getEsther().flip();}
            if(Esther.getEsther().Right() && Esther.getEsther().getPostionX() - Player.getPlayer().getPostionX() < 0){
                Esther.getEsther().flip();}
        }else{
            name.setVisible(false);
        }


    }

    public void handleDialogue(){
        if(Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)){
            Dialogue.activateDialogue();
            level++;
        }
        if(stage == 0 ) {
            switch (level) {
                case 1:
                case 2:
                    Dialogue.activateDialogue();
                    Dialogue.setText("Esther: Hi, I don't usually go on trips like these, but my husband wanted me to come...");
                    break;
                case 3:
                case 4:
                    Dialogue.activateDialogue();
                    Dialogue.setText("You: Really? Where are you going?");
                    break;
                case 5:
                case 6:
                    Dialogue.activateDialogue();
                    Dialogue.setText("Esther: Yes!");
                    break;
                case 7:
                case 8:
                    Dialogue.activateDialogue();
                    Dialogue.setText("You: I'm sorry, what? I asked you where you were headed?");
                    break;
                case 9:
                case 10:
                    Dialogue.activateDialogue();
                    Dialogue.setText("Esther: I heard, its just that the developer did not have time to program a proper response.");
                    break;
                case 11:
                case 12:
                    Dialogue.deactivateDialogue();
                    t1 = true;
                    Dialogue.progression();
                    break;
                case 13:
                case 14:
                    Dialogue.reset();
                    level = 0;
                    stage = 1;

            }
        }
        if(stage == 1 ){
            switch (level) {
                case 1:
                case 2:
                    Dialogue.activateDialogue();
                    Dialogue.setText("Esther: Look at those pretty fields!");
                    break;
                case 3:
                case 4:
                    Dialogue.activateDialogue();
                    Dialogue.setText("You: Since when does the developer have time to draw fields?");
                    break;
                case 5:
                case 6:
                    Dialogue.deactivateDialogue();
                    break;
                case 7:
                case 8:
                    level = 0;
                    break;
            }
        }

        if(stage == 2) {
            switch (level) {
                case 1:
                case 2:
                        Dialogue.setText("Esther: *Heavy sobbing*");
                    Dialogue.activateDialogue();
                    break;
                case 3:
                case 4:
                    Dialogue.activateDialogue();
                    Dialogue.setText("Esther: When you find the person who killed my first husband.");
                    break;
                case 5:
                case 6:
                    Dialogue.setText("Esther (Demonic): MAKE THEM SUFFER!");
                    break;
                case 7:
                case 8:
                    t2 = true;
                    Dialogue.deactivateDialogue();
                    break;
                case 9:
                case 10:
                    level = 0;
                    break;

            }
        }
        if (stage == 3) {
            switch (level) {
                case 1:
                case 2:
                    Dialogue.setText("Esther: Two more dead? Who is doing this?");
                    Dialogue.activateDialogue();
                    break;
                case 3:
                case 4:
                    Dialogue.activateDialogue();
                    Dialogue.setText("Esther: Now i'm scared...");
                    break;
                case 5:
                case 6:
                    Dialogue.setText("You: I'll be finding the killer soon, don't worry.");
                    break;
                case 7:
                case 8:
                    t3 = true;
                    Dialogue.deactivateDialogue();
                    break;
                case 9:
                case 10:
                    level = 0;
                    break;

            }
        }
        if (stage == 4) {
            switch (level) {
                case 1:
                case 2:
                    Dialogue.setText("Esther: If he was the murder...");
                    Dialogue.activateDialogue();
                    break;
                case 3:
                case 4:
                    Dialogue.activateDialogue();
                    Dialogue.setText("Esther: Then i'm happy he is dead.");
                    break;
                case 5:
                case 6:
                    Dialogue.setText("You: ...");
                    break;
                case 7:
                case 8:
                    t4 = true;
                    Dialogue.deactivateDialogue();
                    break;
                case 9:
                case 10:
                    level = 0;
                    break;

            }
        }
        if (stage == 5) {
            switch (level) {
                case 1:
                case 2:
                    Dialogue.setText("Esther: OHHHH, I knew i shouldn't have come! I'm an introvert by nature!");
                    Dialogue.activateDialogue();
                    break;
                case 3:
                case 4:
                    Dialogue.activateDialogue();
                    Dialogue.setText("Esther: *Hyperventilating*");
                    break;
                case 5:
                case 6:
                    Dialogue.setText("You: ...");
                    break;
                case 7:
                case 8:
                    t5 = true;
                    Dialogue.deactivateDialogue();
                    break;
                case 9:
                case 10:
                    level = 0;
                    break;

            }
        }
    }

    private void up() {
        Y += 6;
    }

    private void down() {
        Y -= 6;
    }

    private void right() {
        X += 6;
    }

    private void left() {
        X -= 6;
    }

    public void drawbody(Stage stage) {
        stage.addActor(legs);
        stage.addActor(body);
        stage.addActor(lighting);
        stage.addActor(eyes);
        stage.addActor(hair);
        stage.addActor(hairshine);
        stage.addActor(name);
    }

    private void flip() {
        Esther.getEsther().body.getAnimation().getFrame().flip(true, false);
        Esther.getEsther().lighting.getAnimation().getFrame().flip(true, false);
        Esther.getEsther().hair.getAnimation().getFrame().flip(true, false);
        Esther.getEsther().eyes.getAnimation().getFrame().flip(true, false);
        Esther.getEsther().hairshine.getAnimation().getFrame().flip(true, false);
        Esther.getEsther().legs.getAnimation().getFrame().flip(true, false);
    }

    private boolean Left() {
        return !Esther.getEsther().body.getAnimation().getFrame().isFlipX();

    }

    private boolean Right() {
        return Esther.getEsther().body.getAnimation().getFrame().isFlipX();

    }

    public int getPostionX() {
        return this.X;
    }


    public int getPostionY() {
        return this.Y;
    }


    public static float generateRandomFloat() {

        Random random = new Random();

        return random.nextFloat();

    }

    @Override
    public Vector2 getPosition() {
        return new Vector2(getPostionX(), getPostionY());
    }


}
