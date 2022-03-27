package com.jobapp.service;

import com.jobapp.exceptions.CompanyNotFoundException;
import com.jobapp.model.Candidate;
import com.jobapp.model.Mode;
import com.jobapp.model.ReqSkills;

import java.util.List;

public interface ICompanyService {
    void addCandidate(Candidate candidate);
        void updateCandidate(Candidate candidate);
        void deleteCandidate(Candidate candidate);

        List<Candidate> getCandBySkills(ReqSkills skills) throws CompanyNotFoundException;
        List<Candidate> getByCandPrefLocation(String location) throws CompanyNotFoundException;
        List<Candidate> getByCandExpectedSal(long expsalary) throws CompanyNotFoundException;
        List<Candidate> getByCandPrefMode(Mode mode) throws CompanyNotFoundException;
        List<Candidate> getByCandSkillsAndPrefMode(ReqSkills skills, Mode mode) throws CompanyNotFoundException;
}
