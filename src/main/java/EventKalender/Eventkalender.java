package EventKalender;

import java.util.ArrayList;
import java.util.HashMap;

public class Eventkalender {

    private ArrayList<Event> events;

    public Eventkalender() {
        this.events = new ArrayList<>();
    }

    public void add(Event newEvents) {
        events.add(newEvents);
    }

    public void printEvents() {
        for (Event e : events) {
            System.out.println("e.toString() = " + e.toString());
        }
    }

    public Event findbyTitle(String title) {
        for (Event e : events) {
            if (e.getTitle().equals(title)) {
                return e;
            }
        }
        return null;
    }

    public ArrayList<Event> getByLocation(String location) {
        ArrayList<Event> result = new ArrayList<>();
        for (Event e : events) {
            if (e.getLocation().equals(location))
                result.add(e);
        }

        return result;
    }

    public Event getMostExpensiveByOrt(String location) {
        ArrayList<Event> eventsInLocation = getByLocation(location);

        double maxprice = Double.MIN_VALUE;

        for (Event e : eventsInLocation) {
            if (e.getPrice() > maxprice) {
                maxprice = e.getPrice();
            }
        }

        for (Event e : eventsInLocation) {
            if (e.getPrice() == maxprice) {
                return e;
            }
        }
        return null;
    }

    public HashMap<String, Integer> getCountEventsByLocation() {
        // je Location, die Anzahl der Events
        HashMap<String, Integer> result = new HashMap<>();

        // 1. Liste durchlaufen
        for (Event e : events) {
            if (result.containsKey(e.getLocation())) {
                // Ist für diese Location schon ein Eintrag in der Map?
                // JA
                // 3. auslesen, modifizieren, speichern
                int count = result.get(e.getLocation()); // wieviele Events sind schon gezählt
                count++; // modifzieren
                result.put(e.getLocation(), count); // speichern
            } else {
                // Ist für diese Location schon ein Eintrag in der Map?
                // NEIN
                // 2. Element hinzufügen (Startwert)
                result.put(e.getLocation(), 1);
            }
        }

        return result;


    }

}
