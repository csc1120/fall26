/*
 * Course: CSC-1120
 * Assignment name
 * File name
 * Name: Sean Jones
 * Last Updated:
 */
package week7.section111;

public class Misc {
    enum Day { SUNDAY, MONDAY, TUESDAY,
        WEDNESDAY, THURSDAY, FRIDAY, SATURDAY; }

    static void main() {
        numLettersInADay(Day.WEDNESDAY);

//        Integer a = 6;
//        Integer b = switch(a) {
//            case 0 -> 0;
//            case Integer x when x > 5 -> 100;
//            default -> throw new IllegalArgumentException();
//        };
//
//        Object o = new Object();
//        switch(o) {
//            case String s -> System.out.println("String");
//            case Integer i -> System.out.println(i);
//            default -> System.out.println("Some object");
//        }

//        Integer[] nums = {5, 2, 7, 9, 3, 4};
//        List<Integer> list = Arrays.asList(nums);
//        List<Integer> list2 = List.of(5, 2, 7, 8, 3, 2);
//        List<Integer> list3 = Arrays.stream(nums).toList();
//        List<Integer> list4 = Arrays.stream(nums).collect(Collectors.toList());
//        LinkedList<Integer> list5 = new LinkedList<>(List.of(5, 2, 7, 8, 3, 2));
//
//        System.out.println(list.getClass().getName());
//        System.out.println(list2.getClass().getName());
//        System.out.println(list3.getClass().getName());
//        System.out.println(list4.getClass().getName());
//        System.out.println(list5.getClass().getName());


        int i = 3;
        Object o = new Object();
        String s = "hello"; // string pool
        String str; // declaration allocates stacks space
        str = new String("hello"); // new allocates heap space
        // constructor builds in the heap

        System.out.println(s == "hello");
        System.out.println(str == "hello");
    }

    private static void numLettersInADay(Day day) {
        int numLetters = switch (day) {
            case MONDAY, FRIDAY, SUNDAY -> {
                System.out.println(day);
                yield 6;
            }
            case TUESDAY -> 7;
            case THURSDAY, SATURDAY -> 8;
            case WEDNESDAY -> 9;
            default -> throw new IllegalStateException("Invalid day: " + day);
        };
        System.out.println(numLetters);
    }
}
