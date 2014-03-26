package com.wtf.models;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table LEVEL.
 */
public class Level {

	private Long id;
	private String name;
	private Integer maxScore;

	public Level() {
	}

	public Level(Long id) {
		this.id = id;
	}

	public Level(Long id, String name, Integer maxScore) {
		this.id = id;
		this.name = name;
		this.maxScore = maxScore;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getMaxScore() {
		return maxScore;
	}

	public void setMaxScore(Integer maxScore) {
		this.maxScore = maxScore;
	}

}