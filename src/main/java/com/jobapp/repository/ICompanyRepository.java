package com.jobapp.repository;

import com.jobapp.model.Candidate;
import com.jobapp.model.Mode;
import com.jobapp.model.ReqSkills;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ICompanyRepository {

    void addCandidate(Candidate candidate);
    void updateCandidate(Candidate candidate);
    void deleteCandidate(Candidate candidate);
      @Query("{'skills':?0}")
    List<Candidate> getCandBySkills(ReqSkills skills);
    @Query("{'location':?0}")
    List<Candidate> getByCandPrefLocation(String location);
    @Query("{'expsalary':?0}")
    List<Candidate> getByCandExpectedSal(long expsalary);
    @Query("{'mode':?0}")
    List<Candidate> getByCandPrefMode(Mode mode);
    @Query("{$and:[{'skills':?0} , {'mode':?1}]}")
   // @Query("{'skills':?0} , {'mode':?1}")
    List<Candidate> getByCandSkillsAndPrefMode(ReqSkills skills, Mode mode);
}
