package com.ideas2it.service.inter;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.ideas2it.dto.TraineeDto;
import com.ideas2it.dto.TrainerDto;
import com.ideas2it.model.Trainee;
import com.ideas2it.model.Trainer;

public interface EmployeeService {

	Integer addTrainer(TrainerDto trainerDto);

	List<TrainerDto> getAllTrainers();
	
	boolean checkTrainerById(Integer id);
	
	TrainerDto getTrainerById(Integer id);
	
	void updateTrainerById(TrainerDto trainerDto);

	void deleteTrainerById(Integer id);

	Integer addTrainee(TraineeDto traineeDto);
	
	List<TraineeDto> getAllTrainees();
	
	Boolean checkTraineeById(Integer id);
	
	TraineeDto getTraineeById(Integer id);

	void updateTraineeById(TraineeDto traineeDto);
	
	void deleteTraineeById(Integer id);
	
	Boolean isValidFirstName(String firstName);
	
	Boolean isValidLastName(String lastName);
	
	Boolean isValidPhoneNumber(String str);
	
	Boolean isValidEmailId(String emailId);
	
	Boolean isValidDate(String dateOfBirth);
	
	Boolean isValidEmployee(LocalDate birthDate);
	
	Boolean isFutureDate(LocalDate date);
	
	Boolean isvalidNumberInput(String string);
}
