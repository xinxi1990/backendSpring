package com.app.controller;

import com.app.model.Student;
import com.app.server.StudentRepository;
import com.app.server.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller // This means that this class is a Controller
@RequestMapping(path="/student") // This means URL's start with /demo (after Application path)
public class StudentController {



    @Autowired
    private StudentService studentService;
    private StudentRepository studentRepository;


    @PostMapping(path="/add")
    public @ResponseBody String addNewUser (@RequestParam String name
            , @RequestParam String email) {
        System.out.println(name + "\n" + email);
        studentService.save(name,email);
        System.out.println("Saved ==>");
        return "Saved";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Student> getAllUsers() {
        return studentService.getList();
    }

    @GetMapping(path="/findbyname")
    public @ResponseBody Iterable<Student> findByName(@RequestParam String name) {
        return studentService.findByName(name);
    }


    @GetMapping(path="/findbyemail")
    public @ResponseBody Iterable<Student> findByEmail(@RequestParam String email) {
        return studentService.findByEmail(email);
    }



    @GetMapping(path="/delname")
    public @ResponseBody String deleteByName(@RequestParam String name){
        System.out.println(name);
        int studentID = studentService.deleteByName(name);
        System.out.println(String.format("DEL StudentID  %s", studentID));
        return "DEL";
    }

    @GetMapping(path="/updatename")
    public @ResponseBody String updateByName(@RequestParam int id,@RequestParam String name){
        System.out.println(id);
        System.out.println(name);
        int studentID = studentService.modifyByName(id,name);
        System.out.println(String.format("UPDATE StudentID %s", studentID));
        return "UPDATE";
    }


}
