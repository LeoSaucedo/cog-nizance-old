package com.cgsphoto.cognizance;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.actions.SequenceAction;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class Stage0Screen extends GameScreen {
	Music introVoiceover;
	private MainGame game;
	private Stage screenStage;
	private Skin skin;
	private Label seasonLbl;
	private Music bgMusic;
	
	public Stage0Screen(final MainGame game) {
		super(game);
		this.game = game;
		screenStage = new Stage(new ScreenViewport());
		Gdx.input.setInputProcessor(screenStage);
		skin = new Skin(Gdx.files.internal("graphics/skins/cog-nizance-menu/skin/vhs-ui.json"));
	}
	
	@Override
	public void show() {
		// TODO music
		bgMusic = Gdx.audio.newMusic(Gdx.files.internal("music/riseAndFall.mp3"));
		bgMusic.play();
		bgMusic.setLooping(true);
		
		// Season label
		seasonLbl = new Label("Winter",skin);
		seasonLbl.setColor(seasonLbl.getColor().r, seasonLbl.getColor().g, seasonLbl.getColor().b, 0);
		seasonLbl.setPosition(Gdx.graphics.getWidth()/2-(seasonLbl.getWidth()/2),Gdx.graphics.getHeight()/2-(seasonLbl.getHeight()/2));
		seasonLbl.addAction(Actions.fadeIn(0.5f));
		seasonLbl.addAction(new SequenceAction(Actions.delay(2.5f), Actions.fadeOut(0.5f), new Action() {

			@Override
			public boolean act(float delta) {
				// TODO Auto-generated method stub
				return true;
			}
			
		}));
		screenStage.addActor(seasonLbl);

	}

	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		screenStage.act(Gdx.graphics.getDeltaTime());
		screenStage.draw();
		
		// Escape Key
		if(Gdx.input.isKeyPressed(Keys.ESCAPE)) {
			bgMusic.pause();
			game.setScreen(new PauseScreen(game, this));
		}

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
