package com.jobapp.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor

@ToString

public class Candidate {
    private String location;
    private String designation;
    private Mode mode;
    private double expSalary;
    private SkillsCan skills;
    private int workingHours;

    public Candidate(String location, String designation, Mode mode, double expSalary, SkillsCan skills, int workingHours) {
        this.location = location;
        this.designation = designation;
        this.mode = mode;
        this.expSalary = expSalary;
        this.skills = skills;
        this.workingHours = workingHours;
    }
}
