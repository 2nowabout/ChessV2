package move_rules;

import objects.chesspieces.ChessPieces;
import save_libraries.Move;
import save_libraries.MoveToCheck;
import save_libraries.Position;

import java.util.ArrayList;

public class ChessPieceMoves {
    private ChessPieceMoves() { throw new IllegalStateException(); }

    public static ArrayList<Move> calcPawnMoves(int x, int y, boolean white, ArrayList<ChessPieces> allPieces, boolean firstmove) {
        ArrayList<Move> possibleMoves = new ArrayList<>();
        ArrayList<Position> allEnemyPositions = new ArrayList<>();
        ArrayList<Position> allAllyPositions = new ArrayList<>();
        ArrayList<MoveToCheck> toCheckMoves = new ArrayList<>();
        for (ChessPieces otherPiece : allPieces) {
            if (!otherPiece.isWhite()) {
                allEnemyPositions.add(otherPiece.getPosition());
            } else {
                allAllyPositions.add(otherPiece.getPosition());
            }
        }
        if (firstmove) {
            if (!white) {
                toCheckMoves.add(new MoveToCheck(false, new Position(x, y + 1)));
                toCheckMoves.add(new MoveToCheck(false, new Position(x, y + 2)));
                toCheckMoves.add(new MoveToCheck(true, new Position(x + 1, y + 1)));
                toCheckMoves.add(new MoveToCheck(true, new Position(x - 1, y + 1)));
            } else {
                toCheckMoves.add(new MoveToCheck(false, new Position(x, y - 1)));
                toCheckMoves.add(new MoveToCheck(false, new Position(x, y - 2)));
                toCheckMoves.add(new MoveToCheck(true, new Position(x + 1, y - 1)));
                toCheckMoves.add(new MoveToCheck(true, new Position(x - 1, y - 1)));
            }
        } else {
            if (!white) {
                toCheckMoves.add(new MoveToCheck(false, new Position(x, y + 1)));
                toCheckMoves.add(new MoveToCheck(true, new Position(x + 1, y + 1)));
                toCheckMoves.add(new MoveToCheck(true, new Position(x - 1, y + 1)));
            } else {
                toCheckMoves.add(new MoveToCheck(false, new Position(x, y - 1)));
                toCheckMoves.add(new MoveToCheck(true, new Position(x + 1, y - 1)));
                toCheckMoves.add(new MoveToCheck(true, new Position(x - 1, y - 1)));
            }
        }
        for (MoveToCheck pos : toCheckMoves) {
            boolean positionSafe = !allEnemyPositions.isEmpty() && !checkOutsideBorder(pos.getPosition());
            if(positionSafe) {
                for (Position enemyPos : allEnemyPositions) {
                    if (pos.getPosition().equals(enemyPos) && !pos.isAttack()) {
                        positionSafe = false;
                    }
                    if (pos.isAttack() && !pos.getPosition().equals(enemyPos)) {
                        positionSafe = false;
                    }
                }
                for (Position allyPos : allAllyPositions) {
                    if (pos.getPosition().equals(allyPos)) {
                        positionSafe = false;
                    }
                }
            }
            if (positionSafe) {
                possibleMoves.add(new Move(x, y, pos.getPosition().getX(), pos.getPosition().getY()));
            }
        }
        return possibleMoves;
    }

    public static ArrayList<Move> calcRookMoves(int x, int y, boolean white, ArrayList<ChessPieces> allPieces) {
        ArrayList<Move> possibleMoves = new ArrayList<>();
        ArrayList<Position> allEnemyPositions = new ArrayList<>();
        ArrayList<Position> allAllyPositions = new ArrayList<>();
        for (ChessPieces otherPiece : allPieces) {
            if (!otherPiece.isWhite()) {
                allEnemyPositions.add(otherPiece.getPosition());
            } else {
                allAllyPositions.add(otherPiece.getPosition());
            }
        }
        boolean leftStopt = false;
        boolean rightStopt = false;
        boolean upStopt = false;
        boolean downStopt = false;
        for (int i = 1; i < 9; i++) {
            Position right = new Position(x+i, y);
            Position left = new Position(x-i, y);
            Position up = new Position(x, y-i);
            Position down = new Position(x, y+i);
            for (Position pos: allAllyPositions) {
                if(right.equals(pos) || checkOutsideBorder(right))
                {
                    rightStopt = true;
                }
                if(left.equals(pos) || checkOutsideBorder(left))
                {
                    leftStopt = true;
                }
                if(up.equals(pos) || checkOutsideBorder(up))
                {
                    upStopt = true;
                }
                if(down.equals(pos) || checkOutsideBorder(down))
                {
                    downStopt = true;
                }
            }
            for (Position pos: allEnemyPositions) {
                if(right.equals(pos) && !rightStopt)
                {
                    possibleMoves.add(new Move(x,y,pos.getX(), pos.getY()));
                    rightStopt = true;
                }
                if(left.equals(pos) && !leftStopt)
                {
                    possibleMoves.add(new Move(x,y,pos.getX(), pos.getY()));
                    leftStopt = true;
                }
                if(up.equals(pos) && !upStopt)
                {
                    possibleMoves.add(new Move(x,y,pos.getX(), pos.getY()));
                    upStopt = true;
                }
                if(down.equals(pos) && !downStopt)
                {
                    possibleMoves.add(new Move(x,y, pos.getX(), pos.getY()));
                    downStopt = true;
                }
            }

            if(!rightStopt)
            {
                possibleMoves.add(new Move(x,y, right.getX(), right.getY()));
            }
            if(!leftStopt)
            {
                possibleMoves.add(new Move(x,y, left.getX(), left.getY()));
            }
            if(!upStopt)
            {
                possibleMoves.add(new Move(x,y, up.getX(), up.getY()));
            }
            if(!downStopt)
            {
                possibleMoves.add(new Move(x,y, down.getX(), down.getY()));
            }
        }
        return possibleMoves;
    }

