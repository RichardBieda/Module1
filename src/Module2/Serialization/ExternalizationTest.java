package Module2.Serialization;

import java.io.*;

class ExternalizationTest {



    public static void main(String[] args) {
        Cat cat = new Cat("Fluffy", 3);

        try (FileOutputStream fos = new FileOutputStream("src\\Module2\\Serialization\\cat.ser"); ObjectOutputStream oos = new ObjectOutputStream(fos)){
            oos.writeObject(cat);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        try (FileInputStream fis = new FileInputStream("src\\Module2\\Serialization\\cat.ser"); ObjectInputStream ois = new ObjectInputStream(fis)){
            Cat cat1 = (Cat) ois.readObject();
            System.out.println(cat1);
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    static class Cat implements Externalizable {

        @Serial
        private static final long serialVersionUID = 150L;

        String name;
        int age;

        public Cat() {}
        public Cat(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public void writeExternal(ObjectOutput out) throws IOException {
            out.writeObject(name);
            out.writeObject(age + 10);
        }

        @Override
        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
            name = (String) in.readObject();
            age = (int) in.readObject();
        }

        @Override
        public String toString() {
            return "I'm a cat " + name + ", " + age;
        }
    }
}
