package dashboard.model;

import dashboard.enums.BookingStatus;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Entity keeps general information related to specific booking
 *
 * @author Daniel Gini
 */
public class Itinerary {

    private LocalDate date;
    private List<Booking> bookings;

    public Itinerary(LocalDate date) {
        this.date = date;
        this.bookings = new ArrayList<>();
    }

    public void addBooking(Booking booking) {
        this.bookings.add(booking);
    }

    public LocalDate getDate() {
        return date;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public int getQtyBookings() {
        return bookings.size();
    }
}
