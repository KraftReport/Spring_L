package com.home.leaf.controller;

import com.home.leaf.model.Employee;
import com.home.leaf.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping({"/list","/"})
    public ModelAndView getAllEmployee(){
        var modelAndView = new ModelAndView("list");
        return modelAndView.addObject("employees",employeeService.getAllEmployee());
    }
    @GetMapping("/empForm")
    public ModelAndView empForm(){
        return new ModelAndView("form").addObject("employee",new Employee());
    }

    @PostMapping("/saveEmployee")
    public String save(@ModelAttribute Employee employee){
        employeeService.saveEmployee(employee);
        return "redirect:/list";
    }

    @GetMapping("/showUpdate")
    public ModelAndView showUpdate(@RequestParam("empId")Long id){
      ModelAndView modelAndView = new ModelAndView("form");
      Employee emp = employeeService.findById(id).get(0);
      modelAndView.addObject("employee",emp);
      return modelAndView;
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("empId")Long id){
        employeeService.deleteById(id);
        return "redirect:/list";
    }
}
