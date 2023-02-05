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
        for (BotPieces piece: botPieces) {
            copiedList.add(piece.copyPiece());
        }
        BotPieces enemyToRemove = null;
        for (Move move : botMoves.getMoves()) {
            for (BotPieces piece : copiedList) {
                if(move.isAttack())
                {
                    for (BotPieces enemy: copiedList) {
                        if(enemy.getPosition().getX() == move.getNewX() && enemy.getPosition().getY() == move.getNewY())
                        {
                            enemyToRemove = enemy;
                        }
                    }
                }
                if (piece.getPosition().getX() == move.getOldX() && piece.getPosition().getY() == move.getOldY()) {
                    piece.doMove(move);
                }
            }
            if(enemyToRemove != null) {
                copiedList.remove(enemyToRemove);
            }
        }
        return copiedList;
    }
}

