package com.wtf.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.ArrayMap;
import com.wtf.WTF;
import com.wtf.assets.UIAssets;

/**
 * [A modifier]
 * Modèle de menu. Les pages du menu doivent d�river de cette classe
 * et initWidgets() et initUI() doivent obligatoirement être implémentés
 * et appelés dans le constructeur des classes filles à la fin du constructeur.
 * <p> L'implémentation doit être réalisé de la manière suivante:
 * <pre>
 * public ExempleScreen(final WTF wtf){
 * 	super(wtf);
 *  	//...
 * 	// appel des méthodes initWidgets() et initUI() à la fin du constructeur
 *  	initWidgets();
 *  	initUI();
 *  }
 *</pre>
 */
public abstract class UIScreen implements Screen{
	private final WTF wtf;
	private Skin skin; // design général des menus
	private Stage stage; // conteneur de l'IHM
	private Stage backgroundContainer; // fond des menus
	private ArrayMap<String,Actor> widgetsList; // conteneur de widgets
	
	public UIScreen(final WTF wtf){
		this.wtf = wtf;
		skin = UIAssets.getDefaultSkin();
		stage = new Stage();
		Gdx.input.setInputProcessor(stage);
		
		// initialisation du conteneur de widgets
		widgetsList = new ArrayMap<String,Actor>();
		
		// initialisation du fond
		backgroundContainer = new Stage();
		//Image backImg = new Image(new Texture("style/background.png"));
		Image backImg = UIAssets.getBackground();
		backImg.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		backgroundContainer.addActor(backImg);
		
		// initialisation de la musique
		playMusic();
	}
	
	/**
	 * Tous les �l�ments de l'interface doivent être initialisés dans cette méthode
	 */
	public abstract void initWidgets();
	/**
	 * Le positionnement des widgets doivent être programmés dans cette méthode
	 */
	public abstract void initUI();
	
	@Override
	public void render(float delta){
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		Gdx.gl.glClearColor(152, 250, 201, 1); // 98FAC9
		stage.act(delta);
		Table.drawDebug(stage); // utile pour le debug
		backgroundContainer.draw();
		stage.draw();
	}
	
	public void dispose(){
		skin.dispose();
	}
	
	@Override
	public void hide(){
		skin.dispose();
	}
	
	/**
	 * Joue la musique, si elle n'est pas encore jouée.
	 * La m�thode ne fait rien si la musique est déjà jouée
	 */
	public void playMusic(){
		if(!wtf.getUiMusic().isPlaying())
			wtf.getUiMusic().play();
	}
	
	/**
	 * Arr�te la musique
	 */
	public void stopMusic(){
		wtf.getUiMusic().stop();
	}
	
	public WTF getWtf() {
		return wtf;
	}
	
	public Skin getSkin(){
		return skin;
	}
	
	public Stage getStage(){
		return stage;
	}
	
	/**
	 * @return La liste des éléments de l'interface graphique de l'écran
	 */
	public ArrayMap<String,Actor> getWidgetsList(){
		return widgetsList;
	}

}
