package com.ideas2it.dto;

import com.ideas2it.dto.SkillDto;

import java.util.Set;

public class TraineeDto extends EmployeeDto {

    private Integer passedOutYear;
    private Set<SkillDto> skills;

    public TraineeDto() {
    }

    public TraineeDto(Integer id, String firstName, String lastName, String designation,
                   String department, Long phoneNumber, String emailId, String dateOfBirth,
                   Float previousExperience, String dateOfJoining, Integer passedOutYear,
                   Set<SkillDto> skills) {
        super(id, firstName, lastName, designation, department, phoneNumber, emailId, dateOfBirth,
                previousExperience, dateOfJoining);
        this.passedOutYear = passedOutYear;
        this.skills = skills;
    }

    public TraineeDto(Integer id, String firstName, String lastName, String designation,
                   String department, Long phoneNumber, String emailId, String dateOfBirth,
                   Float previousExperience, String dateOfJoining, Integer passedOutYear) {
        super(id, firstName, lastName, designation, department, phoneNumber, emailId, dateOfBirth,
                previousExperience, dateOfJoining);
        this.passedOutYear = passedOutYear;
    }

    public Integer getPassedOutYear() {
        return passedOutYear;
    }

    public void setPassedOutYear(Integer passedOutYear) {
        this.passedOutYear = passedOutYear;
    }

    public Set<SkillDto> getSkillsDto() {
        return skills;
    }

    public void setSkillsDto(Set<SkillDto> skills) {
        this.skills = skills;
    }

    public String toString() {
        return (super.toString() + "\nPassed Out Year : " + passedOutYear);
    }
}
