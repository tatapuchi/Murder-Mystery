package com.mygdx.game.entities;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.mygdx.game.management.BolbManager;
import com.mygdx.game.utilities.scene2d.CustomAnimation;

import java.util.Random;

public class Rachel implements Entity {

    public static final Rachel rachel = new Rachel();

    private CustomAnimation body, hair, eyes, lighting, hairshine, legs;
    private int X, Y;
    BolbManager bolbManager;
    private boolean interact;
    public static int level, stage;

    public static boolean t1, t2, t3, t4, t5, t6 = false;


    private Rachel() {

        bolbManager = new BolbManager();
        bolbManager.loadCharacter();

        X = 3740;
        Y = 80;


        body = new CustomAnimation(new TextureRegion(bolbManager.get(bolbManager.Body)), 3, 0.4f, 455, 382, Rachel.this.X, Rachel.this.Y);
        eyes = new CustomAnimation(new TextureRegion(bolbManager.get(bolbManager.Eyes)), 3, 0.4f, 455, 382, Rachel.this.X, Rachel.this.Y);
        lighting = new CustomAnimation(new TextureRegion(bolbManager.get(bolbManager.Lighting)), 3, 0.4f, 455, 382, Rachel.this.X, Rachel.this.Y);
        hair = new CustomAnimation(new TextureRegion(bolbManager.get(bolbManager.JesterHair)), 3, 0.4f, 455, 382, Rachel.this.X, Rachel.this.Y);
        hairshine = new CustomAnimation(new TextureRegion(bolbManager.get(bolbManager.JesterHairShine)), 3, 0.4f, 455, 382, Rachel.this.X, Rachel.this.Y);
        legs = new CustomAnimation(new TextureRegion(bolbManager.get(bolbManager.Legs)), 3, 0.4f, 455, 382, Rachel.this.X, Rachel.this.Y);

        body.setHSV(360, 0.64f, 0.6f);
        lighting.setHSV(345, 0.3f, 1f);
        eyes.setHSV(0, 0f, 0f);
        hair.setHSV(168, 1f, 1f);
        legs.setHSV(360, 0.3f, 1f);
        hairshine.setHSV(0, 0f, 1f);


    }

    public static Rachel getRachel() {
        return rachel;
    }

    public void update(float dt) {

        body.setPosition(Rachel.this.X, Rachel.this.Y);
        eyes.setPosition(Rachel.this.X, Rachel.this.Y);
        hair.setPosition(Rachel.this.X, Rachel.this.Y);
        lighting.setPosition(Rachel.this.X, Rachel.this.Y);
        hairshine.setPosition(Rachel.this.X, Rachel.this.Y);
        legs.setPosition(Rachel.this.X, Rachel.this.Y);
        if ((Rachel.getRachel().getPosition().x - Player.getPlayer().getPosition().x < 196 && Rachel.getRachel().getPosition().x - Player.getPlayer().getPosition().x > -196 &&
                Rachel.getRachel().getPosition().y - Player.getPlayer().getPosition().y < 196 && Rachel.getRachel().getPosition().y - Player.getPlayer().getPosition().y > -196) && !Dialogue.p2) {
            handleDialogue();

            if (Rachel.getRachel().Left() && Rachel.getRachel().getPostionX() - Player.getPlayer().getPostionX() > 0) {
                Rachel.getRachel().flip();
            }
            if (Rachel.getRachel().Right() && Rachel.getRachel().getPostionX() - Player.getPlayer().getPostionX() < 0) {
                Rachel.getRachel().flip();
            }
        }
        if(Dialogue.p2){
            hair.setVisible(false);
            eyes.setVisible(false);
            body.setVisible(false);
            lighting.setVisible(false);
            hairshine.setVisible(false);
            legs.setVisible(false);
        }


    }

    public void handleDialogue() {
        if (Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)) {
            Dialogue.activateDialogue();
            level++;
        }
        if (stage == 0) {
            switch (level) {
                case 1:
                case 2:
                    Dialogue.activateDialogue();
                    Dialogue.setText("You: Do i know you from somewhere?");
                    break;
                case 3:
                case 4:
                    Dialogue.activateDialogue();
                    Dialogue.setText("Rachel: Probably my twin sister, she is an actor");
                    break;
                case 5:
                case 6:
                    Dialogue.activateDialogue();
                    Dialogue.setText("Rachel: But you may know me, i'm a model, Hank helped me get this far with my career");
                    break;
                case 7:
                case 8:
                    Dialogue.activateDialogue();
                    Dialogue.setText("You: How does everyone know Hank, and how are you all on the same train?!?");
                    break;
                case 9:
                case 10:
                    Dialogue.activateDialogue();
                    Dialogue.setText("Rachel: ...");
                    break;
                case 11:
                case 12:
                    Dialogue.activateDialogue();
                    Dialogue.setText("You: ...");
                    break;
                case 13:
                case 14:
                    Dialogue.deactivateDialogue();
                    t1 = true;
                    Dialogue.progression();
                    break;
                case 15:
                case 16:
                    Dialogue.reset();
                    level = 0;
                    stage = 1;
                    break;

            }
        }
        if (stage == 1) {
            switch (level) {
                case 1:
                case 2:
                    Dialogue.activateDialogue();
                    Dialogue.setText("Rachel: Can't believe that turd Scarlet broke up with Hank!");
                    break;
                case 3:
                case 4:
                    Dialogue.activateDialogue();
                    Dialogue.setText("You: Let me guess, she's also on the train?");
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

        if (stage == 2) {
            switch (level) {
                case 1:
                case 2:
                    Dialogue.setText("Rachel: Oh no, what if somethings happens to me or April!");
                    Dialogue.activateDialogue();
                    break;
                case 3:
                case 4:
                    Dialogue.activateDialogue();
                    Dialogue.setText("Rachel: I'm scared!");
                    break;
                case 5:
                case 6:
                    Dialogue.setText("You: Shut up, don't play the victim or we will think you are the killer.");
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
        Rachel.getRachel().body.getAnimation().getFrame().flip(true, false);
        Rachel.getRachel().lighting.getAnimation().getFrame().flip(true, false);
        Rachel.getRachel().hair.getAnimation().getFrame().flip(true, false);
        Rachel.getRachel().eyes.getAnimation().getFrame().flip(true, false);
        Rachel.getRachel().hairshine.getAnimation().getFrame().flip(true, false);
        Rachel.getRachel().legs.getAnimation().getFrame().flip(true, false);
    }

    private boolean Left() {
        return !Rachel.getRachel().body.getAnimation().getFrame().isFlipX();

    }

    private boolean Right() {
        return Rachel.getRachel().body.getAnimation().getFrame().isFlipX();

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
