package com.CompanyManager.repository;

import java.util.List;

import com.CompanyManager.entity.Company;

public interface CompanyRepository {
	public List<Company> getCompanys();

	public void saveCompany(Company theCompany);

	public Company getCompany(int theId);

	public void deleteCompany(int theId);
}
