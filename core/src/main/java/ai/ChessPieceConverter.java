package ai;

import ai.botpieces.BotPieces;
import objects.chesspieces.ChessPieces;

import java.util.ArrayList;

public class ChessPieceConverter {
    private ChessPieceConverter() { //sonarcloud
    }

    public static ArrayList<BotPieces> convertChessPieces(ArrayList<ChessPieces> pieces)
    {
        ArrayList<BotPieces> botPieces = new ArrayList<>();
        for (ChessPieces piece: pieces) {
            botPieces.add(piece.makeCopy());
        }
        return botPieces;
    }
}
