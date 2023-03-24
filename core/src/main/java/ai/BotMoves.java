package ai;

import save_libraries.Move;

import java.util.ArrayList;

public class BotMoves {
    private ArrayList<BotMove> moves;
    private double points;
    private double lastAdded;

    public BotMoves()
    {
        moves = new ArrayList<>();
        points = 0;
    }

    public void addMove(BotMove move, double points)
    {
        moves.add(move);
        lastAdded = points;
        this.points = this.points + points;
    }

    public void addPreviousMoves(ArrayList<BotMove> moves, double point)
    {
        this.points = point;
        this.moves.addAll(moves);
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

    public double getLastAdded() {
        return lastAdded;
    }
}
