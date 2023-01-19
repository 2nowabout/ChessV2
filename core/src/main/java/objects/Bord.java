package objects;

import java.util.ArrayList;

public class Bord {
    private ArrayList<Tile> tiles;

    public Bord(ArrayList<Tile> bord)
    {
        this.tiles = bord;
    }

    public Tile getTile(int x, int y)
    {
        for (Tile tile: tiles) {
            if(tile.isThisCorrectTile(x, y))
            {
                return tile;
            }
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public ArrayList<Tile> returnBord()
    {
        return tiles;
    }
}
