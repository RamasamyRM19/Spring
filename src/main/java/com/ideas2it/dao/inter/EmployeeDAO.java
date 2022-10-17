package com.ideas2it.dao.inter;

import java.util.List;

import com.ideas2it.model.Trainee;
import com.ideas2it.model.Trainer;

public interface EmployeeDAO {

	Integer insertTrainer(Trainer trainer);
	
	List<Trainer> retrieveAllTrainers();
	
	Trainer retrieveTrainerById(Integer id);
	
	void updateTrainerById(Trainer trainer);
	
	void deleteTrainerById(Integer id);
	
	Integer insertTrainee(Trainee trainee);
	
	List<Trainee> retrieveAllTrainees();
	
	Trainee retrieveTraineeById(Integer id);
	
	void updateTraineeById(Trainee trainee);
	
	void deleteTraineeById(Integer id);
}
