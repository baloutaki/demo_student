package be.ehb.demo_student.controller;

import be.ehb.demo_student.model.Student;
import be.ehb.demo_student.model.StudentDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class IndexController {
    @Autowired
    StudentDAO dao;


    @ModelAttribute(value = "all")
    public Iterable<Student> findAll(){
        return dao.findAll();
    }
    @RequestMapping(value = {"/","/index"},method = RequestMethod.GET)
    public String showIndex(ModelMap map){
        return "index";
    }
    @RequestMapping(value = "/id",method = RequestMethod.GET)
    public Optional<Student> findStudentById(@PathVariable(value ="id" )int id){
        return dao.findById(id);
    }
}
