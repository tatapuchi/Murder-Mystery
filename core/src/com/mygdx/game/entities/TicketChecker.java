package com.mygdx.game.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.ParticleEffect;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.mygdx.game.management.BolbManager;
import com.mygdx.game.utilities.scene2d.CustomActor;
import com.mygdx.game.utilities.scene2d.CustomAnimation;
import com.mygdx.game.utilities.scene2d.FontActor;

import java.util.Random;

public class TicketChecker implements Entity{

    public static final TicketChecker ticketChecker = new TicketChecker();

    private CustomAnimation body, hair, eyes, lighting, hairshine, legs;
    private int X, Y;
    BolbManager bolbManager;
    public static int level, stage;
    private FontActor name;

    private TicketChecker() {

        bolbManager = new BolbManager();
        bolbManager.loadCharacter();

        X = 780;
        Y = 580;
        name = new FontActor("Ticket Checker", "Font/font.ttf", 16, false);
        name.setVisible(false);
        name.setPosition(930, 920);
        body = new CustomAnimation(new TextureRegion(bolbManager.get(bolbManager.Body)), 3, 0.4f, 455, 382, TicketChecker.this.X, TicketChecker.this.Y);
        eyes = new CustomAnimation(new TextureRegion(bolbManager.get(bolbManager.Eyes)), 3, 0.4f, 455, 382, TicketChecker.this.X, TicketChecker.this.Y);
        lighting = new CustomAnimation(new TextureRegion(bolbManager.get(bolbManager.Lighting)), 3, 0.4f, 455, 382, TicketChecker.this.X,TicketChecker.this.Y);
        hair = new CustomAnimation(new TextureRegion(bolbManager.get(bolbManager.Bald)), 3, 0.4f, 455, 382, TicketChecker.this.X, TicketChecker.this.Y);
        hairshine = new CustomAnimation(new TextureRegion(bolbManager.get(bolbManager.BaldShine)), 3, 0.4f, 455, 382, TicketChecker.this.X, TicketChecker.this.Y);
        legs = new CustomAnimation(new TextureRegion(bolbManager.get(bolbManager.Legs)), 3, 0.4f, 455, 382, TicketChecker.this.X, TicketChecker.this.Y);

        body.setHSV(360,0.14f, 1f);
        lighting.setHSV(345,0.3f, 1f);
        eyes.setHSV(0,0f, 0f);
        hair.setHSV(360,0.14f, 1f);
        legs.setHSV(360,0.3f, 1f);
        hairshine.setHSV(0,0f,1f);
    }

    public static TicketChecker getTicketChecker() {
        return ticketChecker;
    }

    public void update(float dt) {

        body.setPosition(TicketChecker.this.X, TicketChecker.this.Y);
        eyes.setPosition(TicketChecker.this.X, TicketChecker.this.Y);
        hair.setPosition(TicketChecker.this.X, TicketChecker.this.Y);
        lighting.setPosition(TicketChecker.this.X, TicketChecker.this.Y);
        hairshine.setPosition(TicketChecker.this.X, TicketChecker.this.Y);
        legs.setPosition(TicketChecker.this.X, TicketChecker.this.Y);

        if((TicketChecker.getTicketChecker().getPosition().x - Player.getPlayer().getPosition().x < 196 && TicketChecker.getTicketChecker().getPosition().x - Player.getPlayer().getPosition().x > - 196 &&
                TicketChecker.getTicketChecker().getPosition().y - Player.getPlayer().getPosition().y < 196 && TicketChecker.getTicketChecker().getPosition().y - Player.getPlayer().getPosition().y > - 196)&& !Dialogue.p2){
            name.setVisible(true);

            handleDialogue();

            if(TicketChecker.getTicketChecker().Left() && TicketChecker.getTicketChecker().getPostionX() - Player.getPlayer().getPostionX() > 0){
                TicketChecker.getTicketChecker().flip();}
            if(TicketChecker.getTicketChecker().Right() && TicketChecker.getTicketChecker().getPostionX() - Player.getPlayer().getPostionX() < 0){
                TicketChecker.getTicketChecker().flip();}

        }else{
            name.setVisible(false);

        }



        if(Dialogue.p2){
            hair.setVisible(false);
            eyes.setVisible(false);
            body.setVisible(false);
            lighting.setVisible(false);
            hairshine.setVisible(false);
            legs.setVisible(false);
            name.setVisible(false);

        }

    }

