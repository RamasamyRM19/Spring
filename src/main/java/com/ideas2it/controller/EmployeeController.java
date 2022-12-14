package com.ideas2it.controller;

import jakarta.servlet.http.HttpSession;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ideas2it.model.Skills;
import com.ideas2it.model.Trainee;
import com.ideas2it.model.Trainer;
import com.ideas2it.service.inter.EmployeeService;

/**
 * EmployeeController class has the control to display
 * Trainer & Trainee Details using model, service & dao
 *
 * @version 1.0 05 Sep 2022
 *
 * @author  Ramasamy R M
 */
@Controller
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    /**
     * directs to index page
     *
     * @param
     * @return index
     */
    @RequestMapping("/")
    public String index() {
        return "index";
    }

    /**
     * directs to Trainer Form
     *
     * @param
     * @return modelAndView
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

    /**
     * directs to Trainee Form
     *
     * @param
     * @return modelAndView
     */
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
     * add trainee details to trainee object
     *
     * @param trainee
     * @return modelAndView
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
     * @return redirect:/ViewTrainee
     */
    @RequestMapping(value = "/SaveSkill")
    public String addSkill(@ModelAttribute("skill") Skills skill, int id) {

        Trainee trainee = employeeService.getTraineeById(id);
        Set<Skills> skills = new LinkedHashSet<Skills>();
        skills.add(skill);
        trainee.setSkills(skills);
        //employeeService.updateTraineeById(updateTrainee);
        employeeService.updateTraineeById(trainee);
        return ("redirect:/ViewTrainee");
    }

    /**
     * add trainer details to trainer object
     *
     * @param trainer
     * @return redirect:/ViewTrainer
     */
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

    /**
     * update trainer by id
     *
     * @param trainer 
     * @return redirect:/ViewTrainer
     */
    @RequestMapping("updateTrainer")
    public String updateTrainer(@ModelAttribute("trainer") Trainer trainer) {
        employeeService.updateTrainerById(trainer);
        return "redirect:/ViewTrainer";
    }

    /**
     * update trainee by id
     *
     * @param trainee 
     * @return redirect:/ViewTrainee
     */
    @RequestMapping("updateTrainee")
    public String updateTrainee(@ModelAttribute("trainee") Trainee trainee) {
        Trainee trainee1 = employeeService.getTraineeById(trainee.getId());
        Set<Skills> skills = trainee1.getSkills();
        trainee.setSkills(skills);
        employeeService.updateTraineeById(trainee);
        return ("redirect:/ViewTrainee");
    }
    
    /**
     * shows all trainers
     *
     * @return ViewTrainer
     */
    @RequestMapping(value = "/ViewTrainer")
    public ModelAndView viewTrainer() {
        List<Trainer> trainers = employeeService.getAllTrainers();
        ModelAndView modelAndView = new ModelAndView("ViewTrainer");
        modelAndView.addObject("trainers", trainers);
        return modelAndView;
    }

    /**
     * shows all trainees
     *
     * @return ViewTrainee
     */
    @RequestMapping(value = "/ViewTrainee")
    public ModelAndView viewTrainee() {
        List<Trainee> trainees = employeeService.getAllTrainees();
        ModelAndView modelAndView = new ModelAndView("ViewTrainee");
        modelAndView.addObject("trainees", trainees);
        return modelAndView;
    }

    /**
     * get trainee by id
     *
     * @param id 
     * @return UpdateTrainee
     */
    @RequestMapping(value = "/getTraineeById")
    public ModelAndView getTraineeById(@RequestParam int id) {
        Trainee trainee = employeeService.getTraineeById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("trainee", trainee);
        modelAndView.setViewName("UpdateTrainee");
        return modelAndView;
    }

    /**
     * get trainer by id
     *
     * @param id 
     * @return UpdateTrainer
     */
    @RequestMapping(value = "/getTrainerById")
    public ModelAndView getTrainerById(@RequestParam int id) {
        Trainer trainer = employeeService.getTrainerById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("trainer", trainer);
        modelAndView.setViewName("UpdateTrainer");
        return modelAndView;
    }

    /**
     * delete trainer
     *
     * @param id 
     * @return redirect:/ViewTrainer
     */
    @GetMapping("/deleteTrainer")
    public String deleteTrainer(@RequestParam int id, RedirectAttributes redirectAttributes) {
        employeeService.deleteTrainerById(id);
        return "redirect:/ViewTrainer";
    }

    /**
     * delete trainee
     *
     * @param id 
     * @return redirect:/ViewTrainee
     */
    @GetMapping("/deleteTrainee")
    public String deleteTrainee(@RequestParam int id, RedirectAttributes redirectAttributes) {
        employeeService.deleteTraineeById(id);
        return "redirect:/ViewTrainee";
    }
}
