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
    private boolean local;
    private boolean singlePlayer;
    private boolean whiteTurn;
    boolean firstclick = true;
    public GameManager(boolean white, boolean local, boolean singlePlayer)
    {
        this.white = white;
        this.local = local;
        this.whiteTurn = true;
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
                        tile.setCanMoveHere(move.isAttack());
                        canMoveHere.add(tile);
                    }
                }
            }
        }
        else {
            for (Tile tile: canMoveHere) {
                if(tile.isClicked(mouseRectangle))
                {
                    if(tile.isPossibleAttack())
                    {
                        for (ChessPieces chesspiece : chessPieceManager.getAllPieces()) {
                            if(chesspiece.getPosition().getX() == tile.getPosition().getX() && chesspiece.getPosition().getY() == tile.getPosition().getY())
                            {
                                chessPieceManager.killChesspiece(chesspiece);
                            }
                        }
                    }
                    Move move = new Move(clickedPiece.getPosition().getX(), clickedPiece.getPosition().getY(), tile.getPosition().getX(), tile.getPosition().getY(), true); //attack doesn't matter here
                    clickedPiece.doMove(move, tile.getRenderPosition());
                    reset();
                    if(local)
                    {
                        whiteTurn = !whiteTurn;
                    }
                    if(singlePlayer)
                    {
                        //bot do turn
                    }
                    return;
                }
            }
            reset();
            clicked(mouseRectangle);
        }
    }


    private ArrayList<ChessPieces> loadClickablePieces()
    {
        if(local)
        {
            if(whiteTurn) {
                return chessPieceManager.getWhitePieces();
            }
            else {
                return chessPieceManager.getBlackPieces();
            }
        }
        else {
            if (white) {
                return chessPieceManager.getWhitePieces();
            } else {
                return chessPieceManager.getBlackPieces();
            }
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
