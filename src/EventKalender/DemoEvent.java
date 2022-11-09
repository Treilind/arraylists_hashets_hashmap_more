package EventKalender;

public class DemoEvent {
    public static void main(String[] args) {
        Eventkalender eventCalender = new Eventkalender();
        eventCalender.add(new Event("David Haselhoff", "Graz", 69));
        eventCalender.add(new Event("David Haselhoff", "Schladming", 79));
        eventCalender.add(new Event("Sponge Bob Musical", "Graz", 89));
        eventCalender.add(new Event("Grundlagen Softwareentwicklung Klausur", "Graz", 0));

        eventCalender.printEvents();


        System.out.println("eventCalender = " + eventCalender.findbyTitle("David Haselhoff"));
        System.out.println("eventCalender = " + eventCalender.findbyTitle("U2"));

        System.out.println("eventCalender = " + eventCalender.getByLocation("Graz"));

        System.out.println("eventCalender = " + eventCalender.getMostExpensiveByOrt("Graz"));

        System.out.println("eventCalender.getCountEventsByLocation() = " + eventCalender.getCountEventsByLocation());
    }



}
