package com.ideas2it.service.inter;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import com.ideas2it.model.Skills;
import com.ideas2it.model.Trainee;
import com.ideas2it.model.Trainer;

public interface EmployeeService {

	Integer addTrainer(Trainer trainer);

	List<Trainer> getAllTrainers();
	
	boolean checkTrainerById(Integer id);
	
	Trainer getTrainerById(Integer id);
	
	void updateTrainerById(Trainer trainer);

	void deleteTrainerById(Integer id);

	Integer addTrainee(Trainee trainee);
	
	List<Trainee> getAllTrainees();
	
	Boolean checkTraineeById(Integer id);
	
	Trainee getTraineeById(Integer id);

	void updateTraineeById(Trainee trainee);
	
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
