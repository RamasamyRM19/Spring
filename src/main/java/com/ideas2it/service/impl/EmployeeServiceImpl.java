package com.ideas2it.service.impl;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.ideas2it.dto.TraineeDto;
import com.ideas2it.dto.TrainerDto;
import com.ideas2it.mapper.TraineeMapper;
import com.ideas2it.mapper.TrainerMapper;
import org.springframework.stereotype.Component;

import com.ideas2it.dao.inter.EmployeeDAO;
import com.ideas2it.model.Trainee;
import com.ideas2it.model.Trainer;
import com.ideas2it.service.inter.EmployeeService;

/**
 * EmployeeService class has the control to
 * display Trainer & Trainee Details
 *
 * @version 1.0 08 Aug 2022
 *
 * @author  Ramasamy R M
 */
@Component
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeDAO employeeDAO;

    public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }
    /**
     * <p>
     * Create New Trainer by passing object trainer for Trainer.
     * </p>
     *
     * @param trainerDto
     * @return Integer trainer
     */
    public Integer addTrainer(TrainerDto trainerDto) {
        Integer rowsAffected = null;
        Trainer trainer = TrainerMapper.convertTrainerDtoToTrainer(trainerDto);
        rowsAffected = employeeDAO.insertTrainer(trainerDto);
        return rowsAffected;
    }


    /**
     * <p>
     * Display All Trainers details 
     * </p>
     *
     * @param 
     * @return List<Trainer> trainers
     */
    public List<TrainerDto> getAllTrainers() {
        List<TrainerDto> trainers = new ArrayList<>();
        for (Trainer trainer : employeeDAO.retrieveAllTrainers()) {
            trainers.add(TrainerMapper.convertTrainerToTrainerDto(trainer));
        }
        return trainers;
    }

    /**
     * <p>
     * checkTrainerById is a method, checks whether the employee id
     * exists or not in the trainers
     * </p>
     *
     * @param id
     * @return Boolean true, boolean false
     */
    public boolean checkTrainerById(Integer id) {
        Boolean isValidTrainerId = false;
        for (Trainer trainer : employeeDAO.retrieveAllTrainers()) {
            if (trainer.getId().equals(id)) {
                isValidTrainerId = true;
            }
        }
        return isValidTrainerId;
    }

    /**
     * <p>
     * Display specific Trainer by getting Id from the user. Which displays Id, 
     * name, designation, department,phone number, salary & experience. 
     * </p>
     *
     * @param id
     * @return List<Trainer> trainers
     */
    public TrainerDto getTrainerById(Integer id) {
        TrainerDto trainerDto = null;
        Optional<Trainer> trainer = Optional.ofNullable(employeeDAO.retrieveTrainerById(id));
        if (trainer.isPresent()) {
            trainerDto = TrainerMapper.convertTrainerToTrainerDto(trainer.get());
        }
        return trainerDto;
    }

    /**
     * <p>
     * Update specific Trainer by getting Id from the user. Which updates 
     * name, designation, department,phone number, salary & experience for the particular id. 
     * </p>
     *
     * @param trainerDto
     * @return String
     */
    public void updateTrainerById(TrainerDto trainerDto) {
       // List<Trainer> trainers = employeeDAO.retrieveAllTrainers();
        Trainer trainer = TrainerMapper.convertTrainerDtoToTrainer(trainerDto);
        employeeDAO.updateTrainerById(trainer);
		//return trainers;
    }

    /**
     * <p>
     * Delete specific Trainer by getting Id from the user. Which deletes 
     * all the details for the particular id.  
     * </p>
     *
     * @param id
     * @return 
     */
    public void deleteTrainerById(Integer id) {
        employeeDAO.deleteTrainerById(id);
    }

    /**
     * <p>
     * Create New Trainee by passing object trainee for Trainee.
     * </p>
     *
     * @param traineeDto
     * @return void
     */
    public Integer addTrainee(TraineeDto traineeDto) {
        Integer rowsAffected = null;
        Trainee trainee = TraineeMapper.convertTraineeDtoToTrainee(traineeDto);
        rowsAffected = employeeDAO.insertTrainee(trainee);
        return rowsAffected;
    }

    /**
     * <p>
     * Display All Trainees details  
     * </p>
     *
     * @param 
     * @return List<Trainee> trainees
     */
    public List<TraineeDto> getAllTrainees() {
        List<TraineeDto> trainees = new ArrayList<>();
        for (Trainee trainee : employeeDAO.retrieveAllTrainees()) {
            trainees.add(TraineeMapper.convertTraineeToTraineeDto(trainee));
        }
        return trainees;
    }

    /**
     * <p>
     * checkTraineeById is a method, checks whether the employee id
     * exists or not in the trainees
     * </p>
     *
     * @param id
     * @return boolean true, boolean false
     */
    public Boolean checkTraineeById(Integer id) {
        Boolean isValidTraineeId = false;
        for (Trainee trainee : employeeDAO.retrieveAllTrainees()) { 
            if (trainee.getId().equals(id)) {
                isValidTraineeId = true;
            }  
        } 
        return isValidTraineeId;
    }

    /**
     * <p>
     * Display specific Trainee by getting Id from the user. Which displays Id,
     * name, designation, department, phone number, passed out year & skills.
     * </p>
     *
     * @param id
     * @return Trainee trainees
     */
    public TraineeDto getTraineeById(Integer id) {
        TraineeDto traineeDto = null;
        Optional<Trainee> trainee = Optional.ofNullable(employeeDAO.retrieveTraineeById(id));
        if (trainee.isPresent()) {
            traineeDto = TraineeMapper.convertTraineeToTraineeDto(trainee.get());
        }
        return traineeDto;
    }

    /**
     * <p>
     * Update specific Trainee by getting Id from the user, which updates Trainee's
     * details for the particular key. 
     * </p>
     *
     * @param traineeDto
     * @return String
     */
    public void updateTraineeById(TraineeDto traineeDto) {
        Trainee trainee = TraineeMapper.convertTraineeDtoToTrainee(traineeDto);
        employeeDAO.updateTraineeById(trainee);
    }


    /**
     * <p>
     * Delete specific Trainer by getting Id from the user. Which deletes 
     * all the details for the particular id.  
     * </p>
     *
     * @param id
     * @return 
     */
    public void deleteTraineeById(Integer id) {
        employeeDAO.deleteTraineeById(id);
    }

    /**
     * <p>
     * Function to check if the First name is valid or not.
     * the matcher() method creates a matcher that will match the given input against this pattern
     * </p>
     *
     * @param firstName
     * @return Boolean true, Boolean false 
     */   
    public Boolean isValidFirstName(String firstName) {
        return firstName.matches("[A-Z][a-zA-Z]*");
    } 

    /**
     * <p>
     * Function to check if the Last name is valid or not.
     * the matcher() method creates a matcher that will match the given input against this pattern
     * </p>
     *
     * @param lastName
     * @return Boolean true, Boolean false 
     */   
    public Boolean isValidLastName(String lastName) {
        return lastName.matches("[a-zA-z]+([ '-][a-zA-Z]+)*");
    } 

    /**
     * <p>
     * Function to check if the mobile number is valid or not.
     * the matcher() method creates a matcher that will match the given input against this pattern
     * </p>
     *
     * @param str
     * @return Boolean true, Boolean false
     */    
    public Boolean isValidPhoneNumber(String str) {  
        Pattern pattern = Pattern.compile("[6-9][0-9]{9}");  
        Matcher match = pattern.matcher(str);  
        return (match.find() && match.group().equals(str));  
    }

    /**
     * <p>
     * Function to check if the email id is valid or not.
     * the matcher() method creates a matcher that will match the given input against this pattern
     * </p>
     *
     * @param emailId
     * @return Boolean true, Boolean false
     */   
    public Boolean isValidEmailId(String emailId) {
        String regex = "^[a-z][a-z0-9.]{4,}@[a-z0-9.]{5,}(com|in|co.in|org|edu)$";
        Pattern pattern = Pattern.compile(regex);  
        Matcher matcher = pattern.matcher(emailId);  
        return matcher.matches();  
    }  

    /**
     * 
     */
    public Boolean isValidDate(String dateOfBirth) {
        String format = "([0][1-9]|[1][0-2])/([0][1-9]|[1][0-2]{1})/([1][0-9]{3}|[2][0-9]{3})";
        Boolean status = Pattern.matches(format, dateOfBirth);
        return status;
    }
    
    /**
     * <p>
     * Function to check if the employee's age is valid or not.
     * It calculates the age of an employee based on current date & birthday date
     * & checks the age should be greater than 18 and lesser than 60 to be a 
     * eligible employee
     * </p>
     *
     * @param birthDate
     * @return Boolean true, Boolean false
     */   
    public Boolean isValidEmployee(LocalDate birthDate) {
        LocalDate currentDate = LocalDate.now();   
        if ((birthDate != null) && (currentDate != null)) {  
            Integer age = Period.between(birthDate, currentDate).getYears();
            if ((age > 18 ) && (age < 60)) {
                return true;
            } else {
                return false;
            }
        } else {  
            return false;  
        }  
    }

    /**
     * <p>
     * Function to check if the employee's joining date is valid or not.
     * It compares the current date & joining date
     * </p>
     *
     * @param date
     * @return Boolean true, Boolean false
     */   
    public Boolean isFutureDate(LocalDate date) {
        LocalDate currentDate = LocalDate.now();  
        if ((date != null) && (currentDate != null)) { 
            if (date.compareTo(currentDate) > 0) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }

    /**
     * <p>
     * It check the string that check the valid input of user menu.
     * </p>
     * @param {@link String} option
     * @return {@link boolean} If the string in correct format return true else false.
     **/
    public Boolean isvalidNumberInput(String string) {
        String validIdPatten = "[0-9]*";
        return string.matches(validIdPatten);
    } 
}
