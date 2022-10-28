package com.ideas2it.mapper;

import com.ideas2it.dto.SkillDto;
import com.ideas2it.dto.TraineeDto;
import com.ideas2it.model.Skills;
import com.ideas2it.model.Trainee;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class TraineeMapper {

    public static Trainee convertTraineeDtoToTrainee(TraineeDto traineeDto) {
        Trainee trainee = new Trainee();
            trainee.setId(traineeDto.getId());
            trainee.setFirstName(traineeDto.getFirstName());
            trainee.setLastName(traineeDto.getLastName());
            trainee.setDesignation(traineeDto.getDesignation());
            trainee.setDepartment(traineeDto.getDepartment());
            trainee.setPhoneNumber(traineeDto.getPhoneNumber());
            trainee.setEmailId(traineeDto.getEmailId());
            trainee.setPreviousExperience(traineeDto.getPreviousExperience());
            trainee.setDateOfBirth(traineeDto.getDateOfBirth());
            trainee.setDateOfJoining(traineeDto.getDateOfJoining());
            trainee.setPassedOutYear(traineeDto.getPassedOutYear());
            if (traineeDto.getSkillsDto() == null) {
                trainee.setSkills(new LinkedHashSet<>());
            } else {
                trainee.setSkills(SkillMapper.convertSkillDtoToSkill(traineeDto.getSkillsDto()));
            }
        return trainee;
    }

    public static TraineeDto convertTraineeToTraineeDto(Trainee trainee) {
        TraineeDto traineeDto = new TraineeDto();
            traineeDto.setId(trainee.getId());
            traineeDto.setFirstName(trainee.getFirstName());
            traineeDto.setLastName(trainee.getLastName());
            traineeDto.setDesignation(trainee.getDesignation());
            traineeDto.setDepartment(trainee.getDepartment());
            traineeDto.setPhoneNumber(trainee.getPhoneNumber());
            traineeDto.setEmailId(trainee.getEmailId());
            traineeDto.setPreviousExperience(trainee.getPreviousExperience());
            traineeDto.setDateOfBirth(trainee.getDateOfBirth());
            traineeDto.setDateOfJoining(trainee.getDateOfJoining());
            traineeDto.setPassedOutYear(trainee.getPassedOutYear());
            if (trainee.getSkills() == null) {
                traineeDto.setSkillsDto(new LinkedHashSet<>());
            } else {
                traineeDto.setSkillsDto(SkillMapper.convertSkillToSkillDto(trainee.getSkills()));
            }
        return traineeDto;
    }
}
