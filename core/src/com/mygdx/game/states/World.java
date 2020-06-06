package com.mygdx.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.ParticleEffect;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.mygdx.game.entities.Dialogue;
import com.mygdx.game.entities.Entity;
import com.mygdx.game.entities.Ethan;
import com.mygdx.game.entities.Hank;
import com.mygdx.game.entities.Player;
import com.mygdx.game.entities.TicketChecker;
import com.mygdx.game.management.GameStateManager;
import com.mygdx.game.management.State;
import com.mygdx.game.utilities.CameraUtilities;
import com.mygdx.game.utilities.General;
import com.mygdx.game.utilities.scene2d.CustomActor;
import com.mygdx.game.utilities.scene2d.ParticleActor;

import javax.xml.soap.Text;

import sun.security.krb5.internal.crypto.Des;

public class World extends State {

    private Stage stage;
    private Stage HUD;
    private ExtendViewport viewport;
    private OrthographicCamera cam;
    private InputMultiplexer inputMultiplexer;
    private CustomActor background;
    private ParticleActor wind;
    private ParticleEffect windEffect;
    private CustomActor Desk;


    public World(final GameStateManager gsm) {
        super(gsm);
        Pixmap pm = new Pixmap(Gdx.files.internal("HUD/Cursor.png"));
        windEffect = new ParticleEffect();
        windEffect.load(Gdx.files.internal("Environment/Sparticle"), Gdx.files.internal("Environment"));
        wind = new ParticleActor(windEffect, 8192, 900);
        wind.getEffect().findEmitter("Sparticle").scaleSize(0.25f);
        wind.getEffect().findEmitter("Sparticle").getTint().setColors(new float[]{1f, 0.9f,0.9f, 1f});
        wind.getEffect().findEmitter("Sparticle").getAngle().setHigh(180, 180);
        wind.getEffect().findEmitter("Sparticle").setMaxParticleCount(150000);
        wind.getEffect().findEmitter("Sparticle").getLife().setHigh(15000,15000);
        wind.getEffect().findEmitter("Sparticle").getVelocity().setHigh(500,500);
        wind.getEffect().findEmitter("Sparticle").getYOffsetValue().setActive(true);
        wind.getEffect().findEmitter("Sparticle").getYOffsetValue().setLow(50,-50);

        Texture texture = new Texture("Environment/Train.png");
        Texture desk = new Texture("Environment/White-Desk.png");
//        Desk = new CustomActor(new TextureRegion(desk), 432,192, 1500,630 );
        background = new CustomActor(new TextureRegion(texture), 8192 , 1024, 0, 0);
        inputMultiplexer = new InputMultiplexer();
        cam = new OrthographicCamera();
        cam.setToOrtho(false, 1600, 960);
        viewport = new ExtendViewport(General.WIDTH, General.HEIGHT);
        stage = new Stage(viewport);
        HUD = new Stage();
        inputMultiplexer.addProcessor(stage);
        inputMultiplexer.addProcessor(HUD);
        Dialogue.addDialogue(HUD);
        stage.addActor(wind);
        stage.addActor(background);
//        stage.addActor(Desk);

        TicketChecker.getTicketChecker().drawbody(stage);
        Ethan.getEthan().drawbody(stage);
        Hank.getHank().drawbody(stage);
        Player.getPlayer().drawbody(stage);
        Gdx.graphics.setCursor(Gdx.graphics.newCursor(pm, 0, 0));
        Gdx.input.setInputProcessor(inputMultiplexer);

    }

    @Override
    protected void handleInput() {
        if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE)) {
            Gdx.app.exit();
        }



    }

    @Override
    public void update(float dt) {
        viewport.setCamera(cam);
        handleInput();
        Player.getPlayer().update(dt);
        TicketChecker.getTicketChecker().update(dt);
        Ethan.getEthan().update(dt);
        Hank.getHank().update(dt);
    }

    @Override
    public void render(SpriteBatch sb) {
        update(Gdx.graphics.getDeltaTime());
        Gdx.gl.glClearColor(0.7f, 0.8f, 0.3f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);


        CameraUtilities.TrainCamera(cam, new Vector2(Player.getPlayer().getPostionX(), 1000 + (Player.getPlayer().getPostionY())/4));
        cam.update();

        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();
        HUD.act(Gdx.graphics.getDeltaTime());
        HUD.draw();
    }

    @Override
    public void dispose() {

    }
}
