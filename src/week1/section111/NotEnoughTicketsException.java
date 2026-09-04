/*
 * Course: CSC-1120
 * Exceptions Example
 * Custom Exception
 * Name: Sean Jones
 * Last Updated: 9-4-26
 */
package week1.section111;

/**
 * Custom Exception to indicate lack of tickets.
 */
public class NotEnoughTicketsException extends Exception {
    /**
     * Constructor with a custom message.
     * @param message the custom message
     */
    public NotEnoughTicketsException(String message) {
        super(message);
    }
}
