package ai;

import ai.botpieces.BotPieces;
import save_libraries.Move;

import java.util.ArrayList;

public class MaxAlgorithm {
    private BotCalcAllMoves calcAllMoves;

    public MaxAlgorithm() {
        calcAllMoves = new BotCalcAllMoves();
    }

    public void algorithm(ArrayList<BotPieces> botPieces, ArrayList<BotMoves> botMoves, boolean white) {
        ArrayList<Move> goodMoves = new ArrayList<>();
        if (!botMoves.isEmpty()) {
            for (BotMoves move : botMoves) {
                ArrayList<BotPieces> copiedPieces = prepare(botPieces, move);
                calcAllMoves.calcAllMoves(move, copiedPieces, white, true);
            }
        }
    }

    public ArrayList<BotPieces> prepare(ArrayList<BotPieces> botPieces, BotMoves botMoves) {
        //preparation
        ArrayList<BotPieces> copiedList = new ArrayList<>();
        for (BotPieces piece : botPieces) {
            copiedList.add(piece.copyPiece());
        }
        for (BotMove move : botMoves.getMoves()) {
            BotPieces pieceToRemove = null;
            for (BotPieces piece : copiedList) {
                if (move.isAttack()) {
                    if (piece.getPosition().getX() == move.getNewX() && piece.getPosition().getY() == move.getNewY()) {
                        pieceToRemove = piece;
                    }
                }
                if (piece.getPosition().getX() == move.getOldX() && piece.getPosition().getY() == move.getOldY()) {
                    piece.doMove(new Move(move.getOldX(), move.getOldY(), move.getNewX(), move.getNewY(), move.isAttack()));
                }
            }
            if (pieceToRemove != null) {
                copiedList.remove(pieceToRemove);
            }
        }
        return copiedList;
    }
}

