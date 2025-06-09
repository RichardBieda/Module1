package Module2.Reflection.M3;

import Module2.Reflection.Car;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.stream.Stream;

class R3Test {

    public static void main(String[] args) {
        Class<?> aClass;
        try {
            aClass = Class.forName("Module2.Reflection.Car");
            Constructor<?>[] cons = aClass.getDeclaredConstructors();
            Stream<Constructor<?>> stream = Stream.of(cons);
            stream.forEach(t -> {
                System.out.println("class name: " + t.getName());
                System.out.println("is private: " + Modifier.isPrivate(t.getModifiers()));
                int paraCount = t.getParameterCount();
                System.out.println("parameter count: " + paraCount);
                if (paraCount > 0) {
                    Class<?>[] paramTypes = t.getParameterTypes();
                    for (Class<?> p : paramTypes) {
                        System.out.println("parameter type: " + p.getSimpleName());
                    }
                }
                System.out.println("---");
            });

            Constructor<?> con1 = aClass.getDeclaredConstructor(String.class, int.class);
            con1.setAccessible(true);
            Object car1 = (Car) con1.newInstance("Audi", 2025);
            con1.setAccessible(false);

            Constructor<?> con2 = aClass.getDeclaredConstructor();
            con2.setAccessible(true);
            Object car2 = (Car) con2.newInstance();
            con2.setAccessible(false);
            Field brand = aClass.getDeclaredField("brand");
            brand.setAccessible(true);
            brand.set(car2, "Opel");
            brand.setAccessible(false);
            Field year = aClass.getDeclaredField("yearOfConstruction");
            year.setAccessible(true);
            year.set(car2, 2012);
            year.setAccessible(false);

            System.out.println(car1);
            System.out.println(car2);

        } catch (ClassNotFoundException | InvocationTargetException | InstantiationException | IllegalAccessException |
                 NoSuchMethodException | NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
    }
}
