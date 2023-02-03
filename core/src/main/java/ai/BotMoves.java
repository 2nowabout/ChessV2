package ai;

import save_libraries.Move;

import java.util.ArrayList;

public class BotMoves {
    private ArrayList<Move> moves;
    private double points;

    public BotMoves()
    {
        moves = new ArrayList<>();
        points = 0;
    }

    public void addMove(Move move, double points)
    {
        moves.add(move);
        this.points = this.points + points;
    }

    public Move getFirstMove()
    {
        return moves.get(0);
    }

    public ArrayList<Move> getMoves() {
        return moves;
    }
}
