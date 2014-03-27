package com.wtf.screens;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.wtf.WTF;
import com.wtf.games.Game;

/**
 * Ecran de fin de jeu
 */
public class GameOverScreen extends UIScreen {
	
	private Game game; // instance de la partie qui vient d'être jouée
	private Table container; // IHM en m�moire

	public GameOverScreen(final WTF wtf, Game game) {
		super(wtf);
		this.game = game;
		// initialisation des widgets (éléments de l'interface)
		initWidgets();

		// positionnement des éléments de l'interface (sans affichage)
		initUI();
	}
	
	@Override
	public void initWidgets() {
		// initialisation des widgets
		TextButton toMainScreen = new TextButton("Retour à l'accueil", getSkin());
		TextButton toGameScreen = new TextButton("Rejouer", getSkin());
		String endGameText = game.getCharacter().hasWon() ? "Niveau réussi !" : "Game over" ;
		Label endGameLabel = new Label(endGameText,getSkin());
		Label endScore = new Label(game.getScore().toString(), getSkin());
		getWidgetsList().put("toMainScreen", toMainScreen);
		getWidgetsList().put("toGameScreen", toGameScreen);
		getWidgetsList().put("endGameLabel", endGameLabel);
		getWidgetsList().put("endScore", endScore);
		
		// initialisation des événements associés aux boutons
		toGameScreen.addListener(new InputListener() {
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
		toMainScreen.addListener(new InputListener() {
			@Override
			public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
				return true;
			}
			@Override
			public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
				getStage().clear(); // pour effacer l'affichage en cours
				getWtf().setScreen(new MainScreen(getWtf()));
			}
		});
		
	}

	@Override
	public void initUI() {
		
		// initialisation de l'IHM en m�moire
		container = new Table();
		container.setFillParent(true);
		container.add(getWidgetsList().get("endGameLabel"));
		container.row();
		container.add(getWidgetsList().get("endScore"));
		container.row();
		container.add(new Label(" ", getSkin()));
		container.row();
		container.add(getWidgetsList().get("toGameScreen")).padBottom(10); 
		container.row();
		container.add(getWidgetsList().get("toMainScreen")).padBottom(10); 
		//container.debug();
		getStage().addActor(container);
		
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

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}



}
