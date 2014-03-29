package com.wtf.screens.ui;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.wtf.WTF;
import com.wtf.levels.LevelEnum;

/**
 * Ecran de s�lection du niveau
 *
 */
public class LevelSelectScreen extends UIScreen{
	private Table table;

	public LevelSelectScreen(final WTF wtf) {
		super(wtf);
		// initialisation des widgets (�l�ments de l'interface)
		initWidgets();

		// positionnement des �l�ments de l'interface (sans affichage)
		initUI();
	}

	@Override
	public void initWidgets() {
		Label title = new Label("Sélection du niveau", getSkin());
		TextButton lvl1Button = new TextButton("Niveau 1", getSkin());
		TextButton lvl2Button = new TextButton("Niveau 2", getSkin());
		TextButton lvl3Button = new TextButton("Niveau 3", getSkin());
		TextButton returnButton = new TextButton("Retour", getSkin());
		
		//returnButton.addListener(new UIButtonListener(getStage(), getWtf(), new MainScreen(getWtf())));
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
		
		lvl1Button.addListener(new InputListener() {
			@Override
			public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
				return true;
			}
			@Override
			public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
				getStage().clear();
				getWtf().setScreen(new CharacterSelectScreen(getWtf(), LevelEnum.LEVEL1));
			}
		});
		getWidgetsList().put("title",title);
		getWidgetsList().put("lvl1Button", lvl1Button);
		getWidgetsList().put("lvl2Button", lvl2Button);
		getWidgetsList().put("lvl3Button", lvl3Button);
		getWidgetsList().put("returnButton", returnButton);
		
	}

	@Override
	public void initUI() {
		table = new Table();
		table.add(getWidgetsList().get("title")).height(50);
		table.row();
	    table.add(new Label(" ",getSkin()));
	    table.row();
	    table.add(new Label(" ",getSkin()));
	    table.row();
		table.add(getWidgetsList().get("lvl1Button")).height(50).padBottom(10);
		table.row();
		table.add(getWidgetsList().get("lvl2Button")).height(50).padBottom(10);
		table.row();
		table.add(getWidgetsList().get("lvl3Button")).height(50).padBottom(10);
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
