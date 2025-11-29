package ua.opnu;

import java.util.Arrays;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {

        // ===== Завдання 1: MyOptional =====
        MyOptional<String> middleName = new MyOptional<>();
        System.out.println(middleName);                                // MyOptional[empty]
        System.out.println("isPresent: " + middleName.isPresent());    // false
        System.out.println("orElse: " + middleName.orElse("немає"));   // "немає"

        MyOptional<String> username = new MyOptional<>("admin");
        System.out.println(username);                                  // MyOptional[value=admin]
        System.out.println("isPresent: " + username.isPresent());      // true
        System.out.println("get(): " + username.get());                // "admin"
        System.out.println("orElse: " + username.orElse("guest"));     // "admin"

        try {
            String test = middleName.get();
            System.out.println("unexpected: " + test);
        } catch (IllegalStateException ex) {
            System.out.println("Очікуваний виняток: " + ex.getMessage());
        }

        try {
            MyOptional<String> broken = new MyOptional<>(null);
            System.out.println("unexpected: " + broken);
        } catch (IllegalArgumentException ex) {
            System.out.println("Правильно не дозволив null: " + ex.getMessage());
        }

        System.out.println("\n===== Завдання 2: BookData & Comparable =====");
        BookData b1 = new BookData("Java", "Author A", 10, 45.0);   // 4.5
        BookData b2 = new BookData("Python", "Author B", 5, 20.0);  // 4.0
        BookData b3 = new BookData("C#", "Author C", 0, 0.0);       // 0.0

        BookData[] books = {b1, b2, b3};
        Arrays.sort(books);  // сортування за нашим compareTo
        for (BookData b : books) {
            System.out.println(b);
        }

        System.out.println("\n===== Завдання 3: Printer.printArray() =====");
        Printer myPrinter = new Printer();
        Integer[] intArray = {1, 2, 3};
        String[] stringArray = {"Hello", "World"};
        myPrinter.printArray(intArray);
        myPrinter.printArray(stringArray);

        System.out.println("\n===== Завдання 4: GenericUtils.filter() =====");
        Integer[] numbers = {1,2,3,4,5,6,7,8,9,10};
        Predicate<Integer> isEven = n -> n % 2 == 0;
        Integer[] evens = GenericUtils.filter(numbers, isEven);
        System.out.println("Парні: " + Arrays.toString(evens));

        System.out.println("\n===== Завдання 5: GenericUtils.contains() =====");
        String[] words = {"apple", "banana", "cherry"};
        boolean hasBanana = GenericUtils.contains(words, "banana");
        boolean hasMango = GenericUtils.contains(words, "mango");
        System.out.println("banana? " + hasBanana);
        System.out.println("mango? " + hasMango);

        System.out.println("\n===== Завдання 6: GenericTwoTuple / GenericThreeTuple =====");
        GenericTwoTuple<String, Integer> t1 =
                new GenericTwoTuple<>("Саша", 95);
        System.out.println("TwoTuple: " + t1);

        GenericThreeTuple<String, Integer, String> t2 =
                new GenericThreeTuple<>("Марія", 88, "A-");
        System.out.println("ThreeTuple: " + t2);
        System.out.println("Ім'я: " + t2.getFirst() +
                ", рейтинг: " + t2.getSecond() +
                ", літера: " + t2.third);
    }
}