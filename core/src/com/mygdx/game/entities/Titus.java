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

public class Titus implements Entity {

    public static final Titus titus = new Titus();

    private CustomAnimation body, hair, eyes, lighting, hairshine, legs;
    private int X, Y;
    BolbManager bolbManager;
    public static int level, stage;

    public static boolean t1,t2,t3, t4, t5, t6 = false;
    private FontActor name;


    private Titus() {

        bolbManager = new BolbManager();
        bolbManager.loadCharacter();

        X = 4640;
        Y = 80;

        name = new FontActor("Titus", "Font/font.ttf", 16, false);
        name.setVisible(false);
        name.setPosition(4840, 430);
        body = new CustomAnimation(new TextureRegion(bolbManager.get(bolbManager.Body)), 3, 0.4f, 455, 382, Titus.this.X, Titus.this.Y);
        eyes = new CustomAnimation(new TextureRegion(bolbManager.get(bolbManager.Eyes)), 3, 0.4f, 455, 382, Titus.this.X, Titus.this.Y);
        lighting = new CustomAnimation(new TextureRegion(bolbManager.get(bolbManager.Lighting)), 3, 0.4f, 455, 382, Titus.this.X, Titus.this.Y);
        hair = new CustomAnimation(new TextureRegion(bolbManager.get(bolbManager.DefaultHair)), 3, 0.4f, 455, 382, Titus.this.X, Titus.this.Y);
        hairshine = new CustomAnimation(new TextureRegion(bolbManager.get(bolbManager.DefaultHairShine)), 3, 0.4f, 455, 382, Titus.this.X, Titus.this.Y);
        legs = new CustomAnimation(new TextureRegion(bolbManager.get(bolbManager.Legs)), 3, 0.4f, 455, 382, Titus.this.X, Titus.this.Y);

        body.setHSV(360, 0.24f, 1f);
        lighting.setHSV(345, 0.3f, 1f);
        eyes.setHSV(0, 0f, 0f);
        hair.setHSV(360, 0.64f, 0.7f);
        legs.setHSV(360, 0.3f, 1f);
        hairshine.setHSV(0, 0f, 1f);


    }

    public static Titus getTitus() {
        return titus;
    }

    public void update(float dt) {

        body.setPosition(Titus.this.X, Titus.this.Y);
        eyes.setPosition(Titus.this.X, Titus.this.Y);
        hair.setPosition(Titus.this.X, Titus.this.Y);
        lighting.setPosition(Titus.this.X, Titus.this.Y);
        hairshine.setPosition(Titus.this.X, Titus.this.Y);
        legs.setPosition(Titus.this.X, Titus.this.Y);


        if((Titus.getTitus().getPosition().x - Player.getPlayer().getPosition().x < 196 && Titus.getTitus().getPosition().x - Player.getPlayer().getPosition().x > - 196 &&
                Titus.getTitus().getPosition().y - Player.getPlayer().getPosition().y < 196 && Titus.getTitus().getPosition().y - Player.getPlayer().getPosition().y > - 196)&& !Dialogue.p4){
            name.setVisible(true);

            handleDialogue();

            if(Titus.getTitus().Left() && Titus.getTitus().getPostionX() - Player.getPlayer().getPostionX() > 0){
                Titus.getTitus().flip();}
            if(Titus.getTitus().Right() && Titus.getTitus().getPostionX() - Player.getPlayer().getPostionX() < 0){
                Titus.getTitus().flip();}
        }else{
            name.setVisible(false);

        }

        if(Dialogue.p4){
            hair.setVisible(false);
            eyes.setVisible(false);
            body.setVisible(false);
            lighting.setVisible(false);
            hairshine.setVisible(false);
            legs.setVisible(false);
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
                    Dialogue.setText("Titus: I am Ethan's assistant");
                    break;
                case 3:
                case 4:
                    Dialogue.activateDialogue();
                    Dialogue.setText("You: Why on earth does he need an assistant now?");
                    break;
                case 5:
                case 6:
                    Dialogue.activateDialogue();
                    Dialogue.setText("Titus: He is a detective, technically i am his partner on this case, but he is in a higher rank than me");
                    break;
                case 7:
                case 8:
                    Dialogue.activateDialogue();
                    Dialogue.setText("You: Why are you giving me potentially confidential information");
                    break;
                case 9:
                case 10:
                    Dialogue.activateDialogue();
                    Dialogue.setText("Titus: ...");
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
        if(stage == 1){
            switch (level) {
                case 1:
                case 2:
                    Dialogue.activateDialogue();
                    Dialogue.setText("Titus: ...");
                    break;
                case 3:
                case 4:
                    Dialogue.deactivateDialogue();
                    break;
                case 5:
                case 6:
                    level = 0;
                    break;
            }
        }
        if(stage == 2) {
            switch (level) {
                case 1:
                case 2:
                    if(Hank.t2){
                        Dialogue.setText("Titus: I think Hank might be onto something, Bruce seems fishy...");
                    }else{
                    Dialogue.setText("Titus: Barney is dead, I'm betting it has something to do with Esther and Bruce!");}
                    Dialogue.activateDialogue();
                    break;
                case 3:
                case 4:
                    Dialogue.activateDialogue();
                    Dialogue.setText("You: I'll ask around for clues...");
                    break;
                case 5:
                case 6:
                    t2 = true;
                    Dialogue.deactivateDialogue();
                    break;
                case 7:
                case 8:
                    level = 0;
                    break;

            }
        }
        if (stage == 3) {
            switch (level) {
                case 1:
                case 2:
                    Dialogue.setText("Titus: It has to be Bruce...");
                    Dialogue.activateDialogue();
                    break;
                case 3:
                case 4:
                    Dialogue.activateDialogue();
                    Dialogue.setText("You: We have no proof.");
                    break;
                case 5:
                case 6:
                    Dialogue.setText("Titus: We have an educated guess...");
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
                    Dialogue.setText("Titus: Ok, so if Hank is dead, and if it really isn't Bruce...");
                    Dialogue.activateDialogue();
                    break;
                case 3:
                case 4:
                    Dialogue.activateDialogue();
                    Dialogue.setText("Titus: We should be safe...");
                    break;
                case 5:
                case 6:
                    Dialogue.setText("You: We can't let our guard down!");
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
        Titus.getTitus().body.getAnimation().getFrame().flip(true, false);
        Titus.getTitus().lighting.getAnimation().getFrame().flip(true, false);
        Titus.getTitus().hair.getAnimation().getFrame().flip(true, false);
        Titus.getTitus().eyes.getAnimation().getFrame().flip(true, false);
        Titus.getTitus().hairshine.getAnimation().getFrame().flip(true, false);
        Titus.getTitus().legs.getAnimation().getFrame().flip(true, false);
    }

    private boolean Left() {
        return !Titus.getTitus().body.getAnimation().getFrame().isFlipX();

    }

    private boolean Right() {
        return Titus.getTitus().body.getAnimation().getFrame().isFlipX();

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
