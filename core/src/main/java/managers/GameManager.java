package managers;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import function.AssignStartLocation;
import objects.Tile;
import objects.chesspieces.ChessPieces;
import save_libraries.Move;

import java.awt.*;
import java.util.ArrayList;

public class GameManager {

    private ArrayList<Tile> canMoveHere;
    private ChessPieces clickedPiece;
    private ChessPieceManager chessPieceManager;
    private MainBordManager mainBordManager;
    private boolean white;
    boolean firstclick = true;
    public GameManager(boolean white)
    {
        this.white = white;
        canMoveHere = new ArrayList<>();
        this.chessPieceManager = new ChessPieceManager();
        this.mainBordManager = new MainBordManager(white);
        AssignStartLocation assignStartLocation = new AssignStartLocation();
        assignStartLocation.assignStartRenderLocation(chessPieceManager.getAllPieces(), mainBordManager.getBord());
    }

    public void draw(SpriteBatch batch)
    {
        mainBordManager.draw(batch);
        chessPieceManager.draw(batch);
    }

    public void clicked(Rectangle mouseRectangle)
    {
        if(firstclick) {
            ArrayList<ChessPieces> clickablePieces = loadClickablePieces();
            ArrayList<Move> allmoves = getAllMovesFromPiece(clickablePieces, mouseRectangle);
            if(allmoves == null)
            {
                return;
            }
            firstclick = false;
            for (Tile tile: mainBordManager.getBord()) {
                for (Move move: allmoves) {
                    if(move.getNewX() == tile.getPosition().getX() && move.getNewY() == tile.getPosition().getY())
                    {
                        tile.setCanMoveHere();
                        canMoveHere.add(tile);
                    }
                }
            }
        }
        else {
            for (Tile tile: canMoveHere) {
                if(tile.isClicked(mouseRectangle))
                {
                    Move move = new Move(clickedPiece.getPosition().getX(), clickedPiece.getPosition().getY(), tile.getPosition().getX(), tile.getPosition().getY());
                    clickedPiece.doMove(move, tile.getRenderPosition());
                    reset();
                    return;
                }
            }
            reset();
            clicked(mouseRectangle);
        }
    }


    private ArrayList<ChessPieces> loadClickablePieces()
    {
        if (white) {
            return chessPieceManager.getWhitePieces();
        }
        else {
            return chessPieceManager.getBlackPieces();
        }
    }
    private ArrayList<Move> getAllMovesFromPiece(ArrayList<ChessPieces> clickablePieces, Rectangle mouse) {
        for (ChessPieces chesspiece : clickablePieces) {
            if (chesspiece.isClicked(mouse)) {
                clickedPiece = chesspiece;
                return chesspiece.getMoves(chessPieceManager.getAllPieces());
            }
        }
        return null;
    }

    private void reset()
    {
        for (Tile tile: canMoveHere) {
            tile.resetTileEffects();
        }
        canMoveHere = new ArrayList<>();
        firstclick = true;
    }
}
