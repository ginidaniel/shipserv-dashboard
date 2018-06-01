package dashboard.context;

import dashboard.dao.BookingDAO;
import dashboard.dao.CompanyDAO;
import dashboard.dao.impl.BookingDAOImpl;
import dashboard.dao.impl.CompanyDAOImpl;
import dashboard.datasource.DataSource;
import dashboard.datasource.impl.MockDataSource;
import dashboard.services.BookingService;
import dashboard.services.CompanyService;
import dashboard.services.impl.BookingServiceImpl;
import dashboard.services.impl.CompanyServiceImpl;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan
public class AppConfig {

    @Bean
    public BookingDAO getBookingDAO() {

        return new BookingDAOImpl();
    }

    @Bean
    public CompanyDAO getDashboardDAO() {

        return new CompanyDAOImpl();
    }

    @Bean
    public BookingService getBookingService() {

        return new BookingServiceImpl(getBookingDAO());
    }

    @Bean
    public CompanyService getDashboardService() {

        return new CompanyServiceImpl(getDashboardDAO());
    }

    @Bean
    public DataSource getDataSource() {  return new MockDataSource();}
}
