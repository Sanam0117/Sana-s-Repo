package com.jobapp.model;

import lombok.*;

import javax.xml.stream.Location;


@Getter
@Setter
@NoArgsConstructor

@ToString

public class Company {
    private String companyName;
    private Place location;
    private String designation;
    private Mode mode;
    private double ctc;
    private ReqSkills skills;
    private int workingHours;

    public Company(String companyName, Place location, String designation, Mode mode, double ctc, ReqSkills skills, int workingHours) {
        this.companyName = companyName;
        this.location = location;
        this.designation = designation;
        this.mode = mode;
        this.ctc = ctc;
        this.skills = skills;
        this.workingHours = workingHours;
    }
}
