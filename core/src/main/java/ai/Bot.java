package ai;

import ai.botpieces.BotPieces;
import objects.chesspieces.ChessPieces;
import save_libraries.Move;
import state.SinglePlayerGameState;

import java.util.ArrayList;

public class Bot {
    private MinMaxAlgorithm algorithm;

    public Bot(int depth, boolean white)
    {
        algorithm = new MinMaxAlgorithm(depth, white);
    }

    public Move run(ArrayList<ChessPieces> allPieces)
    {
        ArrayList<BotPieces> botPieces = ChessPieceConverter.convertChessPieces(allPieces);
        return algorithm.run(botPieces);
    }
}
