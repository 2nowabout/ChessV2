package state;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import managers.GameManager;

import java.awt.*;

public class LocalGameState extends State {

    private GameManager manager;
    public LocalGameState(GameStateManager gsm) {
        super(gsm);
        manager = new GameManager(true, true, false);
    }

    @Override
    protected void handleInput() {
        Rectangle mouseRectangle = new Rectangle(Gdx.input.getX(), Gdx.input.getY(), 1, 1); //get mouse position
        mouseRectangle.y = Gdx.graphics.getHeight() - mouseRectangle.y; // invert y, this is already inverted in the game
        if (Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)) {
            manager.clicked(mouseRectangle);
        }
    }

    @Override
    public void update(float dt) {
        handleInput();
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        manager.draw(sb);
        sb.end();
    }

    @Override
    public void dispose() {

    }
}
