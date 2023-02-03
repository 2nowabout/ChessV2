package objects.chesspieces;

import ai.botpieces.BotPawn;
import ai.botpieces.BotPieces;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import move_rules.ChessPieceMoves;
import objects.FieldPoints;
import objects.TextureHolder;
import save_libraries.Move;
import save_libraries.Position;

import java.awt.*;
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
    public void doMove(Move move, Position renderPosition) {
        if(this.x == move.getOldX() && this.y == move.getOldY())
        {
            if(firstmove)
            {
                firstmove = false;
            }
            this.x = move.getNewX();
            this.y = move.getNewY();
            this.renderX = renderPosition.getX();
            this.renderY = renderPosition.getY();
            rectangle = new Rectangle(renderX, renderY, WIDTH, HEIGHT);
            return;
        }
        throw new IllegalArgumentException("Old Move cordinates dont allign, Hacking?");
    }

    @Override
    public ArrayList<Move> getMoves(ArrayList<ChessPieces> allPieces) {
        return ChessPieceMoves.calcPawnMoves(x,y,white,allPieces,firstmove);
    }

    @Override
    public ArrayList<ArrayList<Double>> getFieldPoints() {

        return FieldPoints.pawnPoints();
    }

    @Override
    public BotPieces makeCopy() {
        return new BotPawn(this.white, this.x, this.y, this.firstmove);
    }

}