    public static ArrayList<Move> calcKnightMoves(int x, int y, boolean white, ArrayList<ChessPieces> allPieces) {
        ArrayList<Move> possibleMoves = new ArrayList<>();
        ArrayList<Position> allEnemyPositions = new ArrayList<>();
        ArrayList<Position> allAllyPositions = new ArrayList<>();
        for (ChessPieces otherPiece : allPieces) {
            if (!otherPiece.isWhite()) {
                allEnemyPositions.add(otherPiece.getPosition());
            } else {
                allAllyPositions.add(otherPiece.getPosition());
            }
        }
        ArrayList<Position> movesToTest = new ArrayList<>();
        movesToTest.add(new Position(x+2, y+1));
        movesToTest.add(new Position(x+1, y+2));
        movesToTest.add(new Position(x-2, y+1));
        movesToTest.add(new Position(x-1, y+2));
        movesToTest.add(new Position(x+2, y-1));
        movesToTest.add(new Position(x+1, y-2));
        movesToTest.add(new Position(x-2, y-1));
        movesToTest.add(new Position(x-1, y-2));
        for (Position pos: movesToTest) {
            if(!checkOutsideBorder(pos)){
                for (Position allyPos: allAllyPositions) {
                    if(!pos.equals(allyPos))
                    {
                        possibleMoves.add(new Move(x,y, allyPos.getX(), allyPos.getY()));
                    }
                }
            }
        }
        return possibleMoves;
    }

    public static ArrayList<Move> calcBishopMoves(int x, int y, boolean white, ArrayList<ChessPieces> allPieces) {
        ArrayList<Move> possibleMoves = new ArrayList<>();
        ArrayList<Position> allEnemyPositions = new ArrayList<>();
        ArrayList<Position> allAllyPositions = new ArrayList<>();
        for (ChessPieces otherPiece : allPieces) {
            if (!otherPiece.isWhite()) {
                allEnemyPositions.add(otherPiece.getPosition());
            } else {
                allAllyPositions.add(otherPiece.getPosition());
            }
        }
        boolean leftStopt = false;
        boolean rightStopt = false;
        boolean upStopt = false;
        boolean downStopt = false;
        for (int i = 1; i < 9; i++) {
            Position right = new Position(x+i, y+i);
            Position left = new Position(x-i, y-i);
            Position up = new Position(x+i, y-i);
            Position down = new Position(x-i, y+i);
            for (Position pos: allAllyPositions) {
                if(right.equals(pos) || checkOutsideBorder(right))
                {
                    rightStopt = true;
                }
                if(left.equals(pos) || checkOutsideBorder(left))
                {
                    leftStopt = true;
                }
                if(up.equals(pos) || checkOutsideBorder(up))
                {
                    upStopt = true;
                }
                if(down.equals(pos) || checkOutsideBorder(down))
                {
                    downStopt = true;
                }
            }
            for (Position pos: allEnemyPositions) {
                if(right.equals(pos) && !rightStopt)
                {
                    possibleMoves.add(new Move(x,y,pos.getX(), pos.getY()));
                    rightStopt = true;
                }
                if(left.equals(pos) && !leftStopt)
                {
                    possibleMoves.add(new Move(x,y,pos.getX(), pos.getY()));
                    leftStopt = true;
                }
                if(up.equals(pos) && !upStopt)
                {
                    possibleMoves.add(new Move(x,y,pos.getX(), pos.getY()));
                    upStopt = true;
                }
                if(down.equals(pos) && !downStopt)
                {
                    possibleMoves.add(new Move(x,y, pos.getX(), pos.getY()));
                    downStopt = true;
                }
            }
            if(!rightStopt)
            {
                possibleMoves.add(new Move(x,y, right.getX(), right.getY()));
            }
            if(!leftStopt)
            {
                possibleMoves.add(new Move(x,y, left.getX(), left.getY()));
            }
            if(!upStopt)
            {
                possibleMoves.add(new Move(x,y, up.getX(), up.getY()));
            }
            if(!downStopt)
            {
                possibleMoves.add(new Move(x,y, down.getX(), down.getY()));
            }
        }
        return possibleMoves;
    }

    public static ArrayList<Move> calcQueenMoves(int x, int y, boolean white, ArrayList<ChessPieces> allPieces) {
        ArrayList<Move> moves = new ArrayList<>();
        moves.addAll(calcRookMoves(x, y, white, allPieces));
        moves.addAll(calcBishopMoves(x, y, white, allPieces));
        return moves;
    }

    public static ArrayList<Move> calcKingMoves(int x, int y, boolean white, ArrayList<ChessPieces> allPieces) {
        return null; //TODO FIX
    }

    private static boolean checkOutsideBorder(Position move) {
        return move.getY() >= 9 || move.getY() <= 0 || move.getX() >= 9 || move.getX() <= 0;
    }
}
