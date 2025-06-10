package Module2.Reflection.M7;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

class R7Test {

    public static void main(String[] args) {

        try {
            Class<?> clazz = Class.forName("Module2.Reflection.Car");

            System.out.println("Class:");
            printModifiers(clazz.getModifiers());

            System.out.println("\nConstructor");
            for (Constructor<?> ctor : clazz.getDeclaredConstructors()) {
                System.out.println("  " + ctor.getName());
                printModifiers(ctor.getModifiers());
            }

            System.out.println("\nfields:");
            for (Field f : clazz.getDeclaredFields()) {
                System.out.println("  " + f.getName());
                printModifiers(f.getModifiers());
            }

            System.out.println("\nmethods:");
            for (Method m : clazz.getDeclaredMethods()) {
                System.out.println("  " + m.getName());
                printModifiers(m.getModifiers());
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    static void printModifiers(int mods) {
        System.out.println("    Raw: " + mods);
        System.out.println("    visibility:");
        System.out.println("      public? " + Modifier.isPublic(mods));
        System.out.println("      private? " + Modifier.isPrivate(mods));
        System.out.println("      protected? " + Modifier.isProtected(mods));
        System.out.println("    features:");
        System.out.println("      static? " + Modifier.isStatic(mods));
        System.out.println("      final? " + Modifier.isFinal(mods));
        System.out.println("      abstract? " + Modifier.isAbstract(mods));
        System.out.println("    as text: " + Modifier.toString(mods));
        System.out.println();
    }
}
