package com.mygdx.game.entities;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.mygdx.game.management.BolbManager;
import com.mygdx.game.utilities.scene2d.CustomAnimation;

import java.util.Random;

public class Barney implements Entity {

    public static final Barney barney = new Barney();

    private CustomAnimation body, hair, eyes, lighting, hairshine, legs;
    private int X, Y;
    BolbManager bolbManager;
    private boolean interact;
    private int level, stage;

    private Barney() {

        bolbManager = new BolbManager();
        bolbManager.loadCharacter();

        X = 1340;
        Y = 50;


        body = new CustomAnimation(new TextureRegion(bolbManager.get(bolbManager.Body)), 3, 0.4f, 455, 382, Barney.this.X, Barney.this.Y);
        eyes = new CustomAnimation(new TextureRegion(bolbManager.get(bolbManager.Eyes)), 3, 0.4f, 455, 382, Barney.this.X, Barney.this.Y);
        lighting = new CustomAnimation(new TextureRegion(bolbManager.get(bolbManager.Lighting)), 3, 0.4f, 455, 382, Barney.this.X, Barney.this.Y);
        hair = new CustomAnimation(new TextureRegion(bolbManager.get(bolbManager.Bald)), 3, 0.4f, 455, 382, Barney.this.X, Barney.this.Y);
        hairshine = new CustomAnimation(new TextureRegion(bolbManager.get(bolbManager.BaldShine)), 3, 0.4f, 455, 382, Barney.this.X, Barney.this.Y);
        legs = new CustomAnimation(new TextureRegion(bolbManager.get(bolbManager.Legs)), 3, 0.4f, 455, 382, Barney.this.X, Barney.this.Y);

        body.setHSV(360, 0.53f, 0.96f);
        lighting.setHSV(345, 0.3f, 1f);
        eyes.setHSV(0, 0f, 0f);
        hair.setHSV(360, 0.53f, 0.96f);
        legs.setHSV(360, 0.3f, 1f);
        hairshine.setHSV(0, 0f, 1f);


    }

    public static Barney getBarney() {
        return barney;
    }

    public void update(float dt) {

        body.setPosition(Barney.this.X, Barney.this.Y);
        eyes.setPosition(Barney.this.X, Barney.this.Y);
        hair.setPosition(Barney.this.X, Barney.this.Y);
        lighting.setPosition(Barney.this.X, Barney.this.Y);
        hairshine.setPosition(Barney.this.X, Barney.this.Y);
        legs.setPosition(Barney.this.X, Barney.this.Y);
        if(Barney.getBarney().getPosition().x - Player.getPlayer().getPosition().x < 196 && Barney.getBarney().getPosition().x - Player.getPlayer().getPosition().x > - 196 &&
                Barney.getBarney().getPosition().y - Player.getPlayer().getPosition().y < 196 && Barney.getBarney().getPosition().y - Player.getPlayer().getPosition().y > - 196){
            handleDialogue();
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
                    Dialogue.setText("Barney: Buuuurrrppp");
                    break;
                case 3:
                case 4:
                    Dialogue.activateDialogue();
                    Dialogue.setText("You: Is that somehow pure ethyl alcohol?");
                    break;
                case 5:
                case 6:
                    Dialogue.activateDialogue();
                    Dialogue.setText("Barney: Perhaps!");
                    break;
                case 7:
                case 8:
                    Dialogue.activateDialogue();
                    Dialogue.setText("You: Epic");
                    break;
                case 9:
                case 10:
                    Dialogue.deactivateDialogue();
                    break;
                case 11:
                case 12:
                    level = 0;
                    stage ++;

            }
        }
        if(stage == 1){
            switch (level) {
                case 1:
                case 2:
                    Dialogue.activateDialogue();
                    Dialogue.setText("Barney: That turd hank!");
                    break;
                case 3:
                case 4:
                    Dialogue.activateDialogue();
                    Dialogue.setText("You: Okay...");
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
        Barney.getBarney().body.getAnimation().getFrame().flip(true, false);
        Barney.getBarney().lighting.getAnimation().getFrame().flip(true, false);
        Barney.getBarney().hair.getAnimation().getFrame().flip(true, false);
        Barney.getBarney().eyes.getAnimation().getFrame().flip(true, false);
        Barney.getBarney().hairshine.getAnimation().getFrame().flip(true, false);
        Barney.getBarney().legs.getAnimation().getFrame().flip(true, false);
    }

    private boolean Left() {
        return !Barney.getBarney().body.getAnimation().getFrame().isFlipX();

    }

    private boolean Right() {
        return Barney.getBarney().body.getAnimation().getFrame().isFlipX();

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
