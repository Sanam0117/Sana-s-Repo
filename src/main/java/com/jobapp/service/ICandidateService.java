package com.jobapp.service;

import com.jobapp.exceptions.CompanyNotFoundException;
import com.jobapp.model.Company;
import com.jobapp.model.Mode;
import com.jobapp.model.Place;
import com.jobapp.model.ReqSkills;

import java.util.List;

public interface ICandidateService {

    Company getByComName(String companyName);
    List<Company> showallcompanies();
    List<Company> getByCTC(long ctc) throws CompanyNotFoundException;
    List<Company> getByDesignation(String designation) throws CompanyNotFoundException;
    List<Company> getByReqSkills(ReqSkills skills) throws CompanyNotFoundException;
    List<Company> getByWorkingHours(int workingHours) throws CompanyNotFoundException;
    List<Company> getByComMode(Mode mode) throws CompanyNotFoundException;
    List<Company> getByLocation(Place location) throws CompanyNotFoundException;
    List<Company> getByReqSkillsAndWorkingHours(ReqSkills skills, int workingHours) throws CompanyNotFoundException;
}
