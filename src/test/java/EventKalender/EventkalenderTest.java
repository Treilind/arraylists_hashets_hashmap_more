package EventKalender;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EventkalenderTest {

    private Event event1;
    private Event event2;
    private Event event3;


    @BeforeEach
    void setUp() {
        event1 = new Event("Dame", "Austria", 29.99);
        event2 = new Event("Raf Camora", "Austria", 99.99);
        event3 = new Event("Kontra K", "Germany", 10.99);
    }

    @Test
    void add() {
        Eventkalender eventkalender = new Eventkalender();
        eventkalender.add(event1);
        eventkalender.add(event2);
        eventkalender.add(event3);

        Assertions.assertEquals(3, eventkalender.getEvents().size());
    }

    @Test
    void findbyTitle() {
        Eventkalender eventkalender = new Eventkalender();
        eventkalender.add(event1);
        eventkalender.add(event2);
        eventkalender.add(event3);

        Event findByTitleTest = eventkalender.findbyTitle("Dame");


        Assertions.assertEquals(event1, findByTitleTest);

    }

    @Test
    void getByLocation() {
        Eventkalender eventkalender = new Eventkalender();
        eventkalender.add(event1);
        eventkalender.add(event2);
        eventkalender.add(event3);

        Assertions.assertEquals(2, eventkalender.getByLocation("Austria").size());
    }

    @Test
    void getMostExpensiveByOrt() {
        Eventkalender eventkalender = new Eventkalender();
        eventkalender.add(event1);
        eventkalender.add(event2);
        eventkalender.add(event3);

        Assertions.assertEquals(event2, eventkalender.getMostExpensiveByOrt("Austria"));
    }

    @Test
    void getCountEventsByLocation() {
        Eventkalender eventkalender = new Eventkalender();
        eventkalender.add(event1);
        eventkalender.add(event2);
        eventkalender.add(event3);

        Assertions.assertTrue(eventkalender.getCountEventsByLocation().containsKey("Austria"));
        Assertions.assertEquals(2, eventkalender.getCountEventsByLocation().get("Austria"));

    }
}