package com.wtf.screens.ui;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.wtf.WTF;

/**
 * Ecran d'inscription
 *
 */
public class RegisterScreen extends UIScreen{
	private Table table;

	public RegisterScreen(final WTF wtf) {
		super(wtf);
		// initialisation des widgets (éléments de l'interface)
		initWidgets();

		// positionnement des éléments de l'interface (sans affichage)
		initUI();
	}

	@Override
	public void initWidgets() {
		// titre de la page
		Label title = new Label("Inscription", getSkin());
		getWidgetsList().put("title",title);
		
		// initialisation des champs pseudos + mdp
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
	    
	    // initialisation des boutons et leurs �v�nements associ�s
	    TextButton registerButton = new TextButton("S'inscrire", getSkin());
	    registerButton.addListener(new InputListener() {
			@Override
			public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
				return true;
			}
			@Override
			public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
				//getStage().clear();
				System.out.println("Inscription...");
			}
		});
	    TextButton returnButton = new TextButton("Retour", getSkin());
		returnButton.addListener(new InputListener() {
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
		getWidgetsList().put("registerButton", registerButton);
		getWidgetsList().put("returnButton", returnButton);
	}

	@Override
	public void initUI() {
	    // construction de l'interface en m�moire
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
	    table.add(getWidgetsList().get("registerButton")).colspan(2);
		table.row();
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
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}



}
