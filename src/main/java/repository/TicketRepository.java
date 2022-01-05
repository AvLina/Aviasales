package repository;

import domain.Ticket;

public class TicketRepository {

    private Ticket[] ticket = new Ticket[0];

    public Ticket[] findAll() {
        return ticket;
    }

    public void save(Ticket item) {
        int length = ticket.length + 1;
        Ticket[] tmp = new Ticket[length];
        System.arraycopy(ticket, 0, tmp, 0, ticket.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        ticket = tmp;
    }
}

