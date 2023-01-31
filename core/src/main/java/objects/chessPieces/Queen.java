package objects.chessPieces;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import moveRules.ChessPieceMoves;
import objects.FieldPoints;
import objects.TextureHolder;
import saveLibraries.Move;

import java.util.ArrayList;

public class Queen extends ChessPieces {
    public Queen(boolean white, int x, int y) {
        super(white, x, y);
        if (white) {
            points = 90;
        } else {
            points = -90;
        }
    }

    @Override
    public void render(SpriteBatch sb) {
        if(white)
        {
            sb.draw(TextureHolder.WhiteQueenTexture, renderX, renderY, WIDTH, HEIGHT);
        }
        else {
            sb.draw(TextureHolder.BlackQueenTexture, renderX, renderY, WIDTH, HEIGHT);
        }
    }

    @Override
    public void update(float dt, int renderX, int renderY) {
        this.renderX = renderX;
        this.renderY = renderY;
    }

    @Override
    public void doMove(Move move) {
        if(this.x == move.getOldX() && this.y == move.getOldY())
        {
            this.x = move.getNewX();
            this.y = move.getNewY();
            return;
        }
        throw new IllegalArgumentException("Old Move cordinates dont allign, Hacking?");
    }

    @Override
    public ArrayList<Move> getMoves(ArrayList<ChessPieces> allPieces) {
        return ChessPieceMoves.calcQueenMoves(this.x, this.y, white, allPieces);
    }

    @Override
    public ArrayList<ArrayList<Double>> getFieldPoints() {
        return FieldPoints.QueenPoints();
    }
}
