package objects.chessPieces;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import moveRules.ChessPieceMoves;
import objects.FieldPoints;
import objects.TextureHolder;
import saveLibraries.Move;

import java.util.ArrayList;

public class Bishop extends ChessPieces {
    public Bishop(boolean white, int x, int y) {
        super(white, x, y);
        if (white) {
            points = 30;
        } else {
            points = -30;
        }
    }

    @Override
    public void render(SpriteBatch sb) {
        if(white)
        {
            sb.draw(TextureHolder.WhiteBishopTexture, renderX, renderY, WIDTH, HEIGHT);
        }
        else {
            sb.draw(TextureHolder.BlackBishopTexture, renderX, renderY, WIDTH, HEIGHT);
        }
    }

    @Override
    public void update(float dt) {

    }

    @Override
    public void doMove(Move move) {
        if(this.x == move.getOldX() && this.y == move.getOldY())
        {
            this.x = move.getNewX();
            this.y = move.getNewY();
        }
        throw new IllegalArgumentException("Old Move cordinates dont allign, Hacking?");

    }

    @Override
    public ArrayList<Move> getMoves(ArrayList<ChessPieces> allPieces) {
        return ChessPieceMoves.calcBishopMoves(this.x, this.y, this.white, allPieces);
    }

    @Override
    public ArrayList<ArrayList<Double>> getFieldPoints() {
        return FieldPoints.BishopPoints();
    }
}
