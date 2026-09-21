/*
 * Course: CSC-1120
 * Assignment name
 * File name
 * Name: Sean Jones
 * Last Updated:
 */
package week4.section111;

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
        otherMethod(doMath, 2, 3);
        otherMethod((x, y) -> {
            System.out.println(x);
            System.out.println(y);
            return x - y;
            }, 2, 3);
        otherMethod((integer1, integer2) -> integer1 % integer2, 6, 4);
        print(i -> String.valueOf(i).repeat(i * i), 5);
    }

    private static void otherMethod(DoMath doMath, int a, int b) {
        System.out.println(doMath.math(a, b));
    }

    private static void print(Function<Integer, String> function, int i) {
        System.out.println(function.apply(i));
    }

    @FunctionalInterface
    private interface DoMath {
        int math(int a, int b);
    }
}
