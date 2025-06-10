package Module2.Annotationen.M4;

import Module2.Annotationen.M2.Developer;

@Developer(name = "here name")
class App {

    public static void main(String[] args) {
        Class<?> aClass = App.class;
        if (aClass.isAnnotationPresent(Developer.class)) {
            Developer d = aClass.getDeclaredAnnotation(Developer.class);
            System.out.println("is present: " + d.toString());
        }
    }
}
