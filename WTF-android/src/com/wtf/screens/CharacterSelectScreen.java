package com.wtf.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.wtf.WTF;
import com.wtf.assets.UIAssets;
import com.wtf.entities.graphical.characters.CharacterEnum;
import com.wtf.levels.LevelEnum;

/**
 * Ecran de sélection du personnage
 *
 */
public class CharacterSelectScreen extends UIScreen {
	private Table container;
	private LevelEnum lvl;

	public CharacterSelectScreen(final WTF wtf, final LevelEnum lvl) {
		super(wtf);
		this.lvl = lvl;
		// initialisation des widgets (éléments de l'interface)
		initWidgets();

		// positionnement des éléments de l'interface (sans affichage)
		initUI();
	}

	@Override
	public void initWidgets() {
		
		// Titre de l'�cran
		Label title = new Label("Sélection du personnage",getSkin());
		getWidgetsList().put("title", title);

		// init images correspondant aux personnages
		/*Image fluffyBall = new Image(new Texture(Gdx.files.internal("style/icons/fluffyBall.png")));
		Image punkGiraffe = new Image(new Texture(Gdx.files.internal("style/icons/punkGiraffe.png")));
		Image teletoctopus = new Image(new Texture(Gdx.files.internal("style/icons/teletoctopus.png")));*/
		Image fluffyBall = UIAssets.getCharacterIcon("fluffyBall");
		Image punkGiraffe = UIAssets.getCharacterIcon("punkGiraffe");
		Image teletoctopus = UIAssets.getCharacterIcon("teletoctopus");
		getWidgetsList().put("fluffyBall", fluffyBall);
		getWidgetsList().put("punkGiraffe", punkGiraffe);
		getWidgetsList().put("teletoctopus", teletoctopus);

		// init boutons de s�lection des personnages
		TextButton toPunkGiraffe = new TextButton("Punk Giraffe", getSkin());
		TextButton toFluffyBall = new TextButton("Fluffy Ball", getSkin());
		TextButton toTeletoctopus = new TextButton("Teletoctopus", getSkin());
		TextButton returnButton = new TextButton("Retour", getSkin());
		toPunkGiraffe.addListener(new InputListener() {
			@Override
			public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
				return true;
			}
			@Override
			public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
				getStage().clear(); // pour effacer l'affichage en cours
				stopMusic();
				getWtf().setScreen(new GameScreen(getWtf(), CharacterEnum.PUNK_GIRAFFE, lvl));
			}
		});
		toFluffyBall.addListener(new InputListener() {
			@Override
			public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
				return true;
			}
			@Override
			public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
				getStage().clear(); // pour effacer l'affichage en cours
				stopMusic();
				getWtf().setScreen(new GameScreen(getWtf(), CharacterEnum.FLUFFY_BALL, lvl));
			}
		});
		toTeletoctopus.addListener(new InputListener() {
			@Override
			public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
				return true;
			}
			@Override
			public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
				getStage().clear(); // pour effacer l'affichage en cours
				stopMusic();
				getWtf().setScreen(new GameScreen(getWtf(), CharacterEnum.TELETOCTOPUS, lvl));
			}
		});

		returnButton.addListener(new InputListener() {
			@Override
			public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
				return true;
			}
			@Override
			public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
				getStage().clear(); // pour effacer l'affichage en cours
				getWtf().setScreen(new LevelSelectScreen(getWtf()));
			}
		});

		toPunkGiraffe.setHeight(50);
		toFluffyBall.setHeight(50);
		toTeletoctopus.setHeight(50);
		getWidgetsList().put("toPunkGiraffe", toPunkGiraffe);
		getWidgetsList().put("toFluffyBall", toFluffyBall);
		getWidgetsList().put("toTeletoctopus", toTeletoctopus);
		getWidgetsList().put("returnButton", returnButton);
	}

	@Override
	public void initUI() {
		// initialisation du conteneur 
		container = new Table();
		container.setFillParent(true);
		// structure de l'�cran
		container.add(getWidgetsList().get("title")).colspan(2);
		container.row();
		container.add(getWidgetsList().get("fluffyBall"));
		container.add(getWidgetsList().get("toFluffyBall")).width(Gdx.graphics.getWidth() /2);
		container.row();
		container.add(getWidgetsList().get("teletoctopus"));
		container.add(getWidgetsList().get("toTeletoctopus")).width(Gdx.graphics.getWidth() /2);
		container.row();
		container.add(getWidgetsList().get("punkGiraffe"));
		container.add(getWidgetsList().get("toPunkGiraffe")).width(Gdx.graphics.getWidth() /2);
		//container.debug();
		getStage().addActor(container);
		getStage().addActor(getWidgetsList().get("returnButton"));
	}
	
	@Override
	public void render(float delta) {
		super.render(delta);
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
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

}
