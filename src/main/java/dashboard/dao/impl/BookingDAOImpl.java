package dashboard.dao.impl;

import dashboard.dao.BookingDAO;
import dashboard.datasource.DataSource;
import dashboard.model.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Daniel Gini
 */
@Component
public class BookingDAOImpl implements BookingDAO
{
    @Autowired
    private DataSource dataSource;

    public BookingDAOImpl() {    }

    @Override
    public List<Booking> findBookingsByCompany(String company){ return this.dataSource.findBookingsByCompany(company); }

}
