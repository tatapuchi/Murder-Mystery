package com.mygdx.game.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.ParticleEffect;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.mygdx.game.utilities.scene2d.CustomActor;
import com.mygdx.game.utilities.scene2d.CustomAnimation;
import com.mygdx.game.utilities.scene2d.ParticleActor;
import com.mygdx.game.management.BolbManager;

import java.util.Random;

public class Player implements Entity{

    public static final Player player = new Player();
    public static final Player icon = new Player();

    private CustomAnimation body, hair, eyes, lighting, hairshine, move, legs;
    private ParticleActor runActor;
    private int X, Y;
    BolbManager bolbManager;
    public static int interact = 0;

    private Player() {

        bolbManager = new BolbManager();
        bolbManager.loadCharacter();

        X = 1880;
        Y = 0;
        ParticleEffect runEffect = new ParticleEffect();
        runEffect.load(Gdx.files.internal("Environment/Sparticle"), Gdx.files.internal("Environment"));
        body = new CustomAnimation(new TextureRegion(bolbManager.get(bolbManager.Body)), 3, 0.4f, 455, 382, Player.this.X, Player.this.Y);
        eyes = new CustomAnimation(new TextureRegion(bolbManager.get(bolbManager.Eyes)), 3, 0.4f, 455, 382, Player.this.X, Player.this.Y);
        lighting = new CustomAnimation(new TextureRegion(bolbManager.get(bolbManager.Lighting)), 3, 0.4f, 455, 382, Player.this.X, Player.this.Y);
        hair = new CustomAnimation(new TextureRegion(bolbManager.get(bolbManager.JesterHair)), 3, 0.4f, 455, 382, Player.this.X, Player.this.Y);
        hairshine = new CustomAnimation(new TextureRegion(bolbManager.get(bolbManager.JesterHairShine)), 3, 0.4f, 455, 382, Player.this.X, Player.this.Y);
        move = new CustomAnimation(new TextureRegion(bolbManager.get(bolbManager.LegsAnimation)), 3, 0.4f, 455, 382, Player.this.X, Player.this.Y);
        legs = new CustomAnimation(new TextureRegion(bolbManager.get(bolbManager.Legs)), 3, 0.4f, 455, 382, Player.this.X, Player.this.Y);

        runActor = new ParticleActor(runEffect, Player.this.X + 186, Player.this.Y + 120);


        runActor.getEffect().findEmitter("Sparticle").scaleSize(0.25f);
        runActor.getEffect().findEmitter("Sparticle").getTint().setColors(new float[]{0.18f, 0.12f, 0.06f, 1f});

        body.setHSV(360,0.3f, 1f);
        lighting.setHSV(345,0.3f, 1f);
        eyes.setHSV(0,0f, 0f);
        hair.setHSV(0,0f, 0f);
        legs.setHSV(360,0.3f, 1f);
        move.setHSV(360,0.3f, 1f);
        hairshine.setHSV(0,0f,1f);

    }

    public static Player getPlayer() {
        return player;
    }


    public static Player getPlayerIcon() {
        return icon;
    }

    public void setIconPosition(int x, int y){
        Player.this.X = x;
        Player.this.Y = y;

    }


    public void update(float dt) {

        body.setPosition(Player.this.X, Player.this.Y);
        eyes.setPosition(Player.this.X, Player.this.Y);
        hair.setPosition(Player.this.X, Player.this.Y);
        lighting.setPosition(Player.this.X, Player.this.Y);
        hairshine.setPosition(Player.this.X, Player.this.Y);
        legs.setPosition(Player.this.X, Player.this.Y);
        move.setPosition(Player.this.X, Player.this.Y);


        if(Player.this.Y > 620){
            Player.this.Y = 620;
        }
        if(Player.this.Y < 0){
            Player.this.Y = 0;
        }

        if(Player.this.X < -170){
            Player.this.X = -170;
        }
        if(Player.this.X > 7900){
            Player.this.X = 7900;
        }
        if (Right() && Gdx.input.isKeyPressed(Input.Keys.D)) {
            Player.getPlayer().flip();
        }
        if (Left() && Gdx.input.isKeyPressed(Input.Keys.A)) {
            Player.getPlayer().flip();
        }

        setParticlePosition();


        if (Gdx.input.isKeyPressed(Input.Keys.W)) {
            Player.getPlayer().up();
        }

        if (Gdx.input.isKeyPressed(Input.Keys.S)) {
            Player.getPlayer().down();
        }

        if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            Player.getPlayer().left();
        }

