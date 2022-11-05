package com.CompanyManager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.CompanyManager.entity.Company;
import com.CompanyManager.repository.CompanyRepository;

@Service
public class CompanyServiceImpl implements CompanyService {
	@Autowired
	private CompanyRepository companyRepo;

	@Override
	@Transactional
	public List<Company> getCompanys() {
		return companyRepo.getCompanys();
	}

	@Override
	@Transactional
	public void saveCompany(Company theCompany) {
		companyRepo.saveCompany(theCompany);
	}

	@Override
	@Transactional
	public Company getCompany(int theId) {
		return companyRepo.getCompany(theId);
	}

	@Override
	@Transactional
	public void deleteCompany(int theId) {
		companyRepo.deleteCompany(theId);
	}
}
