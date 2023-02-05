package ai;

import ai.botpieces.BotPieces;
import save_libraries.Move;

import java.util.ArrayList;

public class BotCalcAllMoves {
    private BotGetTeamPieces getTeamPieces;

    public BotCalcAllMoves() {
        getTeamPieces = new BotGetTeamPieces();
    }

    public ArrayList<BotMoves> calcAllMovesMax(BotMoves previousMove, ArrayList<BotPieces> allPieces, boolean white) {
        ArrayList<BotPieces> allyPieces = getTeamPieces.getAllyPieces(allPieces, white);
        ArrayList<BotMoves> newMoves = new ArrayList<>();
        for (BotPieces allypiece : allyPieces) {
            ArrayList<Move> moves = allypiece.getMoves(allPieces);
            if(moves != null) {
                for (Move move : moves) {
                    if (move.isAttack()) {
                        for (BotPieces pieces : getTeamPieces.getEnemyPieces(allPieces, white)) {
                            if (move.getNewX() == pieces.getPosition().getX() && move.getNewY() == pieces.getPosition().getY()) {
                                BotMoves newMove = new BotMoves();
                                BotMove botMove;
                                if (previousMove != null) {
                                    newMove.addPreviousMoves(previousMove.getMoves());
                                    botMove = new BotMove(move.getOldX(), move.getOldY(), move.getNewX(), move.getNewY(), move.isAttack(), previousMove.getMoves().size());
                                    if (white) {
                                        newMove.addMove(botMove, previousMove.getPoints() + pieces.getPoints() + allypiece.getFieldPoints(9 - move.getNewX(), 9 - move.getNewY()));
                                    } else {
                                        newMove.addMove(botMove, previousMove.getPoints() + pieces.getPoints() + allypiece.getFieldPoints(move.getNewX(), move.getNewY()));
                                    }
                                } else {
                                    botMove = new BotMove(move.getOldX(), move.getOldY(), move.getNewX(), move.getNewY(), move.isAttack(), 0);
                                    if (white) {
                                        newMove.addMove(botMove, pieces.getPoints() + allypiece.getFieldPoints(9 - move.getNewX(), 9 - move.getNewY()));
                                    } else {
                                        newMove.addMove(botMove, pieces.getPoints() + allypiece.getFieldPoints(move.getNewX(), move.getNewY()));
                                    }
                                }
                                newMoves.add(newMove);
                            }
                        }
                    } else {
                        BotMoves newMove = new BotMoves();
                        BotMove botMove;
                        if (previousMove != null) {
                            newMove.addPreviousMoves(previousMove.getMoves());
                            botMove = new BotMove(move.getOldX(), move.getOldY(), move.getNewX(), move.getNewY(), move.isAttack(), previousMove.getMoves().size());
                        } else {
                            botMove = new BotMove(move.getOldX(), move.getOldY(), move.getNewX(), move.getNewY(), move.isAttack(), 0);
                        }
                        if (white) {
                            newMove.addMove(botMove, allypiece.getFieldPoints(9 - move.getNewX(), 9 - move.getNewY()));
                        } else {
                            newMove.addMove(botMove, allypiece.getFieldPoints(move.getNewX(), move.getNewY()));
                        }
                        newMoves.add(newMove);
                    }
                }
            }
        }
        return newMoves;
    }

    public ArrayList<BotMoves> calcAllMovesMin(BotMoves previousMove, ArrayList<BotPieces> allPieces, boolean white) {
        ArrayList<BotPieces> enemyPieces = getTeamPieces.getEnemyPieces(allPieces, white);
        ArrayList<BotMoves> newMoves = new ArrayList<>();
        for (BotPieces enemyPiece : enemyPieces) {
            ArrayList<Move> moves = enemyPiece.getMoves(allPieces);
            if(moves != null) {
                for (Move move : moves) {
                    if (move.isAttack()) {
                        for (BotPieces pieces : allPieces) {
                            if (move.getNewX() == pieces.getPosition().getX() && move.getNewY() == pieces.getPosition().getY()) {
                                BotMoves newMove = new BotMoves();
                                newMove.addPreviousMoves(previousMove.getMoves());
                                BotMove botMove = new BotMove(move.getOldX(), move.getOldY(), move.getNewX(), move.getNewY(), move.isAttack(), previousMove.getMoves().size());
                                if (white) {
                                    newMove.addMove(botMove, previousMove.getPoints() - (pieces.getPoints() + enemyPiece.getFieldPoints(9 - move.getNewX(), 9 - move.getNewY())));
                                } else {
                                    newMove.addMove(botMove, previousMove.getPoints() - (pieces.getPoints() + enemyPiece.getFieldPoints(move.getNewX(), move.getNewY())));
                                }
                                newMoves.add(newMove);
                            }
                        }
                    } else {
                        BotMoves newMove = new BotMoves();
                        newMove.addPreviousMoves(previousMove.getMoves());
                        BotMove botMove = new BotMove(move.getOldX(), move.getOldY(), move.getNewX(), move.getNewY(), move.isAttack(), previousMove.getMoves().size());
                        if (white) {
                            newMove.addMove(botMove, previousMove.getPoints() - enemyPiece.getFieldPoints(9 - move.getNewX(), 9 - move.getNewY()));
                        } else {
                            newMove.addMove(botMove, previousMove.getPoints() - enemyPiece.getFieldPoints(move.getNewX(), move.getNewY()));
                        }
                        newMoves.add(newMove);
                    }
                }
            }
        }
        return newMoves;
    }
}