        if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            Player.getPlayer().right();
        }

        if (!(Gdx.input.isKeyPressed(Input.Keys.W) || Gdx.input.isKeyPressed(Input.Keys.A) || Gdx.input.isKeyPressed(Input.Keys.S) || Gdx.input.isKeyPressed(Input.Keys.D))) {
            runActor.pause("Sparticle");
            move.pause(true);
            legs.pause(false);
        }

        if ((Gdx.input.isKeyPressed(Input.Keys.W) || Gdx.input.isKeyPressed(Input.Keys.A) || Gdx.input.isKeyPressed(Input.Keys.S) || Gdx.input.isKeyPressed(Input.Keys.D))) {
            runActor.resume("Sparticle");
            move.pause(false);
            legs.pause(true);
        }

    }

    private void up() {
        Y += 16;
    }

    private void down() {
        Y -= 16;
    }

    private void right() {
        X += 16;
    }

    private void left() {
        X -= 16;
    }

    public void drawbody(Stage stage) {
        stage.addActor(runActor);
        stage.addActor(legs);
        stage.addActor(move);
        stage.addActor(body);
        stage.addActor(lighting);
        stage.addActor(eyes);
        stage.addActor(hair);
        stage.addActor(hairshine);

    }

    public float getR(){return Player.getPlayer().body.getColor().r;}
    public float getG(){return Player.getPlayer().body.getColor().g;}
    public float getB(){return Player.getPlayer().body.getColor().b;}
    public float getA(){return Player.getPlayer().body.getColor().a;}

    private void setParticlePosition() {
        if (Left()) {
            runActor.setPosition(Player.this.X + 195, Player.this.Y + 120);
        } else if (Right()) {
            runActor.setPosition(Player.this.X + 255, Player.this.Y + 120);
        }
    }

    public void flip() {
        Player.getPlayer().body.getAnimation().getFrame().flip(true, false);
        Player.getPlayer().lighting.getAnimation().getFrame().flip(true, false);
        Player.getPlayer().hair.getAnimation().getFrame().flip(true, false);
        Player.getPlayer().eyes.getAnimation().getFrame().flip(true, false);
        Player.getPlayer().hairshine.getAnimation().getFrame().flip(true, false);
        Player.getPlayer().legs.getAnimation().getFrame().flip(true, false);
        Player.getPlayer().move.getAnimation().getFrame().flip(true, false);
    }

    private boolean Left() {
        return !Player.getPlayer().body.getAnimation().getFrame().isFlipX();

    }

    private boolean Right() {
        return Player.getPlayer().body.getAnimation().getFrame().isFlipX();

    }
//
//    public void setHSV(int hue, float saturation, float brightness) {
//
//        if (CurrentThing == 1) {
//            this.body.setHSV(hue, saturation, brightness);
//            this.legs.setHSV(hue, saturation,brightness);
//            this.move.setHSV(hue, saturation,brightness);
//            this.lighting.setHSV(hue - 15, saturation, brightness);
//        } else if (CurrentThing == 2) {
//            this.hair.setHSV(hue, saturation, brightness);
//        } else if (CurrentThing == 3) {
//            this.eyes.setHSV(hue, saturation, brightness);
//        }
//        this.hairshine.setHSV(0, 0, 1);
//
//    }

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
