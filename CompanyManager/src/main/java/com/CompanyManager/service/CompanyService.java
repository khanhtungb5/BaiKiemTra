package com.CompanyManager.service;

import java.util.List;

import com.CompanyManager.entity.Company;

public interface CompanyService {
	public List<Company> getCompanys();

	public void saveCompany(Company theCompany);

	public Company getCompany(int theId);

	public void deleteCompany(int theId);
}
