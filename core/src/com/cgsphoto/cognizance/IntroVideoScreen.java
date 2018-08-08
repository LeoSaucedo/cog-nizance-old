package com.cgsphoto.cognizance;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class IntroVideoScreen implements Screen{
	Music introVoiceover;
	private MainGame game;
	Stage screenStage;
	Skin skin;
	
	public IntroVideoScreen(final MainGame game) {
		this.game = game;
		screenStage = new Stage(new ScreenViewport());
		Gdx.input.setInputProcessor(screenStage);
		skin = new Skin(Gdx.files.internal("graphics/skins/cog-nizance-menu/skin/vhs-ui.json"));
	}

	@Override
	public void show() {
		// Intro music
		introVoiceover = Gdx.audio.newMusic(Gdx.files.internal("voice/intro.mp3"));
		introVoiceover.play();
		
		// Enter to skip dialogue
		Label skipLbl = new Label("Enter to skip",skin);
		skipLbl.setColor(skipLbl.getColor().r, skipLbl.getColor().g, skipLbl.getColor().b, 0);
		skipLbl.addAction(Actions.fadeIn(0.5f));
		screenStage.addActor(skipLbl);
		
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		screenStage.act(Gdx.graphics.getDeltaTime());
		screenStage.draw();
		
		// Enter to skip
		if(Gdx.input.isKeyPressed(Keys.ENTER)) {
			
		}
		
		// Escape Key
		if(Gdx.input.isKeyPressed(Keys.ESCAPE)) {
			Gdx.app.exit();
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
