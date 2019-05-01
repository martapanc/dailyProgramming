package codewars.sums;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SumOfIntegersTest {

    @Test
    public void Test1()
    {
        assertEquals(-1, SumOfIntegers.GetSum(0, -1));
        assertEquals(1, SumOfIntegers.GetSum(0, 1));
        assertEquals(18, SumOfIntegers.GetSum(3, 6));
    }

    @Test
    public void Test2()
    {
        assertEquals(-1, SumOfIntegers.GetSum2(0, -1));
        assertEquals(1, SumOfIntegers.GetSum2(0, 1));
        assertEquals(18, SumOfIntegers.GetSum2(3, 6));
    }

}