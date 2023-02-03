package managers;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import function.GeneratePieces;
import objects.chesspieces.ChessPieces;

import java.util.ArrayList;

public class ChessPieceManager {
    private ArrayList<ChessPieces> white;
    private ArrayList<ChessPieces> black;

    public ChessPieceManager()
    {
        GeneratePieces generatePieces = new GeneratePieces();
        black = generatePieces.generateBlackPieces();
        white = generatePieces.generateWhitePieces();
    }

    public void draw(SpriteBatch batch)
    {
        for (ChessPieces piece: white) {
            piece.render(batch);
        }
        for (ChessPieces piece: black) {
            piece.render(batch);
        }
    }

    public ArrayList<ChessPieces> getBlackPieces() {
        return black;
    }

    public ArrayList<ChessPieces> getWhitePieces() {
        return white;
    }

    public ArrayList<ChessPieces> getAllPieces() {
        ArrayList<ChessPieces> all = new ArrayList<>();
        all.addAll(white);
        all.addAll(black);
        return all;
    }

    public void killChesspiece(ChessPieces chessPiece)
    {
        if(chessPiece.isWhite())
        {
            white.remove(chessPiece);
        }
        else {
            black.remove(chessPiece);
        }
    }

}
