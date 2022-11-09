package EventKalender;

import java.util.Objects;

public class Event {
    private String title;
    private String location;
    private double price;

    public Event(String title, String location, double price) {
        this.title = title;
        this.location = location;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Event{" +
                "title='" + title + '\'' +
                ", location='" + location + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return Double.compare(event.price, price) == 0 && Objects.equals(title, event.title) && Objects.equals(location, event.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, location, price);
    }
}
