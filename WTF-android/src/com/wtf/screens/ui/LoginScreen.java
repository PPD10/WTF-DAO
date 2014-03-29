package com.wtf.screens.ui;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.wtf.WTF;

/**
 * Ecran d'identification du joueur
 *
 */
public class LoginScreen extends UIScreen {	
	private Table table;

	public LoginScreen(final WTF game) {
		super(game);
		// initialisation des widgets (éléments de l'interface)
		initWidgets();

		// positionnement des éléments de l'interface (sans affichage)
		initUI();
	}
	
	@Override
	public void initWidgets() {
		// titre de la page
		Label title = new Label("Connexion",getSkin());
		getWidgetsList().put("title", title);
		
		// init champs pseudos + mdp
		Label nameLabel = new Label("Pseudo :", getSkin());
		TextField nameText = new TextField("", getSkin());
		Label passwordLabel = new Label("Mot de passe :", getSkin());
		TextField passwordText = new TextField("", getSkin());
		passwordText.setPasswordCharacter('*');
		passwordText.setPasswordMode(true);
		
		getWidgetsList().put("nameLabel", nameLabel);
		getWidgetsList().put("nameText", nameText);
		getWidgetsList().put("passwordLabel", passwordLabel);
		getWidgetsList().put("passwordText", passwordText);
		
		// init invitation à l'inscription
		Label loginHelp = new Label("Pas encore inscrit ? \nCliquez sur le bouton ci-dessous",getSkin());
		getWidgetsList().put("loginHelp", loginHelp);
		
		// init boutons + la réaction l'événement click
		TextButton loginButton = new TextButton("Connexion", getSkin());
		loginButton.addListener(new InputListener() {
			@Override
			public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
				return true;
			}
			@Override
			public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
				// vers une connection
			}
		});
		TextButton registerButton = new TextButton("S'inscrire", getSkin());
		registerButton.addListener(new InputListener() {
			@Override
			public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
				return true;
			}
			@Override
			public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
				getStage().clear();
				// vers une inscription
				getWtf().setScreen(new RegisterScreen(getWtf()));

			}
		});
		TextButton returnButton = new TextButton("Retour", getSkin());
		//setButtonTarget(returnButton,new MenuScreen(game));
		returnButton.addListener(new InputListener() {
			@Override
			public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
				return true;
			}
			@Override
			public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
				getStage().clear();
				getWtf().setScreen(new MainScreen(getWtf()));
			}
		});
		getWidgetsList().put("loginButton", loginButton);
		getWidgetsList().put("registerButton", registerButton);
		getWidgetsList().put("returnButton", returnButton);

		
	}

	@Override
	public void initUI() {
		// constuction de l'interface en mémoire
		table = new Table();
		table.add(getWidgetsList().get("title")).colspan(2);
		table.row();
	    table.add(new Label(" ",getSkin()));
	    table.row();
	    table.add(getWidgetsList().get("nameLabel"));
	    table.add(getWidgetsList().get("nameText"));
	    table.row();
	    table.add(getWidgetsList().get("passwordLabel"));
	    table.add(getWidgetsList().get("passwordText"));
	    table.row();
	    table.add(getWidgetsList().get("loginButton")).colspan(2);
	    table.row();
	    table.add(new Label(" ",getSkin()));
	    table.row();
	    table.add(getWidgetsList().get("loginHelp")).colspan(2);
	    table.row();
	    table.add(getWidgetsList().get("registerButton")).colspan(2);
		table.row();
	    
		table.debug();
	    table.setFillParent(true);
	    getStage().addActor(table);
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
