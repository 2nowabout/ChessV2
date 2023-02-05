package objects.chesspieces;

import ai.ChessPieceConverter;
import ai.botpieces.BotPieces;
import ai.botpieces.BotQueen;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import move_rules.ChessPieceMoves;
import objects.FieldPoints;
import objects.TextureHolder;
import save_libraries.Move;
import save_libraries.Position;

import java.awt.*;
import java.util.ArrayList;

public class Queen extends ChessPieces {
    public Queen(boolean white, int x, int y) {
        super(white, x, y);
        points = 90;
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
    public void doMove(Move move, Position renderPosition) {
        if(this.x == move.getOldX() && this.y == move.getOldY())
        {
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
        return ChessPieceMoves.calcQueenMoves(this.x, this.y, white, ChessPieceConverter.convertChessPieces(allPieces));
    }

    @Override
    public double getFieldPoints(int x, int y) {
        return FieldPoints.queenPoints().get(y -1).get(x -1);
    }

    @Override
    public BotPieces makeCopy() {
        return new BotQueen(this.white, this.x, this.y, false);
    }
}
