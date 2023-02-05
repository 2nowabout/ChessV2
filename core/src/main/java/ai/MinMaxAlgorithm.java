package ai;

import ai.botpieces.BotPieces;
import save_libraries.Move;
import state.SinglePlayerGameState;

import java.util.ArrayList;

public class MinMaxAlgorithm {
    private int depth;
    private boolean white;

    private MinAlgorithm minAlgorithm;
    private MaxAlgorithm maxAlgorithm;

    public MinMaxAlgorithm(int depth, boolean white)
    {
        this.white = white;
        this.depth = depth;
        minAlgorithm = new MinAlgorithm();
        maxAlgorithm = new MaxAlgorithm();
    }

    public Move run(ArrayList<BotPieces> pieces)
    {
        ArrayList<BotMoves> botMoves = new ArrayList<>();

        System.out.println("start algo");
        for (int i = 0; i < depth; i++) {
            long startmax = System.nanoTime();
            //max
            botMoves = maxAlgorithm.algorithm(pieces, botMoves, white);
            System.out.println(botMoves.size());
            long endmax = System.nanoTime();
            System.out.println("max algo Done");
            checkAlgoTime(startmax, endmax);
            long startmin = System.nanoTime();
            //min
            botMoves = minAlgorithm.algorithm(pieces, botMoves, white);
            System.out.println(botMoves.size());
            long endmin = System.nanoTime();
            System.out.println("one depth done");
            checkAlgoTime(startmin, endmin);
        }
        BotMoves bestMove = new BotMoves();
        bestMove.addMove(new BotMove(0,0,0,0,false, 0), 0);
        for (BotMoves botMove: botMoves) {
            if(botMove.getPoints() > bestMove.getPoints())
            {
                bestMove = botMove;
            }
        }
        return new Move(bestMove.getFirstMove().getOldX(),bestMove.getFirstMove().getOldY(),bestMove.getFirstMove().getNewX(),bestMove.getFirstMove().getNewY(), bestMove.getFirstMove().isAttack());
    }

    private void checkAlgoTime(long start, long end)
    {
        long time = end - start;
        System.out.println("time: " + time);
    }

}
