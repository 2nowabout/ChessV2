package state;


import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class LocalGameState extends State {

    private GameStateManager gsm;

    protected LocalGameState(GameStateManager gsm) {
        super(gsm);
        this.gsm = gsm;

    }

    @Override
    protected void handleInput() {

    }

    @Override
    public void update(float dt) {

    }

    @Override
    public void render(SpriteBatch sb) {

    }

    @Override
    public void dispose() {

    }
}
