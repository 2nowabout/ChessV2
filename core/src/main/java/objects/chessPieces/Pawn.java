package objects.chessPieces;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import moveRules.ChessPieceMoves;
import objects.FieldPoints;
import objects.TextureHolder;
import saveLibraries.Move;

import java.util.ArrayList;

public class Pawn extends ChessPieces {

    private boolean firstmove;

    public Pawn(boolean white, int x, int y) {
        super(white, x, y);
        firstmove = true;
        points = 10;
    }

    @Override
    public void render(SpriteBatch sb) {
        if(white)
        {
            sb.draw(TextureHolder.WhitePawnTexture, renderX, renderY, WIDTH, HEIGHT);
        }
        else {
            sb.draw(TextureHolder.BlackPawnTexture, renderX, renderY, WIDTH, HEIGHT);
        }
    }

    @Override
    public void update(float dt) {

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
        }
        throw new IllegalArgumentException("Old Move cordinates dont allign, Hacking?");
    }

    @Override
    public ArrayList<Move> getMoves(ArrayList<ChessPieces> allPieces) {
        return ChessPieceMoves.calcPawnMoves(x,y,white,allPieces,firstmove);
    }

    @Override
    public ArrayList<ArrayList<Double>> getFieldPoints() {

        return FieldPoints.PawnPoints();
    }

}
