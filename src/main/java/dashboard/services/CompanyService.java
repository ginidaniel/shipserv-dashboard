package dashboard.services;


import dashboard.exceptions.DataNotFoundException;
import dashboard.model.Dashboard;

/**
 * <p>Title: CompanyService.java</p>
 * Company Manager:
 *    		Retrieves company information by company like search stats and visibility.
 *    		It would handle inserts/updates for companies
 *
 * @author Daniel Gini
 * @version 1.0
 */
public interface CompanyService
{
	/**
	 * Retrieves a dashboard with general information related to company's visibility on the site
	 *
	 * @param company
	 * @return Dashboard
	 * @throws DataNotFoundException When the company has not information or does not exist
	 */
	Dashboard getDashboard(String company) throws DataNotFoundException;
}
