package com.sadatmalik.educativeio.recursion;

/**
 * @author sm@creativefusion.net
 */
public class factorial {

    private static int factorialIterative(int n) {
        int factorial = 1;
        for (int i = n; i >= 1; i--) {
            factorial *= i;
        }
        return factorial;
    }

    private static int factorialRecursive(int n) {
        if (n == 1)
            return n;

        return n * factorialRecursive(n-1);
    }

    public static void main(String[] args) {
        System.out.println(factorialIterative(5));
        System.out.println(factorialRecursive(5));
    }
}
