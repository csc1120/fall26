/*
 * Course: CSC-1120
 * Assignment name
 * File name
 * Name: Sean Jones
 * Last Updated:
 */
package week6.section121;

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
    @DisplayName("List size tests")
    void sizeTests() {
        // test list is empty
        Assertions.assertEquals(0, list.size(),
                "New list should have size of 0");
        list.add(1);
        Assertions.assertEquals(1, list.size());
    }

    @SuppressWarnings("ConstantConditions")
    @Test
    void isEmptyTests() {
        Assertions.assertTrue(list.isEmpty());
        list.add(1);
        Assertions.assertFalse(list.isEmpty());
    }

    @Test
    void addAtIndexThrowsException() {
        Assertions.assertThrows(IndexOutOfBoundsException.class,
                () -> list.add(1, 4));
    }
}
