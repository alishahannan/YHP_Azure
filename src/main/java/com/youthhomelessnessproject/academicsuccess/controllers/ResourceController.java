package com.youthhomelessnessproject.academicsuccess.controllers;

import com.youthhomelessnessproject.academicsuccess.models.*;
import com.youthhomelessnessproject.academicsuccess.services.AddressService;
import com.youthhomelessnessproject.academicsuccess.services.ResourceService;
import com.youthhomelessnessproject.academicsuccess.services.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller

public class ResourceController {

    @Autowired
    private SessionService sessionService;

    @Autowired
    private ResourceService resourceService;

    // STUDENT RESOURCE METHODS
    @GetMapping("/resource/{id}")
    public ModelAndView showResourceDetails(@PathVariable Long id) {
        ModelAndView mav = new ModelAndView("student-resource-details");
        Resource resource = resourceService.findResourceById(id);
        mav.addObject("student", ContextController.getStudent());
        mav.addObject("resource", resource);
        return mav;
    }

    @GetMapping("/resources")
    public ModelAndView showAllResources() {
        ModelAndView mav = new ModelAndView("student-resources-list-all");
        List<Resource> resources = resourceService.getAllResources();
        mav.addObject("student", ContextController.getStudent());
        mav.addObject("resources", resources);
        return mav;
    }

    @GetMapping("/student/survey-results")
    public ModelAndView showStudentSurveyResults() {
        Student student = ContextController.getStudent();

        ModelAndView mav = new ModelAndView("student-survey-results-list");

        List<Session> sessions = new ArrayList<>();

        for (Session session : sessionService.getAllSessionsByStudentId(student.getId())) {
            if (session.getEnd_time() != null) {
                sessions.add(session);
            }
        }

        mav.addObject("student", student);
        mav.addObject("sessions", sessions);
        return mav;
    }

    @GetMapping("/student/survey-results/{id}")
    public ModelAndView showStudentSurveyResult(@PathVariable Long id) {
        Student student = ContextController.getStudent();

        ModelAndView mav = new ModelAndView("student-survey-result-resources");

        Session session = sessionService.findSessionById(id);

        double foodScore = session.getFoodScore();
        double housingScore = session.getHousingScore();
        double dependentScore = session.getDependentScore();

        List<Resource> allResources = new ArrayList<>();

        List<Resource> foodResources = resourceService.getAllFoodResourcesWithDegreeLessEqual(foodScore);
        List<Resource> housingResources = resourceService.getAllHousingResourcesWithDegreeLessEqual(housingScore);
        List<Resource> dependentResources = resourceService.getAllDependentResourcesWithDegreeLessEqual(dependentScore);

        for (Resource resource : foodResources) {
            if ((resource.getAddress().getZip()).equals(session.getZipCode())) {
                allResources.add(resource);
            }
        }

        for (Resource resource : housingResources) {
            if ((resource.getAddress().getZip()).equals(session.getZipCode())) {
                allResources.add(resource);
            }
        }

        for (Resource resource : dependentResources) {
            if ((resource.getAddress().getZip()).equals(session.getZipCode())) {
                allResources.add(resource);
            }
        }

        mav.addObject("student", student);
        mav.addObject("foodScore", foodScore);
        mav.addObject("foodResources", foodResources);

        mav.addObject("housingScore", housingScore);
        mav.addObject("housingResources", housingResources);

        mav.addObject("dependentScore", dependentScore);
        mav.addObject("dependentResources", dependentResources);

        mav.addObject("allResources", allResources);

        return mav;
    }
}
