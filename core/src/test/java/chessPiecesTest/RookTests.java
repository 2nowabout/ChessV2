package chessPiecesTest;

import objects.chesspieces.Rook;
import objects.chesspieces.ChessPieces;
import org.junit.Test;
import save_libraries.Move;
import save_libraries.Position;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class RookTests {
    @Test
    public void RookMovementTest()
    {
        Rook rook = new Rook(true, 3, 3);
        Rook enemy = new Rook(false, 8,8);
        ArrayList<ChessPieces> allPieces = new ArrayList<>();
        allPieces.add(rook);
        allPieces.add(enemy);
        ArrayList<Move> moves = rook.getMoves(allPieces);
        assertEquals(14, moves.size());
    }

    @Test
    public void RookMovementAttackTest()
    {
        Rook rook = new Rook(true, 3, 3);
        Rook enemy = new Rook(false, 3,4);
        ArrayList<ChessPieces> allPieces = new ArrayList<>();
        allPieces.add(rook);
        allPieces.add(enemy);
        ArrayList<Move> moves = rook.getMoves(allPieces);
        assertEquals(10, moves.size()); //size should be 10, enemy blocking 4 squares
    }

    @Test
    public void RookCheckPoints()
    {
        Rook rook = new Rook(true, 2,2);
        assertEquals(50, rook.getPoints());
    }

    @Test
    public void RookCheckIfMoved()
    {
        Rook rook = new Rook(true, 2, 2);
        rook.doMove(new Move(2,2,3,2, true), new Position(0,0));
        assertEquals(3, rook.getPosition().getX());
        assertEquals(2, rook.getPosition().getY());
    }

    @Test(expected = IllegalArgumentException.class)
    public void RookCheckMoveHacking()
    {
        Rook rook = new Rook(true, 2, 2);
        rook.doMove(new Move(2,3,3,2, true), new Position(0,0));
    }
}
