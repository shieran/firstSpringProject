package by.hancharou;


import org.junit.Test;

import static org.junit.Assert.*;

public class FractionTest {

    Fraction first = new Fraction(3, 4);
    Fraction second = new Fraction(5,3);
    Fraction third = new Fraction(12,1);

    @Test
    public void add(){
        Fraction res1 = first.addFractions(second);
        Fraction res2 = second.addFractions(first);

        assertEquals("29/12", res1.toString());
        assertEquals(res1.toString(), res2.toString());
    }

    @Test
    public void multiply(){
        Fraction fraction1 = first.multiplyFractions(second);
        Fraction fraction2 = second.multiplyFractions(first);
        assertEquals(fraction1.toString(), fraction2.toString());
    }

    @Test(expected = LessThanZeroException.class)
    public void fractionConstructorTest(){
        Fraction testFraction1 = new Fraction(0, 12);
    }

    @Test(expected = LessThanZeroException.class)
    public void fractionConstructorTest2(){
        Fraction testFraction1 = new Fraction(0);
    }

    @Test()
    public void fractionConstructorTest3(){
        Fraction testFraction1 = new Fraction( 12);
        assertEquals(12, testFraction1.getNumerator());
    }

    @Test
    public void fractionConstructorTest4(){
        Fraction testFraction4 = new Fraction(10,12);
        assertEquals(10,testFraction4.getNumerator());
        assertEquals(12,testFraction4.getDenumerator());

    }

    @Test(expected = LessThanZeroException.class)
    public void fractionConstructorTest5(){
        Fraction testFraction1 = new Fraction(12, 0);
    }


    @Test
    public void toStringTest(){
        assertEquals("12", third.toString());
        assertEquals("5/3", second.toString());
    }

    @Test
    public void fractionReductionTest(){
        Fraction fraction = new Fraction(24,16);
        Fraction fraction1 = new Fraction(23,25);
        Fraction fraction2 = new Fraction(12,24);
        Fraction fraction3 = new Fraction(6,4);
        Fraction fraction4 = new Fraction(9,4);
        assertEquals("3/2", Fraction.fractionReduction(fraction).toString());
        assertEquals("23/25", Fraction.fractionReduction(fraction1).toString());
        assertEquals("1/2", Fraction.fractionReduction(fraction2).toString());
        assertEquals("3/2", Fraction.fractionReduction(fraction3).toString());
        assertEquals("9/4", Fraction.fractionReduction(fraction4).toString());
    }

    @Test
    public void compareToTest(){
        Fraction fraction1 = new Fraction(1,3);
        Fraction fraction2 = new Fraction(1,5);
        Fraction fraction3 = new Fraction(1,3);
        Fraction fraction4 = new Fraction(1,2);

        assertEquals(1, fraction1.compareTo(fraction2));
        assertEquals(0, fraction1.compareTo(fraction3));
        assertEquals(-1, fraction1.compareTo(fraction4));
    }

    @Test
    public void equalsTest(){
        Fraction fraction1 = new Fraction(2,4);
        Fraction fraction2 = new Fraction(2,4);
        Fraction fraction5 = new Fraction(2,3);
        Fraction fraction3 = fraction1;
        Fraction fraction4 = new Fraction(3,2);
        Object object = new Object();
        Object object1 = null;



        assertTrue(fraction1.equals(fraction3));
        assertTrue(fraction1.equals(fraction2));
        assertFalse(fraction1.equals(fraction4));
        assertFalse(fraction1.equals(object));
        assertFalse(fraction1.equals(object1));
        assertFalse(fraction1.equals(fraction5));
    }

    @Test
    public void hashCodeTest(){
        Fraction fraction1 = new Fraction(2,4);
        Fraction fraction2 = new Fraction(2,4);
        Fraction fraction3 = new Fraction(3,2);

        assertEquals(fraction1.hashCode(), fraction2.hashCode());
        assertNotEquals(fraction1.hashCode(), fraction3.hashCode());
    }

}

