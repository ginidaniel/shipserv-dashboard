package dashboard.model;

import dashboard.enums.BookingStatus;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Entity keeps general information related to specific booking
 *
 * @author Daniel Gini
 */
public class Booking {

    private Company company;
    private String bookingRef;
    private String buyer;
    private BigDecimal amount;
    private LocalDate requestDelivery;
    private BookingStatus status;

    public Booking(String bookingRef, Company company, String buyer, BigDecimal amount, LocalDate date, BookingStatus status) {
        this.bookingRef = bookingRef;
        this.company = company;
        this.amount = amount;
        this.buyer = buyer;
        this.requestDelivery = date;
        this.status = BookingStatus.UNACTIONED;
        if (status!=null) this.status = status;
    }

    public BigDecimal getAmount() {
        return amount.setScale(2,BigDecimal.ROUND_HALF_UP);
    }

    public Company getCompany() {
        return company;
    }

    public String getBuyer() {
        return buyer;
    }

    public LocalDate getRequestDelivery() { return requestDelivery; }

    public String getBookingRef() { return bookingRef; }

    public BookingStatus getStatus() {
        return status;
    }

    public void setStatus(BookingStatus status) { this.status = status; }

}
