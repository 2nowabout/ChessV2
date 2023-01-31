package saveLibrarytest;

import org.junit.Test;
import save_libraries.MoveToCheck;
import save_libraries.Position;

import static org.junit.Assert.*;

public class MoveToCheckTests {

    @Test
    public void MoveToCheckSetAndGetTest()
    {
        MoveToCheck move = new MoveToCheck(true, new Position(2,3));
        assertEquals(2, move.getPosition().getX());
        assertEquals(3, move.getPosition().getY());
        assertTrue(move.isAttack());
    }

    @Test
    public void MoveToCheckSetAndGetTestNot()
    {
        MoveToCheck move = new MoveToCheck(false, new Position(2,3));
        assertNotEquals(4, move.getPosition().getX());
        assertNotEquals(5, move.getPosition().getY());
        assertFalse(move.isAttack());
    }
}
