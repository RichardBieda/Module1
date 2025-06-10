package Module2.Reflection.M8;

import java.lang.reflect.Constructor;

class R8Test {

    public static void main(String[] args) {

        try {
            String className = "Module2.Reflection.Car";
            Class<?> aClass = Class.forName(className);

            Constructor<?> con = aClass.getDeclaredConstructor(String.class, int.class);
            con.setAccessible(true);
            Object obj = con.newInstance("Porsche 911", 2015);
            con.setAccessible(false);

            System.out.println("class name" + obj.getClass().getCanonicalName() + ", object: " + obj.toString());
        } catch (Exception e) {
            throw  new RuntimeException(e);
        }
    }
}
