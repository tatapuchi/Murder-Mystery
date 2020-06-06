package com.mygdx.game.utilities.scene2d;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.ParticleEffect;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class ParticleActor extends Actor {
    private ParticleEffect effect;
    private int x, y;
    private boolean paused;

    public ParticleActor(ParticleEffect effect, int x, int y) {
        this.effect = effect;
        this.x = x;
        this.y = y;

    }

    public void draw(Batch batch, float parentAlpha) {

        effect.draw(batch, Gdx.graphics.getDeltaTime());

    }

    public void act(float delta) {

        super.act(delta);
        effect.setPosition(x, y);

        effect.start();

    }

    public void setColour(float[] RGB, String emitter){
        effect.findEmitter(emitter).getTint().setColors(RGB);
    }

    public void pause(String emitter) {
        effect.findEmitter(emitter).getTransparency().setHigh(0f, 0f);
    }

    public void resume(String emitter) {
        effect.findEmitter(emitter).getTransparency().setHigh(1f, 1f);
    }


    public ParticleEffect getEffect() {
        return effect;
    }

    public void setPosition(int valX, int valY) {
        this.x = valX;
        this.y = valY;
    }


}