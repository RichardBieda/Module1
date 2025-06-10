package Module2.Reflection.M4;

import Module2.Reflection.Car;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.Arrays;

class R4Test {

    public static void main(String[] args) {

        Class<?> aClass;
        try {
            aClass = Class.forName("Module2.Reflection.Car");
            Field[] fields = aClass.getDeclaredFields();
            Arrays.stream(fields).forEach(t -> {
                System.out.println("field name: " + t.getName());
                System.out.println("field type: " + t.getType());
                System.out.println("field modifier: " + Modifier.toString(t.getModifiers()));
                System.out.println("---");
            });

            Constructor<?> con = aClass.getDeclaredConstructor();
            con.setAccessible(true);
            Object car = (Car) con.newInstance();
            con.setAccessible(false);
            Field brand = aClass.getDeclaredField("brand");
            brand.setAccessible(true);
            brand.set(car, "Opel");
            brand.setAccessible(false);
            Field year = aClass.getDeclaredField("yearOfConstruction");
            year.setAccessible(true);
            year.set(car, 2010);
            year.setAccessible(false);
            System.out.println(car);
        } catch(ClassNotFoundException | InvocationTargetException | NoSuchMethodException | InstantiationException |
                IllegalAccessException | NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
    }
}
