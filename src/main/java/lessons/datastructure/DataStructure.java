package lessons.datastructure;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import java.util.Stack;
import java.util.Vector;

public class DataStructure {
    public static void main(String[] args) {
        array();
        // stack();
        // quee();
        // list();
        // set();
        // map();
    }

    public static void map() {
        var hashMap = new HashMap<Integer, String>();
        String c1 = "IBM";
        String c2 = "Google";
        String c3 = "Amazon";

        hashMap.put(c1.hashCode(), c1);
        hashMap.put(c2.hashCode(), c2);
        hashMap.put(c3.hashCode(), c3);

        System.out.println("HasMap: " + hashMap);

        var keys = hashMap.keySet();
        for (Integer key : keys) {
            System.out.println("Key: " + key + ", Value: " + hashMap.get(key));
        }

        var values = hashMap.values();
        values.forEach(System.out::println);

        hashMap.entrySet().forEach(item -> {
            System.out.println("Key: " + item.getKey() + " Value: " + item.getValue());
        });
    }

    public static void set() {
        Set<String> hashSet = new HashSet<>();
        hashSet.add("IBM");
        hashSet.add("Google");
        hashSet.add("Casio");
        hashSet.add("Casio");

        String company = "Amazon";
        hashSet.add(company);

        System.out.println("HashSet: " + hashSet);

        for (String element : hashSet) {
            System.out.println("Element: " + element);
        }
    }

    public static void list() {
        List<String> vector = new Vector<>();
        vector.add("Hola");
        vector.add("Mundo");

        System.out.println(vector);

        // ArrayList
        var arrayList = new java.util.ArrayList<Integer>();
        arrayList.add(17);
        arrayList.add(9);
        arrayList.add(98);

        arrayList.forEach(value -> System.out.println("Number: " + value));
        System.out.println("ArrayList Size: " + arrayList.size());
        // LinkedList
        List<String> linkedList = new LinkedList<>();
        linkedList.add("Apple");
        linkedList.add("Banana");
        linkedList.add("Cherry");

        System.out.println("LinkedList is empty: " + linkedList.isEmpty());

        // ListIterator
        ListIterator<String> li = linkedList.listIterator();
        while (li.hasNext()) {
            System.out.println("Element: " + li.next());
        }
    }

    public static void quee() {
        Deque<Integer> deque = new ArrayDeque<>();
        deque.push(1);
        deque.push(3);
        deque.push(6);

        for (Integer number : deque) {
            System.out.println("Number: " + number);
        }
    }

    public static void stack() {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(3);
        stack.push(6);
        stack.push(9);

        for (Integer number : stack) {
            System.out.println("Number: " + number);
        }

        System.out.println("Stack size: " + stack.size());
        System.out.println("Stack Peek: " + stack.peek());

        while (!stack.isEmpty()) {
            System.out.println("Popped: " + stack.pop());
        }

        System.out.println("Stack size: " + stack.size());
    }

    public static void array() {
        int[] nums = new int[5];

        nums[0] = 1;
        nums[1] = 2;
        nums[2] = 3;
        nums[3] = 4;
        nums[4] = 5;

        int[] nums2 = {6, 7, 8, 9, 10};

        System.out.println("Array 1: " + Arrays.toString(nums));
        System.out.println("Array 2: " + Arrays.toString(nums2));

        int result = Arrays.compare(nums, nums2);
        System.out.println("Compare nums and nums2: " + result);

    }
}
