package com.mygdx.game;

public class Rock extends ObjModel{
    public Rock(float x, float y, float z, Stage3D stage) {
        super(x, y, z, stage);
        loadObjModel("assets/rock.obj");
        setBasePolygon();
        setScale(3, 3, 3);
    }
}
