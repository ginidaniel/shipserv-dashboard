package dashboard.services.impl;

import dashboard.dao.CompanyDAO;
import dashboard.exceptions.DataNotFoundException;
import dashboard.model.Dashboard;
import dashboard.services.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 *
 * @author Daniel Gini
 */
@Component
@Service
public class CompanyServiceImpl implements CompanyService {

	private CompanyDAO companyDAO;

	@Autowired
	public CompanyServiceImpl(CompanyDAO companyDAO) {
		this.companyDAO = companyDAO;
	}

	@Override
	public Dashboard getDashboard(String company) throws DataNotFoundException {
		return companyDAO.findDashboardByCompany(company);
	}

}