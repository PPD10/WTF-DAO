package com.wtf.entities.infos;

import com.wtf.entities.Entity;

public class MaxScore extends Entity {

	private int maxScore = 0;

	public MaxScore() {
		super();
	}

	public MaxScore(int x, int y) {
		super(x, y);
	}

	public int getMaxScore() {
		return maxScore;
	}
	
	public void setMaxScore(int maxScore) {
		this.maxScore = maxScore;
	}

	@Override
	public String toString() {
		return "Max score : " + maxScore;
	}

}
