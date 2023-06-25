import java.util.*;                                     //Закомментировал циклы вывода массивов для работы с большим количеством чисел

public class Main {
    public static void main(String[] args) {
        int length = getRandomNumber(5000, 100000);     //Создание массива в заданных пределах длины
        int[] array = new int[length];
        for (int i=0; i < length; i++) {                //Заполнение значениями в заданных пределах
            array[i] = getRandomNumber(-100, 100);
        }
        System.out.println("Стартовый массив:");        //Вывод стартового массива
        System.out.println("Длина массива:"+ array.length);
        //for (int i : array) {
        //    System.out.print(i + " ");
        //}
        System.out.println();
        List<Integer> list = new ArrayList<>();         //Перевод массива в лист
        for (int i : array) {
            list.add(i);
        }
        long start1 = System.nanoTime();                //Начало сортировки выбором
        int[] result = sortingChoose(array, length);
        long finish1 = System.nanoTime();
        System.out.println("Время сортировки: " + (finish1-start1)/1000 + " мс");
        System.out.println("Сортированный массив:");
        //for (int i : result) {
        //    System.out.print(i + " ");
        //}
        System.out.println();
        long start2 = System.nanoTime();                //Сортировка через Collections.sort() для сравнения
        Collections.sort(list);
        long finish2 = System.nanoTime();
        System.out.println("Время сортировки: " + (finish2-start2)/1000 + " мс");
        System.out.println("Сортированный лист:");
        //int listSize = list.size();
        //for (int i=0; i <listSize; i++) {
        //    System.out.print(list.get(i)+ " ");
        //}
    }
    //Сортировка выбором
    public static int[] sortingChoose(int[] array,int length) {
        for (int i=0; i<length-1;i++) {
            int indexMin = i;
            for (int j =i+1; j < length; j++) {
                if (array[indexMin] > array[j]) {
                    indexMin = j;
                }
            }
            if (indexMin != i) {
                int swapN = array[i];
                array[i] = array[indexMin];
                array[indexMin] = swapN;
            }
        }
        return array;
    }
    //Создание случайных чисел для длины и заполнения массива
    public static int getRandomNumber(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }
}