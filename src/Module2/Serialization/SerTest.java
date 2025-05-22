package Module2.Serialization;

import java.io.*;

class SerTest {

    public static void main(String[] args) {
//        Dog dog = new Dog("bello", 5);
//        try (FileOutputStream fos = new FileOutputStream("src\\Module2\\Serialization\\dog.ser"); ObjectOutputStream oos = new ObjectOutputStream(fos)){
//            oos.writeObject(dog);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }


        try (FileInputStream fis = new FileInputStream("src\\Module2\\Serialization\\dog.ser"); ObjectInputStream ois = new ObjectInputStream(fis)){
            Dog dog1 = (Dog) ois.readObject();
            System.out.println(dog1);
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    static class Dog implements Serializable {

        @Serial
        private static final long serialVersionUID = 1L;
        private static int count;
        String name;
        int age;

        Dog() {
            count++;
        }
        Dog(String name, int age) {
            this.name = name;
            this.age = age;
            count++;
        }

        @Override
        public String toString() {
            return "I'm a dog " + name + ", " + age + ", " + count;
        }
    }
}
