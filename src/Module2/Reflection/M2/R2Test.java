package Module2.Reflection.M2;

import java.lang.reflect.Modifier;
import java.util.stream.Stream;

class R2Test {

    public static void main(String[] args) {

        Class<?> aClass;
        try {
            aClass = Class.forName("Module2.Reflection.Car");
            System.out.println(aClass.getCanonicalName());
            System.out.println(aClass.getSimpleName());
            System.out.println(aClass.getSuperclass());

            Class<?>[] interfaces = aClass.getInterfaces();
            Stream<Class<?>> inter = Stream.of(interfaces);

            inter.forEach(System.out::println);
            int modi = aClass.getModifiers();
            System.out.println(Modifier.isPublic(modi));
            System.out.println(Modifier.isFinal(modi));
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
