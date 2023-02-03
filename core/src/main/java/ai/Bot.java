package ai;

import ai.botpieces.BotPieces;
import objects.chesspieces.ChessPieces;
import state.SinglePlayerGameState;

import java.util.ArrayList;

public class Bot {

    public Bot(int depth, SinglePlayerGameState state, boolean white)
    {

    }

    public void run(ArrayList<ChessPieces> allPieces, boolean white)
    {
        ArrayList<BotPieces> botPieces = ChessPieceConverter.convertChessPieces(allPieces);
    }
}
