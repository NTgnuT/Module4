package com.ra.controller;

import com.ra.modal.entity.Account;
import com.ra.modal.entity.Student;
import com.ra.modal.service.StudentService;
import com.ra.modal.service.StudentServiceIMPL;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class HomeController {
    private final StudentService studentService = new StudentServiceIMPL();
    @RequestMapping("/")
    public String home(){
        return "home";
    }

    @RequestMapping("/student")
    public String student(Model model){
        List<Student> students = studentService.findAll();
        model.addAttribute("list", students);
        return "student";
    }

    @RequestMapping("/register")
    public String register(Model model) {
        Account account = new Account();
        model.addAttribute("account", account);
        return "register";
    }

    @RequestMapping(value = "/post-register")
    public String postRegister(@ModelAttribute("account")Account account) {
        System.out.println(account.getEmail());
        System.out.println(account.getPassword());
        return "home";
    }

//    @RequestMapping(value = "/post-register")
//    public String postRegister(@RequestParam("email") String email, @RequestParam("password") String password) {
//        System.out.println("ok");
//        return "home";
//    }

    // Cách lấy id trên table
    // Cách 1:
//    @RequestMapping("/edit")
//    public String edit(@RequestParam("id") Integer id) {
//
//    }

    // Cách 2:
    @RequestMapping("/edit/{id}")
    public void edit(@PathVariable("id") Integer id) {
        System.out.println(id);
    }


}
