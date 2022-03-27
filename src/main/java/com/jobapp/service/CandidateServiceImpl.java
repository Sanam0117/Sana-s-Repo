package com.jobapp.service;

import com.jobapp.exceptions.CompanyNotFoundException;
import com.jobapp.model.*;
import com.jobapp.repository.ICandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class CandidateServiceImpl implements ICandidateService{
    @Autowired
    private ICandidateRepository candidateRepository;
    @Override
    public Company getByComName(String companyName) {
        return candidateRepository.getByComName(companyName);
    }

    @Override
    public List<Company> showallcompanies() {
        return candidateRepository.showallcompanies();
    }

    @Override
    public List<Company> getByCTC(long ctc) throws CompanyNotFoundException {
        List<Company> companies = candidateRepository.getByCTC(ctc);
        if(companies.isEmpty()) throw new CompanyNotFoundException("Companies with"+ ctc +"LPA are not found" );
        return companies;
    }

    @Override
    public List<Company> getByDesignation(String designation) throws CompanyNotFoundException {
        List<Company> companies = candidateRepository.getByDesignation(designation);
        if(companies.isEmpty()) throw new CompanyNotFoundException("Companies with"+ designation+"role are not found");
        return companies;
    }

    @Override
    public List<Company> getByReqSkills(ReqSkills skills) throws CompanyNotFoundException {
        return null;
    }

   /* @Override
    public List<Company> getByReqSkills(SkillsCan skills) throws CompanyNotFoundException {
        List<Company> companies = candidateRepository.getByReqSkills(skills);
        if(companies.isEmpty()) throw new CompanyNotFoundException("Companies with "+skills+" requirement are not found");
        return companies;
    }*/

    @Override
    public List<Company> getByWorkingHours(int workingHours) throws CompanyNotFoundException {
        List<Company> companies = candidateRepository.getByWorkingHours(workingHours);
        if(companies.isEmpty()) throw new CompanyNotFoundException("Companies with"+ workingHours+ "hours of work are not found");
        return companies;
    }

    @Override
    public List<Company> getByComMode(Mode mode) throws CompanyNotFoundException {
        List<Company> companies = candidateRepository.getByComMode(mode);
        if(companies.isEmpty()) throw new CompanyNotFoundException("Companies with"+ mode+" mode are not found");
        return companies;
    }

    @Override
    public List<Company> getByLocation(Place location) throws CompanyNotFoundException {
        List<Company> companies = candidateRepository.getByLocation(location);
        if(companies.isEmpty()) throw  new CompanyNotFoundException("Companies with"+ location +"location are not found ");
        return companies;
    }

    @Override
    public List<Company> getByReqSkillsAndWorkingHours(ReqSkills skills, int workingHours) throws CompanyNotFoundException {
        return null;
    }

   /* @Override
    public List<Company> getByReqSkillsAndWorkingHours(SkillsCan skills, int workingHours) throws CompanyNotFoundException {
        List<Company> companies = candidateRepository.getByReqSkillsAndWorkingHours(skills, workingHours);
        if(companies.isEmpty()) throw new CompanyNotFoundException("Companies with" +skills +"and of"+ workingHours+"hours work are not found");
        return companies;
    }*/
}
