package ua.opnu;

public class Printer {

    // узагальнений метод, який друкує елементи масиву будь-якого типу
    public <T> void printArray(T[] array) {
        for (T element : array) {
            System.out.println(element);
        }
    }
}