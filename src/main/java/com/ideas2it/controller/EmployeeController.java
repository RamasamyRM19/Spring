package com.ideas2it.controller;

import com.ideas2it.model.Skills;
import com.ideas2it.model.Trainee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ideas2it.model.Trainer;
import com.ideas2it.service.inter.EmployeeService;

import java.util.List;

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
        modelAndView.addObject("skills", new Skills());
        modelAndView.addObject("action", "insertTrainee");
        modelAndView.setViewName("CreateTrainee");
        return modelAndView;
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

    @RequestMapping("insertTrainee")
    public String insertTrainee(@ModelAttribute("trainee") Trainee trainee, RedirectAttributes redirectAttributes) {
        Integer employeeId = 0;
        if (redirectAttributes.equals("insertTrainee")) {
            System.out.println("Insert Trainee page Entered");
            employeeId = employeeService.addTrainee(trainee);
        } else {
            employeeService.updateTraineeById(trainee);
        }
        return "redirect:/ViewTrainee";
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

    @GetMapping("/updateTrainer")
    public String getTrainerById(@RequestParam("id") int trainerId, Model model) {
        Trainer trainer = employeeService.getTrainerById(trainerId);
        model.addAttribute("trainer", trainer);
        model.addAttribute("action", "updateTrainer");
        return "updateTrainer";
    }

    @GetMapping("/updateTrainee")
    public String getTraineeById(@RequestParam("id") int traineeId, Model model) {
        Trainee trainee = employeeService.getTraineeById(traineeId);
        model.addAttribute("trainee", trainee);
        model.addAttribute("action", "updateTrainee");
        return "insertTrainee";
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
