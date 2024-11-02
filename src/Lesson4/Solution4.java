package Lesson4;

import java.util.Scanner;

public class Solution4 {

    public static void main(String[] args) {

//        Write a program to print Fibonacci series of n terms where n is input by user. Fibonacci numbers: 1,1,2,3,5,8,13,21,34,55...
//        int n = new Scanner(System.in).nextInt();
//        int old = 0;
//        int fib = 1;
//
//        while (n > 0) {
//            System.out.println(fib);
//            int lastFib = old;
//            old = fib;
//            fib = lastFib + old;
//            n--;
//        }

//         Write a program that generates a random number and asks the user to guess what the number is.
//        Scanner scan = new Scanner(System.in);
//        double x = Math.random();
//        int randomNumber = (int) (x * 10) +1;
//
//        System.out.println("What's the wanted number 1-10");
//        while (true) {
//            int number = scan.nextInt();
//            if (number == randomNumber) {
//                System.out.println("Hurray you got it");
//                break;
//            } else {
//                System.out.println("Try it again");
//            }
//        }

//        Write a program to check whether a number is prime or not.
        int number = new Scanner(System.in).nextInt();
        boolean isprime = false;

        if (number == 0 || number == 1) {
            isprime = false;
        } else {
            for (int i = 2; i <= number/2; i++) {
                if (number %i == 0) {
                    isprime = false;
                } else {
                    isprime = true;
                }
            }
        }

        if (isprime) {
            System.out.println(number + " is a Primenumber");
        } else {
            System.out.println(number + " is not a Primenumber");
        }
    }
}
