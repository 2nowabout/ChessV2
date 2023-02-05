package ai;

import ai.botpieces.BotPieces;
import save_libraries.Move;

import java.util.ArrayList;

public class BotCalcAllMoves {
    private BotGetAllAllyPieces getAllAllyPieces;
    public BotCalcAllMoves()
    {
        getAllAllyPieces = new BotGetAllAllyPieces();
    }
    public ArrayList<BotMoves> calcAllMoves(BotMoves previousMove, ArrayList<BotPieces> allPieces, boolean white, boolean max)
    {
        ArrayList<BotPieces> allyPieces = getAllAllyPieces.getAllyPieces(allPieces, white);
        if(previousMove != null)
        {
            if(max)
            {
                for (BotPieces allypiece: allyPieces) {
                   ArrayList<Move> moves = allypiece.getMoves(allPieces);
                    for (Move move: moves) {
                        if(move.isAttack()) {
                            BotPieces toRemove = null;
                            for (BotPieces pieces: allPieces) {
                                if(move.getNewX() == pieces.getPosition().getX() && move.getNewY() == pieces.getPosition().getY())
                                {
                                    toRemove = pieces;
                                    if(white)
                                    {
                                        previousMove.addMove(move, pieces.getPoints() + allypiece.getFieldPoints(8-move.getNewX(), 8-move.getNewY()));
                                    }
                                    else {
                                        previousMove.addMove(move, pieces.getPoints() + allypiece.getFieldPoints(move.getNewX(), move.getNewY()));
                                    }

                                }
                            }
                            if(toRemove != null) {
                                allPieces.remove(toRemove);
                            }
                            else {
                                throw new IllegalStateException("no Chesspiece found on attack - BOT");
                            }
                        }
                        else
                        {
                            
                        }
                    }
                }
            }
            else
            {
                
            }

        }
        return null;
    }
}
