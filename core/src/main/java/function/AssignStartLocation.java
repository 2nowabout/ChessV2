package function;

import objects.Tile;
import objects.chesspieces.ChessPieces;

import java.util.ArrayList;

public class AssignStartLocation {
    public AssignStartLocation() { //sonarcloud wanted this
        }

    public void assignStartRenderLocation(ArrayList<ChessPieces> chessPieces, ArrayList<Tile> bord)
    {
        for (ChessPieces chesspiece: chessPieces) {
            for (Tile tile: bord) {
                if(chesspiece.getPosition().equals(tile.getPosition())) {
                    chesspiece.updateLocation(tile.getPosition().getX(),tile.getPosition().getY(),tile.getRenderPosition().getX(),tile.getRenderPosition().getY());
                }
            }
        }
    }
}
