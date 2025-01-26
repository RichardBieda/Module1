package Lesson21;

import java.util.Stack;

public class Main {

    public static void main(String[] args) {

        System.out.println(isBalanced("()()()[]{{[]}}"));//true
        System.out.println(isBalanced("((])[)"));//false
        System.out.println(isBalanced("((({}{[]})))"));//true
        System.out.println(isBalanced("([]){(}"));//false
        System.out.println(removeAdjacentLetters("afghhgfdds"));
        System.out.println(removeAdjacentLetters("xdaabbccdy"));
    }

    //Method who tests whether brackets are properly paired
    //The idea using a stack is from goggle (it suits well), but the implementation is complete by myself.
    public static boolean isBalanced(String input) {
        char[] bracketArray = input.toCharArray();
        Stack<Character> chStack = new Stack<>();

        for (char newElement : bracketArray) {
            if (chStack.isEmpty()) {
                chStack.push(newElement);
                continue;
            }

            char oldElement = chStack.peek();
            if (isPair(oldElement, newElement)) {
                chStack.pop();
            } else {
                chStack.push(newElement);
            }
        }
        return chStack.isEmpty();
    }

    private static boolean isPair(char a, char b) {
        return a == '(' && b == ')' || a == '{' && b == '}' || a == '[' && b == ']';
    }


    public static String removeAdjacentLetters(String input) {
        Stack<Character> result = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            if (result.isEmpty()) {
                result.push(input.charAt(i));
                continue;
            }
            if (result.peek() == input.charAt(i)) {
                result.pop();
            } else {
                result.push(input.charAt(i));
            }
        }
        return result.toString().replaceAll("[\\W]", "");
    }
}
