/*
 * Course: CSC-1120
 * Exceptions Example
 * TicketOffice
 * Name: Sean Jones
 * Last Updated: 9-4-26
 */
package week1.section111;

/**
 * A simulated ticket office where you can purchase tickets as a student or
 * adult.
 */
public class TicketOffice {
    private int ticketsAvailable;

    /**
     * Constructor that creates an office with a set number of tickets.
     * @param ticketsAvailable the number of tickets still available
     */
    public TicketOffice(int ticketsAvailable) {
        this.ticketsAvailable = ticketsAvailable;
    }

    /**
     * Method that sets aside ticket for a given order and returns the total cost
     * to the user.
     * @param quantityText how many tickets
     * @param ticketType student or adult ticket
     * @return the total cost of the tickets
     * @throws NotEnoughTicketsException thrown if there are insufficient tickets
     * available for the order
     * @throws NumberFormatException throw if quantityText is not an integer
     * @throws IllegalArgumentException thrown if the ticketType is not "student" or "adult"
     */
    public double buyTickets(String quantityText, String ticketType)
            throws NotEnoughTicketsException {
        final double studentPrice = 8.00;
        final double adultPrice = 12.00;
        final int quantity = Integer.parseInt(quantityText);
        final double price;
        if(ticketType.equals("student")) {
            price = studentPrice;
        } else if(ticketType.equals("adult")) {
            price = adultPrice;
        } else {
            throw new IllegalArgumentException("Unknown ticket type");
        }

        if(quantity > ticketsAvailable) {
            throw new NotEnoughTicketsException("Only " + ticketsAvailable + " tickets remaining");
        }
        ticketsAvailable -= quantity;
        return quantity * price;
    }
}
