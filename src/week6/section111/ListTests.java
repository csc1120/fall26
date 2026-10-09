/*
 * Course: CSC-1120
 * Assignment name
 * File name
 * Name: Sean Jones
 * Last Updated:
 */
package week6.section111;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ListTests {
    private DoubleLinkedList<Integer> list;

    @BeforeEach
    void setup() {
        list = new DoubleLinkedList<>();
    }

    @Test
    @DisplayName("Testing size()")
    void testSize() {
        Assertions.assertEquals(0, list.size());
        list.add(1);
        Assertions.assertEquals(1, list.size());
    }

    @SuppressWarnings("ConstantConditions")
    @Test
    @DisplayName("Testing isEmpty()")
    void testIsEmpty() {
        Assertions.assertTrue(list.isEmpty());
        Assertions.assertFalse(!list.isEmpty());
        list.add(1);
        Assertions.assertFalse(list.isEmpty());
    }

    @Test
    void testAddAtIndexThrowsException() {
        Assertions.assertThrows(IndexOutOfBoundsException.class,
                () -> list.add(1, 4));
    }
}
