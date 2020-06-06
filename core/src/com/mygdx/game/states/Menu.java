package com.mygdx.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.mygdx.game.management.GameStateManager;
import com.mygdx.game.management.State;
import com.mygdx.game.utilities.General;
import com.mygdx.game.utilities.scene2d.FontActor;

public class Menu extends State{
    FontActor font;
    Stage stage;
    public Menu(final GameStateManager gsm) {
        super(gsm);
         stage = new Stage();
         FontActor font = new FontActor("Left Click to Continue","Font/font.ttf", 24, false);
         font.setPosition(Gdx.graphics.getWidth()/3,Gdx.graphics.getHeight()/3);
         stage.addActor(font);
    }

    @Override
    protected void handleInput() {
        if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE)) {
            Gdx.app.exit();
        }
    }

    @Override
    public void update(float dt) {
        if(Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)){
            gsm.push(new World(gsm));
        }

    }

    @Override
    public void render(SpriteBatch sb) {
        Gdx.gl.glClearColor(0.4f, 0.2f, 0.6f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();


    }

    @Override
    public void dispose() {
    stage.dispose();
    }
}
