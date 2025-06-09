package Module2.Reflection.M1;

class Rtest {

    public static void main(String[] args) {

        Class<?> aClass;
        try {
            aClass = Class.forName("Module2.Reflection.Car");
            System.out.println(aClass.getCanonicalName());
//            Field[] fields = aClass.getDeclaredFields();
//            for (Field f : fields)
//                System.out.println(f.getName());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
