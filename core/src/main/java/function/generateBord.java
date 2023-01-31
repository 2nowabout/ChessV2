package function;

import objects.Tile;

import java.util.ArrayList;

public class GenerateBord {
    private ArrayList<Tile> bord;

    public GenerateBord() {
        bord = new ArrayList<>();
    }

    public ArrayList<Tile> generate(boolean white)
    {
        int originalyPos;
        if (white) {
            originalyPos = 180;
        }
        else {
            originalyPos = 880;
        }
        int originalxPos = 560;
        int xPos = originalxPos;
        int yPos = originalyPos;
        boolean whiteTile = false;

        for (int y = 1; y < 9; y++) {
            for (int x = 1; x < 9; x++) {
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
                    if(white) {
                        yPos = yPos + 100;
                    } else {
                        yPos = yPos - 100;
                    }
                    whiteTile = y % 2 != 0;
                } else {
                    xPos = xPos + 100;
                }
            }
        }
        return bord;
    }
}
