package com.mygdx.game.management;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Stack;


public class GameStateManager {

	public BolbManager assetManager;
	private Stack<State> states;

	public GameStateManager() {
		this.assetManager = new BolbManager();
		states = new Stack<State>();
	}

	public void push(State state) {
		states.push(state);

	}

	public void pop() {
		states.pop();

	}

	public void set(State state) {
		states.pop();
		states.push(state);

	}

	public void update(float dt) {
		states.peek().update(dt);

	}

	public void render(SpriteBatch sb) {
		states.peek().render(sb);
	}

}
