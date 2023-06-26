package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;

public class DemoScreen extends BaseScreen{
    BaseActor3D player;
    @Override
    public void initialize() {
        Box screen = new Box(0, 0, 0, mainStage3D);
        screen.setScale(16, 12, 0.1f);
        screen.loadTexture("assets/starfish-collector.png");

        Box marker0 = new Box(0, 0, 0, mainStage3D);
        marker0.setColor(Color.BROWN);
        marker0.loadTexture("assets/crate.jpg");

        Box markerX = new Box(5, 0, 0, mainStage3D);
        markerX.setColor(Color.RED);
        markerX.loadTexture("assets/crate.jpg");

        Box markerY = new Box(0, 5, 0, mainStage3D);
        markerY.setColor(Color.GREEN);
        markerY.loadTexture("assets/crate.jpg");

        Box markerZ = new Box(0, 0, 5, mainStage3D);
        markerZ.setColor(Color.BLUE);
        markerZ.loadTexture("assets/crate.jpg");

        player = new Sphere(0, 1, 8, mainStage3D);
        player.loadTexture("assets/sphere-pos-neg.png");

        mainStage3D.setCameraPosition(3, 4, 10);
        mainStage3D.setCameraDirection(0, 0, 0);
    }

    @Override
    public void update(float deltaTime) {
        float speed = 3.0f;
        float rotateSpeed = 45.0f;

        if (Gdx.input.isKeyPressed(Input.Keys.SHIFT_LEFT) || Gdx.input.isKeyPressed(Input.Keys.SHIFT_RIGHT)) {
            // when the shift is pressed
            if (Gdx.input.isKeyPressed(Input.Keys.W))
                mainStage3D.moveCameraForward(speed * deltaTime);
            if (Gdx.input.isKeyPressed(Input.Keys.S))
                mainStage3D.moveCameraForward(-speed * deltaTime);
            if (Gdx.input.isKeyPressed(Input.Keys.A))
                mainStage3D.moveCameraRight(-speed * deltaTime);
            if (Gdx.input.isKeyPressed(Input.Keys.D))
                mainStage3D.moveCameraRight(speed * deltaTime);

            if (Gdx.input.isKeyPressed(Input.Keys.R))
                mainStage3D.moveCameraUp(speed * deltaTime);
            if (Gdx.input.isKeyPressed(Input.Keys.F))
                mainStage3D.moveCameraUp(-speed * deltaTime);

            if (Gdx.input.isKeyPressed(Input.Keys.Q))
                mainStage3D.turnCamera(-rotateSpeed * deltaTime);
            if (Gdx.input.isKeyPressed(Input.Keys.E))
                mainStage3D.turnCamera(rotateSpeed * deltaTime);

            if (Gdx.input.isKeyPressed(Input.Keys.T))
                mainStage3D.tiltCamera(rotateSpeed * deltaTime);
            if (Gdx.input.isKeyPressed(Input.Keys.G))
                mainStage3D.tiltCamera(-rotateSpeed * deltaTime);
        }
    }
}
