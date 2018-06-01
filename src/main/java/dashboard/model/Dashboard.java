package dashboard.model;

/**
 * Entity which contains stats related to company's visibility accordingly to buyers searches, interactions and bookings
 *
 * @author Daniel Gini
 */
public class Dashboard {

    private Company company;
    private long searchImpressions;
    private long profileViews;
    private long contactViews;

    private BookingsDashboard bookingsDB;

    public Dashboard(Company company, int searchImpressions, int profileViews, int contactViews) {
        this.company = company;
        this.searchImpressions = searchImpressions;
        this.profileViews = profileViews;
        this.contactViews = contactViews;
    }

    public void setBookingsDB(BookingsDashboard bookingsDB) {
        this.bookingsDB = bookingsDB;
    }

    public Company getCompany() {
        return company;
    }

    public long getSearchImpressions() {
        return searchImpressions;
    }

    public long getProfileViews() {
        return profileViews;
    }

    public long getContactViews() {
        return contactViews;
    }

    public BookingsDashboard getBookingsDB() {
        return bookingsDB;
    }
}
