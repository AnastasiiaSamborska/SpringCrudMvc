package com.samborska_anastasiia.cruddemo1.controller;

import com.samborska_anastasiia.cruddemo1.entity.Employee;
import com.samborska_anastasiia.cruddemo1.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    private EmployeeService employeeService;
    @Autowired
    public EmployeeController(EmployeeService theEmployeeService){
        employeeService = theEmployeeService;
    }

    @GetMapping("/list")
    public String listEmployees(Model theModel){
        List<Employee> theEmployees = employeeService.findAll();
        theModel.addAttribute("employees", theEmployees);
        return "employees/list-employees";

    }
    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel){
        Employee theEmployee = new Employee();
        theModel.addAttribute("employee",theEmployee);
        return "employees/employee-form";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("employeeId") int theId, Model theModel){
        //get the employee from the service
        Employee theEmployee = employeeService.findById(theId);

        //set employee in the model to prepopulate the form
        theModel.addAttribute("employee",theEmployee);

        //send over to form
        return "employees/employee-form";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee theEmployee){
        //Save the employee
        employeeService.save(theEmployee);
        // Redirect to prevent duplicate submissions
        return "redirect:/employees/list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("employeeId") int theId){
        employeeService.deleteById(theId);
        return "redirect:/employees/list";
    }
}
