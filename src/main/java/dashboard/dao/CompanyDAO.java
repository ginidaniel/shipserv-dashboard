package dashboard.dao;

import dashboard.exceptions.DataNotFoundException;
import dashboard.model.Dashboard;

/**
 * <p>Title: CompanyDAO.java</p>
 *
 * @author Daniel Gini
 * @version 1.0
 */
public interface CompanyDAO
{
    /**
     * Retrieves Dashboard by Company from the data source
     *
     * @param company
     * @return Dashboard
     * @throws DataNotFoundException When the company has not information or does not exist
     */
    Dashboard findDashboardByCompany(String company) throws DataNotFoundException;
}
