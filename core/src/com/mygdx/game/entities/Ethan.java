package com.mygdx.game.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.mygdx.game.management.BolbManager;
import com.mygdx.game.utilities.scene2d.CustomAnimation;
import com.mygdx.game.utilities.scene2d.FontActor;

import java.util.Random;

public class Ethan implements Entity {

    public static final Ethan ethan = new Ethan();

    private CustomAnimation body, hair, eyes, lighting, hairshine, legs;
    private int X, Y;
    BolbManager bolbManager;
    public static int level = 0;
    private FontActor name;
    public static int stage = 0;

    public static boolean t1,t2,t3, t4, t5, t6 = false;


    private Ethan() {


        bolbManager = new BolbManager();
        bolbManager.loadCharacter();

        X = 1840;
        Y = 580;

        name = new FontActor("Ethan", "Font/font.ttf", 16, false);
        name.setVisible(false);
        name.setPosition(2040, 930);
        body = new CustomAnimation(new TextureRegion(bolbManager.get(bolbManager.Body)), 3, 0.4f, 455, 382, Ethan.this.X, Ethan.this.Y);
        eyes = new CustomAnimation(new TextureRegion(bolbManager.get(bolbManager.Eyes)), 3, 0.4f, 455, 382, Ethan.this.X, Ethan.this.Y);
        lighting = new CustomAnimation(new TextureRegion(bolbManager.get(bolbManager.Lighting)), 3, 0.4f, 455, 382, Ethan.this.X, Ethan.this.Y);
        hair = new CustomAnimation(new TextureRegion(bolbManager.get(bolbManager.DefaultHair)), 3, 0.4f, 455, 382, Ethan.this.X, Ethan.this.Y);
        hairshine = new CustomAnimation(new TextureRegion(bolbManager.get(bolbManager.DefaultHairShine)), 3, 0.4f, 455, 382, Ethan.this.X, Ethan.this.Y);
        legs = new CustomAnimation(new TextureRegion(bolbManager.get(bolbManager.Legs)), 3, 0.4f, 455, 382, Ethan.this.X, Ethan.this.Y);

        body.setHSV(360, 0.14f, 1f);
        lighting.setHSV(345, 0.3f, 1f);
        eyes.setHSV(0, 0f, 0f);
        hair.setHSV(39, 0.5f, 1f);
        legs.setHSV(360, 0.3f, 1f);
        hairshine.setHSV(0, 0f, 1f);


    }

    public static Ethan getEthan() {
        return ethan;
    }

    public void update(float dt) {


        body.setPosition(Ethan.this.X, Ethan.this.Y);
        eyes.setPosition(Ethan.this.X, Ethan.this.Y);
        hair.setPosition(Ethan.this.X, Ethan.this.Y);
        lighting.setPosition(Ethan.this.X, Ethan.this.Y);
        hairshine.setPosition(Ethan.this.X, Ethan.this.Y);
        legs.setPosition(Ethan.this.X, Ethan.this.Y);

//            Dialogue.initDialogue(Dialogue.Ethan_Dialogue_1);

        if((Ethan.getEthan().getPosition().x - Player.getPlayer().getPosition().x < 196 && Ethan.getEthan().getPosition().x - Player.getPlayer().getPosition().x > - 196 &&
                Ethan.getEthan().getPosition().y - Player.getPlayer().getPosition().y < 196 && Ethan.getEthan().getPosition().y - Player.getPlayer().getPosition().y > - 196) && !Dialogue.p4){
            name.setVisible(true);

            handleDialogue();

            if(Ethan.getEthan().Left() && Ethan.getEthan().getPostionX() - Player.getPlayer().getPostionX() > 0){
                Ethan.getEthan().flip();}
            if(Ethan.getEthan().Right() && Ethan.getEthan().getPostionX() - Player.getPlayer().getPostionX() < 0){
                Ethan.getEthan().flip();}
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
                    Dialogue.setText("Ethan: Hi there. Do you not also find that this train is completely ordinary and safe?");
                    break;
                case 3:
                case 4:
                    Dialogue.activateDialogue();
                    Dialogue.setText("Ethan: Yes, Nothing could go wrong on this train, that is for sure!");
                    break;
                case 5:
                case 6:
                    Dialogue.activateDialogue();
                    Dialogue.setText("You: I have no idea what you are talking about");
                    break;
                case 7:
                case 8:
                    Dialogue.activateDialogue();
                    Dialogue.setText("Ethan: CHEESE SANDWICH!");
                    break;
                case 9:
                case 10:
                    Dialogue.activateDialogue();
                    Dialogue.setText("You: CHEESE SANDWICH!");
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
                    Dialogue.setText("Ethan: Cheez gang?");
                    break;
                case 3:
                case 4:
                    Dialogue.activateDialogue();
                    Dialogue.setText("You: CHEEZ GANGG!");
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
                    if(Titus.t2){
                        Dialogue.setText("Ethan: Sure Titus may think it is Bruce or Esther who killed him.");} else{
                        Dialogue.setText("Ethan: I know who killed Barney.");
                    }

                    Dialogue.activateDialogue();
                    break;
                case 3:
                case 4:
                    Dialogue.activateDialogue();
                    Dialogue.setText("Ethan: I am a detective. I say its Hank.");
                    break;
                case 5:
                case 6:
                    Dialogue.setText("Ethan: You can never trust a businessman, they are here for business!");
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
                    Dialogue.setText("Ethan: Hank did this! I'm sure of it now!");
                    Dialogue.activateDialogue();
                    break;
                case 3:
                case 4:
                    Dialogue.activateDialogue();
                    Dialogue.setText("Ethan: I'm gonna take him out.");
                    break;
                case 5:
                case 6:
                    Dialogue.setText("You: Ethan, don't do anything you'll regret!!!");
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
                    Dialogue.setText("Ethan: Good. He's dead.");
                    Dialogue.activateDialogue();
                    break;
                case 3:
                case 4:
                    Dialogue.activateDialogue();
                    Dialogue.setText("You: I told you not to act rashly");
                    break;
                case 5:
                case 6:
                    Dialogue.setText("Ethan: I do what i want! I don't report to you!");
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
        Ethan.getEthan().body.getAnimation().getFrame().flip(true, false);
        Ethan.getEthan().lighting.getAnimation().getFrame().flip(true, false);
        Ethan.getEthan().hair.getAnimation().getFrame().flip(true, false);
        Ethan.getEthan().eyes.getAnimation().getFrame().flip(true, false);
        Ethan.getEthan().hairshine.getAnimation().getFrame().flip(true, false);
        Ethan.getEthan().legs.getAnimation().getFrame().flip(true, false);
    }

    private boolean Left() {
        return !Ethan.getEthan().body.getAnimation().getFrame().isFlipX();

    }

    private boolean Right() {
        return Ethan.getEthan().body.getAnimation().getFrame().isFlipX();

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
        public Vector2 getPosition () {
            return new Vector2(getPostionX(), getPostionY());
        }


    }


