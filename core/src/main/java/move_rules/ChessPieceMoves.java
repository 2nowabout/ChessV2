package move_rules;

import ai.botpieces.BotPieces;
import objects.chesspieces.ChessPieces;
import save_libraries.Move;
import save_libraries.MoveToCheck;
import save_libraries.Position;

import java.util.ArrayList;

public class ChessPieceMoves {
    private ChessPieceMoves() { throw new IllegalStateException(); }

    private static ArrayList<Position> allEnemyPositions = new ArrayList<>();
    private static ArrayList<Position> allAllyPositions = new ArrayList<>();

    public static ArrayList<Move> calcPawnMoves(int x, int y, boolean white, ArrayList<BotPieces> allPieces, boolean firstmove) {
        ArrayList<Move> possibleMoves = new ArrayList<>();
        ArrayList<MoveToCheck> toCheckMoves = new ArrayList<>();
        getAllyAndEnemy(white, allPieces);
            if (white) {
                toCheckMoves.add(new MoveToCheck(false, new Position(x, y + 1)));
                if(firstmove) {
                    toCheckMoves.add(new MoveToCheck(false, new Position(x, y + 2)));
                }
                toCheckMoves.add(new MoveToCheck(true, new Position(x + 1, y + 1)));
                toCheckMoves.add(new MoveToCheck(true, new Position(x - 1, y + 1)));
            } else {
                toCheckMoves.add(new MoveToCheck(false, new Position(x, y - 1)));
                if (firstmove) {
                    toCheckMoves.add(new MoveToCheck(false, new Position(x, y - 2)));
                }
                toCheckMoves.add(new MoveToCheck(true, new Position(x + 1, y - 1)));
                toCheckMoves.add(new MoveToCheck(true, new Position(x - 1, y - 1)));
            }
        for (MoveToCheck pos : toCheckMoves) {
            boolean positionSafe = !allEnemyPositions.isEmpty() && !checkOutsideBorder(pos.getPosition());
            boolean attack = false;
            if(positionSafe) {
                for (Position enemyPos : allEnemyPositions) {
                    if (pos.getPosition().equals(enemyPos) && !pos.isAttack()) {
                        positionSafe = false;
                    }
                    if(pos.isAttack() && !pos.getPosition().equals(enemyPos))
                    {
                        positionSafe = false;
                    }
                    if (pos.isAttack() && pos.getPosition().equals(enemyPos)) {
                        attack = true;
                    }
                }
                for (Position allyPos : allAllyPositions) {
                    if (pos.getPosition().equals(allyPos)) {
                        positionSafe = false;
                    }
                }
            }
            if (positionSafe && !attack) {
                possibleMoves.add(new Move(x, y, pos.getPosition().getX(), pos.getPosition().getY(), false));
            }
            if(attack) {
                possibleMoves.add(new Move(x, y, pos.getPosition().getX(), pos.getPosition().getY(), true));
            }
        }
        return possibleMoves;
    }

