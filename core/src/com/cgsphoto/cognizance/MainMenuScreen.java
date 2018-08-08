package com.cgsphoto.cognizance;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.audio.Music;

public class MainMenuScreen implements Screen {
	
	private MainGame game;
	private Texture imgTexture;
	private Image bgImage;
	private Music introMusic;
	private BitmapFont font;
	private Stage menuStage;
	private ScreenViewport viewport;
	private Table menuTable;
	
	// Constructor
	public MainMenuScreen(final MainGame game) {
		this.game = game;
		menuStage = new Stage(new ScreenViewport());
		Gdx.input.setInputProcessor(menuStage);
	}
	
	@Override
	public void show() {
		
		// Splash screen image
		imgTexture = new Texture("graphics/splash_screens/start-menu.png");
		bgImage = new Image(imgTexture);
		
		// Intro Music
		introMusic = Gdx.audio.newMusic(Gdx.files.internal("music/lament.mp3"));
		introMusic.play();
		introMusic.setLooping(true);
		
		// Menu Options
		menuTable = new Table();
		menuTable.setFillParent(true);
		float centerY = menuTable.getY();
		float centerX = menuTable.getX();
		menuTable.setPosition(centerY, centerX - 150); // Moves the table down 300p.
		menuTable.setDebug(false); // Set to true to see image frames.
		menuStage.addActor(bgImage);
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
				menuStage.dispose();
				introMusic.stop();
				game.setScreen(new IntroVideoScreen(game));
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
				Gdx.app.exit();
			}
		});
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		menuStage.act(Gdx.graphics.getDeltaTime());
		menuStage.draw();
		
		// Escape Key
		if(Gdx.input.isKeyPressed(Keys.ESCAPE)) {
			Gdx.app.exit();
		}
	}

	@Override
	public void resize(int width, int height) {
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
	}
	
}