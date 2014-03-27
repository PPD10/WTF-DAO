package com.wtf.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.wtf.WTF;
import com.wtf.assets.UIAssets;

/**
 * Ecran d'aide
 */
public class HelpScreen extends UIScreen{
	private Table container;

	public HelpScreen(final WTF wtf) {
		super(wtf);
		// initialisation des widgets (éléments de l'interface)
		initWidgets();

		// positionnement des éléments de l'interface (sans affichage)
		initUI();
	}

	@Override
	public void render(float delta) {
		super.render(delta);	
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		getStage().setViewport(width, height, false);
		
	}

	@Override
	public void show() {
	}

	@Override
	public void hide() {
		super.hide();
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
	public void initWidgets() {
		// Personnages
		Label characterTitle = new Label("Personnages :",getSkin());
		Image giraffeImg = UIAssets.getCharacterIcon("punkGiraffe");
		Label giraffeDescription = new Label("Punk Giraffe :\nune girafe surprenante !",getSkin());
		Image fluffyBallImg = UIAssets.getCharacterIcon("fluffyBall");
		Label fluffyBallDescription = new Label("Fluffy Ball : \nUne boule toute mignonne !",getSkin());
		Image teletoctopusImg =  UIAssets.getCharacterIcon("teletoctopus");
		Label teletoctopusDescription = new Label("Teletoctopus : \n"
				+ "Un mélange subtil d'une pieuvre\net d'un teletubbies",getSkin());
		getWidgetsList().put("characterTitle", characterTitle);
		getWidgetsList().put("giraffeImg", giraffeImg);
		getWidgetsList().put("giraffeDescription", giraffeDescription);
		getWidgetsList().put("fluffyBallImg", fluffyBallImg);
		getWidgetsList().put("fluffyBallDescription", fluffyBallDescription);
		getWidgetsList().put("teletoctopusImg", teletoctopusImg);
		getWidgetsList().put("teletoctopusDescription", teletoctopusDescription);

		// bonus
		Label bonusTitle = new Label("Les bonus :",getSkin());
		Label invincibilityImg = new Label("   ",getSkin());
		Label invincibilityDescription = new Label("Invulnérabilité :\n"
				+ "pendant 3 secondes \nvous ne pouvez perdre de vies",getSkin());
		Image coinsBagImg = new Image(new Texture(Gdx.files.internal("worlds/entities/bonus/sacpiece.png")));
		Label coinsBagDescription = new Label("Sac de points : \n"
				+ "vous gagnez des points en plus",getSkin());
		getWidgetsList().put("bonusTitle", bonusTitle);
		getWidgetsList().put("invincibilityImg", invincibilityImg);
		getWidgetsList().put("invincibilityDescription", invincibilityDescription);
		getWidgetsList().put("coinsBagImg", coinsBagImg);
		getWidgetsList().put("coinsBagDescription", coinsBagDescription);

		// malus
		Label penaltyTitle = new Label("Les malus :",getSkin());
		Label suddenDeathImg = new Label("   ",getSkin());
		Label suddenDeathDescription = new Label("Mort subite :\n"
				+ "mort instantanée de votre\npersonnage",getSkin());
		Label vulnerabilityImg = new Label("   ",getSkin());
		Label vulnerabilityDescription = new Label("Vulnérabilité temporaire : \n"
				+ "pendant quelques secondes,\n"
				+ "vous perdez plus de vies",getSkin());
		getWidgetsList().put("penaltyTitle", penaltyTitle);
		getWidgetsList().put("suddenDeathImg", suddenDeathImg);
		getWidgetsList().put("suddenDeathDescription", suddenDeathDescription);
		getWidgetsList().put("vulnerabilityImg", vulnerabilityImg);
		getWidgetsList().put("vulnerabilityDescription", vulnerabilityDescription);
		
		// bouton de retour vers le menu principal
		TextButton toMenuScreen = new TextButton("Retour",getSkin());
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
		// conteneur
		container = new Table();
		container.setFillParent(true);
		// contenu avec scroll
		Table table = new Table();
		final ScrollPane scroll = new ScrollPane(table, getSkin()); // ascenseur sur le contenu
		table.pad(10).defaults().expandX().space(4);
		
		// initUI
		table.add(getWidgetsList().get("characterTitle")).colspan(2);
		table.row();
		table.add(getWidgetsList().get("giraffeImg"));
		table.add(getWidgetsList().get("giraffeDescription")).expandX().fillX();
		table.row();
		table.add(getWidgetsList().get("fluffyBallImg"));
		table.add(getWidgetsList().get("fluffyBallDescription")).expandX().fillX();
		table.row();
		table.add(getWidgetsList().get("teletoctopusImg"));
		table.add(getWidgetsList().get("teletoctopusDescription")).expandX().fillX();
		
		table.row();
		table.add(new Label(" ",getSkin())).pad(10);
		table.row();
		
		// Bonus
		table.add(getWidgetsList().get("bonusTitle")).colspan(2);
		table.row();
		table.add(getWidgetsList().get("invincibilityImg")).pad(10);
		table.add(getWidgetsList().get("invincibilityDescription")).expandX().fillX();
		table.row();
		table.add(getWidgetsList().get("coinsBagImg"));
		table.add(getWidgetsList().get("coinsBagDescription")).expandX().fillX();
		
		table.row();
		table.add(new Label(" ",getSkin())).pad(10);
		table.row();
		
		// Malus
		table.add(getWidgetsList().get("penaltyTitle")).colspan(2);
		table.row();
		table.add(getWidgetsList().get("suddenDeathImg")).pad(10);
		table.add(getWidgetsList().get("suddenDeathDescription")).expandX().fillX();
		table.row();
		table.add(getWidgetsList().get("vulnerabilityImg")).pad(10);
		table.add(getWidgetsList().get("vulnerabilityDescription")).expandX().fillX();
		table.row();
		table.add(new Label(" ",getSkin())).pad(10);
		table.row();
		
		//table.debug();
		container.add(scroll).expand().fill().colspan(4);
		getStage().addActor(container);
		getStage().addActor(getWidgetsList().get("toMenuScreen"));
	}

}
