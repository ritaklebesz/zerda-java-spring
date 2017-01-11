package com.greenfox.exams.spring.service;

import com.greenfox.exams.spring.domain.UserInput;
import com.greenfox.exams.spring.repository.UserInputRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Rita on 2017-01-11.
 */
@Component
public class UserInputService {
    private ArrayList<String> requirements = new ArrayList<>(Arrays.asList("amazing", "awesome", "blithesome", "excellent", "fabulous", "fantastic", "favorable", "fortuitous", "great", "incredible", "ineffable", "mirthful", "outstanding", "perfect", "propitious", "remarkable", "smart", "spectacular", "splendid", "stellar", "stupendous", "super", "ultimate", "unbelievable", "wondrous"));
    private UserInputRepo repo;

    @Autowired
    public UserInputService(UserInputRepo repo) {
        this.repo = repo;
    }

    public boolean isValid(UserInput userInput) {
        if (isValidOpinion(userInput.getExperience()) && isValidEmail(userInput.getEmail()) && userInput.getScale() >= 10) {
            return true;
        } else {
            return false;
        }
    }

    private boolean isValidOpinion(String opinion) {
        int counter = 0;
        for (String requirement : requirements) {
            if (opinion.contains(requirement)) {
                counter++;
            }
        }
        if (counter >= 3) {
            return true;
        } else {
            return false;
        }
    }

    private boolean isValidEmail(String email) {
        boolean hasAtSign = false;
        boolean hasDot = false;
        for (int i = 0; i < email.length(); i++) {
            if (email.charAt(i) == '@') {
                hasAtSign = true;
            } else if (email.charAt(i) == '.') {
                hasDot = true;
            }
        }
        return (hasAtSign && hasDot);
    }

    public void addNewInput(UserInput userInput) {
        repo.save(userInput);
    }

    public String getProblem(UserInput userInput) {
        String problem = "Invalid submission: ";
        if (!isValidOpinion(userInput.getExperience())) {
            problem += " Add more positive adjectives.";
        }
        if (!isValidEmail(userInput.getEmail())) {
            problem += " Invalid email address.";
        }
        if (!(userInput.getScale() >= 10)) {
            problem += " Add a higher score.";
        }
        return problem;
    }
}
