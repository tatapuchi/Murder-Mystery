package com.mygdx.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.mygdx.game.management.GameStateManager;
import com.mygdx.game.management.State;
import com.mygdx.game.utilities.scene2d.CustomActor;
import com.mygdx.game.utilities.scene2d.FontActor;

import java.util.Random;

import javax.xml.soap.Text;

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.rotateBy;

public class Menu extends State {
    FontActor font, title, description;
    Stage stage;
    CustomActor button;

    public Menu(final GameStateManager gsm) {
        super(gsm);
        stage = new Stage();
        Texture texture = new Texture("Buttons/Play.png");
        button = new CustomActor(new TextureRegion(texture), 256, 128, 500, 250);
        font = new FontActor("Play", "Font/font.ttf", 36, false);
        title = new FontActor("Overly Pixelated Murder-Mystery", "Font/font.ttf", 24, false);
        description = new FontActor("By Eggz team", "Font/font.ttf", 16, false);
        font.setPosition(580, 340);
        title.setPosition(30, 700);
        description.setPosition(30, 660);
        stage.addActor(button);
        stage.addActor(font);
        stage.addActor(title);
        stage.addActor(description);
        Pixmap pm = new Pixmap(Gdx.files.internal("HUD/Cursor.png"));
        Gdx.graphics.setCursor(Gdx.graphics.newCursor(pm, 0, 0));
    }

    @Override
    protected void handleInput() {
        if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE)) {
            Gdx.app.exit();
        }
    }

    @Override
    public void update(float dt) {
        if (Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)) {
            gsm.push(new World(gsm));
        }


    }

    @Override
    public void render(SpriteBatch sb) {
        Gdx.gl.glClearColor(rainbow().x, rainbow().y, rainbow().z, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();


    }

    @Override
    public void dispose() {
        stage.dispose();
    }


    float r, g, b;

    public Vector3 rainbow() {
        if (r < 1f && g == 0.0f && b == 0.0f) {
            r += 0.001f;
        }
        if (r > 0.98f) {
            if(b>0.0f){
                b-=0.001f;
            }
            if (b < 0.02f && g < 1f) {
                g += 0.001f;
            }
        }
        if (g > 0.98f) {
            if (r > 0.0f) {
                r -= 0.001f;
            } else if (r < 0.02f) {
                if (b < 1f) {
                    b += 0.001f;
                }
            }
            if (b > 0.98f) {
                if (g > 0.0f) {
                    g -= 0.001f;
                }
                if (g < 0.02f) {
                    r += 0.001f;
                }
            }

        }
        return new Vector3(r,g,b);

    }

}
