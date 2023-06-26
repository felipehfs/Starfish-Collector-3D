package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.ui.Label;

public class LevelScreen extends BaseScreen{

    Turtle turtle;
    Label starfishLabel;
    Label messageLabel;
    @Override
    public void initialize() {
        new Floor(0, 0, 0, mainStage3D);

        Sphere skydome = new Sphere(0, 0, 0, mainStage3D);
        skydome.loadTexture("assets/sky-sphere.png");
        skydome.setScale(500, 500, -500);

        turtle = new Turtle(0, 0, 15, mainStage3D);
        turtle.setTurnAngle(90);

        turtle.setTurnAngle(90);

        new Rock(-15, 1,  0, mainStage3D);
        new Rock(-15, 1, 15, mainStage3D);
        new Rock(-15, 1, 30, mainStage3D);
        new Rock(  0, 1,  0, mainStage3D);
        new Rock(  0, 1, 30, mainStage3D);
        new Rock( 15, 1,  0, mainStage3D);
        new Rock( 15, 1, 15, mainStage3D);
        new Rock( 15, 1, 30, mainStage3D);

        new Starfish( 10, 0, 10, mainStage3D);
        new Starfish( 10, 0, 20, mainStage3D);
        new Starfish(-10, 0, 10, mainStage3D);
        new Starfish(-10, 0, 20, mainStage3D);

        mainStage3D.setCameraPosition(0,10,0);
        mainStage3D.setCameraDirection( new Vector3(0,0,0) );

        starfishLabel = new Label("Starfish left: 4", BaseGame.labelStyle);
        starfishLabel.setColor( Color.CYAN );
        messageLabel = new Label("You Win!", BaseGame.labelStyle);
        messageLabel.setColor( Color.LIME );
        messageLabel.setFontScale(2);
        messageLabel.setVisible(false);

        uiTable.pad(20);
        uiTable.add(starfishLabel);
        uiTable.row();
        uiTable.add(messageLabel).expandY();
    }

    @Override
    public void update(float deltaTime) {

        float speed = 3.0f;
        float rotateSpeed = 45.0f;

        if ( Gdx.input.isKeyPressed(Input.Keys.UP) )
            turtle.moveForward( speed * deltaTime );
        if ( Gdx.input.isKeyPressed(Input.Keys.LEFT) )
            turtle.turn( -rotateSpeed * deltaTime );
        if ( Gdx.input.isKeyPressed(Input.Keys.RIGHT) )
            turtle.turn( rotateSpeed * deltaTime );

        mainStage3D.setCameraDirection( turtle.getPosition() );

        for ( BaseActor3D rock : BaseActor3D.getList( mainStage3D, "com.mygdx.game.Rock") )
            turtle.preventOverlap(rock);

        for ( BaseActor3D starfish : BaseActor3D.getList( mainStage3D, "com.mygdx.game.Starfish") )
            if (turtle.overlaps(starfish) )
                starfish.remove();

        int starfishCount = BaseActor3D.count(mainStage3D, "com.mygdx.game.Starfish");
        starfishLabel.setText( "Starfish left: " + starfishCount );

        if (starfishCount == 0)
            messageLabel.setVisible(true);
    }
}
