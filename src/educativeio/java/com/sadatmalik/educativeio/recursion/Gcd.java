package com.sadatmalik.educativeio.recursion;

/**
 * @author sm@creativefusion.net
 */
public class Gcd {

    private static int gcd(int num1, int num2) {
        if (num1 < num2)
            gcd(num2, num1);

        int divisor = num1 / 2;

        return gcd(num1, num2, divisor);
    }

    private static int gcd(int num1, int num2, int divisor) {
        if (num1 % divisor == 0 && num2 % divisor == 0)
            return divisor;

        return gcd(num1, num2, divisor-1);
    }

    public static void main(String[] args) {
        System.out.println(gcd(24, 18)); //6
        System.out.println(gcd(36, 54)); //18
    }
}
