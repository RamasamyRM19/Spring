package com.ideas2it.controller;

import com.ideas2it.dto.SkillDto;
import com.ideas2it.dto.TraineeDto;
import com.ideas2it.dto.TrainerDto;
import com.ideas2it.model.Skills;
import com.ideas2it.model.Trainee;
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

    /**
     *
     * 	To Show Index Page
     *
     * @return index page
     */
    @RequestMapping("/")
    public String index() {
        return "index";
    }

    /**
     *
     * To Show Trainer Form
     *
     * @return modelAndView - to show insertTrainer page
     */
    @GetMapping(value = "/CreateTrainer")
    public String showTrainerForm(Model model) {
        System.out.println("Controller Entered");
        model.addAttribute("trainerDto", new TrainerDto());
        model.addAttribute("action", "insertTrainer");
        return "CreateTrainer";
    }

    /**
     *
     * To Show Trainee Form
     *
     * @return modelAndView - to show insertTrainee page
     */
    @GetMapping(value = "/CreateTrainee")
    public String showTraineeForm(Model model) {
        System.out.println("Controller Entered");
        model.addAttribute("traineeDto", new TraineeDto());
        //model.addAttribute("action", "insertTrainee");
        return "CreateTrainee";
    }

    /**
     * add trainee details to trainee object
     *
     * @param traineeDto
     * @return redirect:/viewTrainees
     */
    @RequestMapping(value = "/insertTrainee")
    public ModelAndView insertTrainee(@ModelAttribute("traineeDto") TraineeDto traineeDto) {
        int id = employeeService.addTrainee(traineeDto);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("skillDto", new SkillDto());
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
    public String addSkill(@ModelAttribute("skillDto") SkillDto skill, int id) {

        TraineeDto traineeDto = employeeService.getTraineeById(id);
        Set<SkillDto> skills = new LinkedHashSet<SkillDto>();
        skills.add(skill);
        traineeDto.setSkillsDto(skills);
        //employeeService.updateTraineeById(updateTrainee);
        employeeService.updateTraineeById(traineeDto);
        return ("redirect:/ViewTrainee");
    }


    @RequestMapping(value = "insertTrainer")
    public String insertTrainer(@ModelAttribute("trainerDto") TrainerDto trainerDto, RedirectAttributes redirectAttributes) {
        Integer employeeId = 0;
        if (redirectAttributes.equals("insertTrainer")) {
            System.out.println("Insert Trainer page Entered");
            employeeId = employeeService.addTrainer(trainerDto);
        } else {
            employeeService.updateTrainerById(trainerDto);
        }
        return "redirect:/ViewTrainer";
    }

    @RequestMapping (value = "/ViewTrainer")
    public ModelAndView viewTrainer() {
        List<TrainerDto> trainersDto = employeeService.getAllTrainers();
        ModelAndView modelAndView = new ModelAndView("ViewTrainer");
        modelAndView.addObject("trainersDto", trainersDto);
        return modelAndView;
    }

    @RequestMapping (value = "/ViewTrainee")
    public ModelAndView viewTrainee() {
        List<TraineeDto> traineesDto = employeeService.getAllTrainees();
        ModelAndView modelAndView = new ModelAndView("ViewTrainee");
        modelAndView.addObject("traineesDto", traineesDto);
        return modelAndView;
    }

    @RequestMapping("updateTrainer")
    public String updateTrainer(@ModelAttribute("trainerDto") TrainerDto trainerDto) {
        employeeService.updateTrainerById(trainerDto);
        return "redirect:/ViewTrainer";
    }
    @RequestMapping(value = "/getTrainerById")
    public ModelAndView getTrainerById(@RequestParam int id) {
        TrainerDto trainerDto = employeeService.getTrainerById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("trainerDto", trainerDto);
        modelAndView.setViewName("UpdateTrainer");
        return modelAndView;
    }

    @RequestMapping(value = "/getTraineeById")
    public ModelAndView getTraineeById(@RequestParam int id) {
        TraineeDto traineeDto = employeeService.getTraineeById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("traineeDto", traineeDto);
        modelAndView.setViewName("UpdateTrainee");
        return modelAndView;
    }

    @RequestMapping("updateTrainee")
    public String updateTrainee(@ModelAttribute("traineeDto") TraineeDto traineeDto) {
        TraineeDto trainee1 = employeeService.getTraineeById(traineeDto.getId());
        Set<SkillDto> skills = trainee1.getSkillsDto();
        traineeDto.setSkillsDto(skills);
        employeeService.updateTraineeById(traineeDto);
        return ("redirect:/ViewTrainee");
    }


    @GetMapping("/deleteTrainer")
    public String deleteTrainer(@RequestParam int id, RedirectAttributes redirectAttributes)  {
        employeeService.deleteTrainerById(id);
        return "redirect:/ViewTrainer";
    }

    @GetMapping("/deleteTrainee")
    public String deleteTrainee(@RequestParam int id, RedirectAttributes redirectAttributes) {
        employeeService.deleteTraineeById(id);
        return "redirect:/ViewTrainee";
    }
}
