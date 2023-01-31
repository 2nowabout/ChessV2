package state;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import managers.GameManager;
import managers.MainBordManager;


public class SinglePlayerGameState extends State {

    private GameManager manager;


    public SinglePlayerGameState(GameStateManager gsm) {
        super(gsm);
        manager = new GameManager(true);
    }

    @Override
    protected void handleInput() {

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
