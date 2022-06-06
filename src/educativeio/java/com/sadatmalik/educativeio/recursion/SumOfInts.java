package com.sadatmalik.educativeio.recursion;

/**
 * @author sm@creativefusion.net
 */
public class SumOfInts {

    private static int sumOfInts(int n) {
        if (n == 1)
            return 1;

        return n + sumOfInts(n-1);
    }

    public static void main(String[] args) {
        System.out.println(sumOfInts(5));
    }
}
