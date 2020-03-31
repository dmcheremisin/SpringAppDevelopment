package com.learn.spring.controller;

import com.learn.spring.entity.Employee;
import com.learn.spring.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping
    public String getEmployees(Model model) {
        model.addAttribute("employees", employeeService.getAllEmployees());
        return "employee-list";
    }

    @GetMapping("/{id}")
    public String getEmployeeById(@PathVariable Integer id, Model model) {
        model.addAttribute("employeeCommand", employeeService.getEmployeeById(id));
        return "employee";
    }

    @GetMapping("/addEmployee")
    public ModelAndView getAddEmployeePage() {
        return new ModelAndView("employee", "employeeCommand", new Employee());
    }

    @GetMapping("/delete")
    public String deleteEmployee(@RequestParam Integer id) {
        employeeService.deleteEmployeeById(id);
        return "redirect:/employee";
    }

    @PostMapping
    public String addUpdateEmployee(@ModelAttribute Employee employeeCommand) {
        if (employeeCommand.getId() == null)
            employeeService.insertEmployee(employeeCommand);
        else
            employeeService.updateEmployee(employeeCommand);
        return "redirect:/employee";
    }
}
