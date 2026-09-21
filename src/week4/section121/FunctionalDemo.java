/*
 * Course: CSC-1120
 * Assignment name
 * File name
 * Name: Sean Jones
 * Last Updated:
 */
package week4.section121;

import java.util.function.Function;

public class FunctionalDemo {
    static void main() {
        DoMath doMath = new DoMath() {
            @Override
            public int math(int a, int b) {
                return a + b;
            }
        };
        System.out.println(doMath.math(2, 3));
//        otherMethod(doMath, 2, 3);
        otherMethod((x, y) -> x - y, 2, 3);
        otherMethod((x, y) -> x * y, 2, 3);
        otherMethod((integer1, integer2) -> {
            System.out.println(integer1);
            System.out.println(integer2);
            return integer1 % integer2;
        }, 2, 3);

        useFunction(x -> String.valueOf(x).repeat(x), 6);
    }


    private static void otherMethod(DoMath math, int a, int b) {
        System.out.println(math.math(a, b));
    }

    private static void useFunction(Function<Integer, String> function, int i) {
        System.out.println(function.apply(i));
    }

    @FunctionalInterface
    private interface DoMath {
        int math(int a, int b);
    }
}
