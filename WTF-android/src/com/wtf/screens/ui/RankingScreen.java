package com.wtf.screens.ui;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.Array;
import com.wtf.WTF;
import com.wtf.net.NetPlayer;

/**
 * Ecran du classement des joueurs
 *
 */
public class RankingScreen extends UIScreen{
	private Table container;
	private Array<NetPlayer> playersList;
	private TextButton toMenuScreen;
	
	public RankingScreen(final WTF game) {
		super(game);
		// initialisation des widgets (éléments de l'interface)
		initWidgets();

		// positionnement des éléments de l'interface (sans affichage)
		initUI();

	}

	@Override
	public void initWidgets() {
		// initialisation de la liste des joueurs
		playersList = new Array<NetPlayer>();
		Label title = new Label("Classement général", getSkin());
		getWidgetsList().put("title", title);
		// jeu d'essai sans BD
		playersList.add(new NetPlayer("Dark Avenger",100000));
		playersList.add(new NetPlayer("Gameplayer",680));
		playersList.add(new NetPlayer("Samus",500));
		playersList.add(new NetPlayer("Killer",100));
		for(int i = 0; i<100 ; ++i)
			playersList.add(new NetPlayer("Testeur",100));

		// bouton de retour vers le menu principal
		toMenuScreen = new TextButton("Retour",getSkin());
		toMenuScreen.addListener(new InputListener() {
			@Override
			public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
				return true;
			}
			@Override
			public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
				System.out.println("start");
				getStage().clear();
				getWtf().setScreen(new MainScreen(getWtf()));
			}
		});
		getWidgetsList().put("toMenuScreen", toMenuScreen);

	}

	@Override
	public void initUI() {
		container = new Table();
		container.setFillParent(true);
		Table table = new Table();
		final ScrollPane scroll = new ScrollPane(table, getSkin());
		table.add(getWidgetsList().get("title")).colspan(3);
		table.row();
		// liste des joueurs
		int i=1;
		for(NetPlayer t : playersList){
			Label rankingText = new Label(Integer.toString(i),getSkin());
			Label nameText= new Label(t.getName(), getSkin());
			Label scoreText= new Label(t.getScoreString(),getSkin());
			table.add(rankingText).pad(10);
			table.add(nameText).pad(10);
			table.add(scoreText).pad(10);
			table.row();
			++i;
		}
		table.debug();
		//table.setFillParent(true);
		container.add(scroll).expand().fill().colspan(4);
		getStage().addActor(container);
		getStage().addActor(toMenuScreen);
		
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
	
	public Array<NetPlayer> getPlayersList(){
		return playersList;
	}

}
