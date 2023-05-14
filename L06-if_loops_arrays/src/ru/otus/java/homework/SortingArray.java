package ru.otus.java.homework;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class SortingArray {
    public static void main(String[] args) {
        //тут генерируем массив чисел
        int[] array = generateRandomArray(100_000);

        //копируем этот массив для сортировки пузырьковым методом
        int[] bubleSortArray = Arrays.copyOf(array, array.length);

        // используем collection.sort() для сортировки, замеряем время
        long startTime = System.currentTimeMillis();
        Arrays.sort(array);
        long endTime = System.currentTimeMillis();
        long collectionSortTime = endTime - startTime;

        // тоже самое пузырьком
        startTime = System.currentTimeMillis();
        bubleSort(bubleSortArray);
        endTime = System.currentTimeMillis();
        long bubleSortTime = endTime - startTime;

        System.out.println("Время сортировки с помощью collection.Sort(): " + collectionSortTime + " мс");
        System.out.println("Время сортировки пузырьковым методом: " + bubleSortTime + " мс");
    }

    private static int[] generateRandomArray(int size) {
        int[] array = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt();
        }
        return array;
    }

    public static void bubleSort(int[] array) {
        int n = array.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }
}