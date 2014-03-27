package com.wtf.net;

/**
 * Classe temporaire pour représenter le joueur dans le serveur
 * 
 */
public class NetPlayer{
	private String name;
	private int score;
	
	public NetPlayer(String name, int score){
		this.name = name;
		this.score = score;
	}

	public String getName() {
		return name;
	}

	public int getScore() {
		return score;
	}
	
	public String getScoreString(){
		return Integer.toString(score);
	}
	

}
