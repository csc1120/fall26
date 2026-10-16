/*
 * Course: CSC-1120
 * Assignment name
 * File name
 * Name: Sean Jones
 * Last Updated:
 */
package week7.section121;

import java.util.Optional;
import java.util.OptionalInt;

public class Misc {
    enum Day { SUNDAY, MONDAY, TUESDAY,
        WEDNESDAY, THURSDAY, FRIDAY, SATURDAY; }

    static void main() {
//        numLettersInADay(Day.WEDNESDAY);
//        Integer a = 5;
//        int b = switch(a) {
//            case 0 -> 0;
//            case Integer x when x > 0 && x <= 10 -> 100;
//            default -> throw new IllegalArgumentException();
//        };
//
//        Object o = new Object();
//        switch(o) {
//            case String s -> System.out.println("String");
//            case Integer i -> System.out.println("Integer");
//            default -> throw new IllegalArgumentException();
//        }


//        Integer[] nums = {5, 8, 2, 1, 9};
//        List<Integer> list = Arrays.asList(nums);
//        List<Integer> list2 = List.of(5, 1, 4, 7, 9);
//        List<Integer> list3 = Arrays.stream(nums).toList();
//        List<Integer> list4 = Arrays.stream(nums).collect(Collectors.toList());
//        List<Integer> list5 = new LinkedList<>(List.of(5, 1, 4, 7, 9));
//
//        System.out.println(list.getClass().getName());
//        System.out.println(list2.getClass().getName());
//        System.out.println(list3.getClass().getName());
//        System.out.println(list4.getClass().getName());
//        System.out.println(list5.getClass().getName());

        int i = 5;
        String s = "hello";
        String str; // assigning variable to the stack
        str = new String("hello"); // new allocates memory on the heap
        // constructor fills in memory location on the heap

        System.out.println(s.equals("hello"));
        System.out.println(s == "hello");
        System.out.println(str == "hello");
        System.out.println(str.equals("hello"));

        Optional<String> opt = Optional.of("hello");
        OptionalInt opi = OptionalInt.of(5);
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
