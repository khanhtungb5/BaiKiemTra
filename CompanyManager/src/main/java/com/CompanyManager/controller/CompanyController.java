package com.CompanyManager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.CompanyManager.entity.Company;
import com.CompanyManager.service.CompanyService;

@Controller
@RequestMapping("/company")
public class CompanyController {
	@Autowired
    private CompanyService companyService;

    @GetMapping("/list")
    public String listCompanys(Model theModel) {
        List<Company> theCompanys = companyService.getCompanys();
        theModel.addAttribute("companys", theCompanys);
        return "list-companys";
    }

    @GetMapping("/showForm")
    public String showFormForAdd(Model theModel) {
    	Company theCompany = new Company();
        theModel.addAttribute("company", theCompany);
        return "company-form";
    }

    @PostMapping("/saveCompany")
    public String saveCompany(@ModelAttribute("company") Company theCompany) {
    	companyService.saveCompany(theCompany);
        return "redirect:/company/list";
    }

    @GetMapping("/updateForm")
    public String showFormForUpdate(@RequestParam("companyId") int theId,
        Model theModel) {
        Company theCompany = companyService.getCompany(theId);
        theModel.addAttribute("company", theCompany);
        return "company-form";
    }

    @GetMapping("/delete")
    public String deleteCompany(@RequestParam("companyId") int theId) {
    	companyService.deleteCompany(theId);
        return "redirect:/company/list";
    }
}
