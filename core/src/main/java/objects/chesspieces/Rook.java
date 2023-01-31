package objects.chesspieces;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import move_rules.ChessPieceMoves;
import objects.FieldPoints;
import objects.TextureHolder;
import save_libraries.Move;

import java.util.ArrayList;

public class Rook extends ChessPieces {

    private boolean firstmove;

    public Rook(boolean white, int x, int y) {
        super(white, x, y);
        firstmove = true;
        if (white) {
            points = 50;
        } else {
            points = -50;
        }
    }

    @Override
    public void render(SpriteBatch sb) {
        if(white)
        {
            sb.draw(TextureHolder.WhiteRookTexture, renderX, renderY, WIDTH, HEIGHT);
        }
        else {
            sb.draw(TextureHolder.BlackRookTexture, renderX, renderY, WIDTH, HEIGHT);
        }
    }

    @Override
    public void doMove(Move move) {
        if(this.x == move.getOldX() && this.y == move.getOldY())
        {
            if(firstmove)
            {
                firstmove = false;
            }
            this.x = move.getNewX();
            this.y = move.getNewY();
            return;
        }
        throw new IllegalArgumentException("Old Move cordinates dont allign, Hacking?");
    }

    @Override
    public ArrayList<Move> getMoves(ArrayList<ChessPieces> allPieces) {
        return ChessPieceMoves.calcRookMoves(this.x, this.y, this.white, allPieces);
    }

    @Override
    public ArrayList<ArrayList<Double>> getFieldPoints() {
        return FieldPoints.rookPoints();
    }
}
