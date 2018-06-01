package dashboard.datasource.impl;

import dashboard.datasource.DataSource;
import dashboard.enums.BookingStatus;
import dashboard.exceptions.DataNotFoundException;
import dashboard.model.Booking;
import dashboard.model.Company;
import dashboard.model.Dashboard;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author Daniel Gini
 * @version 1.0
 */
public class MockDataSource implements DataSource {

    private List<Company> companies;
    private List<Dashboard> dashboards;
    private List<Booking> bookings;

    public MockDataSource()
    {
        companies = new ArrayList<>();
        bookings = new ArrayList<>();
        dashboards = new ArrayList<>();

        Company c1 = new Company("ShipServ");
        Company c2 = new Company("Electric Motors");

        companies.add(c1);
        companies.add(c2);

        Dashboard a1 = new Dashboard(c1, 159331,6811,11);
        Dashboard a2 = new Dashboard(c2, 200000,7000,140);

        dashboards.add(a1);
        dashboards.add(a2);

        bookings.add(new Booking("001", c1, "Shell", new BigDecimal(2000.00), LocalDate.now().plus(1, ChronoUnit.DAYS), BookingStatus.WON));
        bookings.add(new Booking("002", c1, "Norwegian", new BigDecimal(1567.50), LocalDate.now().plus(1, ChronoUnit.DAYS), BookingStatus.WON));
        bookings.add(new Booking("003", c1, "SeaSpan", new BigDecimal(2938.45), LocalDate.now().plus(2, ChronoUnit.DAYS),  null));
        bookings.add(new Booking("004", c1, "Thome", new BigDecimal(12500.60), LocalDate.now().plus(2, ChronoUnit.DAYS),  BookingStatus.LOST));
        bookings.add(new Booking("005", c1, "Dof", new BigDecimal(8492.70), LocalDate.now().plus(3, ChronoUnit.DAYS),  BookingStatus.QUOTED));
        bookings.add(new Booking("006", c1, "Shell", new BigDecimal(2817.03), LocalDate.now().plus(3, ChronoUnit.DAYS),  BookingStatus.DECLINED));
        bookings.add(new Booking("007", c1, "Dof", new BigDecimal(20430.98), LocalDate.now().plus(3, ChronoUnit.DAYS),  BookingStatus.DECLINED));

        bookings.add(new Booking("008", c2, "Norwegian", new BigDecimal(22000.10), LocalDate.now().plus(1, ChronoUnit.DAYS), null));
        bookings.add(new Booking("009", c2, "EagleStar", new BigDecimal(12300.00), LocalDate.now().plus(1, ChronoUnit.DAYS),  BookingStatus.WON));
        bookings.add(new Booking("010", c2, "Thome", new BigDecimal(6500.00), LocalDate.now().plus(2, ChronoUnit.DAYS),  BookingStatus.LOST));
        bookings.add(new Booking("011", c2, "SeaSpan", new BigDecimal(3800.00), LocalDate.now().plus(2, ChronoUnit.DAYS),  BookingStatus.QUOTED));
        bookings.add(new Booking("012", c2, "Maersk", new BigDecimal(91400.00), LocalDate.now().plus(3, ChronoUnit.DAYS),  BookingStatus.QUOTED));
        bookings.add(new Booking("013", c2, "Holland", new BigDecimal(12400.00), LocalDate.now().plus(3, ChronoUnit.DAYS),  BookingStatus.DECLINED));
    }

    @Override
    public Dashboard findDashboardByCompany(String company) throws DataNotFoundException {
        Optional<Dashboard> db = dashboards.stream().filter(d -> d.getCompany().getName().equals(company)).findFirst();
        if (db.isPresent())
            return db.get();
        throw new DataNotFoundException();
    }

    @Override
    public List<Booking> findBookingsByCompany(String company) {
        return bookings.stream().filter(b -> b.getCompany().getName().equals(company)).collect(Collectors.toList());
    }
}
