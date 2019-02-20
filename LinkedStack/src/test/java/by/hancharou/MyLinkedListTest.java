package by.hancharou;

import org.junit.Test;
import static org.junit.Assert.*;

public class MyLinkedListTest {

    @Test
    public void addTestValid(){
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();
        myLinkedList.add(0, 123);
        assertEquals(123, (int) myLinkedList.get(0));
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void addTestInvalid(){
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();
        myLinkedList.add(2, 123);

    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void checkElementIndexTest(){
        MyLinkedList<Integer> numbers = new MyLinkedList<>();
        numbers.get(4);
    }

    @Test
    public void hashcodeTest(){
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();
        MyLinkedList<Integer> myLinkedList2 = new MyLinkedList<>();
        MyLinkedList<String> myLinkedList3 = new MyLinkedList<>();
        myLinkedList.add(0, 123);
        myLinkedList.add(1, 1123124124);
        myLinkedList2.add(0, 123);
        myLinkedList3.add(0, null);
        myLinkedList2.add(1, 1123124124);

        assertTrue(myLinkedList.hashCode() == myLinkedList2.hashCode());
        assertEquals(31, myLinkedList3.hashCode());


    }

    @Test
    public void removeTest(){
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();
        myLinkedList.add(0, 1);
        myLinkedList.add(1, 2);
        myLinkedList.add(2, 3);
        myLinkedList.add(3, 4);
        myLinkedList.add(4, 5);
        myLinkedList.add(5, 6);
        myLinkedList.add(2, 7);
        myLinkedList.add(4, 8);
        myLinkedList.add(0, 9);
        myLinkedList.remove(0);
        myLinkedList.remove(4);
        myLinkedList.remove(1);
        myLinkedList.remove(5);
        assertEquals(1, (int) myLinkedList.get(0));
    }

    @Test
    public void getTest(){
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();
        myLinkedList.add(0, 123);
        assertEquals(123, (int) myLinkedList.get(0));
    }

    @Test
    public void sizeTest(){
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();
        myLinkedList.add(0, 123);
        assertEquals(1, myLinkedList.size());
    }

    @Test
    public void equalsTest(){
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();
        MyLinkedList<Integer> myLinkedList2 = new MyLinkedList<>();
        MyLinkedList<Integer> myLinkedList3 = new MyLinkedList<>();
        MyLinkedList<Integer> myLinkedList5 = new MyLinkedList<>();
        MyLinkedList<Integer> myLinkedList4 = null;
        Fraction fraction = new Fraction(12);
        Fraction fraction2 = null;

        myLinkedList.add(0,0);
        myLinkedList.add(1,1);
        myLinkedList.add(2,2);

        myLinkedList2.add(0,0);
        myLinkedList2.add(1,1);
        myLinkedList2.add(2,2);


        myLinkedList5.add(0,2);
        myLinkedList5.add(1,6);
        myLinkedList5.add(2,2);

        myLinkedList3.add(0,2);
        myLinkedList3.add(1,3);

        assertTrue(myLinkedList.equals(myLinkedList2));
        assertTrue(myLinkedList.equals(myLinkedList));
        assertFalse(myLinkedList.equals(myLinkedList3));
        assertFalse(myLinkedList.equals(myLinkedList4));
        assertFalse(myLinkedList.equals(fraction));
        assertFalse(myLinkedList.equals(fraction2));
        assertFalse(myLinkedList.equals(myLinkedList5));

    }

    @Test
    public void checkMyLinkedListsForEquals(){
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();
        MyLinkedList<Integer> myLinkedList2 = new MyLinkedList<>();

        myLinkedList.add(0,0);
        myLinkedList.add(1,1);
        myLinkedList.add(2,2);

        myLinkedList2.add(0,4);
        myLinkedList2.add(1,2);
        myLinkedList2.add(2,1);

        assertEquals(false, myLinkedList.checkMyLinkedListsForEquals(myLinkedList2));
    }

    @Test
    public void isElementIndexTest(){
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();
        myLinkedList.add(0,1);
        myLinkedList.add(0,1);
        myLinkedList.add(0,1);
        myLinkedList.add(0,1);
        assertEquals(false, myLinkedList.isElementIndex(5));
        assertEquals(true, myLinkedList.isElementIndex(0));
        assertEquals(false, myLinkedList.isElementIndex(-1));
        assertEquals(true, myLinkedList.isElementIndex(3));
    }

    @Test
    public void isPositionIndexTest(){
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();
        myLinkedList.add(0,1);
        myLinkedList.add(0,1);
        myLinkedList.add(0,1);
        myLinkedList.add(0,1);

        assertEquals(true, myLinkedList.isPositionIndex(0));
        assertEquals(false, myLinkedList.isPositionIndex(-1));
        assertEquals(false, myLinkedList.isPositionIndex(5));
        assertEquals(true, myLinkedList.isPositionIndex(4));
        assertEquals(true, myLinkedList.isPositionIndex(2));
    }

    @Test
    public void toStringTest(){
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();
        myLinkedList.add(0,0);
        myLinkedList.add(1,1);
        myLinkedList.add(2,2);
        assertEquals("This collection: [0;1;2]", myLinkedList.toString());
    }

}
