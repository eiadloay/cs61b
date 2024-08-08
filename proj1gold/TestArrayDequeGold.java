import org.junit.Assert;
import org.junit.Test;

public class TestArrayDequeGold {
    StudentArrayDeque<Integer> sad = new StudentArrayDeque<>();
    ArrayDequeSolution<Integer> ads = new ArrayDequeSolution<>();

    @Test
    public void test1() {
        Integer num = StdRandom.uniform(9);
        sad.addFirst(num);
        ads.addFirst(num);
        sad.addFirst(0);
        ads.addFirst(0);

        Integer actual = sad.removeFirst();
        Integer expected = ads.removeFirst();

        String message = "StudentArrayDeque.addFirst(1);\n" +
                         "StudentArrayDeque.addFirst(0);\n" +
                         "StudentArrayDeque.removeFirst();\n" +
                         "Student wast " + actual + "\t Expected was " + expected;

        Assert.assertEquals(message, expected, actual);
    }

    @Test
    public void test2() {
        sad.addFirst(1);
        ads.addFirst(1);
        sad.addFirst(0);
        ads.addFirst(0);
        sad.addFirst(2);
        ads.addFirst(2);
        sad.addFirst(3);
        ads.addFirst(3);
        sad.addFirst(4);
        ads.addFirst(4);
        sad.addFirst(5);
        ads.addFirst(5);


        Integer actual = sad.removeFirst();
        Integer expected = ads.removeFirst();
        String message = "StudentArrayDeque.addFirst(1);\n" +
                         "StudentArrayDeque.addFirst(0);\n" +
                         "StudentArrayDeque.addFirst(2);\n" +
                         "StudentArrayDeque.addFirst(3);\n" +
                         "StudentArrayDeque.addFirst(4);\n" +
                         "StudentArrayDeque.addFirst(5);\n" +
                         "StudentArrayDeque.removeFirst();\n" +
                         "Student was " + actual + "\t Expected was " + expected;

        Assert.assertEquals(message, expected, actual);
    }

    @Test
    public void test3() {
        sad.addFirst(1);
        ads.addFirst(1);
        sad.addFirst(0);
        ads.addFirst(0);
        sad.addFirst(2);
        ads.addFirst(2);
        sad.addFirst(3);
        ads.addFirst(3);
        sad.addFirst(4);
        ads.addFirst(4);
        sad.addFirst(5);
        ads.addFirst(5);


        Integer actual = sad.removeLast();
        Integer expected = ads.removeLast();
        String message = "StudentArrayDeque.addFirst(1);\n" +
                         "StudentArrayDeque.addFirst(0);\n" +
                         "StudentArrayDeque.addFirst(2);\n" +
                         "StudentArrayDeque.addFirst(3);\n" +
                         "StudentArrayDeque.addFirst(4);\n" +
                         "StudentArrayDeque.addFirst(5);\n" +
                         "StudentArrayDeque.removeLast();\n" +
                         "Student was " + actual + "\t Expected was "+ expected;

        Assert.assertEquals(message, expected, actual);
    }

    @Test
    public void test4() {
        sad.addFirst(1);
        ads.addFirst(1);
        sad.addFirst(0);
        ads.addFirst(0);
        sad.addFirst(2);
        ads.addFirst(2);
        sad.removeLast();
        ads.removeLast();
        sad.addFirst(3);
        ads.addFirst(3);
        sad.addFirst(4);
        ads.addFirst(4);
        sad.addFirst(5);
        ads.addFirst(5);
        sad.removeFirst();
        ads.removeFirst();
        sad.addLast(6);
        ads.addLast(6);
        sad.addLast(7);
        ads.addLast(7);
        sad.addLast(8);
        ads.addLast(8);
        sad.addLast(9);
        ads.addLast(9);
        sad.removeFirst();
        ads.removeFirst();
        sad.removeLast();
        ads.removeLast();


        Integer actual = sad.removeLast();
        Integer expected = ads.removeLast();
        String message = "StudentArrayDeque.addFirst(1);\n" +
                         "StudentArrayDeque.addFirst(0);\n" +
                         "StudentArrayDeque.addFirst(2);\n" +
                         "StudentArrayDeque.removeLast();\n" +
                         "StudentArrayDeque.addFirst(3);\n" +
                         "StudentArrayDeque.addFirst(4);\n" +
                         "StudentArrayDeque.addFirst(5);\n" +
                         "StudentArrayDeque.removeFirst();\n" +
                         "StudentArrayDeque.addFirst(6);\n" +
                         "StudentArrayDeque.addFirst(7);\n" +
                         "StudentArrayDeque.addFirst(8);\n" +
                         "StudentArrayDeque.addFirst(9);\n" +
                         "StudentArrayDeque.removeFirst();\n" +
                         "StudentArrayDeque.removeLast();\n" +
                         "StudentArrayDeque.removeLast();\n";

        Assert.assertEquals(message, expected, actual);
    }
}
