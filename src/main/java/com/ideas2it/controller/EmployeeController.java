package com.ideas2it.controller;

import com.ideas2it.model.Skills;
import com.ideas2it.model.Trainee;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ideas2it.model.Trainer;
import com.ideas2it.service.inter.EmployeeService;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Controller
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    /*
     * @RequestMapping(value = "/CreateTrainer") public String
     * insertTrainer(@ModelAttribute Trainer trainer) {
     * employeeService.addTrainer(trainer); return "redirect:/ViewTrainer"; }
     */

    @GetMapping(value = "/CreateTrainer")
    public ModelAndView showTrainerForm() {
        System.out.println("Controller Entered");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("trainer", new Trainer());
        modelAndView.addObject("action", "insertTrainer");
        modelAndView.setViewName("CreateTrainer");
        return modelAndView;
    }

    @GetMapping(value = "/CreateTrainee")
    public ModelAndView showTraineeForm() {
        System.out.println("Controller Entered");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("trainee", new Trainee());
        modelAndView.addObject("action", "insertTrainee");
        modelAndView.setViewName("CreateTrainee");
        return modelAndView;
    }

    /**
     * directs to trainee form
     *
     * @param model
     * @return SaveTrainee
     */
    /*@RequestMapping("/SaveTrainee")
    public String TraineeForm(Model model) {
        model.addAttribute("trainee", new Trainee());
        return ("SaveTrainee");
    }*/

    /**
     * add trainee details to trainee object
     *
     * @param trainee
     * @return redirect:/viewTrainees
     */
    @RequestMapping(value = "/insertTrainee")
    public ModelAndView insertTrainee(@ModelAttribute("trainee") Trainee trainee) {
        int id = employeeService.addTrainee(trainee);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("skill", new Skills());
        modelAndView.addObject("id", id);
        modelAndView.setViewName("/CreateSkills");
        return modelAndView;
    }

    /**
     * add trainee skill to skill object
     *
     * @param skill, id
     * @return redirect:/viewTrainees
     */
    @RequestMapping(value = "/SaveSkill")
    public String addSkill(@ModelAttribute("skill") Skills skill, int id) {

        Trainee trainee = employeeService.getTraineeById(id);
        String firstName = trainee.getFirstName();
        String lastName = trainee.getLastName();
        String designation = trainee.getDesignation();
        String department = trainee.getDepartment();
        Long phoneNumber = trainee.getPhoneNumber();
        String emailId = trainee.getEmailId();
        String dateOfBirth = trainee.getDateOfBirth();
        Float previousExperience = trainee.getPreviousExperience();
        String dateOfJoining = trainee.getDateOfJoining();
        Integer passedOutYear = trainee.getPassedOutYear();
        Set<Skills> skills = new LinkedHashSet<Skills>();
        skills.add(skill);
        Trainee updateTrainee = new Trainee(id, firstName, lastName,
                designation, department, phoneNumber, emailId, dateOfBirth,
                previousExperience, dateOfJoining, passedOutYear, skills);
        //employeeService.updateTraineeById(updateTrainee);
        employeeService.addTrainee(updateTrainee);
        return ("redirect:/ViewTrainee");
    }

    @RequestMapping("insertTrainer")
    public String insertTrainer(@ModelAttribute("trainer") Trainer trainer, RedirectAttributes redirectAttributes) {
        Integer employeeId = 0;
        if (redirectAttributes.equals("insertTrainer")) {
            System.out.println("Insert Trainer page Entered");
            employeeId = employeeService.addTrainer(trainer);
        } else {
            employeeService.updateTrainerById(trainer);
        }
        return "redirect:/ViewTrainer";
    }

    @RequestMapping (value = "/ViewTrainer")
    public ModelAndView viewTrainer() {
        List<Trainer> trainers = employeeService.getAllTrainers();
        ModelAndView modelAndView = new ModelAndView("ViewTrainer");
        modelAndView.addObject("trainers", trainers);
        return modelAndView;
    }

    @RequestMapping (value = "/ViewTrainee")
    public ModelAndView viewTrainee() {
        List<Trainee> trainees = employeeService.getAllTrainees();
        ModelAndView modelAndView = new ModelAndView("ViewTrainee");
        modelAndView.addObject("trainees", trainees);
        return modelAndView;
    }

    @RequestMapping(value = "/getTraineeById/{id}")
    public String getTraineeById(@PathVariable int id, Model model) {
        Trainee trainee = employeeService.getTraineeById(id);
        model.addAttribute("command", trainee);
        return ("UpdateTrainee");
    }

    @RequestMapping(value = "/updateTraineeById/{id}", method = RequestMethod.POST)
    public String updateTraineeById(@ModelAttribute("trainee") Trainee trainee) {
        employeeService.updateTraineeById(trainee);
        return ("redirect:/ViewTrainee");
    }

    @GetMapping("/deleteTrainer")
    public String deleteTrainer(@RequestParam int id, RedirectAttributes redirectAttributes)  {
        employeeService.deleteTrainerById(id);
        //  redirectAttributes.addFlashAttribute("msg",id + " SuccessFully Deleted");
        return "redirect:/ViewTrainer";
    }

    @GetMapping("/deleteTrainee")
    public String deleteTrainee(@RequestParam int id, RedirectAttributes redirectAttributes) {
        employeeService.deleteTraineeById(id);
        //  redirectAttributes.addFlashAttribute("msg",id + " SuccessFully Deleted");
        return "redirect:/ViewTrainee";
    }
}
