/*
 * Course: CSC-1120
 * Assignment name
 * File name
 * Name: Sean Jones
 * Last Updated:
 */
package week1.section121;

public class TicketDemo {
    private static final int TICKETS_AVAILABLE = 10;
    static void main() {
        TicketOffice office = new TicketOffice(TICKETS_AVAILABLE);
        try {
            final double cost = office.buyTickets("34", "student");
            System.out.println("Cost: $" + cost);
        } catch(NumberFormatException e) {
            System.out.println("Quantity needs to be a number");
        } catch(NotEnoughTicketsException e) {
            System.out.println(e.getMessage());
        } catch(IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
