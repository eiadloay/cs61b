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
    // Uncomment this class once you've created your CharacterComparator interface and OffByOne class. **/
}
