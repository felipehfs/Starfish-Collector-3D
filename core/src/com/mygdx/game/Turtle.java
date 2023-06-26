package com.mygdx.game;

public class Turtle extends ObjModel{
    public Turtle(float x, float y, float z, Stage3D stage) {
        super(x, y, z, stage);
        loadObjModel("assets/turtle.obj");
        setBasePolygon();
    }
}
