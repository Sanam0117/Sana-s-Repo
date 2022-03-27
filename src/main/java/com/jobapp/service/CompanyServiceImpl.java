package com.jobapp.service;

import com.jobapp.exceptions.CandidateNotFoundException;
import com.jobapp.model.Candidate;
import com.jobapp.model.Mode;
import com.jobapp.model.ReqSkills;
import com.jobapp.model.SkillsCan;
import com.jobapp.repository.ICompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CompanyServiceImpl implements ICompanyService{
    @Autowired
    private ICompanyRepository companyRepository;
    
    @Override
    public void addCandidate(Candidate candidate) {
        companyRepository.addCandidate(candidate);
    }

    @Override
    public void updateCandidate(Candidate candidate) {
        companyRepository.updateCandidate(candidate);
    }

    @Override
    public void deleteCandidate(Candidate candidate) {
       companyRepository.deleteCandidate(candidate);
    }

    @Override
    public List<Candidate> getCandBySkills(ReqSkills skills) throws CandidateNotFoundException {
        List<Candidate> candidates = companyRepository.getCandBySkills(skills);
        if(candidates.isEmpty()) throw new CandidateNotFoundException("Candidate with these skills are not found");
        return candidates;
    }

    @Override
    public List<Candidate> getByCandPrefLocation(String location) throws CandidateNotFoundException {
        List<Candidate> candidates = companyRepository.getByCandPrefLocation(location);
        if(candidates.isEmpty()) throw new CandidateNotFoundException("Candidates with preferring to"+ location+" location are not found");
        return candidates;
    }

    @Override
    public List<Candidate> getByCandExpectedSal(long expsalary) throws CandidateNotFoundException {
        List<Candidate> candidates = companyRepository.getByCandExpectedSal(expsalary);
        if(candidates.isEmpty()) throw new CandidateNotFoundException("Candidates willing to work for"+ expsalary+"LPA are not found");
        return candidates;
    }

    @Override
    public List<Candidate> getByCandPrefMode(Mode mode) throws CandidateNotFoundException{
        List<Candidate> candidates = companyRepository.getByCandPrefMode(mode);
        if(candidates.isEmpty()) throw new CandidateNotFoundException("Candidates with this mode are not found");
        return candidates;
    }

    @Override
    public List<Candidate> getByCandSkillsAndPrefMode(ReqSkills skills, Mode mode) throws CandidateNotFoundException{
        List<Candidate> candidates = companyRepository.getByCandSkillsAndPrefMode(skills,mode);
        if(candidates.isEmpty()) throw new CandidateNotFoundException("Candidates with "+skills +"and willing to work in"+ mode+"mode are not found");
        return candidates;
    }
}
