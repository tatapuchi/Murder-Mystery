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

public class April implements Entity {

    public static final April april = new April();

    private CustomAnimation body, hair, eyes, lighting, hairshine, legs;
    private int X, Y;
    BolbManager bolbManager;
    private boolean interact;
    public static int level, stage;
    private FontActor name;

    public static boolean t1, t2, t3, t4, t5, t6 = false;

    private April() {

        bolbManager = new BolbManager();
        bolbManager.loadCharacter();

        X = 940;
        Y = 30;

        name = new FontActor("April", "Font/font.ttf", 16, false);
        name.setVisible(false);
        name.setPosition(1140, 390);

        body = new CustomAnimation(new TextureRegion(bolbManager.get(bolbManager.Body)), 3, 0.4f, 455, 382, April.this.X, April.this.Y);
        eyes = new CustomAnimation(new TextureRegion(bolbManager.get(bolbManager.Eyes)), 3, 0.4f, 455, 382, April.this.X, April.this.Y);
        lighting = new CustomAnimation(new TextureRegion(bolbManager.get(bolbManager.Lighting)), 3, 0.4f, 455, 382, April.this.X, April.this.Y);
        hair = new CustomAnimation(new TextureRegion(bolbManager.get(bolbManager.JesterHair)), 3, 0.4f, 455, 382, April.this.X, April.this.Y);
        hairshine = new CustomAnimation(new TextureRegion(bolbManager.get(bolbManager.JesterHairShine)), 3, 0.4f, 455, 382, April.this.X, April.this.Y);
        legs = new CustomAnimation(new TextureRegion(bolbManager.get(bolbManager.Legs)), 3, 0.4f, 455, 382, April.this.X, April.this.Y);

        body.setHSV(360, 0.64f, 0.6f);
        lighting.setHSV(345, 0.3f, 1f);
        eyes.setHSV(0, 0f, 0f);
        hair.setHSV(139, 1f, 1f);
        legs.setHSV(360, 0.3f, 1f);
        hairshine.setHSV(0, 0f, 1f);


    }

    public static April getApril() {
        return april;
    }

    public void update(float dt) {

        body.setPosition(April.this.X, April.this.Y);
        eyes.setPosition(April.this.X, April.this.Y);
        hair.setPosition(April.this.X, April.this.Y);
        lighting.setPosition(April.this.X, April.this.Y);
        hairshine.setPosition(April.this.X, April.this.Y);
        legs.setPosition(April.this.X, April.this.Y);
        if ((April.getApril().getPosition().x - Player.getPlayer().getPosition().x < 196 && April.getApril().getPosition().x - Player.getPlayer().getPosition().x > -196 &&
                April.getApril().getPosition().y - Player.getPlayer().getPosition().y < 196 && April.getApril().getPosition().y - Player.getPlayer().getPosition().y > -196) && !Dialogue.p2) {
            name.setVisible(true);
            handleDialogue();


            if (April.getApril().Left() && April.getApril().getPostionX() - Player.getPlayer().getPostionX() > 0) {
                April.getApril().flip();
            }
            if (April.getApril().Right() && April.getApril().getPostionX() - Player.getPlayer().getPostionX() < 0) {
                April.getApril().flip();
            }
        }else{
            name.setVisible(false);
        }
        if(Dialogue.p2){
            hair.setVisible(false);
            eyes.setVisible(false);
            body.setVisible(false);
            lighting.setVisible(false);
            hairshine.setVisible(false);
            legs.setVisible(false);
            name.setVisible(false);
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
                    Dialogue.setText("April: No don't worry i'm just a twin, the person over there who looks like me is my sister Rachel.");
                    break;
                case 3:
                case 4:
                    Dialogue.activateDialogue();
                    Dialogue.setText("You: Didn't you star in \"Generic Show 5\"?");
                    break;
                case 5:
                case 6:
                    Dialogue.activateDialogue();
                    Dialogue.setText("April: Yes. Although, not anymore.");
                    break;
                case 7:
                case 8:
                    Dialogue.activateDialogue();
                    Dialogue.setText("April: I can't seem to do anything after i found out that Hank was cheating on me...");
                    break;
                case 9:
                case 10:
                    Dialogue.activateDialogue();
                    Dialogue.setText("April: I just feel so betrayed!");
                    break;
                case 11:
                case 12:
                    Dialogue.activateDialogue();
                    Dialogue.setText("You: I don't know you, and we just met, why would you tell me that?");
                    t1 = true;
                    Dialogue.progression();
                    break;
                case 13:
                case 14:
                    Dialogue.deactivateDialogue();
                    break;
                case 15:
                case 16:
                    Dialogue.reset();
                    level = 0;
                    stage++;
                    break;

            }
        }
        if (stage == 1) {
            switch (level) {
                case 1:
                case 2:
                    Dialogue.activateDialogue();
                    Dialogue.setText("April: Oh Hank...");
                    break;
                case 3:
                case 4:
                    Dialogue.activateDialogue();
                    Dialogue.setText("April: *cries*");
                    break;
                case 5:
                case 6:
                    Dialogue.activateDialogue();
                    Dialogue.setText("You: Um, would you like a sandwich?");
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

        if (stage == 2) {
            switch (level) {
                case 1:
                case 2:
                    Dialogue.setText("April: Uh oh, If this was Hank's work then i might be in danger.");
                    Dialogue.activateDialogue();
                    break;
                case 3:
                case 4:
                    Dialogue.activateDialogue();
                    Dialogue.setText("April: When we were dating he told me a lot of his company's secrets.");
                    break;
                case 5:
                case 6:
                    Dialogue.setText("You: Don't worry, nothing is going to happen to you.");
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
        stage.addActor(name);

    }

    private void flip() {
        April.getApril().body.getAnimation().getFrame().flip(true, false);
        April.getApril().lighting.getAnimation().getFrame().flip(true, false);
        April.getApril().hair.getAnimation().getFrame().flip(true, false);
        April.getApril().eyes.getAnimation().getFrame().flip(true, false);
        April.getApril().hairshine.getAnimation().getFrame().flip(true, false);
        April.getApril().legs.getAnimation().getFrame().flip(true, false);
    }

    private boolean Left() {
        return !April.getApril().body.getAnimation().getFrame().isFlipX();

    }

    private boolean Right() {
        return April.getApril().body.getAnimation().getFrame().isFlipX();

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
