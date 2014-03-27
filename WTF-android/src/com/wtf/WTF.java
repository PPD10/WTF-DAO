package com.wtf;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.wtf.assets.UIAssets;
import com.wtf.dao.DaoSession;
import com.wtf.screens.MainScreen;

public class WTF extends Game {

	private SpriteBatch batch;
	private BitmapFont font;
	private DaoSession daoSession;
	private Music UIMusic;

	public WTF(DaoSession daoSession) {
		this.daoSession = daoSession;
	}

	@Override
	public void create() {
		batch = new SpriteBatch();
		
		font = UIAssets.getFont("segoeUi");
		font.setColor(1,0,0,1);
		
		UIAssets.loadMusic();
		UIAssets.manager.finishLoading();
		UIMusic = UIAssets.manager.get(UIAssets.DEFAULT_MUSIC);
		UIMusic.setLooping(true);
		
		Texture.setEnforcePotImages(false);
		
		this.setScreen(new MainScreen(this));
	}

	@Override
	public void dispose() {
		super.dispose();
		
		batch.dispose();
		font.dispose();
		UIAssets.dispose();
	}

	@Override
	public void render() {
		super.render();
	}

	@Override
	public void resize(int width, int height) {
		super.resize(width, height);
	}

	@Override
	public void pause() {
		super.pause();
	}

	@Override
	public void resume() {
		super.resume();
	}

	public SpriteBatch getBatch() {
		return batch;
	}

	public BitmapFont getFont() {
		return font;
	}
	
	public DaoSession getDaoSession() {
		return daoSession;
	}
	
	public Music getUiMusic() {
		return UIMusic;
	}

}
