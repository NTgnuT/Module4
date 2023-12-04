package com.ra.controller;

import com.ra.model.entity.Category;
import com.ra.model.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @RequestMapping("/category")
    public String index(Model model) {
        List<Category> list = categoryService.findAll();
        model.addAttribute("listCate", list);
        return "category/index";
    }

    @GetMapping("/category-add")
    public String add(Model model) {
        Category category = new Category();
        model.addAttribute("category", category);
        return "category/add";
    }

    @PostMapping("/create-category")
    public String create(@ModelAttribute("category") Category category, RedirectAttributes redirectAttributes) {
        categoryService.saveOrUpdate(category);
//        redirectAttributes.addAttribute("mess", "Thêm mới thành công");
        System.out.println(category);
        return "redirect:/category";
    }

    @GetMapping("category/edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model) {
        Category category = categoryService.findById(id);
        model.addAttribute("category", category);
        return "category/edit";
    }

    @PostMapping("category-update")
    public String update (@ModelAttribute("category") Category category, RedirectAttributes redirectAttributes) {
        categoryService.saveOrUpdate(category);
        redirectAttributes.addAttribute("mess", "Sửa thành công");
        return "redirect:/category";
    }

    @GetMapping("category/change/{id}")
    public String change (@PathVariable("id") Integer id) {
        categoryService.delete(id);
        return "redirect:/category";
    }
}
