package managers;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import function.GenerateBord;
import objects.Tile;

import java.util.ArrayList;

public class MainBordManager {

    private ArrayList<Tile> bord;

    public MainBordManager(boolean white) {
        GenerateBord generator = new GenerateBord();
        if(white) {
            bord = generator.generateWhiteView();
        }
        else {
            bord = generator.generateBlackView();
        }

    }

    public void draw(SpriteBatch batch)
    {
        for (Tile tile: bord) {
            tile.render(batch);
        }
    }

    public ArrayList<Tile> getBord() {
        return bord;
    }
}
