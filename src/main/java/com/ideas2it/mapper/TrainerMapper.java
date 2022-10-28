package com.ideas2it.mapper;

import com.ideas2it.dto.TrainerDto;
import com.ideas2it.model.Trainer;

public class TrainerMapper {
    public static Trainer convertTrainerDtoToTrainer(TrainerDto trainerDto) {
        Trainer trainer = new Trainer();
        if (!(trainerDto.equals(null))) {
            trainer.setId(trainerDto.getId());
            trainer.setFirstName(trainerDto.getFirstName());
            trainer.setLastName(trainerDto.getLastName());
            trainer.setDesignation(trainerDto.getDesignation());
            trainer.setDepartment(trainerDto.getDepartment());
            trainer.setPhoneNumber(trainerDto.getPhoneNumber());
            trainer.setEmailId(trainerDto.getEmailId());
            trainer.setPreviousExperience(trainerDto.getPreviousExperience());
            trainer.setDateOfBirth(trainerDto.getDateOfBirth());
            trainer.setDateOfJoining(trainerDto.getDateOfJoining());
            trainer.setSalary(trainerDto.getSalary());
        }
        return trainer;
    }

    public static TrainerDto convertTrainerToTrainerDto(Trainer trainer) {
        TrainerDto trainerDto = new TrainerDto();
        if (!(trainer.equals(null))) {
            trainerDto.setId(trainer.getId());
            trainerDto.setFirstName(trainer.getFirstName());
            trainerDto.setLastName(trainer.getLastName());
            trainerDto.setDesignation(trainer.getDesignation());
            trainerDto.setDepartment(trainer.getDepartment());
            trainerDto.setPhoneNumber(trainer.getPhoneNumber());
            trainerDto.setEmailId(trainer.getEmailId());
            trainerDto.setPreviousExperience(trainer.getPreviousExperience());
            trainerDto.setDateOfBirth(trainer.getDateOfBirth());
            trainerDto.setDateOfJoining(trainer.getDateOfJoining());
            trainerDto.setSalary(trainer.getSalary());
        }
        return trainerDto;
    }
}