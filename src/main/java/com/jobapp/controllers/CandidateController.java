package com.jobapp.controllers;

import com.jobapp.exceptions.CompanyNotFoundException;
import com.jobapp.model.Company;
import com.jobapp.model.Mode;
import com.jobapp.model.Place;
import com.jobapp.model.ReqSkills;
import com.jobapp.service.ICandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/job-api")
public class CandidateController {
    private ICandidateService candidateService;
@Autowired
    public CandidateController(ICandidateService candidateService) {
        this.candidateService = candidateService;
    }

    @GetMapping("/company")
    Company getByComName(String companyName) throws CompanyNotFoundException
    {
    return candidateService.getByComName(companyName);

    }
    @GetMapping("/company")
    List<Company> showallcompanies(){
        return candidateService.showallcompanies();
    }
    @GetMapping("/company/ctc/{ctc}")
    List<Company> getByCTC(long ctc)  throws CompanyNotFoundException
    {
        return candidateService.getByCTC(ctc);
    }
    @GetMapping("/company/designation/{designation}")
    List<Company> getByDesignation(String designation)  throws CompanyNotFoundException{

    return candidateService.getByDesignation(designation);
    }

    @GetMapping("/companies/skills/{skills}")
    List<Company> getByReqSkills(ReqSkills skills)  throws CompanyNotFoundException
    {
        return candidateService.getByReqSkills(skills);
    }
    @GetMapping("/companies/workingHours/{workingHours}")
    List<Company> getByWorkingHours(int workingHours) throws CompanyNotFoundException
    {
        return candidateService.getByWorkingHours(workingHours);
    }
    @GetMapping("/companies/mode/{mode}")
    List<Company> getByComMode(Mode mode) throws CompanyNotFoundException
    {
        return candidateService.getByComMode(mode);
    }
    @GetMapping("/companies/location/{location}")
    List<Company> getByLocation(Place location) throws CompanyNotFoundException
    {
        return candidateService.getByLocation(location);
    }
    @GetMapping("/companies/skills/{skills}/workingHours/{workingHours}")
    List<Company> getByReqSkillsAndWorkingHours(ReqSkills skills, int workingHours) throws CompanyNotFoundException
    {
        return candidateService.getByReqSkillsAndWorkingHours(skills, workingHours);
    }
}
