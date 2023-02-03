package chessPiecesTest;

import objects.chesspieces.Knight;
import objects.chesspieces.ChessPieces;
import org.junit.Test;
import save_libraries.Move;
import save_libraries.Position;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class KnightTests {
    @Test
    public void KnightMovementTest()
    {
        Knight knight = new Knight(true, 3, 3);
        Knight enemy = new Knight(false, 8,8);
        ArrayList<ChessPieces> allPieces = new ArrayList<>();
        allPieces.add(knight);
        allPieces.add(enemy);
        ArrayList<Move> moves = knight.getMoves(allPieces);
        assertEquals(8, moves.size());
    }

    @Test
    public void KnightMovementAttackTest()
    {
        Knight knight = new Knight(true, 3, 3);
        Knight enemy = new Knight(false, 2,1);
        ArrayList<ChessPieces> allPieces = new ArrayList<>();
        allPieces.add(knight);
        allPieces.add(enemy);
        ArrayList<Move> moves = knight.getMoves(allPieces);
        assertEquals(8, moves.size()); //size should be 10, enemy blocking one square
    }

    @Test
    public void KnightCheckPoints()
    {
        Knight knight = new Knight(true, 2,2);
        assertEquals(30, knight.getPoints());
    }

    @Test
    public void KnightCheckIfMoved()
    {
        Knight knight = new Knight(true, 2, 2);
        knight.doMove(new Move(2,2,3,2, true), new Position(0,0));
        assertEquals(3, knight.getPosition().getX());
        assertEquals(2, knight.getPosition().getY());
    }

    @Test(expected = IllegalArgumentException.class)
    public void KnightCheckMoveHacking()
    {
        Knight knight = new Knight(true, 2, 2);
        knight.doMove(new Move(2,3,3,2, true), new Position(0,0));
    }
}
