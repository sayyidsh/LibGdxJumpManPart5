package pro.nanosystems.jumpman;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class JumpMan extends ApplicationAdapter {
    SpriteBatch batch;
    Texture background;
    Texture[] man;
    int manState = 0;
    int pause = 0;
    // TODO (1) declare Gravity variable: float gravity = 0.2f;
    float gravity = 0.2f;
    // TODO (2) declare Velocity variable: float velocity = 0;
    float velocity = 0;
    // TODO (3) declare manY variable: int manY = 0;
    int manY = 0;

    @Override
    public void create() {
        batch = new SpriteBatch();
        background = new Texture("bg.png");
        man = new Texture[4];
        man[0] = new Texture("frame-1.png");
        man[1] = new Texture("frame-2.png");
        man[2] = new Texture("frame-3.png");
        man[3] = new Texture("frame-4.png");
        // TODO (4) Initial manY default value: manY = Gdx.graphics.getHeight() / 2 - man[manState].getHeight() / 2;
        manY = Gdx.graphics.getHeight() / 2 - man[manState].getHeight() / 2;
    }

    @Override
    public void render() {
        batch.begin();
        // draw scene
        batch.draw(background, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        // TODO (5) Check on Touch Scree and subtract 10 from  velocity
        if (Gdx.input.justTouched()) { // -- on Touch Screen.
            velocity = -10;
        }
        // TODO (6) Append new gravity to Current velocity
        velocity += gravity;
        // TODO (7) subtract  velocity from manY
        //  manY = manY - (int)velocity;
        manY -= velocity;
        // TODO (8) Control manY to be greater than 0
        if (manY <= 0) {
            manY = 0;
        }

        if (pause < 8) {// To delay move.
            pause++;
        } else {
            pause = 0;
            if (manState < 3) {
                manState++;
            } else manState = 0;
        }

       // TODO (9) change Initial Y position  to manY
        batch.draw(man[manState],
                Gdx.graphics.getWidth() / 2 - man[manState].getWidth() / 2,
                manY);


        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        background.dispose();
        for (int i = 0; i < 4; i++) {
            man[i].dispose();
        }

    }
}
