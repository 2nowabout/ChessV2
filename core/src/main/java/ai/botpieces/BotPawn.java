package ai.botpieces;

import move_rules.ChessPieceMoves;
import objects.FieldPoints;
import objects.chesspieces.ChessPieces;
import save_libraries.Move;

import java.util.ArrayList;

public class BotPawn extends BotPieces {
    public BotPawn(boolean white, int x, int y, boolean firstmove) {
        super(white, x, y, firstmove);
        points = 10;
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
    public ArrayList<Move> getMoves(ArrayList<BotPieces> allPieces) {
        return ChessPieceMoves.calcPawnMoves(this.x, this.y, this.white, allPieces, firstmove);
    }

    @Override
    public double getFieldPoints(int x, int y) {
        return FieldPoints.pawnPoints().get(y -1).get(x -1);
    }

    @Override
    public BotPieces copyPiece() {
        return new BotPawn(this.white, this.x, this.y, this.firstmove);
    }
}
