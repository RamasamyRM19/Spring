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
	
	void updateTrainerById(Integer id, String firstName, String lastName, String designation, 
			String department, String phoneNumber, String emailId, 
			String dateOfBirth, String previousExperience, 
			String dateOfJoining, String salary);

	void deleteTrainerById(Integer id);

	Integer addTrainee(Integer id, String firstName, String lastName, String designation,
			String department, Long phoneNumber, String emailId,  
			String dateOfBirth, Float previousExperience, String dateOfJoining, 
			Integer passedOutYear, Set<Skills> skills);
	
	List<Trainee> getAllTrainees();
	
	Boolean checkTraineeById(Integer id);
	
	Trainee getTraineeById(Integer id);
	
	void updateTraineeById(Integer id, String firstName, String lastName, String designation, 
			String department, String phoneNumber, String emailId, 
			String dateOfBirth, String previousExperience, 
			String dateOfJoining, String passedOutYear, Set<Skills> skills);
	
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
