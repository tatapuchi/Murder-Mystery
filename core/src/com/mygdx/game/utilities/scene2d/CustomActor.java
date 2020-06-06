package com.mygdx.game.utilities.scene2d;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.Logger;

public class CustomActor extends Actor {

    private static final Logger log = new Logger(CustomActor.class.getName(), Logger.DEBUG);

    private final TextureRegion region;
    public int x, y, width, height;
    public double floatX,floatY;
    public float OriginX, OriginY;
    public boolean CenteredOrigin;


    public CustomActor(TextureRegion region, int x, int y) {
        this.region = region;
        this.x = x;
        this.y = y;
        CustomActor.this.setPosition(x, y);
    }

    public CustomActor(TextureRegion region, int width, int height, int x, int y) {
        this.region = region;
        this.x = x;
        this.y = y;
        CustomActor.this.setSize(width, height);
        CustomActor.this.setPosition(x, y);
    }

    public CustomActor(TextureRegion region, int width, int height, int x, int y, boolean CenteredOrigin) {
        this.region = region;
        this.x = x;
        this.y = y;
        CustomActor.this.setSize(width, height);
        CustomActor.this.setPosition(x, y);
        if (CenteredOrigin = true) {
            CustomActor.this.setOrigin(CustomActor.this.getWidth() / 2, CustomActor.this.getHeight() / 2);
        }

//        x = preferences.getInteger("X");
//        y = preferences.getInteger("Y");
    }

    public CustomActor(TextureRegion region, int width, int height, int x, int y, float originX, float originY) {
        this.region = region;
        this.x = x;
        this.y = y;
        CustomActor.this.setSize(width, height);
        CustomActor.this.setPosition(x, y);
        CustomActor.this.setOrigin(originX, originY);

//        x = preferences.getInteger("X");
//        y = preferences.getInteger("Y");
    }

    public void pause(boolean b){if(b){
    CustomActor.this.setVisible(false);}
    else if (!b){CustomActor.this.setVisible(true);}}


    @Override
    public void draw(Batch batch, float parentAlpha) {

            Color color = getColor();
            batch.setColor(color);
            batch.draw(region,
                    getX(), getY(),
                    getOriginX(), getOriginY(),
                    getWidth(), getHeight(),
                    getScaleX(), getScaleY(),
                    getRotation()
            );
        }

}