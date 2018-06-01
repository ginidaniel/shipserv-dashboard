package dashboard.dao.impl;

import dashboard.dao.CompanyDAO;
import dashboard.datasource.DataSource;
import dashboard.exceptions.DataNotFoundException;
import dashboard.model.Dashboard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.zip.DataFormatException;

/**
 * @author Daniel Gini
 */
@Component
public class CompanyDAOImpl implements CompanyDAO
{
    @Autowired
    private DataSource dataSource;

    public CompanyDAOImpl() {    }

    @Override
    public Dashboard findDashboardByCompany(String company) throws DataNotFoundException {
        return dataSource.findDashboardByCompany(company);
    }

}
