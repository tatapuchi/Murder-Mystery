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
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.mygdx.game.entities.April;
import com.mygdx.game.entities.Barney;
import com.mygdx.game.entities.Bruce;
import com.mygdx.game.entities.Dialogue;
import com.mygdx.game.entities.Entity;
import com.mygdx.game.entities.Esther;
import com.mygdx.game.entities.Ethan;
import com.mygdx.game.entities.Hank;
import com.mygdx.game.entities.Rachel;
import com.mygdx.game.entities.Player;
import com.mygdx.game.entities.Scarlet;
import com.mygdx.game.entities.TicketChecker;
import com.mygdx.game.entities.Titus;
import com.mygdx.game.management.GameStateManager;
import com.mygdx.game.management.State;
import com.mygdx.game.utilities.CameraUtilities;
import com.mygdx.game.utilities.General;
import com.mygdx.game.utilities.scene2d.CustomActor;
import com.mygdx.game.utilities.scene2d.ParticleActor;

import org.omg.PortableInterceptor.DISCARDING;

import java.util.Random;

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

        //NPCS and Player
        TicketChecker.getTicketChecker().drawbody(stage);
        Ethan.getEthan().drawbody(stage);
        Hank.getHank().drawbody(stage);
        April.getApril().drawbody(stage);
        Esther.getEsther().drawbody(stage);
        Rachel.getRachel().drawbody(stage);
        Scarlet.getScarlet().drawbody(stage);
        Bruce.getBruce().drawbody(stage);
        Barney.getBarney().drawbody(stage);
        Titus.getTitus().drawbody(stage);
        Player.getPlayer().drawbody(stage);


        Gdx.graphics.setCursor(Gdx.graphics.newCursor(pm, 0, 0));
        Gdx.input.setInputProcessor(inputMultiplexer);

    }

    @Override
    protected void handleInput() {
        if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE)) {
            Gdx.app.exit();
        }

        if(Barney.t1 && Hank.t1 && Esther.t1 && Ethan.t1 && Titus.t1 && Bruce.t1 && April.t1 && Scarlet.t1 && Rachel.t1 && !Dialogue.p1){
            Dialogue.progress = 1;
            Hank.stage = 2;
            Titus.stage = 2;
            April.stage = 2;
            Esther.stage = 2;
            Ethan.stage = 2;
            Scarlet.stage = 2;
            Bruce.stage = 2;
            Rachel.stage = 2;
            TicketChecker.stage = 2;
        }
        if(Hank.t2  && Esther.t2 && Ethan.t2 && Titus.t2 && Bruce.t2 && April.t2 && Scarlet.t2 && Rachel.t2 && !Dialogue.p2){
            Dialogue.progress = 2;
            Hank.stage = 3;
            Titus.stage = 3;
            April.stage = 3;
            Esther.stage = 3;
            Ethan.stage = 3;
            Scarlet.stage = 3;
            Bruce.stage = 3;
            Rachel.stage = 3;
            TicketChecker.stage = 3;

        }

        if( Ethan.t3 && !Dialogue.p3){
            Dialogue.progress = 3;
            Hank.stage = 4;
            Titus.stage = 4;
            April.stage = 4;
            Esther.stage = 4;
            Ethan.stage = 4;
            Scarlet.stage = 4;
            Bruce.stage = 4;
            Rachel.stage = 4;
            TicketChecker.stage = 4;

        }

        if( (Titus.t4 || Scarlet.t4 || Esther.t4 || Bruce.t4) && !Dialogue.p4){
            Dialogue.progress = 4;
            Hank.stage = 5;
            Titus.stage = 5;
            April.stage = 5;
            Esther.stage = 5;
            Ethan.stage = 5;
            Scarlet.stage = 5;
            Bruce.stage = 5;
            Rachel.stage = 5;
            TicketChecker.stage = 5;

        }
        if(  Scarlet.t5 && Esther.t5 && Bruce.t5 && !Dialogue.p5){
            Dialogue.progress = 5;
            Hank.stage = 6;
            Titus.stage = 6;
            April.stage = 6;
            Esther.stage = 6;
            Ethan.stage = 6;
            Scarlet.stage = 6;
            Bruce.stage = 6;
            Rachel.stage = 6;
            TicketChecker.stage = 6;

        }
        Dialogue.blackout();
        if (Gdx.input.isKeyPressed(Input.Keys.SPACE) && !Dialogue.p1) {
            Dialogue.p1 = true;
            Dialogue.deactivateDialogue();
            Dialogue.deactivateBlackout();
            Hank.level = 0;
            Titus.level = 0;
            April.level = 0;
            Esther.level = 0;
            Ethan.level = 0;
            Scarlet.level = 0;
            Bruce.level = 0;
            Rachel.level = 0;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.SPACE) && !Dialogue.p2 && Dialogue.progress == 2) {
            Dialogue.p2 = true;
            Dialogue.deactivateDialogue();
            Dialogue.deactivateBlackout();
            Hank.level = 0;
            Titus.level = 0;
            April.level = 0;
            Esther.level = 0;
            Ethan.level = 0;
            Scarlet.level = 0;
            Bruce.level = 0;
            Rachel.level = 0;
        }

        if (Gdx.input.isKeyPressed(Input.Keys.SPACE) && !Dialogue.p3 && Dialogue.progress == 3) {
            Dialogue.p3 = true;
            Dialogue.deactivateDialogue();
            Dialogue.deactivateBlackout();
            Hank.level = 0;
            Titus.level = 0;
            April.level = 0;
            Esther.level = 0;
            Ethan.level = 0;
            Scarlet.level = 0;
            Bruce.level = 0;
            Rachel.level = 0;
        }

        if (Gdx.input.isKeyPressed(Input.Keys.SPACE) && !Dialogue.p4 && Dialogue.progress == 4) {
            Dialogue.p4 = true;
            Dialogue.deactivateDialogue();
            Dialogue.deactivateBlackout();
            Hank.level = 0;
            Titus.level = 0;
            April.level = 0;
            Esther.level = 0;
            Ethan.level = 0;
            Scarlet.level = 0;
            Bruce.level = 0;
            Rachel.level = 0;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.SPACE) && Dialogue.progress == 5) {

        Dialogue.progress = 6;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.SPACE) && Dialogue.progress == 6) {

            Dialogue.progress = 7;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.SPACE) && Dialogue.progress == 7) {

            gsm.push(new Menu(gsm));
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
        April.getApril().update(dt);
        Esther.getEsther().update(dt);
        Rachel.getRachel().update(dt);
        Scarlet.getScarlet().update(dt);
        Bruce.getBruce().update(dt);
        Barney.getBarney().update(dt);
        Titus.getTitus().update(dt);
    }

    @Override
    public void render(SpriteBatch sb) {

        update(Gdx.graphics.getDeltaTime());
        Gdx.gl.glClearColor(rainbow().x, rainbow().y, rainbow().z, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);


//        if(!Gdx.input.isButtonPressed(Input.Buttons.RIGHT)){
        CameraUtilities.TrainCamera(cam, new Vector2(Player.getPlayer().getPostionX(), 1000 + (Player.getPlayer().getPostionY())/4));
//    }
//        else{
//            CameraUtilities.shake(cam, new Vector2(10,10), 1f);
//        }
        cam.update();

        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();
        HUD.act(Gdx.graphics.getDeltaTime());
        HUD.draw();
    }

    @Override
    public void dispose() {

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
