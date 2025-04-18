package BinaryTree;

import BinaryTree.TestClasses.Person;

import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
        BiTree<Person> bt = new BiTree<>(Person::getID);
        bt.addAll(new Person("Milan", "Vucic", 1111), new Person("Mikhail", "Mikhailovic", 2222),
                new Person("Donny", "Donovon", 3333), new Person("Michael", "John", 4444), new Person("Richard", "Bieda", 5555));

        Iterator<Person> periterator = bt.getIterator();
        while (periterator.hasNext())
            System.out.println(periterator.next());
    }
}
