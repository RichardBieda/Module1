package Lesson6;



public class LazyEvaluationExemple {
    public static void main(String[] args) {

        int number = 10;
        int bigNumber = 100000;

        if (0 < 500 && (number += 10) < bigNumber) {
            System.out.printf("(number + 10) was executed, number is now %d\n", number);
        }

        if (500 < 0 && (number += 10) < bigNumber) {

        } else {
            System.out.printf("(number + 10) wasn't executed, number is still %d\n", number);
        }
    }
}
