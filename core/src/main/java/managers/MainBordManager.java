package managers;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import function.GenerateBord;
import objects.Tile;

import java.util.ArrayList;

public class MainBordManager {

    private ArrayList<Tile> bord;

    public MainBordManager() {
        GenerateBord generator = new GenerateBord();
        bord = generator.generate();
    }

    public void draw(SpriteBatch batch)
    {
        for (Tile tile: bord) {
            tile.render(batch);
        }
    }
}
