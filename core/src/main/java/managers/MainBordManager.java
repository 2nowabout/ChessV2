package managers;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import function.GenerateBord;
import objects.Tile;

import java.util.ArrayList;

public class MainBordManager {

    private ArrayList<Tile> bord;

    private BitmapFont font;

    public MainBordManager(boolean white) {
        GenerateBord generator = new GenerateBord();
        bord = generator.generate(white);
        font = new BitmapFont();
    }

    public void draw(SpriteBatch batch)
    {
        for (Tile tile: bord) {
            tile.render(batch, font);
        }
    }

    public ArrayList<Tile> getBord() {
        return bord;
    }
}
