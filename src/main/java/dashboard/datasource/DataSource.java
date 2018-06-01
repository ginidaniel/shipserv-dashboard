package dashboard.datasource;

import dashboard.exceptions.DataNotFoundException;
import dashboard.model.Booking;
import dashboard.model.Dashboard;

import java.util.List;

/**
 * <p>Title: DataSource.java</p>
 * Retrieves information from the data source depending on implementations (files, database, etc)
 *
 * @author Daniel Gini
 * @version 1.0
 */
public interface DataSource {

    /**
     * Dashboard entity with company stats
     *
     * @param company
     * @return Dashboard
     * @throws DataNotFoundException When the company has not information or does not exist
     */
    Dashboard findDashboardByCompany(String company) throws DataNotFoundException;

    /**
     * List of bookings filtered by company
     *
     * @param company
     * @return List<Booking>
     */
    List<Booking> findBookingsByCompany(String company);

}
