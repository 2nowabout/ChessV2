package interfaces;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.awt.*;

public interface IButtons {
    void update(float dt);
    void render(SpriteBatch sb);
    void dispose();
    Rectangle getRectangle();
    String getString();
}
