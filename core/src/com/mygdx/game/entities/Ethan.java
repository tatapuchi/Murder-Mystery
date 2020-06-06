package com.mygdx.game.entities;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.mygdx.game.management.BolbManager;
import com.mygdx.game.utilities.scene2d.CustomAnimation;

import java.util.Random;

public class Ethan implements Entity {

    public static final Ethan ethan = new Ethan();

    private CustomAnimation body, hair, eyes, lighting, hairshine, legs;
    private int X, Y;
    BolbManager bolbManager;
    private boolean interact;

    private Ethan() {

        bolbManager = new BolbManager();
        bolbManager.loadCharacter();

        X = 1840;
        Y = 160;


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
    public Vector2 getPosition() {
        return new Vector2(getPostionX(), getPostionY());
    }


}
