package ch.fhnw.depa.l01;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AbstractCollectionTest {

    @Test
    public void sizeTest() {
        // arrange
        var col = new CollectionImpl<Integer>();

        // act
        col.add(12);
        col.add(13);
        col.add(14);
        col.add(15);

        // assert
        assertEquals(4, col.size());
    }

    @Test
    public void isEmptyTest_True() {
        // arrange
        var col = new CollectionImpl<Integer>();

        // act

        // assert
        assertTrue(col.isEmpty());
    }

    @Test
    public void isEmptyTest_False() {
        // arrange
        var col = new CollectionImpl<Integer>();

        // act
        col.add(12);
        col.add(13);
        col.add(14);
        col.add(15);

        // assert
        assertFalse(col.isEmpty());
    }
}
