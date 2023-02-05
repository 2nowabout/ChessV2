package ai;

import ai.botpieces.BotPieces;

import java.util.ArrayList;

public class BotGetAllAllyPieces {

    public BotGetAllAllyPieces()
    {

    }

    public ArrayList<BotPieces> getAllyPieces(ArrayList<BotPieces> allPieces, boolean white)
    {
        ArrayList<BotPieces> allyPieces = new ArrayList<>();
        for (BotPieces piece: allPieces) {
            if(white == piece.isWhite())
            {
                allyPieces.add(piece);
            }
        }
        return allyPieces;
    }
}
