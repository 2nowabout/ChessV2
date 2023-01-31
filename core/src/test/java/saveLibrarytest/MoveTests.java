package saveLibrarytest;

import org.junit.Test;
import saveLibraries.Move;

import static org.junit.Assert.*;

public class MoveTests {
    @Test
    public void MoveSetAndGetTest()
    {
        Move move = new Move(1,2,3,4);
        assertEquals(1, move.getOldX());
        assertEquals(2, move.getOldY());
        assertEquals(3, move.getNewX());
        assertEquals(4, move.getNewY());
        move.setOldX(5);
        move.setOldY(6);
        move.setNewX(7);
        move.setNewY(8);
        assertEquals(5, move.getOldX());
        assertEquals(6, move.getOldY());
        assertEquals(7, move.getNewX());
        assertEquals(8, move.getNewY());
    }
}
