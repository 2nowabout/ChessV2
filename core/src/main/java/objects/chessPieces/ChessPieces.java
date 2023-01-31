package objects.chessPieces;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import moveRules.ChessPieceMoves;
import saveLibraries.Move;
import saveLibraries.Position;

import java.awt.*;
import java.util.ArrayList;

public abstract class ChessPieces {
    protected static final int WIDTH = 100;
    protected static final int HEIGHT = 100;

    protected boolean white;

    protected int points;

    protected int x;
    protected int y;

    protected int renderX;
    protected int renderY;

    protected Rectangle rectangle;
    protected ArrayList<Position> possibleMoves;

    public ChessPieces(boolean white, int x, int y)
    {
        this.white = white;
        this.x = x;
        this.y = y;
    }

    public void updateLocation(int x, int y, int renderX, int renderY)
    {
        this.x = x;
        this.y = y;
        this.renderX = renderX;
        this.renderY = renderY;
        this.rectangle = new Rectangle(renderX, renderY, WIDTH, HEIGHT);
    }

    public abstract void render(SpriteBatch sb);
    public abstract void update(float dt, int renderX, int renderY);
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

    public abstract ArrayList<Move> getMoves(ArrayList<ChessPieces> allPieces);

    public abstract ArrayList<ArrayList<Double>> getFieldPoints();
}
