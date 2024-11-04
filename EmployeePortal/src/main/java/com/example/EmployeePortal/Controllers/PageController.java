package com.example.EmployeePortal.Controllers;

import com.example.EmployeePortal.DTO.DepartementDto;
import com.example.EmployeePortal.DTO.EmployeeDto;
import com.example.EmployeePortal.Services.DepartmentService;
import com.example.EmployeePortal.Services.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.support.BasicAuthenticationInterceptor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.ui.Model;

import java.util.Arrays;
import java.util.List;

@Controller
public class PageController {

    RestTemplate restTemplate = new RestTemplate();
    EmployeeService employeeService;
    DepartmentService departmentService;
    PageController(EmployeeService employeeService, DepartmentService departmentService) {
        this.employeeService = employeeService;
        this.departmentService = departmentService;
    }

    @GetMapping("/")
    public String showHomePage() {
        return "home"; // This should match the template file name
    }


    @GetMapping("/viewEmployees")
    public String showEmployeeList(Model model) {
        restTemplate.getInterceptors().add(
                new BasicAuthenticationInterceptor("admin", "123") // Replace with actual credentials
        );
        String url = "http://localhost:8080/emp/get";
        EmployeeDto[] employeeArray = restTemplate.getForObject(url, EmployeeDto[].class);
        List<EmployeeDto> employees = Arrays.asList(employeeArray);
        model.addAttribute("employees", employees);

        return "employeeList";
    }

    @GetMapping("/createEmployeeForm")
    @PreAuthorize("hasRole('ADMIN')") // Restrict access to users with the ADMIN role
    public String showCreateEmployeeForm(Model model) {
        model.addAttribute("employee", new EmployeeDto());
        return "create_employee";
    }

    @GetMapping("/createDepartmentForm")
    @PreAuthorize("hasRole('ADMIN')") // Restrict access to users with the ADMIN role
    public String showCreateDepartmentForm(Model model) {
        model.addAttribute("department", new DepartementDto());
        return "createDepartment"; // This should match the template file name
    }

    @GetMapping("/viewDepartments")
    public String viewDepartments(Model model) {
        List<DepartementDto> departments = departmentService.get();
        model.addAttribute("departments", departments);
        return "viewDepartments"; // This should match the template file name
    }

    @GetMapping("/403")
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public String handle403(Model model) {
        model.addAttribute("errorMessage", "You do not have permission to access this resource.");
        return "forbidden"; // Return the name of the Thymeleaf template for the forbidden error
    }

}
