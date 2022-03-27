package com.jobapp.controllers;

import com.jobapp.exceptions.CandidateNotFoundException;
import com.jobapp.model.Candidate;
import com.jobapp.model.Mode;
import com.jobapp.model.ReqSkills;
import com.jobapp.service.ICompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/company-api")
public class CompanyController {
    private ICompanyService companyService;
@Autowired
    public CompanyController(ICompanyService companyService) {
        this.companyService = companyService;
    }
@PostMapping("/Candidate")
    void addCandidate(Candidate candidate){
         companyService.addCandidate(candidate);
    }
    @PutMapping("/Candidate")
    void updateCandidate(Candidate candidate){
    companyService.updateCandidate(candidate);
    }
    @DeleteMapping("/Candidate")
    void deleteCandidate(Candidate candidate){
     companyService.deleteCandidate(candidate);
    }
      @GetMapping("/Candidate/skills/{skills}")
    List<Candidate> getCandBySkills(ReqSkills skills) throws CandidateNotFoundException {
        return companyService.getCandBySkills(skills);
    }
    @GetMapping("/Candidate/location/{location}")
    List<Candidate> getByCandPrefLocation(String location) throws CandidateNotFoundException{
        return companyService.getByCandPrefLocation(location);
    }
    @GetMapping("/Candidate/expsalary/{expsalary}")
    List<Candidate> getByCandExpectedSal(long expsalary) throws CandidateNotFoundException{
        return companyService.getByCandExpectedSal(expsalary);
    }
    @GetMapping("/Candidate/mode/{mode}")
    List<Candidate> getByCandPrefMode(Mode mode) throws CandidateNotFoundException{
        return companyService.getByCandPrefMode(mode);
    }
    @GetMapping("/Candidate/skills/{skills}/mode/{mode}")
    List<Candidate> getByCandSkillsAndPrefMode(ReqSkills skills, Mode mode) throws CandidateNotFoundException{
        return companyService.getByCandSkillsAndPrefMode(skills,mode);
    }
}
