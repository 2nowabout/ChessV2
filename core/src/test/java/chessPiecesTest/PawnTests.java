package chessPiecesTest;

import objects.chesspieces.ChessPieces;
import objects.chesspieces.Pawn;
import org.junit.Test;
import save_libraries.Move;

import java.util.ArrayList;
import static org.junit.Assert.*;

public class PawnTests {

    @Test
    public void PawnMovementTest()
    {
        Pawn pawn = new Pawn(true, 3, 3);
        Pawn enemy = new Pawn(false, 8,8);
        ArrayList<ChessPieces> allPieces = new ArrayList<>();
        allPieces.add(pawn);
        allPieces.add(enemy);
        ArrayList<Move> moves = pawn.getMoves(allPieces);
        ArrayList<Move> expectedMove = new ArrayList<>();
        expectedMove.add(new Move(3,3,3,2));
        expectedMove.add(new Move(3,3,3,1));
        assertEquals(expectedMove.get(0).getNewX(), moves.get(0).getNewX());
        assertEquals(expectedMove.get(0).getNewY(), moves.get(0).getNewY());
        assertEquals(expectedMove.get(0).getOldX(), moves.get(0).getOldX());
        assertEquals(expectedMove.get(0).getOldY(), moves.get(0).getOldY());
        assertEquals(expectedMove.size(), moves.size());
    }

    @Test
    public void PawnMovementAttackTest()
    {
        Pawn pawn = new Pawn(true, 3, 3);
        Pawn enemy = new Pawn(false, 4,2);
        ArrayList<ChessPieces> allPieces = new ArrayList<>();
        allPieces.add(pawn);
        allPieces.add(enemy);
        ArrayList<Move> moves = pawn.getMoves(allPieces);
        ArrayList<Move> expectedMove = new ArrayList<>();
        expectedMove.add(new Move(3,3,3,2));
        expectedMove.add(new Move(3,3,3,1));
        expectedMove.add(new Move(3,3,4,2));
        assertEquals(expectedMove.get(0).getNewX(), moves.get(0).getNewX());
        assertEquals(expectedMove.get(0).getNewY(), moves.get(0).getNewY());
        assertEquals(expectedMove.get(0).getOldX(), moves.get(0).getOldX());
        assertEquals(expectedMove.get(0).getOldY(), moves.get(0).getOldY());
        assertEquals(expectedMove.size(), moves.size()); //size should be 3, 2 forward and one attack
    }

    @Test
    public void PawnCheckPoints()
    {
        Pawn pawn = new Pawn(true, 2,2);
        assertEquals(10, pawn.getPoints());
    }

    @Test
    public void PawnCheckIfMoved()
    {
        Pawn pawn = new Pawn(true, 2, 2);
        pawn.doMove(new Move(2,2,3,2));
        assertEquals(3, pawn.getPosition().getX());
        assertEquals(2, pawn.getPosition().getY());
    }

    @Test(expected = IllegalArgumentException.class)
    public void PawnCheckMoveHacking()
    {
        Pawn pawn = new Pawn(true, 2, 2);
        pawn.doMove(new Move(2,3,3,2));
    }
}
