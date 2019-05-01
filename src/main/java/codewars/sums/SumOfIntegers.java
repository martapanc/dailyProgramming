package codewars.sums;

public class SumOfIntegers {
    public static int GetSum(int a, int b) {
        return (Math.abs(a - b) + 1) * (a + b) / 2;
    }

    public static int GetSum2(int a, int b) {
        if (a > b) {
            int temp = b;
            b = a;
            a = temp;
        }
        return (b * (b + 1) - a * (a - 1)) / 2;
    }

}

// Sum of integers from a to b (a < b):
// S = (Sum 1 to b) - (sum of 1 to a-1)
//   = b (b+1) / 2    -    (a-1) a / 2          apply Gauss' formula
//   = ( bb + b - aa + a ) / 2                  expand
//   = ( bb - ab + b + ab - aa  + a ) / 2       add and subtract ab
//   = ( b + a ) ( b - a + 1) / 2               factorise
//
//   Use of absolute value to remove the (a < b) constraint: ( b + a ) ( |b - a| + 1 ) / 2

