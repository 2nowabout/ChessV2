package ai.botpieces;

import move_rules.ChessPieceMoves;
import objects.FieldPoints;
import objects.chesspieces.ChessPieces;
import save_libraries.Move;

import java.util.ArrayList;

public class BotQueen extends BotPieces {
    public BotQueen(boolean white, int x, int y, boolean firstmove) {
        super(white, x, y, firstmove);
        points = 90;
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
    public ArrayList<Move> getMoves(ArrayList<BotPieces> allPieces) {
        return ChessPieceMoves.calcQueenMoves(this.x, this.y, this.white, allPieces);
    }

    @Override
    public double getFieldPoints(int x, int y) {
            return FieldPoints.queenPoints().get(y - 1).get(x - 1);
    }

    @Override
    public BotPieces copyPiece() {
        return new BotQueen(this.white, this.x, this.y, this.firstmove);
    }
}
