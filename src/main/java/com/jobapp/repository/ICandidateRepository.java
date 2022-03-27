package com.jobapp.repository;

import com.jobapp.model.*;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ICandidateRepository extends MongoRepository<Candidate , Integer> {
    @Query("{'companyName':?0")
    Company getByComName(String companyName);

    List<Company> showallcompanies();
    @Query("{'ctc':?0}")
    List<Company> getByCTC(long ctc);
    @Query("{'designation':?0}")
    List<Company> getByDesignation(String designation);
    @Query("{'skills':?0}")
    List<Company> getByReqSkills(SkillsCan skills);
    @Query("{'workingHours':?0}")
    List<Company> getByWorkingHours(int workingHours);
    @Query("{'mode':?0}")
    List<Company> getByComMode(Mode mode);
    @Query("{'location':?0}")
    List<Company> getByLocation(Place location);
    @Query("{'skills':?0 , 'workingHours':?1}")
   // @Query("{$and:[{'skills':?0} , {'workingHours':?1}]}")
    List<Company> getByReqSkillsAndWorkingHours(SkillsCan skills, int workingHours);
}
