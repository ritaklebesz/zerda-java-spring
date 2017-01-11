package com.greenfox.exams.spring.controller;

import com.greenfox.exams.spring.domain.UserInput;
import com.greenfox.exams.spring.repository.ProjectRepo;
import com.greenfox.exams.spring.service.UserInputService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * Created by Rita on 2017-01-11.
 */
@Controller
public class ExamController {

    UserInputService userInputService;
    ProjectRepo projectRepo;

    @Autowired
    public ExamController(UserInputService userInputService, ProjectRepo projectRepo) {
        this.userInputService = userInputService;
        this.projectRepo = projectRepo;
    }

    @GetMapping(value = "/")
    public String welcome(Model model,
                          @RequestParam(name = "problem", defaultValue = "false") String problem,
                          @RequestParam(name = "description", defaultValue = "") String description) {
        if (problem.equals("true")) {
            model.addAttribute("problemDescription", description);
        }
        model.addAttribute("userInput", new UserInput());
        return "welcome";
    }

    @PostMapping(value = "/add")
    public String add(@ModelAttribute UserInput userInput) throws UnsupportedEncodingException {
        if (userInputService.isValid(userInput)) {
            userInputService.addNewInput(userInput);
            return "redirect:/thanks";
        } else {
            return "redirect:/?problem=true&description=" + URLEncoder.encode(userInputService.getProblem(userInput), "UTF-8");
        }
    }

    @GetMapping(value = "/thanks")
    public String thanks(Model model) {
        model.addAttribute("projects", projectRepo.findAll());
        return "thanks";
    }
}
