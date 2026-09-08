/*
 * Course: CSC-1120
 * Assignment name
 * File name
 * Name: Sean Jones
 * Last Updated:
 */
package week1.section121;

public class TicketOffice {
    private int ticketsAvailable;

    public TicketOffice(int ticketsAvailable) {
        this.ticketsAvailable = ticketsAvailable;
    }

    public double buyTickets(String quantityText, String ticketType)
            throws NotEnoughTicketsException {
        final double studentPrice = 8.00;
        final double adultPrice = 12.00;
        final int quantity = Integer.parseInt(quantityText);
        final double price;

        if(ticketType.equalsIgnoreCase("student")) {
            price = studentPrice;
        } else if(ticketType.equalsIgnoreCase("adult")) {
            price = adultPrice;
        } else {
            throw new IllegalArgumentException("unknown ticket type");
        }

        if(quantity > ticketsAvailable) {
            throw new NotEnoughTicketsException("Only " + ticketsAvailable + " tickets left.");
        }

        ticketsAvailable -= quantity;
        return price * quantity;
    }
}
