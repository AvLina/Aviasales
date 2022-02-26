package manager;

import domain.Ticket;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repository.TicketRepository;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class TicketManagerTest {

    TicketRepository repository = new TicketRepository();
    TicketManager manager = new TicketManager(repository);

    Ticket ticket1 = new Ticket(40, 200, "DME", "ARV", 1000);
    Ticket ticket2 = new Ticket(60, 330, "ABT", "ABX", 10000);
    Ticket ticket3 = new Ticket(10, 250, "DME", "ARV", 3000);
    Ticket ticket4 = new Ticket(50, 450, "AXG", "AXJ", 6000);
    Ticket ticket5 = new Ticket(20, 300, "AXD", "AZP", 3000);
    Ticket ticket6 = new Ticket(30, 400, "DME", "AXJ", 6000);

    @BeforeEach
    public void setUp() {
        repository.save(ticket1);
        repository.save(ticket2);
        repository.save(ticket3);
        repository.save(ticket4);
        repository.save(ticket5);
        repository.save(ticket6);
    }

    @Test //Задача №1. Сортировка по цене
    public void shouldSortByPrice() {
        Ticket[] expected = {ticket1, ticket3, ticket5, ticket2, ticket6, ticket4};
        Ticket[] actual = {ticket1, ticket2, ticket3, ticket4, ticket5, ticket6};

        Arrays.sort(actual);
        assertArrayEquals(expected, actual);
    }

    @Test //Задача №2. Поиск нескольких элементов
    public void shouldFromTo() {
        Ticket[] expected = {ticket1, ticket3};
        Ticket[] actual = manager.searchTicket("DME", "ARV");

        assertArrayEquals(expected, actual);
    }

    @Test //Задача №3. Сортировка пустой набор
    public void shouldNoTicket() {
        Ticket[] expected = {};
        Ticket[] actual = manager.searchTicket("LED", "DME");

        assertArrayEquals(expected, actual);
    }

    @Test //Задача №4. Поиск одного элемента
    public void shouldSearchLine() {
        Ticket[] expected = {ticket4};
        Ticket[] actual = manager.searchTicket("AXG", "AXJ");

        assertArrayEquals(expected, actual);
    }

}
