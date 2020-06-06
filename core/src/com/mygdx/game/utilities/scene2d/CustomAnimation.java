package com.mygdx.game.utilities.scene2d;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.Logger;
import com.mygdx.game.entities.Player;
import com.mygdx.game.utilities.Animation;

//Animation for scene2d stages
public class CustomAnimation extends Actor {

    private static final Logger log = new Logger(CustomAnimation.class.getName(), Logger.DEBUG);


    private final Animation animation;
    private int hue;
    private float saturation, brightness;
    private TextureRegion region;


    public CustomAnimation(TextureRegion region, int frameCount, float cycleTime, int width, int height, int x, int y) {
        this.region = region;
        this.animation = new Animation(this.region, frameCount, cycleTime);
        CustomAnimation.this.setSize(width, height);
        CustomAnimation.this.setPosition(x, y);
    }

    public CustomAnimation(TextureRegion region) {
        this.animation = new Animation(region, 3, 0.4f);
        CustomAnimation.this.setSize(455, 382);
        CustomAnimation.this.setPosition(200, 200);
    }
    public void setHSV(int hue, float saturation, float brightness) {
        this.brightness = brightness;
        this.saturation = saturation;
        this.hue = hue;
    }
    public void setRegion(TextureRegion region){
        this.region = region;
    }
    public void pause(boolean b){if(b){
        CustomAnimation.this.setColor(0,0,0,0);}
    else if (!b){CustomAnimation.this.setColor(Player.getPlayer().getR(), Player.getPlayer().getG(), Player.getPlayer().getB(), Player.getPlayer().getA());}}

    public Animation getAnimation() {
        return animation;
    }
    @Override
    public void draw(Batch batch, float parentAlpha) {
            Color color = getColor();
            batch.setColor(color);
        animation.update(Gdx.graphics.getDeltaTime());
            color.fromHsv(hue, saturation, brightness);
            this.setColor(color);
            batch.draw(animation.getFrame(),
                    getX(), getY(),
                    getOriginX(), getOriginY(),
                    getWidth(), getHeight(),
                    getScaleX(), getScaleY(),
                    getRotation()
            );


    }
}
