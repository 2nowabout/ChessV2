package chessPiecesTest;

import objects.chessPieces.ChessPieces;
import objects.chessPieces.Bishop;
import org.junit.Test;
import saveLibraries.Move;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class BishopTests {

    @Test
    public void BishopMovementTest()
    {
        Bishop bishop = new Bishop(true, 3, 3);
        Bishop enemy = new Bishop(false, 8,8);
        ArrayList<ChessPieces> allPieces = new ArrayList<>();
        allPieces.add(bishop);
        allPieces.add(enemy);
        ArrayList<Move> moves = bishop.getMoves(allPieces);
        ArrayList<Move> expectedMove = new ArrayList<>();
        expectedMove.add(new Move(3,3,4,4));
        expectedMove.add(new Move(3,3,3,1));
        assertEquals(expectedMove.get(0).getNewX(), moves.get(0).getNewX());
        assertEquals(expectedMove.get(0).getNewY(), moves.get(0).getNewY());
        assertEquals(expectedMove.get(0).getOldX(), moves.get(0).getOldX());
        assertEquals(expectedMove.get(0).getOldY(), moves.get(0).getOldY());
        assertEquals(expectedMove.size(), moves.size());
    }

    @Test
    public void BishopMovementAttackTest()
    {
        Bishop bishop = new Bishop(true, 3, 3);
        Bishop enemy = new Bishop(false, 4,2);
        ArrayList<ChessPieces> allPieces = new ArrayList<>();
        allPieces.add(bishop);
        allPieces.add(enemy);
        ArrayList<Move> moves = bishop.getMoves(allPieces);
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
    public void BishopCheckPoints()
    {
        Bishop bishop = new Bishop(true, 2,2);
        assertEquals(10, bishop.getPoints());
    }

    @Test
    public void BishopCheckIfMoved()
    {
        Bishop bishop = new Bishop(true, 2, 2);
        bishop.doMove(new Move(2,2,3,2));
        assertEquals(3, bishop.getPosition().getX());
        assertEquals(2, bishop.getPosition().getY());
    }

    @Test(expected = IllegalArgumentException.class)
    public void BishopCheckMoveHacking()
    {
        Bishop bishop = new Bishop(true, 2, 2);
        bishop.doMove(new Move(2,3,3,2));
    }
}
