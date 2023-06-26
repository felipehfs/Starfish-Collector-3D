package com.mygdx.game;

public class Project3D extends BaseGame {

	@Override
	public void create() {
		super.create();
		setActiveScreen(new LevelScreen());
	}
}
