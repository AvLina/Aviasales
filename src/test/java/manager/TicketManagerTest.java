package manager;

import domain.Ticket;
import org.junit.jupiter.api.Test;
import repository.TicketRepository;

import static org.junit.jupiter.api.Assertions.*;

class TicketManagerTest {

    Ticket ticket1 = new Ticket(10,200, "DME", "ARV", 1000);
    Ticket ticket2 = new Ticket(20, 300, "ABT", "ABX", 10000);
    Ticket ticket3 = new Ticket(30, 250, "DME", "ARV", 4000);
    Ticket ticket4 = new Ticket(40, 450, "AXG", "AXJ", 6000);
    Ticket ticket5 = new Ticket(50, 300, "AXD", "AZP", 3000);
    Ticket ticket6 = new Ticket(60, 400, "DME", "AXJ", 6000);

    @Test
    public void findAllTickets () {

        TicketRepository repository = new TicketRepository();
        TicketManager manager = new TicketManager(repository);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);

        Ticket[] expected = {ticket1, ticket2, ticket3, ticket4, ticket5, ticket6};
        Ticket[] actual = repository.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFromTo () {

        TicketRepository repository = new TicketRepository();
        repository.save(ticket5);
        repository.save(ticket2);
        repository.save(ticket1);
        repository.save(ticket4);
        repository.save(ticket6);
        repository.save(ticket3);

        TicketManager manager = new TicketManager(repository);

        Ticket[] expected = {ticket1, ticket3};
        Ticket[] actual = manager.searchTicket("DME", "ARV");

        assertArrayEquals(expected, actual);
    }
}