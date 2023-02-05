package ai;

import save_libraries.Move;

import java.util.ArrayList;

public class BotMoves {
    private ArrayList<BotMove> moves;
    private double points;

    public BotMoves()
    {
        moves = new ArrayList<>();
        points = 0;
    }

    public void addMove(BotMove move, double points)
    {
        moves.add(move);
        this.points = this.points + points;
    }

    public void addPreviousMoves(ArrayList<BotMove> moves)
    {
        moves.addAll(moves);
    }

    public BotMove getFirstMove()
    {
        return moves.get(0);
    }

    public ArrayList<BotMove> getMoves() {
        return moves;
    }

    public double getPoints() {
        return points;
    }
}
