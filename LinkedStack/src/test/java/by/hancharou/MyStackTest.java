package by.hancharou;

import org.junit.Test;

import java.util.EmptyStackException;

import static org.junit.Assert.*;

public class MyStackTest {

    @Test
    public void toStingAndPushTest(){
        MyStack<Integer> numbers = new MyStack<>();
        numbers.push(123);
        numbers.push(123);
        numbers.push(123);
        assertEquals("This Stack: 123 123 123", numbers.toString());
    }

    @Test
    public void popTest(){
        MyStack<Integer> numbers = new MyStack<>();
        numbers.push(123);
        assertEquals("123", numbers.pop().toString());
    }

    @Test
    public void sizeTest(){
        MyStack<Integer> numbers = new MyStack<>();
        numbers.push(123);
        numbers.push(123);
        numbers.push(123);
        assertEquals(3, numbers.size());
    }

    @Test
    public void equalsTest(){
        MyStack<Integer> numbers = new MyStack<>();
        numbers.push(1);
        numbers.push(2);

        MyStack<Integer> numbers2 = new MyStack<>();
        numbers2.push(1);
        numbers2.push(2);

        MyStack<Integer> numbers3 = new MyStack<>();
        numbers3.push(3);
        numbers3.push(2);

        MyStack<Integer> numbers6 = new MyStack<>();
        numbers6.push(3);
        numbers6.push(3);
        numbers6.push(3);
        numbers6.push(3);
        numbers6.push(3);

        MyStack<Integer> numbers4 = numbers;
        MyStack<Integer> numbers5 = null;
        Fraction fraction = new Fraction(2);



        assertTrue(numbers.equals(numbers2));
        assertTrue(numbers.equals(numbers));
        assertFalse(numbers.equals(numbers3));
        assertTrue(numbers.equals(numbers4));
        assertFalse(numbers.equals(fraction));
        assertFalse(numbers.equals(numbers5));
        assertFalse(numbers.equals(numbers6));


    }

    @Test
    public void hashCodeTest(){
        MyStack<Integer> numbers = new MyStack<>();
        numbers.push(987654321);
        numbers.push(123456789);

        MyStack<Integer> numbers2 = new MyStack<>();
        numbers2.push(987654321);
        numbers2.push(123456789);

        MyStack<Integer> numbers3 = new MyStack<>();
        numbers3.push(123123123);
        numbers3.push(356457);

        assertTrue(numbers.hashCode() == numbers2.hashCode());
        assertFalse(numbers.hashCode() == numbers3.hashCode());
    }

    @Test
    public void hugeCapacityTest(){
        MyStack<String> stack = new MyStack<>();
        stack.push("123");
        stack.push("123");
        stack.grow(3);
        stack.hugeCapacity(4);
    }

    @Test(expected = OutOfMemoryError.class)
    public void hugeCapacityTest2(){
        MyStack<String> stack = new MyStack<>();
        stack.push("123");
        stack.push("123");
        stack.push("123");
        stack.push("123");
        stack.push("123");
        stack.push("123");
        stack.push("123");
        stack.grow(-3);
    }

    @Test
    public void hugeCapacityTest3(){
        MyStack<String> string = new MyStack<>();
        assertEquals(Integer.MAX_VALUE, string.hugeCapacity(9));
        assertEquals(8, string.hugeCapacity(3));
    }


        @Test (expected = EmptyStackException.class)
    public void peekTest(){
        MyStack<String> stack = new MyStack<>();
        stack.peek();
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void elementAtTest(){
        MyStack<String> stack = new MyStack<>();
        stack.elementAt(3);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void removeElementAtTest1(){
        MyStack<String> stack = new MyStack<>();
        stack.removeElementAt(4);
    }

    @Test (expected = ArrayIndexOutOfBoundsException.class)
    public void removeElementAtTest2(){
        MyStack<String> stack = new MyStack<>();
        stack.removeElementAt(-4);
    }

    @Test
    public void removeElementAtTest3(){
        MyStack<String> stack = new MyStack<>();
        stack.push("string");
        stack.push("string");
        stack.push("string");
        stack.push("string");
        stack.push("string");
        stack.removeElementAt(2);
    }

    @Test
    public void growTest(){
        MyStack<Integer> integers = new MyStack<>();
        integers.push(1);
        integers.push(1);
        integers.push(1);
        integers.push(1);
        integers.push(1);
        integers.push(1);
        integers.grow(2);
    }



}
