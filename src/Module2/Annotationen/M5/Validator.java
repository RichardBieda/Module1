package Module2.Annotationen.M5;

import java.lang.reflect.Field;

class Validator {

    public static void validate(Object obj) throws IllegalAccessException {
        Class<?> clazz = obj.getClass();
        for (Field f : clazz.getDeclaredFields()) {
            f.setAccessible(true);
            if (f.isAnnotationPresent(NotNull.class)) {
                Object value = f.get(obj);
                if (value == null) {
                    System.out.println("field '" + f.getName() + "' cannot be null!");
                }
            }
        }
    }

    public static void main(String[] args) {
        Customer cus = new Customer(null);
        try {
            Validator.validate(cus);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
