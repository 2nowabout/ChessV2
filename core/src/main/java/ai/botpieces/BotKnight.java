package ai.botpieces;

import move_rules.ChessPieceMoves;
import objects.FieldPoints;
import objects.chesspieces.ChessPieces;
import save_libraries.Move;

import java.util.ArrayList;

public class BotKnight extends BotPieces {
    public BotKnight(boolean white, int x, int y, boolean firstmove) {
        super(white, x, y, firstmove);
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
        return ChessPieceMoves.calcKnightMoves(this.x, this.y, this.white, allPieces);
    }

    @Override
    public ArrayList<ArrayList<Double>> getFieldPoints() {
        return FieldPoints.knightPoints();
    }
}
