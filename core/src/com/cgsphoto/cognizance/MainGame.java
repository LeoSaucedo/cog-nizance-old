package com.cgsphoto.cognizance;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;

public class MainGame extends Game {
	
	// State variables
	public int state;
	public final int GAME_RUNNING = 0;
	public final int GAME_PAUSED = 1;
	public final int GAME_INMENU = 2;
	public final int GAME_LEVEL_END = 3;
	public final int GAME_OVER = 4;
	
	public SpriteBatch batch;
	public Screen currentScreen;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		this.setScreen(new MainMenuScreen(this));
	}
	
	public void pause() {
		if(this.getScreen() instanceof MainMenuScreen) {
		}else {
			currentScreen = this.getScreen();
			this.setGameState(GAME_PAUSED);
			this.getScreen().pause();
			this.setScreen(new PauseScreen(this, currentScreen));
		}
	}
	
	public void resume() {
		if(this.getScreen() instanceof MainMenuScreen) {
			
		}else {
			this.setGameState(GAME_RUNNING);
		}
	}
	
	/**
	 * Sets the state of the game.
	 * @param state the state of the game.
	 */
	public void setGameState(int newState) {
		state = newState;
	}
}
