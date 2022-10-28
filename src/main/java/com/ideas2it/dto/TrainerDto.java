package com.ideas2it.dto;

import com.ideas2it.dto.EmployeeDto;

public class TrainerDto extends EmployeeDto {
    private Long salary;

    public TrainerDto() {
    }

    public TrainerDto(Integer id, String firstName, String lastName, String designation,
                   String department, Long phoneNumber, String emailId, String dateOfBirth,
                   Float previousExperience, String dateOfJoining, Long salary) {
        super(id, firstName, lastName, designation, department, phoneNumber, emailId, dateOfBirth,
                previousExperience, dateOfJoining);
        this.salary = salary;
    }

    public Long getSalary() {
        return salary;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }

    public String toString() {
        return (super.toString() + "\nSalary        : " + salary);
    }

    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return false;
    }
}
