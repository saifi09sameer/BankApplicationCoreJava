package com.Test;
public class PrimeNumberCheck {
    public static void main(String[] args) {
        int count = 0;
        int sum = 0;
        for (int i = 100; i <= 1000; i++) {
            for (int ii = 2; ii < i / 2; ii++) {
                if (i % ii == 0) {
                    count++;
                    break;
                }
            }
            if (count == 0) {
                System.out.println("Prime No : " + i);
                int n = i;
                while (n != 0) {
                    sum = sum + n % 10;
                    n = n / 10;
                }
                if (sum == 19) {
                    System.out.println("Prime Number whose sum is 19:-  " + i);
                }
                sum = 0;
            }
            count = 0;
        }
    }
}