package Module2.ObjectsClass;

import java.lang.reflect.Method;
import java.util.Objects;

public class Person implements Cloneable {

    String name;
    String surName;

    Person(String name, String surName) {
        this.name = name;
        this.surName = surName;
    }

    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return name.equals(person.name) && surName.equals(person.surName);
    }

    public int hashCode() {
        return 7 * (Objects.hashCode(name) + Objects.hashCode(surName));
    }

    public static void main(String[] args) {
        Person p1 = new Person("Richard", "Bieda");
        Person p2 = new Person("Richard", "Bieda");
        System.out.println(p1.equals(p2));
        System.out.println(p1.hashCode());
        System.out.println(p1.hashCode() == p2.hashCode());

        Person p3 = new Person("Ronald", "McDonald");
        Person p4 = p3.clone();
        System.out.println(p4.name+ " "+p4.surName);
    }

//    @Override
//    public Person clone() {
//        try {
//            Person clone = (Person) super.clone();
//            // TODO: copy mutable state here, so the clone can't change the internals of the original
//            clone.name = this.name;
//            clone.surName = this.surName;
//            return clone;
//        } catch (CloneNotSupportedException e) {
//            throw new AssertionError();
//        }
//    }
    public Person clone() {
        Person result = null;
        try {
            result =  (Person)super.clone();
        } catch (CloneNotSupportedException e) {}
        return result;
    }
}
