package com.mygdx.game;

public class Starfish extends ObjModel{
    public Starfish(float x, float y, float z, Stage3D stage) {
        super(x, y, z, stage);
        loadObjModel("assets/star.obj");
        setScale(3, 1, 3);
        setBasePolygon();
    }

    @Override
    public void act(float dt) {
        super.act(dt);
        turn(90 * dt);
    }
}
