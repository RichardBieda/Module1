package Module2.Casting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        Collections.addAll(list, 1, 2, 3, 4, 5, 6, 7, 8, 9,0);
        list.forEach(x -> System.out.println(getNumber(x)));

        getProductTypeByName("Cherry");
    }

    static String getNumber(int number) {
        return switch (number) {
            case 1, 3, 5, 7, 9 -> number + " Ungerade";
            default -> number + " Gerade";
        };
    }

    static String getProductTypeByName(String product) {
        var result = switch (product) {
            case "Apple", "Peach" -> {
                System.out.println("This is a Fruit");
                yield "Fruit";
            }
            case "Raspberry", "Cherry" -> {
                System.out.println("This is a Berry");
                yield "Berry";
            }
            case "Tomato" -> {
                System.out.println("This is a Vegetable");
                yield "Vegetables";
            }
            default -> {
                System.out.println("Other");
                yield "other";
            }

        };
        return result;
    }
}
