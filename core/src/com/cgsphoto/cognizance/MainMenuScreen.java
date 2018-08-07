package com.cgsphoto.cognizance;

import com.badlogic.gdx.Screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;

public class MainMenuScreen implements Screen {
	
	Texture img;
	Music introMusic;
	SpriteBatch batch;
	BitmapFont font;
	private Stage menuStage;

	
	//Constructor
	public MainMenuScreen(final MainGame game) {
		menuStage = new Stage(new ScreenViewport());
		Gdx.input.setInputProcessor(menuStage);
	}
	
	@Override
	public void show() {
		// Splash screen image
		batch = new SpriteBatch();
		img = new Texture("graphics/splash_screens/start-menu.png");
		
		// Intro Music
		introMusic = Gdx.audio.newMusic(Gdx.files.internal("music/disintegrating.mp3"));
		introMusic.play();
		
		// Menu Options
		Table menuTable = new Table();
		menuTable.setFillParent(true);
		float centerY = menuTable.getY();
		float centerX = menuTable.getX();
		menuTable.setPosition(centerY, centerX - 250);
		menuTable.setDebug(false); // Set to true to see image frames.
		menuStage.addActor(menuTable);
		
		// Temporary until we have asset manager in
		Skin menuSkin = new Skin(Gdx.files.internal("graphics/skins/cog-nizance-menu/skin/vhs-ui.json"));
		
		// Create buttons
		TextButton newGameButton = new TextButton("New Game", menuSkin);
		TextButton loadGameButton = new TextButton("Load Game", menuSkin);
		TextButton exitButton = new TextButton("Exit", menuSkin);
		
		// Add buttons to menuTable
		menuTable.add(newGameButton).fillX().uniformX();
		menuTable.row().pad(10, 0, 10, 0);
		menuTable.add(loadGameButton).fillX().uniformX();
		menuTable.row();
		menuTable.add(exitButton).fillX().uniformX();
		
		/*
		 * Button Listeners
		 */
		
		// New Game Button
		newGameButton.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				System.out.println("User clicked new game button.");
			}
		});
		
		// Load Game Button
		loadGameButton.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				System.out.println("User clicked load game button.");
			}
		});
		
		// Exit Button
		exitButton.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				System.out.println("User clicked exit button.");
				batch.dispose();
				img.dispose();
				System.exit(0);
			}
		});
		
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(img, 0, 0);
		batch.end();
		
		menuStage.draw();
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
		batch.dispose();
		img.dispose();
	}
	
}