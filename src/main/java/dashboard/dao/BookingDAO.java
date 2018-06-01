package dashboard.dao;

import dashboard.model.Booking;

import java.util.List;

/**
 * <p>Title: BookingDAO.java</p>
 *
 * @author Daniel Gini
 * @version 1.0
 */
public interface BookingDAO
{

    /**
     * Retrieves list of bookings by Company from the data source
     *
     * @param company
     * @return List<Booking>
     */
    List<Booking> findBookingsByCompany(String company);

}
