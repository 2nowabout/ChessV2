package ai;

import ai.botpieces.BotPieces;
import save_libraries.Move;
import state.SinglePlayerGameState;

import java.util.ArrayList;

public class MinMaxAlgorithm {
    private int depth;
    private ArrayList<BotPieces> botPieces;
    private SinglePlayerGameState state;
    private boolean white;

    private MinAlgorithm minAlgorithm;
    private MaxAlgorithm maxAlgorithm;

    public MinMaxAlgorithm(int depth, SinglePlayerGameState state, boolean white)
    {
        this.white = white;
        this.depth = depth;
        this.state = state;
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
            long endmax = System.nanoTime();
            System.out.println("max algo Done");
            checkAlgoTime(startmax, endmax);
            long startmin = System.nanoTime();
            //min
            long endmin = System.nanoTime();
            System.out.println("one depth done");
            checkAlgoTime(startmin, endmin);

        }

        BotMoves bestMove = null;
        return bestMove.getFirstMove();
    }

    private void checkAlgoTime(long start, long end)
    {
        long time = end - start;
        System.out.println("time: " + time);
    }

}
