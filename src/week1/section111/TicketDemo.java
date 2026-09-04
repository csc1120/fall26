/*
 * Course: CSC-1120
 * Exceptions Example
 * Driver
 * Name: Sean Jones
 * Last Updated: 9-4-26
 */
package week1.section111;

/**
 * The driver for the TicketOffice example.
 */
public class TicketDemo {
    private static final int TICKETS_AVAILABLE = 10;

    static void main() {
        TicketOffice ticketOffice = new TicketOffice(TICKETS_AVAILABLE);
        try {
            double cost = ticketOffice.buyTickets("3", "student");
            System.out.println("Cost: $" + cost);
        } catch (NumberFormatException exception) {
            System.out.println("The ticket quantity must be a number.");
        } catch (IllegalArgumentException exception) {
            System.out.println("That ticket type does not exist.");
        } catch (NotEnoughTicketsException exception) {
            System.out.println(exception.getMessage());
        }
    }
}