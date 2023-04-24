package ru.otus.java.demo;

public class HW {
    public static void main(String[] args) {
        System.out.print("Привет\t");
        System.out.println("Вывод закончен");
        String[] array = getArray();
//        System.out.println(array.length);
//        for (int i = 100; i <= array.length; i++) {
//            System.out.println(array[i - 100]);
//        }

        String[] s = {"1"};
        String[] s2 = new String[1];


        String[][] array_2 = {
                {"1", "3"},
                {"1", "2"},
                {"1"},
        };
        String[][] array3 = new String[3][];
//        {
//                null,
//                null,
//                null,
//        };
        array3[0] = new String[2];
//        {
//                {null, null},
//                null,
//                null,
//        };
        array3[1] = new String[2];
//        {
//                {null, null},
//                {null, null},
//                null,
//        };
        array3[2] = new String[1];
//        {
//                {null, null},
//                {null, null},
//                {null},
//        };
        array_2[2][0] = "Привет\n";
//        {
//                {null, null},
//                {null, null},
//                {""},
//        };
//        System.out.println(s); // [Ljava.lang.String;@4617c264
//        System.out.println(array_2); // [[Ljava.lang.String;@36baf30c
//        System.out.println(array_2[0]); // [Ljava.lang.String;@7a81197d
//        System.out.println(array_2[1][1]); // [Ljava.lang.String;@7a81197d


        for (int i = 0; i < array_2.length; i++) {
            for (int j = 0; j < array_2[i].length; j++) {
                System.out.println(i + 1 + ". " + array_2[i][j]); // i 0 j 0 -> i 0 j 1 -> i 1 j 0
            }
            System.out.println();
        }

    }

    private static String[] getArray() {
        String[] strings = new String[4];
        strings[0] = "Hello";
        strings[1] = "Hello";
        strings[2] = "Hello";
        return strings;
    }
}
