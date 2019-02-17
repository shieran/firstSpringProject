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

        assertTrue(numbers.equals(numbers2));
        assertFalse(numbers.equals(numbers3));

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
}
