package ai.botpieces;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import save_libraries.Move;
import save_libraries.Position;

import java.awt.*;
import java.util.ArrayList;

public abstract class BotPieces {

    protected boolean white;
    protected int points;

    protected int x;
    protected int y;
    protected ArrayList<Position> possibleMoves;

    protected boolean firstmove;

    protected BotPieces(boolean white, int x, int y, boolean firstmove)
    {
        this.firstmove = firstmove;
        this.white = white;
        this.x = x;
        this.y = y;
    }
    public boolean isWhite(){
        return white;
    }
    public Position getPosition() {
        return new Position(x, y);
    }

    public int getPoints() {
        return points;
    }

    public abstract void doMove(Move move);

    public abstract ArrayList<Move> getMoves(ArrayList<BotPieces> allPieces);

    public abstract double getFieldPoints(int x, int y);

    public abstract BotPieces copyPiece();

}

