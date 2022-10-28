package com.ideas2it.dao.inter;

import java.util.List;

import com.ideas2it.dto.TraineeDto;
import com.ideas2it.dto.TrainerDto;
import com.ideas2it.model.Skills;
import com.ideas2it.model.Trainee;
import com.ideas2it.model.Trainer;

public interface EmployeeDAO {

	Integer insertTrainer(TrainerDto trainerDto);
	
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
