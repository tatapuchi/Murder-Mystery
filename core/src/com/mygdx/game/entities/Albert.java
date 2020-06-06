package com.mygdx.game.entities;


import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.mygdx.game.management.BolbManager;
import com.mygdx.game.utilities.scene2d.CustomAnimation;

import java.util.Random;

public class Albert implements Entity {

    public static final Albert albert = new Albert();

    private CustomAnimation body, hair, eyes, lighting, hairshine, legs;
    private int X, Y;
    BolbManager bolbManager;
    private boolean interact;

    private Albert() {

        bolbManager = new BolbManager();
        bolbManager.loadCharacter();

        X = 1840;
        Y = 160;


        body = new CustomAnimation(new TextureRegion(bolbManager.get(bolbManager.Body)), 3, 0.4f, 455, 382, Albert.this.X, Albert.this.Y);
        eyes = new CustomAnimation(new TextureRegion(bolbManager.get(bolbManager.Eyes)), 3, 0.4f, 455, 382, Albert.this.X, Albert.this.Y);
        lighting = new CustomAnimation(new TextureRegion(bolbManager.get(bolbManager.Lighting)), 3, 0.4f, 455, 382, Albert.this.X, Albert.this.Y);
        hair = new CustomAnimation(new TextureRegion(bolbManager.get(bolbManager.DefaultHair)), 3, 0.4f, 455, 382, Albert.this.X, Albert.this.Y);
        hairshine = new CustomAnimation(new TextureRegion(bolbManager.get(bolbManager.DefaultHairShine)), 3, 0.4f, 455, 382, Albert.this.X, Albert.this.Y);
        legs = new CustomAnimation(new TextureRegion(bolbManager.get(bolbManager.Legs)), 3, 0.4f, 455, 382, Albert.this.X, Albert.this.Y);

        body.setHSV(360, 0.14f, 1f);
        lighting.setHSV(345, 0.3f, 1f);
        eyes.setHSV(0, 0f, 0f);
        hair.setHSV(39, 0.5f, 1f);
        legs.setHSV(360, 0.3f, 1f);
        hairshine.setHSV(0, 0f, 1f);


    }

    public static Albert getAlbert() {
        return albert;
    }

    public void update(float dt) {

        body.setPosition(Albert.this.X, Albert.this.Y);
        eyes.setPosition(Albert.this.X, Albert.this.Y);
        hair.setPosition(Albert.this.X, Albert.this.Y);
        lighting.setPosition(Albert.this.X, Albert.this.Y);
        hairshine.setPosition(Albert.this.X, Albert.this.Y);
        legs.setPosition(Albert.this.X, Albert.this.Y);

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
        Albert.getAlbert().body.getAnimation().getFrame().flip(true, false);
        Albert.getAlbert().lighting.getAnimation().getFrame().flip(true, false);
        Albert.getAlbert().hair.getAnimation().getFrame().flip(true, false);
        Albert.getAlbert().eyes.getAnimation().getFrame().flip(true, false);
        Albert.getAlbert().hairshine.getAnimation().getFrame().flip(true, false);
        Albert.getAlbert().legs.getAnimation().getFrame().flip(true, false);
    }

    private boolean Left() {
        return !Albert.getAlbert().body.getAnimation().getFrame().isFlipX();

    }

    private boolean Right() {
        return Albert.getAlbert().body.getAnimation().getFrame().isFlipX();

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
