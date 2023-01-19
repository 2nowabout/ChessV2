import objects.chessPieces.ChessPieces;
import objects.chessPieces.Pawn;
import org.junit.Test;
import saveLibraries.Move;

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
}
