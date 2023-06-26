package com.mygdx.game;

public class Floor extends Box{
    public Floor(float x, float y, float z, Stage3D stage) {
        super(x, y, z, stage);
        loadTexture("assets/water.jpg");
        setScale(500, 0.1f, 500);
    }

}
