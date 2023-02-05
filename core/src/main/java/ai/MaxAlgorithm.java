package ai;

import ai.botpieces.BotPieces;
import save_libraries.Move;

import java.util.ArrayList;

public class MaxAlgorithm {
    private BotCalcAllMoves calcAllMoves;

    public MaxAlgorithm() {
        calcAllMoves = new BotCalcAllMoves();
    }

    public ArrayList<BotMoves> algorithm(ArrayList<BotPieces> botPieces, ArrayList<BotMoves> botMoves, boolean white) {
        ArrayList<BotMoves> goodMoves = new ArrayList<>();
        System.out.println("max botmoves recieved: " + botMoves.size());
        if (!botMoves.isEmpty()) {
            for (BotMoves move : botMoves) {
                ArrayList<BotPieces> copiedPieces = prepare(botPieces, move);
                goodMoves.addAll(calcAllMoves.calcAllMovesMax(move, copiedPieces, white));
            }
        }
        else {
            goodMoves = calcAllMoves.calcAllMovesMax(null, botPieces, white);
        }
        double average = 0;
        for (BotMoves moves: goodMoves) {
            average = average + moves.getPoints();
        }
        average = average / goodMoves.size();
        ArrayList<BotMoves> toRemove = new ArrayList<>();
        for (BotMoves moves: goodMoves) {
            if(moves.getPoints() < average)
            {
                toRemove.add(moves);
            }
        }
        goodMoves.removeAll(toRemove);
        return goodMoves;
    }

    private ArrayList<BotPieces> prepare(ArrayList<BotPieces> botPieces, BotMoves botMoves) {
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

