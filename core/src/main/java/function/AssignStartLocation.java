package function;

import objects.Tile;
import objects.chessPieces.ChessPieces;

import java.util.ArrayList;

public class AssignStartLocation {
    public AssignStartLocation() {}

    public void AssignStartRenderLocation(ArrayList<ChessPieces> chessPieces, ArrayList<Tile> bord)
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
