package Module2.Reflection.M6;

import Module2.Reflection.Important;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

class R6Test {

    public static void main(String[] args) {

        try {
            Class<?> aClass;
            aClass = Class.forName("Module2.Reflection.Car");
            Constructor<?> con = aClass.getDeclaredConstructor(String.class, int.class);
            con.setAccessible(true);
            Object obj = con.newInstance("Porsche 911", 2015);
            con.setAccessible(false);

            Field[] fields = aClass.getDeclaredFields();
            Arrays.stream(fields).filter(x -> x.isAnnotationPresent(Important.class)).forEach(x -> {
                Important i = x.getAnnotation(Important.class);
                System.out.println("field: " + x.getName()+ ", annotation type: " + i.annotationType() + ", annotation value: " + i.value());
            });
        } catch (ClassNotFoundException | InvocationTargetException | InstantiationException | IllegalAccessException |
                 NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }
}
