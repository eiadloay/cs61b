import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {

    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();

    // Your tests go here.
    @Test
    public void testOffByOne() {
        char a = 'a';
        char b = 'b';
        assertTrue(offByOne.equalChars(a, b));
    }

    @Test
    public void testOffByOne2() {
        char a = 'a';
        char z = 'z';
        assertFalse(offByOne.equalChars(a, z));
    }

    @Test
    public void testOffByOneUpperCase() {
        char a = 'a';
        char B = 'B';
        assertFalse(offByOne.equalChars(a, B));
    }

    @Test
    public void testOffByOneNonLetters() {
        char a = '&';
        char z = '%';
        assertTrue(offByOne.equalChars(a, z));
    }
}
