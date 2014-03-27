package com.wtf.screens;

import java.util.Iterator;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.wtf.WTF;
import com.wtf.assets.UIAssets;

/**
 * Ecran principal du jeu
 *
 */
public class MainScreen extends UIScreen {

	private Table table;
	private Image logo;

	public MainScreen(final WTF wtf) {
		super(wtf);
		
		// initialisation des widgets (éléments de l'interface)
		initWidgets();

		// positionnement des éléments de l'interface (sans affichage)
		initUI();
	}
	
	public void initWidgets() {
		// initialisation du logo
		//logo = new Image(new Texture(Gdx.files.internal("title.png")));
		logo = UIAssets.getLogo();
		logo.setX(0);
		logo.setWidth(Gdx.graphics.getWidth());
		logo.setHeight(150);
		
		// initialisation des boutons et des événements associés
		//Group buttonsList = new Group();
		TextButton startButton = new TextButton("Jouer", getSkin());
		TextButton rankingButton = new TextButton("Classement", getSkin());
		TextButton loginButton = new TextButton("Connexion", getSkin());
		TextButton helpButton = new TextButton("Aide", getSkin());

		startButton.addListener(new InputListener() {
			@Override
			public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
				return true;
			}
			@Override
			public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
				getStage().clear();
				getWtf().setScreen(new LevelSelectScreen(getWtf()));
			}
		});
		//loginButton.addListener(new UIButtonListener(stage, wtf, new LoginScreen(wtf)));
		loginButton.addListener(new InputListener() {
			@Override
			public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
				return true;
			}
			@Override
			public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
				getStage().clear();
				getWtf().setScreen(new LoginScreen(getWtf()));
			}
		});
		//rankingButton.addListener(new UIButtonListener(stage, wtf, new RankingScreen(wtf)));
		rankingButton.addListener(new InputListener() {
			@Override
			public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
				return true;
			}
			@Override
			public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
				getStage().clear();
				getWtf().setScreen(new RankingScreen(getWtf()));
			}
		});
		//helpButton.addListener(new UIButtonListener(stage, wtf, new HelpScreen(wtf)));
		helpButton.addListener(new InputListener() {
			@Override
			public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
				return true;
			}
			@Override
			public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
				getStage().clear();
				getWtf().setScreen(new HelpScreen(getWtf()));
			}
		});
		/*buttonsList.addActor(startButton);
		buttonsList.addActor(loginButton);
		buttonsList.addActor(rankingButton);
		buttonsList.addActor(helpButton);
		getWidgetsList().put("buttonsList", buttonsList);*/
		getWidgetsList().put("startButton", startButton);
		getWidgetsList().put("loginButton", loginButton);
		getWidgetsList().put("rankingButton", rankingButton);
		getWidgetsList().put("helpButton", helpButton);
	}
	
	public void initUI() {
		table = new Table();
		table.add(logo);
		//table.add(getWidgetsList().get("title"));
		table.row();
		table.add(new Label("   ",getSkin())).pad(10);
		table.row();
		table.add(new Label("   ",getSkin())).pad(10);
		table.row();
		Iterator<String> it = getWidgetsList().keys();
		while(it.hasNext()){
			table.add(getWidgetsList().get(it.next())).width(Gdx.graphics.getWidth()/2).pad(10);
			table.row();
		}
		/*Group buttonsListGroup = (Group) getWidgetsList().get("buttonsList");
		SnapshotArray<Actor> buttonsList = buttonsListGroup.getChildren();
		Actor[] items = buttonsList.begin();
		for(int i = 0, n = buttonsList.size ; i < n ; ++i){
			table.add(items[i]).width(Gdx.graphics.getWidth()/2).pad(10);
			table.row();
		}
		buttonsList.end();*/
		table.setFillParent(true);
		getStage().addActor(table);
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
		super.dispose();
	}

}
