package com.wtf.assets;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

/**
 * [Non fini]
 * Utilitaire pour les menus 
 * pour r�cup�rer les fichiers audio, images, polices, etc.
 */
public class UIAssets {
	
	public static final AssetManager manager = new AssetManager();
	
	// Emplacement du logo (gros titre)
	private static final String MAIN_TITLE = "ui/title.png";
	
	// Emplacement du fond
	private static final String BACKGROUND = "ui/background.png";
	
	// Emplacement du design général de l'interface
	private static final String DEFAULT_DESIGN = "ui/uiskin.json";
	
	// Emplacement de la musique de l'interface
	public static final String DEFAULT_MUSIC ="ui/music/menu.mp3";
	
	// Emplacement des polices
	private static final String FONTS_FOLDER = "ui/fonts/";
	
	// Emplacement des éléments de la page d'aide (HelpScreen)
	private static final String HELP_FOLDER = "ui/icons/";
	
	public static Skin getDefaultSkin(){
		return new Skin(Gdx.files.internal(DEFAULT_DESIGN));
	}
	
	public static Image getCharacterIcon(String character){
		return new Image(new Texture(Gdx.files.internal(HELP_FOLDER + character +".png")));
	}
	
	public static Image getLogo(){
		return new Image(new Texture(Gdx.files.internal(MAIN_TITLE)));
	}
	/*
	public static Music getDefaultMusic(){
		return Gdx.audio.newMusic(Gdx.files.internal(DEFAULT_MUSIC));
	}
	*/
	
	public static void loadMusic() {
		manager.load(new AssetDescriptor<Music>(DEFAULT_MUSIC, Music.class));
	}
	
	public static BitmapFont getFont(String font){
		return new BitmapFont(Gdx.files.internal(FONTS_FOLDER+font+"Font.fnt"));
	}
	
	public static Image getBackground(){
		return new Image(new Texture(BACKGROUND));
	}

	public static void dispose() {
		manager.clear();
	}
	
}
