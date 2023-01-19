package managers;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import function.generateBord;
import objects.Tile;

import java.util.ArrayList;

public class MainBordManager {

    private ArrayList<Tile> bord;

    public MainBordManager() {
        generateBord generator = new generateBord();
        bord = generator.generate();
    }

    public void draw(SpriteBatch batch)
    {
        for (Tile tile: bord) {
            tile.render(batch);
        }
    }
}
