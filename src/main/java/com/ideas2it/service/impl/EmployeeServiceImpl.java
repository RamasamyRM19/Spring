package com.ideas2it.service.impl;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher; 
import java.util.regex.Pattern;
import java.util.Set;

import com.ideas2it.dao.impl.EmployeeDAOImpl;
import com.ideas2it.dao.inter.EmployeeDAO;
import com.ideas2it.model.Skills;
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
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeDAO employeeDAO = new EmployeeDAOImpl();

    /**
     * <p>
     * Create New Trainer by passing object trainer for Trainer.
     * </p>
     *
     * @param Integer id, String firstName, String lastName, String designation,
     *        String department, Long phoneNumber, String emailId, String dateOfBirth, 
     *        Float previousExperience, String dateOfJoining, Long salary
     * @return Integer trainer
     */
    public Integer addTrainer(Trainer trainer) {
        Integer rowsAffected = null;
        rowsAffected = employeeDAO.insertTrainer(trainer);
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
    public List<Trainer> getAllTrainers() {
        List<Trainer> trainers = new ArrayList<Trainer>();
        trainers = employeeDAO.retrieveAllTrainers();
        return trainers;
    }

    /**
     * <p>
     * checkTrainerById is a method, checks whether the employee id
     * exists or not in the trainers
     * </p>
     *
     * @param Integer id
     * @return Boolean true, boolean false
     */
    public boolean checkTrainerById(Integer id) {
        for (Trainer trainer : employeeDAO.retrieveAllTrainers()) {
            if (trainer.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }

    /**
     * <p>
     * Display specific Trainer by getting Id from the user. Which displays Id, 
     * name, designation, department,phone number, salary & experience. 
     * </p>
     *
     * @param Integer id 
     * @return List<Trainer> trainers
     */
    public Trainer getTrainerById(Integer id) { 
        Trainer trainer = employeeDAO.retrieveTrainerById(id); 
        return trainer;
    }

    /**
     * <p>
     * Update specific Trainer by getting Id from the user. Which updates 
     * name, designation, department,phone number, salary & experience for the particular id. 
     * </p>
     *
     * @param Integer id, String firstName, String lastName, String designation, String department, 
     *        Long phoneNumber, String emailId, String dateOfBirth, Float previousExperience, 
     *        String dateOfJoining, Long salary
     * @return String
     */
    public void updateTrainerById(Integer id, String firstName, String lastName, String designation, 
            String department, String phoneNumber, String emailId, 
            String dateOfBirth, String previousExperience, 
            String dateOfJoining, String salary) {
        List<Trainer> trainers = employeeDAO.retrieveAllTrainers();
        for (Trainer trainer : trainers) {
            if ((trainer.getId()).equals(id)) {
                if (!firstName.isEmpty()) {
                    trainer.setFirstName(firstName);
                }
                if (!lastName.isEmpty()) {
                    trainer.setLastName(lastName);
                }
                if (!designation.isEmpty()) {
                    trainer.setDesignation(designation);
                }
                if (!department.isEmpty()) {
                    trainer.setDepartment(department);
                }
                if (!phoneNumber.isEmpty()) {
                    trainer.setPhoneNumber(Long.parseLong(phoneNumber));
                }
                if (!emailId.isEmpty()) {
                    trainer.setEmailId(emailId);
                }
                if (!dateOfBirth.isEmpty()) {
                    trainer.setDateOfBirth(dateOfBirth);
                }
                if (!previousExperience.isEmpty()) {
                    trainer.setPreviousExperience(Float.parseFloat(previousExperience));
                }
                if (!dateOfJoining.isEmpty()) {
                    trainer.setDateOfJoining(dateOfJoining);
                }
                if (!salary.isEmpty()) {
                    trainer.setSalary(Long.parseLong(salary));
                }   
                employeeDAO.updateTrainerById(trainer);
            }
        }
		//return trainers;
    }

    /**
     * <p>
     * Delete specific Trainer by getting Id from the user. Which deletes 
     * all the details for the particular id.  
     * </p>
     *
     * @param Integer id
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
     * @param Integer id, String firstName, String lastName, String designation,
     *        String department, long phoneNumber, String dateOfBirth, 
     *        String dateOfJoining, int passedOutYear, String listOfSkills 
     * @return void
     */
    public Integer addTrainee(Integer id, String firstName, String lastName, String designation,
            String department, Long phoneNumber, String emailId,  
            String dateOfBirth, Float previousExperience, String dateOfJoining, 
            Integer passedOutYear, Set<Skills> skills) {
        Integer rowsAffected = null;
        Trainee trainee = new Trainee(id, firstName, lastName, designation, department, phoneNumber, emailId,
                dateOfBirth, previousExperience, dateOfJoining, passedOutYear, skills);
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
    public List<Trainee> getAllTrainees() {
        List<Trainee> trainees = new ArrayList<Trainee>();
        trainees = employeeDAO.retrieveAllTrainees();
        return trainees;
    }

    /**
     * <p>
     * checkTraineeById is a method, checks whether the employee id
     * exists or not in the trainees
     * </p>
     *
     * @param Integer id
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
     * @param Integer id - employee id value for the Trainee display operation
     * @return Trainee trainees
     */
    public Trainee getTraineeById(Integer id) { 
        Trainee trainee = new Trainee();
        trainee = employeeDAO.retrieveTraineeById(id); 
        return trainee;
    }

    /**
     * <p>
     * Update specific Trainee by getting Id from the user, which updates Trainee's
     * details for the particular key. 
     * </p>
     *
     * @param Integer id, String firstName, String lastName, String designation, String department, 
              long phoneNumber, String dateOfBirth, String dateOfJoining, Integer passedOutYear, 
              String listOfSkills
     * @return String
     */
    public void updateTraineeById(Integer id, String firstName, String lastName, String designation, 
            String department, String phoneNumber, String emailId, 
            String dateOfBirth, String previousExperience, 
            String dateOfJoining, String passedOutYear, Set<Skills> skills) {
        List<Trainee> trainees = employeeDAO.retrieveAllTrainees();
        for (Trainee trainee : trainees) {
            if ((trainee.getId()).equals(id)) {
                if (!firstName.isEmpty()) {
                    trainee.setFirstName(firstName);
                }
                if (!lastName.isEmpty()) {
                    trainee.setLastName(lastName);
                }
                if (!designation.isEmpty()) {
                    trainee.setDesignation(designation);
                }
                if (!department.isEmpty()) {
                    trainee.setDepartment(department);
                }
                if (!phoneNumber.isEmpty()) {
                    trainee.setPhoneNumber(Long.parseLong(phoneNumber));
                }
                if (!emailId.isEmpty()) {
                    trainee.setEmailId(emailId);
                }
                if (!dateOfBirth.isEmpty()) {
                    trainee.setDateOfBirth(dateOfBirth);
                }
                if (!previousExperience.isEmpty()) {
                    trainee.setPreviousExperience(Float.parseFloat(previousExperience));
                }
                if (!dateOfJoining.isEmpty()) {
                    trainee.setDateOfJoining(dateOfJoining);
                }
                if (!passedOutYear.isEmpty()) {
                    trainee.setPassedOutYear(Integer.parseInt(passedOutYear));
                }
                if (!skills.isEmpty()) {
                    trainee.setSkills(skills);
                }
                System.out.println(skills);
                employeeDAO.updateTraineeById(trainee);
            }
        }
    }  

    /**
     * <p>
     * Delete specific Trainer by getting Id from the user. Which deletes 
     * all the details for the particular id.  
     * </p>
     *
     * @param Integer id
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
     * @param String firstName
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
     * @param String lastName
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
     * @param String str
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
     * @param String emailId
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
     * @param LocalDate birthDate
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
     * @param LocalDate date
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
