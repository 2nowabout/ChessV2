package state;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import managers.MainBordManager;


public class SinglePlayerGameState extends State {

    private GameStateManager gsm;
    private MainBordManager bordManager;


    protected SinglePlayerGameState(GameStateManager gsm) {
        super(gsm);
        this.gsm = gsm;
        bordManager = new MainBordManager();
    }

    @Override
    protected void handleInput() {

    }

    @Override
    public void update(float dt) {

    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        bordManager.draw(sb);
        sb.end();
    }

    @Override
    public void dispose() {

    }
}
