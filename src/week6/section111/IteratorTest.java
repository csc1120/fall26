/*
 * Course: CSC-1120
 * Assignment name
 * File name
 * Name: Sean Jones
 * Last Updated:
 */
package week6.section111;

/**
 * Test driver for an iterator.
 */
public class IteratorTest {
    static void main() {
        final DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
//        for(Integer i : list) {
//            System.out.println(i);
//        }
//        Iterator<Integer> it = list.iterator();
//        while(it.hasNext()) {
//            System.out.println(it.next());
//        }
        System.out.println(list);
    }
}
