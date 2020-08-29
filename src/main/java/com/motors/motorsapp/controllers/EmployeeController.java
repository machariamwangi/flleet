package com.motors.motorsapp.controllers;

import com.motors.motorsapp.models.Employee;
import com.motors.motorsapp.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class EmployeeController {
//    @GetMapping("/employee")
//    public String getEmployees(){
//        return "employee";
//    }

    @Autowired
    private EmployeeService employeeService;
    @Autowired	private JobTitleService jobTitleService;
    @Autowired	private EmployeeTypeService employeeTypeService;
    @Autowired	private CountryService countryService;
    @Autowired	private StateService stateService;





    @GetMapping("/employee")
    public String getEmployees(Model model, String keyword) {

        model.addAttribute("jobTitles", jobTitleService.getJobTitles());
        model.addAttribute("employeeTypes", employeeTypeService.getEmployeeType());
        model.addAttribute("countries", countryService.getCountries());
        model.addAttribute("states", stateService.getStates());
        model.addAttribute("employees", employeeService.getEmployees());
//
//        if(keyword != null){
//            model.addAttribute("employees", employeeService.findByKeyword(keyword));
//        }
//        else
//        {
//        }

        return "employee";
    }

    @GetMapping("/employeesFiltered")
    public String getEmployeesFiltered(Model model, String keyword) {

        model.addAttribute("jobTitles", jobTitleService.getJobTitles());
        model.addAttribute("employeeTypes", employeeTypeService.getEmployeeType());
        model.addAttribute("countries", countryService.getCountries());
        model.addAttribute("states", stateService.getStates());

        model.addAttribute("employees", employeeService.getEmployees());


        return "EmployeeFiltered";
    }



    @PostMapping("/employee/addNew")
    public String addNew(Employee employee) {
        employeeService.save(employee);
        return "redirect:/employee";
    }

    @RequestMapping("employee/findById")
    @ResponseBody
    public Optional<Employee> findById(int id) {
        return employeeService.findById(id);
    }

    @RequestMapping(value="/employee/update", method= {RequestMethod.PUT, RequestMethod.GET})
    public String update(Employee employee) {
        employeeService.save(employee);
        return "redirect:/employee";
    }

    @RequestMapping(value="/employee/delete", method= {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id) {
        employeeService.delete(id);
        return "redirect:/employee";
    }
}
