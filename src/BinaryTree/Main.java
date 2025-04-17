package BinaryTree;

import BinaryTree.TestClasses.Person;

import java.util.Comparator;
import java.util.Objects;

import static java.lang.Integer.compare;

public class Main {

    public static void main(String[] args) {
        BiTree<Person> bt = new BiTree<>(Person::getID);
        bt.addAll(new Person("Milan", "Vucic", 857245), new Person("Mikhail", "Mikhailovic", 785895),
                new Person("Donny", "Donovon", 987542), new Person("Michael", "John", 845785), new Person("Richard", "Bieda", 1000000));

    }
}
