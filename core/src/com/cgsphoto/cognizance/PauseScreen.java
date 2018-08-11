package com.cgsphoto.cognizance;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class PauseScreen extends GameScreen {
	
	private MainGame game;
	private Stage pauseStage;
	private Skin pauseSkin;
	private Table pauseTable;
	private Screen lastScreen;
	
	public PauseScreen(final MainGame game, Screen lastScreen) {
		super(game, lastScreen);
		this.game = game;
		this.lastScreen = lastScreen;
		pauseStage = new Stage(new ScreenViewport());
		Gdx.input.setInputProcessor(pauseStage);
		pauseSkin = new Skin(Gdx.files.internal("graphics/skins/cog-nizance-menu/skin/vhs-ui.json"));
	}

	@Override
	public void show() {
		
		// Pause menu options
		pauseTable = new Table();
		pauseTable.setFillParent(true);
		pauseTable.setDebug(false);
		pauseStage.addActor(pauseTable);
		
		TextButton resumeBtn = new TextButton("Resume", pauseSkin);
		TextButton optionsBtn = new TextButton("Options", pauseSkin);
		TextButton exitBtn = new TextButton("Save & Quit", pauseSkin);
		
		pauseTable.add(resumeBtn).fillX().uniformX();
		pauseTable.row().pad(10,0,10,0);
		pauseTable.add(optionsBtn).fillX().uniformX();
		pauseTable.row();
		pauseTable.add(exitBtn).fillX().uniformX();
		
		/*
		 * Button listeners
		 */
		
		// Resume Button
		resumeBtn.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				game.setScreen(lastScreen);
				lastScreen.resume();
			}
		});
		
		// Options Button
		optionsBtn.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				System.out.println("User clicked Options button.");
			}
		});
		
		// Exit Button
		exitBtn.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				Gdx.app.exit();
			}
		});
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		pauseStage.act(Gdx.graphics.getDeltaTime());
		pauseStage.draw();

	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub

	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

}
