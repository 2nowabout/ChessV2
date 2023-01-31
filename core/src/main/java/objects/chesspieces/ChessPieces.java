package objects.chesspieces;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import save_libraries.Move;
import save_libraries.Position;

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

    protected ChessPieces(boolean white, int x, int y)
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
    public void update(float dt, int renderX, int renderY)
    {
        this.renderX = renderX;
        this.renderY = renderY;
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

    public abstract void doMove(Move move, Position renderPosition);

    public abstract ArrayList<Move> getMoves(ArrayList<ChessPieces> allPieces);

    public abstract ArrayList<ArrayList<Double>> getFieldPoints();

    public boolean isClicked(Rectangle mouse)
    {
        if(mouse.intersects(rectangle))
        {
            return true;
        }
        return false;
    }
}
