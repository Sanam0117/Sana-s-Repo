package com.jobapp;

import com.jobapp.model.*;
import com.jobapp.service.ICandidateService;
import com.jobapp.service.ICompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import static com.jobapp.model.Mode.PHYSICAL;
import static com.jobapp.model.Mode.VIRTUAL;
import static com.jobapp.model.Place.*;
import static com.jobapp.model.ReqSkills.*;
import static com.jobapp.model.ReqSkills.JAVA;
import static com.jobapp.model.SkillsCan.*;

@SpringBootApplication
@ImportResource({"classpath*:application-context.xml"})
@EnableMongoRepositories("com.jobapp.repository.ICompanyRepository")
@ComponentScan({"com.jobapp.service.ICompanyService"})
public class SpringRestAppjobRelationsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringRestAppjobRelationsApplication.class, args);
	}
	@Autowired
     private ICompanyService companyService;
	 private ICandidateService candidateService;

	public void run(String... args) throws Exception{
		Company company1= new Company("Kloudspot", BANGALORE,"Software",VIRTUAL,3.0, JAVA,7);
		Company company2= new Company("Samsung", CHENNAI,"Test Engineer",PHYSICAL,5.3, JAVA,7);
		Company company3= new Company("Infosys", MYSORE," Associate Software Engineer",PHYSICAL,3.5, JAVA,8);
		Company company4= new Company("Capgemini", HYDERABAD,"Software Trainee",VIRTUAL,2.5, JAVA,4);

		Candidate candidate1= new Candidate("Bangalore,Hyderabad","Software Engineer",PHYSICAL,5, MERN, 8);
		Candidate candidate2= new Candidate("Chennai","Software Trainee",PHYSICAL,3.5, MEAN, 8);
		Candidate candidate3= new Candidate("Hyderabad","Software Intern",VIRTUAL,3.5, HTML, 3);
		Candidate candidate4= new Candidate("Pune","Manager",PHYSICAL,5.5, SkillsCan.SPRING, 10);

		candidateService.getByLocation(HYDERABAD);
		candidateService.getByLocation(BANGALORE);
		candidateService.getByReqSkills(JAVA);
		candidateService.getByComMode(PHYSICAL);
		candidateService.getByDesignation("Test Engineer");
		candidateService.getByCTC(5);
		candidateService.getByReqSkillsAndWorkingHours(ReqSkills.ANGULAR,7);

      companyService.getByCandPrefMode(VIRTUAL);
		companyService.getByCandExpectedSal(7);
		companyService.getCandBySkills(ReqSkills.JAVASCRIPT);
		companyService.getByCandSkillsAndPrefMode(ReqSkills.ANGULAR,PHYSICAL);
	}
}