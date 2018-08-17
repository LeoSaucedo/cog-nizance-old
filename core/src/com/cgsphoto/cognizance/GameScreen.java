package com.cgsphoto.cognizance;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener.ChangeEvent;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL20;

public abstract class GameScreen implements Screen {
	
	private MainGame game;
	private Stage pauseStage;
	private Skin pauseSkin;
	private Table pauseTable;
	private Screen lastScreen;
	private Music bgMusic;
	public gameState state;

	public enum gameState{
		PAUSE,
		RUN,
		RESUME,
		STOPPED
	}
	
	public GameScreen(final MainGame game) {
		state = gameState.RUN;

	}

	@Override
	public void show() {
		// TODO Auto-generated method stub

	}

	@Override
	public void render(float delta) {
		switch(state){
			case RUN:
				// Runs the code.
				break;
			case PAUSE:
				// Pauses the game.
				break;
			case RESUME:
				// Resumes the game after a pause.
				break;
			case STOPPED:
				// Stops the game.
				break;
		}
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub

	}

	@Override
	public void pause() {
		state = gameState.PAUSE;

	}

	@Override
	public void resume() {
		state = gameState.RESUME;

	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		state = gameState.STOPPED;

	}
	
}
