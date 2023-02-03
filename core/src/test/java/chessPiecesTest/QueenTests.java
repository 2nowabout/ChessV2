package chessPiecesTest;

import objects.chesspieces.Queen;
import objects.chesspieces.ChessPieces;
import org.junit.Test;
import save_libraries.Move;
import save_libraries.Position;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class QueenTests {
    @Test
    public void QueenMovementTest()
    {
        Queen Queen = new Queen(true, 3, 3);
        Queen enemy = new Queen(false, 8,8);
        ArrayList<ChessPieces> allPieces = new ArrayList<>();
        allPieces.add(Queen);
        allPieces.add(enemy);
        ArrayList<Move> moves = Queen.getMoves(allPieces);
        assertEquals(25, moves.size());
    }

    @Test
    public void QueenMovementAttackTest()
    {
        Queen Queen = new Queen(true, 3, 3);
        Queen enemy = new Queen(false, 3,4);
        ArrayList<ChessPieces> allPieces = new ArrayList<>();
        allPieces.add(Queen);
        allPieces.add(enemy);
        ArrayList<Move> moves = Queen.getMoves(allPieces);
        assertEquals(21, moves.size()); //size should be 10, enemy blocking one square
    }

    @Test
    public void QueenCheckPoints()
    {
        Queen Queen = new Queen(true, 2,2);
        assertEquals(90, Queen.getPoints());
    }

    @Test
    public void QueenCheckIfMoved()
    {
        Queen Queen = new Queen(true, 2, 2);
        Queen.doMove(new Move(2,2,3,2, true), new Position(0,0));
        assertEquals(3, Queen.getPosition().getX());
        assertEquals(2, Queen.getPosition().getY());
    }

    @Test(expected = IllegalArgumentException.class)
    public void QueenCheckMoveHacking()
    {
        Queen Queen = new Queen(true, 2, 2);
        Queen.doMove(new Move(2,3,3,2, true), new Position(0,0));
    }
}
