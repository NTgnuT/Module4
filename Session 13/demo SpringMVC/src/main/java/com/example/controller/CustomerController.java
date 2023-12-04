package com.example.controller;

import com.example.model.entity.Customer;
import com.example.model.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    ICustomerService customerService;
    @GetMapping("/getAll")
    public String showList (Model model) {
        List<Customer> customers = customerService.findAll();
        model.addAttribute("cusList", customers);
        return "list";
    }

    @GetMapping("/create")
    public String formCreateCustomer(Model model) {
        model.addAttribute("customer", new Customer());
        return "create";
    }

    @PostMapping("/create")
    public String createCustomer(@ModelAttribute ("customer") Customer customer) {
        boolean check = customerService.save(customer);
        if (check) {
            return "redirect:getAll";
        } else {
            return "redirect:create";
        }
    }

    @GetMapping("/edit")
    public String formEditCustomer(Model model, int idEdit) {
        Customer customer = customerService.findById(idEdit);
        model.addAttribute("cusEdit", customer);
        return "edit";
    }

    @PostMapping("/edit")
    public String editCustomer(@ModelAttribute ("cusEdit") Customer customer) {
        boolean check = customerService.save(customer);
        if (check) {
            return "redirect:getAll";
        } else {
            return "redirect:edit";
        }
    }

    @GetMapping("/delete")
    public String deleteCustomer(int idDelete) {
        customerService.delete(idDelete);
        return "redirect:getAll";
    }
}
