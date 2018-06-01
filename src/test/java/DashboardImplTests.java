import dashboard.enums.BookingStatus;
import dashboard.model.Booking;
import dashboard.model.BookingsDashboard;
import dashboard.model.Dashboard;
import dashboard.model.Itinerary;
import dashboard.services.BookingService;
import dashboard.services.CompanyService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import dashboard.context.AppConfig;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={AppConfig.class})
public class DashboardImplTests {

    @Autowired
    private CompanyService companyService;

    @Autowired
    private BookingService bookingService;

    @Test
    public void testDashboardData() {
        try {

            String company = "ShipServ";

            Dashboard db = companyService.getDashboard(company);
            assertNotNull(db);

            assertEquals(159331,db.getSearchImpressions());
            assertEquals(6811,db.getProfileViews());
            assertEquals(11,db.getContactViews());

        }   catch (Exception e)    {
            assertTrue(false);
        }
    }

    @Test
    public void testBookingsData() {
        try {

            String company = "ShipServ";

            List<Booking> bookings = bookingService.getBookingsByCompany(company, null);
            assertNotNull(bookings);

            assertEquals(8,bookings.size());

        }   catch (Exception e)    {
            assertTrue(false);
        }
    }

    @Test
    public void testBookingDashboardData() {
        String company = "ShipServ";

        BookingsDashboard bdb = bookingService.getBookingDB(company);

        assertEquals(1,bdb.getLost());
        assertEquals(3,bdb.getWon());
        assertEquals(1,bdb.getQuoted());
        assertEquals(1,bdb.getUnactioned());
        assertEquals(2,bdb.getDeclined());
        assertEquals(new BigDecimal(4567.50).setScale(2),bdb.getAmountWon());
    }

    @Test
    public void testItineraryData() {
        try {

            String company = "ShipServ";

            List<Booking> bookings = bookingService.getBookingsByCompany(company, BookingStatus.WON);
            List<Itinerary> itineraries = bookingService.createItineraries(bookings);

            assertEquals(2, itineraries.size());
            assertEquals(2,itineraries.get(0).getQtyBookings());
            assertEquals(1,itineraries.get(1).getQtyBookings());

        }   catch (Exception e)    {
            assertTrue(false);
        }
    }

}
