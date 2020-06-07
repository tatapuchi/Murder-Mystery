package com.mygdx.game.entities;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.mygdx.game.management.BolbManager;
import com.mygdx.game.utilities.scene2d.CustomAnimation;

import java.util.Random;

public class Hank implements Entity {

    public static final Hank hank = new Hank();

    private CustomAnimation body, hair, eyes, lighting, hairshine, legs;
    private int X, Y;
    BolbManager bolbManager;
    private boolean interact;
    private int level, stage;

    public static boolean t1,t2,t3, t4, t5, t6 = false;


    private Hank() {

        bolbManager = new BolbManager();
        bolbManager.loadCharacter();

        X = 1640;
        Y = 80;


        body = new CustomAnimation(new TextureRegion(bolbManager.get(bolbManager.Body)), 3, 0.4f, 455, 382, Hank.this.X, Hank.this.Y);
        eyes = new CustomAnimation(new TextureRegion(bolbManager.get(bolbManager.Eyes)), 3, 0.4f, 455, 382, Hank.this.X, Hank.this.Y);
        lighting = new CustomAnimation(new TextureRegion(bolbManager.get(bolbManager.Lighting)), 3, 0.4f, 455, 382, Hank.this.X, Hank.this.Y);
        hair = new CustomAnimation(new TextureRegion(bolbManager.get(bolbManager.DefaultHair)), 3, 0.4f, 455, 382, Hank.this.X, Hank.this.Y);
        hairshine = new CustomAnimation(new TextureRegion(bolbManager.get(bolbManager.DefaultHairShine)), 3, 0.4f, 455, 382, Hank.this.X, Hank.this.Y);
        legs = new CustomAnimation(new TextureRegion(bolbManager.get(bolbManager.Legs)), 3, 0.4f, 455, 382, Hank.this.X, Hank.this.Y);

        body.setHSV(360, 0.54f, 0.7f);
        lighting.setHSV(345, 0.3f, 1f);
        eyes.setHSV(0, 0f, 0f);
        hair.setHSV(139, 0.5f, 0f);
        legs.setHSV(360, 0.3f, 1f);
        hairshine.setHSV(0, 0f, 1f);


    }

    public static Hank getHank() {
        return hank;
    }

    public void update(float dt) {

        body.setPosition(Hank.this.X, Hank.this.Y);
        eyes.setPosition(Hank.this.X, Hank.this.Y);
        hair.setPosition(Hank.this.X, Hank.this.Y);
        lighting.setPosition(Hank.this.X, Hank.this.Y);
        hairshine.setPosition(Hank.this.X, Hank.this.Y);
        legs.setPosition(Hank.this.X, Hank.this.Y);
        if(Hank.getHank().getPosition().x - Player.getPlayer().getPosition().x < 196 && Hank.getHank().getPosition().x - Player.getPlayer().getPosition().x > - 196 &&
                Hank.getHank().getPosition().y - Player.getPlayer().getPosition().y < 196 && Hank.getHank().getPosition().y - Player.getPlayer().getPosition().y > - 196){
            handleDialogue();

            if(Hank.getHank().Left() && Hank.getHank().getPostionX() - Player.getPlayer().getPostionX() > 0){
                Hank.getHank().flip();}
            if(Hank.getHank().Right() && Hank.getHank().getPostionX() - Player.getPlayer().getPostionX() < 0){
                Hank.getHank().flip();}
        }


    }

    public void handleDialogue(){
        if(Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)){
            Dialogue.activateDialogue();
            level++;
        }
        if(stage == 0 && !Dialogue.p1) {
            switch (level) {
                case 1:
                case 2:
                    Dialogue.activateDialogue();
                    Dialogue.setText("Hank: Greetings fellow passenger!");
                    break;
                case 3:
                case 4:
                    Dialogue.activateDialogue();
                    Dialogue.setText("You: Whoah. Hank McHank from egg salad incorporated?!?");
                    break;
                case 5:
                case 6:
                    Dialogue.activateDialogue();
                    Dialogue.setText("Hank: The very one!");
                    break;
                case 7:
                case 8:
                    Dialogue.activateDialogue();
                    Dialogue.setText("You: I'm a big fan");
                    break;
                case 9:
                case 10:
                    Dialogue.activateDialogue();
                    Dialogue.setText("Hank: Haha!");
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
                    Dialogue.setText("Hank: I know that look...");
                    break;
                case 3:
                case 4:
                    Dialogue.activateDialogue();
                    Dialogue.setText("Hank: Of course you can have a selfie!");
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
        if(stage == 2){
            switch (level) {
                case 1:
                case 2:
                    Dialogue.activateDialogue();
                    Dialogue.setText("Hank: Barney is dead, oh my, but how?");
                    break;
                case 3:
                case 4:
                    Dialogue.activateDialogue();
                    Dialogue.setText("Hank: It couldn't have been of all the drinking, someone must have killed him");
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
        Hank.getHank().body.getAnimation().getFrame().flip(true, false);
        Hank.getHank().lighting.getAnimation().getFrame().flip(true, false);
        Hank.getHank().hair.getAnimation().getFrame().flip(true, false);
        Hank.getHank().eyes.getAnimation().getFrame().flip(true, false);
        Hank.getHank().hairshine.getAnimation().getFrame().flip(true, false);
        Hank.getHank().legs.getAnimation().getFrame().flip(true, false);
    }

    private boolean Left() {
        return !Hank.getHank().body.getAnimation().getFrame().isFlipX();

    }

    private boolean Right() {
        return Hank.getHank().body.getAnimation().getFrame().isFlipX();

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
