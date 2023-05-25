public class Sort {
    public static void main(String[] args) {
        java.util.List<Integer> integers = new java.util.ArrayList<>(java.util.List.of(1, 5, 3));
        java.util.List<Integer> integers3 = new java.util.ArrayList<>(java.util.List.of(1, 2, 3));
        java.util.List<Integer> integers2 = new java.util.ArrayList<>(integers);

        integers.forEach(System.out::println);
        java.util.Collections.sort(integers); // bubble sort
        integers.forEach(System.out::println);
        java.util.Collections.sort(integers2); // Collections.sort
    }
}