    private void handleDialogue(){
        if(Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)){
            Dialogue.activateDialogue();
            level++;
        }
        if(stage == 0) {
            switch (level) {
                case 1:
                case 2:
                    Dialogue.activateDialogue();
                    Dialogue.setText("You: Hi there!");
                    break;
                case 3:
                case 4:
                    Dialogue.activateDialogue();
                    Dialogue.setText("Ticket Checker: Tickets please");
                    break;
                case 5:
                case 6:
                    Dialogue.activateDialogue();
                    Dialogue.setText("You: What?");
                    break;
                case 7:
                case 8:
                    Dialogue.activateDialogue();
                    Dialogue.setText("Ticket Checker (menacingly): TICKETS PLEASE!");
                    break;
                case 9:
                case 10:
                    Dialogue.deactivateDialogue();
                    break;
                case 11:
                case 12:
                    level = 0;
                    stage++;

            }
        }
        if(stage == 1){
            switch (level) {
                case 1:
                case 2:
                    Dialogue.activateDialogue();
                    Dialogue.setText("Ticket Checker: Do you have your ticket?");
                    break;
                case 3:
                case 4:
                    Dialogue.activateDialogue();
                    Dialogue.setText("You: No...");
                    break;
                case 5:
                case 6:
                    Dialogue.activateDialogue();
                    Dialogue.setText("Ticket Checker: Then get lost!");
                    break;
                case 7:
                case 8:
                    Dialogue.deactivateDialogue();
                    break;
                case 9:
                case 10:
                    level = 0;
                    break;
            }
        }
        if(stage == 2) {
            switch (level) {
                case 1:
                case 2:
                    Dialogue.setText("Ticket Checker: Oh dear, a murder on the train!");
                    Dialogue.activateDialogue();
                    break;
                case 3:
                case 4:
                    Dialogue.activateDialogue();
                    Dialogue.setText("Ticket Checker: Well at least I won't have to check their ticket");
                    break;
                case 5:
                case 6:
                    Dialogue.deactivateDialogue();
                    break;
                case 7:
                case 8:
                    level = 0;
                    break;

            }
        }
    }


    private void up() {
        Y += 6;
    }

    private void down() {
        Y -= 6;
    }

    private void right() {
        X += 6;
    }

    private void left() {
        X -= 6;
    }

    public void drawbody(Stage stage) {
        stage.addActor(legs);
        stage.addActor(body);
        stage.addActor(lighting);
        stage.addActor(eyes);
        stage.addActor(hair);
        stage.addActor(hairshine);
        stage.addActor(name);

    }

    private void flip() {
        TicketChecker.getTicketChecker().body.getAnimation().getFrame().flip(true, false);
        TicketChecker.getTicketChecker().hair.getAnimation().getFrame().flip(true, false);
        TicketChecker.getTicketChecker().eyes.getAnimation().getFrame().flip(true, false);
        TicketChecker.getTicketChecker().hairshine.getAnimation().getFrame().flip(true, false);
        TicketChecker.getTicketChecker().legs.getAnimation().getFrame().flip(true, false);
        TicketChecker.getTicketChecker().lighting.getAnimation().getFrame().flip(true, false);
    }

    private boolean Left() {
        return TicketChecker.getTicketChecker().body.getAnimation().getFrame().isFlipX();

    }

    private boolean Right() {
        return !TicketChecker.getTicketChecker().body.getAnimation().getFrame().isFlipX();

    }

    public int getPostionX() {
        return this.X + 200;
    }


    public int getPostionY() {
        return this.Y + 170;
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
