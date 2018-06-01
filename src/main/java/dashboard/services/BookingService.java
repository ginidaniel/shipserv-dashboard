package dashboard.services;

import dashboard.enums.BookingStatus;
import dashboard.model.Booking;
import dashboard.model.BookingsDashboard;

import java.util.List;

/**
 * <p>Title: BookingService.java</p>
 * Bookings Manager:
 *  		Retrieve bookings information by company, list of bookings and stats.
 *
 * @author Daniel Gini
 * @version 1.0
 */
public interface BookingService
{

	/**
	 * @param company
	 * @param status (when it is null, it will retrieve all bookings)
	 *
	 * @return List of bookings filtered by company and status
	 */
	List<Booking> getBookingsByCompany(String company, BookingStatus status);

	/**
	 * @param company
	 *
	 * @return Dashboard with bookings summary
	 */
	BookingsDashboard getBookingDB(String company);

}
