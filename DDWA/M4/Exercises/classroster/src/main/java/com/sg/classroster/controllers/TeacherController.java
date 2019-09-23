/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.classroster.controllers;

import com.sg.classroster.daos.CourseDao;
import com.sg.classroster.daos.StudentDao;
import com.sg.classroster.daos.TeacherDao;
import com.sg.classroster.dtos.Teacher;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validation;
import javax.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


/**
 *
 * @author seanking
 */
@Controller
public class TeacherController {
    
    Set<ConstraintViolation<Teacher>> violations = new HashSet<>();
    
    @Autowired
    TeacherDao teacherDao;
    
    @Autowired
    StudentDao studentDao;
    
    @Autowired
    CourseDao courseDao;
    
    //localhost: 8080 'GET' teachers
    @GetMapping("teachers")
    public String displayTeachers(Model model) {
        List<Teacher> teachers = teacherDao.getAllTeachers();
        model.addAttribute("teachers", teachers);
        model.addAttribute("errors", violations);
        return "teachers";
    }
    
      @PostMapping("addTeacher")
    public String addTeacher(HttpServletRequest request) {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String specialty = request.getParameter("specialty");
        
        Teacher teacher = new Teacher();
        teacher.setFirstName(firstName);
        teacher.setLastName(lastName);
        teacher.setSpecialty(specialty);
        
Validator validate = Validation.buildDefaultValidatorFactory().getValidator();
violations = validate.validate(teacher);

if(violations.isEmpty()) {
    teacherDao.addTeacher(teacher);
}
        
        return "redirect:/teachers";
    }
    
    //http://localhost:8080/deleteTeacher?id=(id) - GET
    @GetMapping("deleteTeacher")
    public String deleteTeacher(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        teacherDao.deleteTeacherById(id);
        
        return "redirect:/teachers";
    }
    
        //http://localhost:8080/editTeacher?id=(id) - GET

    @GetMapping("editTeacher")
    public String editTeacher(HttpServletRequest request, Model model) {
        int id = Integer.parseInt(request.getParameter("id"));
        Teacher teacher = teacherDao.getTeacherById(id);
        
        model.addAttribute("teacher", teacher);
        //add attribute is the way your html page gets variables
        return "editTeacher";
    }
    
     @PostMapping("editTeacher")
    public String performEditTeacher(@Valid Teacher teacher, BindingResult result, Model model ) {
//        int id = Integer.parseInt(request.getParameter("id"));
//        Teacher teacher = teacherDao.getTeacherById(id);
//        
//        teacher.setFirstName(request.getParameter("firstName"));
//        teacher.setLastName(request.getParameter("lastName"));
//        teacher.setSpecialty(request.getParameter("specialty"));
//     

if (result.hasErrors() == true){
    model.addAttribute("teacher", teacher);
        //add attribute is the way your html page gets variables
        return "editTeacher";
    
}
       teacherDao.updateTeacher(teacher);
      
       return "redirect:/teachers";
    }
    
   
}
