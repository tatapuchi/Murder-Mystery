package com.mygdx.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.management.GameStateManager;
import com.mygdx.game.management.State;
import com.mygdx.game.utilities.General;

public class Menu extends State{

    public Menu(final GameStateManager gsm) {
        super(gsm);

    }

    @Override
    protected void handleInput() {
        if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE)) {
            Gdx.app.exit();
        }
    }

    @Override
    public void update(float dt) {

    }

    @Override
    public void render(SpriteBatch sb) {
        General.ClearScreen();

    }

    @Override
    public void dispose() {

    }
}
