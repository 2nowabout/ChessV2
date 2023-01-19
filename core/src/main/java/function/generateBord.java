package function;

import objects.Tile;
import objects.chessPieces.*;

import java.util.ArrayList;
import java.util.List;

public class generateBord {
    private ArrayList<Tile> bord;

    public generateBord() {
        bord = new ArrayList<>();
    }

    public ArrayList<Tile> generate()
    {
        int originalyPos = 840;
        int originalxPos = 560;
        int xPos = originalxPos;
        int yPos = originalyPos;
        boolean whiteTile = true;

        for (int y = 0; y < 8; y++) {
            for (int x = 0; x < 8; x++) {
                if (whiteTile) {
                    Tile tile = new Tile(whiteTile, xPos, yPos, x, y);
                    bord.add(tile);

                    whiteTile = false;
                } else {
                    Tile tile = new Tile(whiteTile, xPos, yPos, x, y);
                    bord.add(tile);
                    whiteTile = true;
                }
                if (xPos >= 1260) {
                    xPos = originalxPos;
                    yPos = yPos - 100;
                    if (y % 2 == 0) {
                        whiteTile = false;
                    } else {
                        whiteTile = true;
                    }
                } else {
                    xPos = xPos + 100;
                }
            }
        }
        return bord;
    }
}
