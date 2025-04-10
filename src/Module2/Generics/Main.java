package Module2.Generics;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("Hallo");
        list.add(1);
        for (Object x : list) {
//            String s = (String) x; ClassCastException
//            System.out.println(s.toUpperCase());
        }

        List<String> list1 = new ArrayList();
        list1.add("Hallo");
//        list1.add(1);

        List<Double> list2 = fill(1.5, 5.5, 10d);
        for (Number d : list2) {
            System.out.println(d);
        }

        List<Integer> list3 = fill(5, 100);
        for (Number d : list3) {
            System.out.println(d);
        }

        List<String> list4 = new LinkedList<>();
        list4.add("Hello");
        list4.add("you");

        Map<String, String> map = new HashMap<>();
        map.put("11", "22");
        map.put("kkkk", "tttt");
        doThinks(list4);
        doThinks(map);


        List<Integer> list5 = genericArray(list3, 55, 66, 77);
        for (Integer i : list5) {
            System.out.println(i);
        }
//        Creating arrays of a non-reifiable type is not allowed in Java
        List<LinkedList<String>> list6 = new ArrayList<>();
        List<LinkedList<String>> list7 = genericArray(list6, new LinkedList<>(), new LinkedList<>());
        System.out.println(list7.size());
        for (LinkedList<String> x : list7) {
            System.out.print(x.toString());
        }

//        generic array creation
//        ArrayList<String>[] arr = new ArrayList<String>[3];
        ArrayList<String>[] arr = new ArrayList[3];
        ArrayList<String> a1 = new ArrayList<>();
        a1.add("hello");
        ArrayList<String> a2 = new ArrayList<>();
        a2.add("blabla");
        ArrayList<Integer> a3 = new ArrayList<>();
        a3.add(44);
        arr[0] = a1;
        arr[1] = a2;
//        arr[2] = a3;
        for (List<String> l : arr) {
            for (String s : l) {
                System.out.print(s.toUpperCase());
            }
        }
    }

    static <T> List<T> fill(T...elements) {
        List<T> list = new ArrayList<>();
        for (T t : elements) {
            list.add(t);
        }
        return list;
    }
    static <T> void doThinks(Collection<T> collection) {
       for (T t : collection) {
           System.out.println(t);
       }
    }

    static <K, V> void doThinks(Map<K, V> map) {
        for (K k : map.keySet()) {
            System.out.println(map.get(k));
        }
    }

    @SafeVarargs
    static <E> List<E> genericArray(List<E> list, E...elements) {
        for (E e : elements) {
            list.add(e);
        }
        return list;
    }
}
