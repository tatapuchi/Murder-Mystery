package com.mygdx.game.entities;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.mygdx.game.management.BolbManager;
import com.mygdx.game.utilities.scene2d.CustomAnimation;

import java.util.Random;

public class Esther implements Entity {

    public static final Esther esther = new Esther();

    private CustomAnimation body, hair, eyes, lighting, hairshine, legs;
    private int X, Y;
    BolbManager bolbManager;
    private boolean interact;
    private int level, stage;

    private Esther() {

        bolbManager = new BolbManager();
        bolbManager.loadCharacter();

        X = 1540;
        Y = 80;


        body = new CustomAnimation(new TextureRegion(bolbManager.get(bolbManager.Body)), 3, 0.4f, 455, 382, Esther.this.X, Esther.this.Y);
        eyes = new CustomAnimation(new TextureRegion(bolbManager.get(bolbManager.Eyes)), 3, 0.4f, 455, 382, Esther.this.X, Esther.this.Y);
        lighting = new CustomAnimation(new TextureRegion(bolbManager.get(bolbManager.Lighting)), 3, 0.4f, 455, 382, Esther.this.X, Esther.this.Y);
        hair = new CustomAnimation(new TextureRegion(bolbManager.get(bolbManager.DefaultHair)), 3, 0.4f, 455, 382, Esther.this.X, Esther.this.Y);
        hairshine = new CustomAnimation(new TextureRegion(bolbManager.get(bolbManager.DefaultHairShine)), 3, 0.4f, 455, 382, Esther.this.X, Esther.this.Y);
        legs = new CustomAnimation(new TextureRegion(bolbManager.get(bolbManager.Legs)), 3, 0.4f, 455, 382, Esther.this.X, Esther.this.Y);

        body.setHSV(360, 0.54f, 0.7f);
        lighting.setHSV(345, 0.3f, 1f);
        eyes.setHSV(0, 0f, 0f);
        hair.setHSV(139, 0.5f, 0f);
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
                    Dialogue.setText("Esther: Greetings fellow passenger!");
                    break;
                case 3:
                case 4:
                    Dialogue.activateDialogue();
                    Dialogue.setText("You: Whoah. Esther McEsther from egg salad incorporated?!?");
                    break;
                case 5:
                case 6:
                    Dialogue.activateDialogue();
                    Dialogue.setText("Esther: The very one!");
                    break;
                case 7:
                case 8:
                    Dialogue.activateDialogue();
                    Dialogue.setText("You: I'm a big fan");
                    break;
                case 9:
                case 10:
                    Dialogue.activateDialogue();
                    Dialogue.setText("Esther: Haha!");
                    break;
                case 11:
                case 12:
                    Dialogue.deactivateDialogue();
                    break;
                case 13:
                case 14:
                    level = 0;
                    stage ++;

            }
        }
        if(stage == 1){
            switch (level) {
                case 1:
                case 2:
                    Dialogue.activateDialogue();
                    Dialogue.setText("Esther: I know that look...");
                    break;
                case 3:
                case 4:
                    Dialogue.activateDialogue();
                    Dialogue.setText("Esther: Of course you can have a selfie!");
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