    public static ArrayList<Move> calcRookMoves(int x, int y, boolean white, ArrayList<BotPieces> allPieces) {
        ArrayList<Move> possibleMoves = new ArrayList<>();
        getAllyAndEnemy(white, allPieces);
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
                    possibleMoves.add(new Move(x,y,pos.getX(), pos.getY(), true));
                    rightStopt = true;
                }
                if(left.equals(pos) && !leftStopt)
                {
                    possibleMoves.add(new Move(x,y,pos.getX(), pos.getY(), true));
                    leftStopt = true;
                }
                if(up.equals(pos) && !upStopt)
                {
                    possibleMoves.add(new Move(x,y,pos.getX(), pos.getY(), true));
                    upStopt = true;
                }
                if(down.equals(pos) && !downStopt)
                {
                    possibleMoves.add(new Move(x,y, pos.getX(), pos.getY(), true));
                    downStopt = true;
                }
            }

            if(!rightStopt)
            {
                possibleMoves.add(new Move(x,y, right.getX(), right.getY(), false));
            }
            if(!leftStopt)
            {
                possibleMoves.add(new Move(x,y, left.getX(), left.getY(), false));
            }
            if(!upStopt)
            {
                possibleMoves.add(new Move(x,y, up.getX(), up.getY(), false));
            }
            if(!downStopt)
            {
                possibleMoves.add(new Move(x,y, down.getX(), down.getY(), false));
            }
        }
        return possibleMoves;
    }

    public static ArrayList<Move> calcKnightMoves(int x, int y, boolean white, ArrayList<BotPieces> allPieces) {
        ArrayList<Move> possibleMoves = new ArrayList<>();
        getAllyAndEnemy(white, allPieces);
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
                boolean safe = true;
                boolean addedAsAttack = false;
                for (Position allyPos: allAllyPositions) {
                    if(pos.equals(allyPos))
                    {
                        safe = false;
                    }
                }
                if(safe)
                {
                    for (Position enemyPos: allEnemyPositions) {
                        if(enemyPos.getX() == pos.getX() && enemyPos.getY() == pos.getY())
                        {
                            possibleMoves.add(new Move(x,y, pos.getX(), pos.getY(), true));
                            addedAsAttack = true;
                        }
                    }
                    if(!addedAsAttack)
                    {
                        possibleMoves.add(new Move(x, y, pos.getX(), pos.getY(), false));
                    }
                }
            }
        }
        return possibleMoves;
    }

    public static ArrayList<Move> calcBishopMoves(int x, int y, boolean white, ArrayList<BotPieces> allPieces) {
        ArrayList<Move> possibleMoves = new ArrayList<>();
        getAllyAndEnemy(white, allPieces);
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
                    possibleMoves.add(new Move(x,y,pos.getX(), pos.getY(), true));
                    rightStopt = true;
                }
                if(left.equals(pos) && !leftStopt)
                {
                    possibleMoves.add(new Move(x,y,pos.getX(), pos.getY(), true));
                    leftStopt = true;
                }
                if(up.equals(pos) && !upStopt)
                {
                    possibleMoves.add(new Move(x,y,pos.getX(), pos.getY(), true));
                    upStopt = true;
                }
                if(down.equals(pos) && !downStopt)
                {
                    possibleMoves.add(new Move(x,y, pos.getX(), pos.getY(), true));
                    downStopt = true;
                }
            }
            if(!rightStopt)
            {
                possibleMoves.add(new Move(x,y, right.getX(), right.getY(), false));
            }
            if(!leftStopt)
            {
                possibleMoves.add(new Move(x,y, left.getX(), left.getY(), false));
            }
            if(!upStopt)
            {
                possibleMoves.add(new Move(x,y, up.getX(), up.getY(), false));
            }
            if(!downStopt)
            {
                possibleMoves.add(new Move(x,y, down.getX(), down.getY(), false));
            }
        }
        return possibleMoves;
    }

    public static ArrayList<Move> calcQueenMoves(int x, int y, boolean white, ArrayList<BotPieces> allPieces) {
        ArrayList<Move> moves = new ArrayList<>();
        moves.addAll(calcRookMoves(x, y, white, allPieces));
        moves.addAll(calcBishopMoves(x, y, white, allPieces));
        return moves;
    }

    public static ArrayList<Move> calcKingMoves(int x, int y, boolean white, ArrayList<BotPieces> allPieces) {
        return null; //TODO FIX
    }

    private static boolean checkOutsideBorder(Position move) {
        return move.getY() >= 9 || move.getY() <= 0 || move.getX() >= 9 || move.getX() <= 0;
    }

    private static void getAllyAndEnemy(boolean white, ArrayList<BotPieces> allPieces)
    {
        allEnemyPositions = new ArrayList<>();
        allAllyPositions = new ArrayList<>();
        for (BotPieces otherPiece : allPieces) {
            if(white)
            {
                if (!otherPiece.isWhite()) {
                    allEnemyPositions.add(otherPiece.getPosition());
                } else {
                    allAllyPositions.add(otherPiece.getPosition());
                }
            }
            else
            {
                if (otherPiece.isWhite()) {
                    allEnemyPositions.add(otherPiece.getPosition());
                } else {
                    allAllyPositions.add(otherPiece.getPosition());
                }
            }
        }
    }
}
