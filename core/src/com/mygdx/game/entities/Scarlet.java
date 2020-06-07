package com.mygdx.game.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.mygdx.game.management.BolbManager;
import com.mygdx.game.utilities.scene2d.CustomAnimation;

import java.util.Random;

public class Scarlet implements Entity {

    public static final Scarlet scarlet = new Scarlet();

    private CustomAnimation body, hair, eyes, lighting, hairshine, legs;
    private int X, Y;
    BolbManager bolbManager;
    private boolean interact;
    private int level, stage;

    public static boolean t1,t2,t3, t4, t5, t6 = false;


    private Scarlet() {

        bolbManager = new BolbManager();
        bolbManager.loadCharacter();

        X = 4840;
        Y = 480;


        body = new CustomAnimation(new TextureRegion(bolbManager.get(bolbManager.Body)), 3, 0.4f, 455, 382, Scarlet.this.X, Scarlet.this.Y);
        eyes = new CustomAnimation(new TextureRegion(bolbManager.get(bolbManager.Eyes)), 3, 0.4f, 455, 382, Scarlet.this.X, Scarlet.this.Y);
        lighting = new CustomAnimation(new TextureRegion(bolbManager.get(bolbManager.Lighting)), 3, 0.4f, 455, 382, Scarlet.this.X, Scarlet.this.Y);
        hair = new CustomAnimation(new TextureRegion(bolbManager.get(bolbManager.JesterHair)), 3, 0.4f, 455, 382, Scarlet.this.X, Scarlet.this.Y);
        hairshine = new CustomAnimation(new TextureRegion(bolbManager.get(bolbManager.JesterHairShine)), 3, 0.4f, 455, 382, Scarlet.this.X, Scarlet.this.Y);
        legs = new CustomAnimation(new TextureRegion(bolbManager.get(bolbManager.Legs)), 3, 0.4f, 455, 382, Scarlet.this.X, Scarlet.this.Y);

        body.setHSV(360, 0.0f, 1f);
        lighting.setHSV(345, 0.0f, 1f);
        eyes.setHSV(0, 0f, 0f);
        hair.setHSV(0, 1f, 1f);
        legs.setHSV(360, 0.3f, 1f);
        hairshine.setHSV(0, 0f, 1f);


    }

    public static Scarlet getScarlet() {
        return scarlet;
    }

    public void update(float dt) {

        body.setPosition(Scarlet.this.X, Scarlet.this.Y);
        eyes.setPosition(Scarlet.this.X, Scarlet.this.Y);
        hair.setPosition(Scarlet.this.X, Scarlet.this.Y);
        lighting.setPosition(Scarlet.this.X, Scarlet.this.Y);
        hairshine.setPosition(Scarlet.this.X, Scarlet.this.Y);
        legs.setPosition(Scarlet.this.X, Scarlet.this.Y);

        if(Scarlet.getScarlet().getPosition().x - Player.getPlayer().getPosition().x < 196 && Scarlet.getScarlet().getPosition().x - Player.getPlayer().getPosition().x > - 196 &&
                Scarlet.getScarlet().getPosition().y - Player.getPlayer().getPosition().y < 196 && Scarlet.getScarlet().getPosition().y - Player.getPlayer().getPosition().y > - 196){
            handleDialogue();

            if(Scarlet.getScarlet().Left() && Scarlet.getScarlet().getPostionX() - Player.getPlayer().getPostionX() > 0){
                Scarlet.getScarlet().flip();}
            if(Scarlet.getScarlet().Right() && Scarlet.getScarlet().getPostionX() - Player.getPlayer().getPostionX() < 0){
                Scarlet.getScarlet().flip();}
        }



    }

    public void handleDialogue(){
        if(Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)){
            Dialogue.activateDialogue();
            level++;
        }
        if(stage == 0) {
            switch (level) {
                case 1:
                case 2:
                    Dialogue.activateDialogue();
                    Dialogue.setText("Scarlet: Hi, i'm Scarlet");
                    break;
                case 3:
                case 4:
                    Dialogue.activateDialogue();
                    Dialogue.setText("You: You broke up with Hank? Wait, why am i doing this?");
                    break;
                case 5:
                case 6:
                    Dialogue.activateDialogue();
                    Dialogue.setText("Scarlet: He is a dirty cheater.");
                    break;
                case 7:
                case 8:
                    Dialogue.activateDialogue();
                    Dialogue.setText("You: I honestly could not care less.");
                    break;
                case 9:
                case 10:
                    Dialogue.activateDialogue();
                    Dialogue.setText("You: And why in the blue heck are you all on the same train?");
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
                    stage ++;

            }
        }
        if(stage == 1){
            switch (level) {
                case 1:
                case 2:
                    Dialogue.activateDialogue();
                    Dialogue.setText("Scarlet: Oh me? I'm a fashion designer, Rachel back there is one of my models");
                    break;
                case 3:
                case 4:
                    Dialogue.activateDialogue();
                    Dialogue.setText("Scarlet: I could hook you up with something, if you just let me take some measurements");
                    break;
                case 5:
                case 6:
                    Dialogue.activateDialogue();
                    Dialogue.setText("You: Get away from me devil woman!");
                    break;
                case 7:
                case 8:
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

    }

    private void flip() {
        Scarlet.getScarlet().body.getAnimation().getFrame().flip(true, false);
        Scarlet.getScarlet().lighting.getAnimation().getFrame().flip(true, false);
        Scarlet.getScarlet().hair.getAnimation().getFrame().flip(true, false);
        Scarlet.getScarlet().eyes.getAnimation().getFrame().flip(true, false);
        Scarlet.getScarlet().hairshine.getAnimation().getFrame().flip(true, false);
        Scarlet.getScarlet().legs.getAnimation().getFrame().flip(true, false);
    }

    private boolean Left() {
        return !Scarlet.getScarlet().body.getAnimation().getFrame().isFlipX();

    }

    private boolean Right() {
        return Scarlet.getScarlet().body.getAnimation().getFrame().isFlipX();

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
