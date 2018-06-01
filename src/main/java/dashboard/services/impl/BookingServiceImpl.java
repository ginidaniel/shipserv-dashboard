package dashboard.services.impl;

import dashboard.dao.BookingDAO;
import dashboard.enums.BookingStatus;
import dashboard.model.Booking;
import dashboard.model.BookingsDashboard;
import dashboard.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Daniel Gini
 */
@Component
public class BookingServiceImpl implements BookingService
{
	private BookingDAO bookingDAO;

	@Autowired
	public BookingServiceImpl(BookingDAO bookingDAO)
	{
		this.bookingDAO = bookingDAO;
	}

	@Override
	public List<Booking> getBookingsByCompany(String company, BookingStatus status) {
		List<Booking> bookings = bookingDAO.findBookingsByCompany(company);

		if (status==null)
			return bookings;

		return bookings.stream().filter(b -> b.getStatus().equals(status)).collect(Collectors.toList());
	}

	public BookingsDashboard getBookingDB(String company) {
		List<Booking> bookings = getBookingsByCompany(company,null);

		BigDecimal amountWon = new BigDecimal(bookings.stream().filter(b -> b.getStatus().equals(BookingStatus.WON))
				.map(Booking::getAmount).mapToDouble(BigDecimal::doubleValue).sum());

		return new BookingsDashboard(
				bookings.stream().filter(b -> b.getStatus().equals(BookingStatus.UNACTIONED)).count(),
				bookings.stream().filter(b -> b.getStatus().equals(BookingStatus.DECLINED)).count(),
				bookings.stream().filter(b -> b.getStatus().equals(BookingStatus.QUOTED)).count(),
				bookings.stream().filter(b -> b.getStatus().equals(BookingStatus.LOST)).count(),
				bookings.stream().filter(b -> b.getStatus().equals(BookingStatus.WON)).count(),
				amountWon
			);
	}

}
