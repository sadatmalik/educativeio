package com.sadatmalik.educativeio.recursion;

/**
 * @author sm@creativefusion.net
 */
public class Fibonacci {

    private static int fib(int n) {
        if (n == 0)
            return 0;

        if (n == 1)
            return 1;

        return fib(n-1) + fib(n-2);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            System.out.print(fib(i) + " ");
        }
    }
}
