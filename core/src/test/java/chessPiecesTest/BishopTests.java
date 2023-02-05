package chessPiecesTest;

import objects.chesspieces.ChessPieces;
import objects.chesspieces.Bishop;
import org.junit.Test;
import save_libraries.Move;
import save_libraries.Position;

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
        expectedMove.add(new Move(3,3,4,4, true));
        expectedMove.add(new Move(3,3,3,1, true));
        assertEquals(expectedMove.get(0).getNewX(), moves.get(0).getNewX());
        assertEquals(expectedMove.get(0).getNewY(), moves.get(0).getNewY());
        assertEquals(expectedMove.get(0).getOldX(), moves.get(0).getOldX());
        assertEquals(expectedMove.get(0).getOldY(), moves.get(0).getOldY());
        assertEquals(11, moves.size());
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
        assertEquals(10, moves.size()); //size should be 10, enemy blocking one square
    }

    @Test
    public void BishopCheckPoints()
    {
        Bishop bishop = new Bishop(true, 2,2);
        assertEquals(30, bishop.getPoints());
    }

    @Test
    public void BishopCheckIfMoved()
    {
        Bishop bishop = new Bishop(true, 2, 2);
        bishop.doMove(new Move(2,2,3,2, true), new Position(0,0));
        assertEquals(3, bishop.getPosition().getX());
        assertEquals(2, bishop.getPosition().getY());
    }

    @Test(expected = IllegalArgumentException.class)
    public void BishopCheckMoveHacking()
    {
        Bishop bishop = new Bishop(true, 2, 2);
        bishop.doMove(new Move(2,3,3,2, true), new Position(0,0));
    }

    @Test
    public void BischopFieldPointTest()
    {
        Bishop bishop = new Bishop(true, 2, 2);
        assertEquals(0.0, (double) bishop.getFieldPoints(2,2), 0);
    }
}
