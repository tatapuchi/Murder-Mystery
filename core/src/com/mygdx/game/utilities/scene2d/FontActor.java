package com.mygdx.game.utilities.scene2d;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class FontActor extends Actor {

    private BitmapFont font;
    private String text, classPath;
    private int size;
    private boolean flip;
    private FreeTypeFontGenerator.FreeTypeFontParameter fontParamter = new FreeTypeFontGenerator.FreeTypeFontParameter();
    private FreeTypeFontGenerator generator;
    private FileHandle fontPath;


    public FontActor(String text, String classPath, int size, boolean flip) {
        this.text = text;
        this.size = size;
        this.flip = flip;
        this.classPath = classPath;

        fontPath = new FileHandle(classPath);
        generator = new FreeTypeFontGenerator(fontPath);
        fontParamter.size = size;
        fontParamter.flip = flip;
        this.font = generator.generateFont(fontParamter);
    }




    @Override
    public void draw(Batch batch, float parentAlpha) {
        Color color = getColor();
        batch.setColor(color);
       font.draw(batch, text, getX(),getY());
    }

    public BitmapFont getFont() {
        return font;
    }

    public String getClassPath() {
        return classPath;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setClassPath(String classPath) {
        this.classPath = classPath;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setFlip(boolean flip) {
        this.flip = flip;
    }
}
