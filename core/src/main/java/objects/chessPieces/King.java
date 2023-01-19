package objects.chessPieces;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import moveRules.ChessPieceMoves;
import objects.FieldPoints;
import objects.TextureHolder;
import saveLibraries.Move;

import java.util.ArrayList;

public class King extends ChessPieces {
    public King(boolean white, int x, int y) {
        super(white, x, y);
        if (white) {
            points = 900;
        } else {
            points = -900;
        }
    }

    @Override
    public void render(SpriteBatch sb) {
        if(white)
        {
            sb.draw(TextureHolder.WhiteKingTexture, renderX, renderY, WIDTH, HEIGHT);
        }
        else {
            sb.draw(TextureHolder.BlackKingTexture, renderX, renderY, WIDTH, HEIGHT);
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
        return ChessPieceMoves.calcKingMoves(this.x, this.y, this.white, allPieces);
    }

    @Override
    public ArrayList<ArrayList<Double>> getFieldPoints() {
        return FieldPoints.KingPoints();
    }
}
