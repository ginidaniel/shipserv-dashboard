package dashboard.services;

import dashboard.enums.BookingStatus;
import dashboard.model.Booking;
import dashboard.model.BookingsDashboard;
import dashboard.model.Itinerary;

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
	 * List of bookings filtered by company and status
	 *
	 * @param company
	 * @param status (when it is null, it will retrieve all bookings)
	 * @return List<Booking>
	 */
	List<Booking> getBookingsByCompany(String company, BookingStatus status);

	/**
	 * Dashboard with bookings summary
	 *
	 * @param company
	 * @return BookingsDashboard
	 */
	BookingsDashboard getBookingDB(String company);

	/**
	 * Generates a list of itineraries by Date from the booking list given
	 *
	 * @param bookings
	 * @return List<Itinerary>
	 */
    List<Itinerary> createItineraries(List<Booking> bookings);
}
