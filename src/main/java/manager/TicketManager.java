package manager;

import domain.Ticket;
import repository.TicketRepository;

public class TicketManager {

    private TicketRepository repository;

    public TicketManager(TicketRepository repository) {
        this.repository = repository;
    }

    public void add (Ticket ticket) {
        repository.save(ticket);
    }

    public Ticket[] searchTicket(String from, String to) {
        Ticket[] result = new Ticket[0];
        for (Ticket ticket : repository.findAll()) {
            if (ticket.getDepartureAirport().contains(from)) {
                if (ticket.getArrivalAirport().contains(to)) {
                    Ticket[] tmp = new Ticket[result.length + 1];
                    System.arraycopy(result, 0, tmp, 0, result.length);
                    tmp[tmp.length - 1] = ticket;
                    result = tmp;
                }
            }

        }
        return result;
    }
}

