package ai;

import ai.botpieces.BotPieces;

import java.util.ArrayList;

public class BotGetTeamPieces {

    public BotGetTeamPieces()
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

    public ArrayList<BotPieces> getEnemyPieces(ArrayList<BotPieces> allPieces, boolean white)
    {
        ArrayList<BotPieces> enemyPieces = new ArrayList<>();
        for (BotPieces piece: allPieces) {
            if(white != piece.isWhite())
            {
                enemyPieces.add(piece);
            }
        }
        return enemyPieces;
    }
}
