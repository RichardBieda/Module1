package Module2.Reflection.M5;

import java.lang.reflect.*;
import java.util.Arrays;

class R5Test {

    public static void main(String[] args) {

        try {
            Class<?> aClass;
            aClass = Class.forName("Module2.Reflection.Car");
            Constructor<?> con = aClass.getDeclaredConstructor();
            con.setAccessible(true);
            Object obj = con.newInstance();
            con.setAccessible(false);

            Method[] methods = aClass.getDeclaredMethods();
            Arrays.stream(methods).forEach(t -> {
                System.out.println("method name: " + t.getName());
                System.out.println("method return type: " + t.getReturnType());
                System.out.println("parameter type: " + Arrays.toString(t.getParameterTypes()));
                System.out.println("field modifier: " + Modifier.toString(t.getModifiers()));
                System.out.println("---");
            });

            Method infoMethod = aClass.getDeclaredMethod("info");
            infoMethod.setAccessible(true);
            Object result = infoMethod.invoke(obj);
            infoMethod.setAccessible(false);
            System.out.println(result);
        } catch (ClassNotFoundException | NoSuchMethodException | InvocationTargetException | IllegalAccessException |
                 InstantiationException e) {
            throw new RuntimeException(e);
        }
    }
}
