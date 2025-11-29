package ua.opnu;

import java.util.Arrays;
import java.util.function.Predicate;

public class GenericUtils {

    // === Завдання 4: filter ===
    public static <T> T[] filter(T[] input, Predicate<T> predicate) {
        @SuppressWarnings("unchecked")
        T[] temp = (T[]) new Object[input.length];

        int counter = 0;
        for (T element : input) {
            if (predicate.test(element)) {
                temp[counter++] = element;
            }
        }

        // Повертаємо масив того ж типу
        @SuppressWarnings("unchecked")
        T[] result = Arrays.copyOf(input, counter);
        for (int i = 0; i < counter; i++) {
            result[i] = temp[i];
        }
        return result;
    }

    // === Завдання 5: contains ===
    public static <T extends Comparable<T>, V extends T> boolean contains(T[] array, V element) {
        for (T item : array) {
            if (item.compareTo(element) == 0) {
                return true;
            }
        }
        return false;
    }
}