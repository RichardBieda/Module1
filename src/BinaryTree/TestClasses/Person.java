package BinaryTree.TestClasses;

public class Person {

    private String name;
    private String surName;
    private final int ID;

    public Person(String name, String surName, int income) {
        this.name = name;
        this.surName = surName;
        this.ID = income;
    }

    public int getID() {
        return ID;
    }

    public String getSurName() {
        return surName;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return name + " " + surName;
    }
}
