package com.example.EmployeePortal.Controllers;

import com.example.EmployeePortal.DTO.EmployeeDto;
import com.example.EmployeePortal.Services.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@RestController
@RequestMapping("/emp")
public class employeeController {
    EmployeeService employeeService;

    employeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

//    @PreAuthorize("hasRole('ADMIN')")
//    @GetMapping(path = "/hello")
//    public String hello() {
//        return "hello";
//    }

//    @PostMapping(path = "/create")
//    @PreAuthorize("hasRole('ADMIN')")
//    public ResponseEntity<?> create(@RequestBody EmployeeDto employeeDto) {
//
//        EmployeeDto created_emp;
//        try {
//
//            created_emp = employeeService.createEmployee(employeeDto);
//        } catch (IllegalArgumentException exception) {
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//
//        return new ResponseEntity<>(created_emp, HttpStatus.OK);
//    }

@PostMapping(path = "/create", consumes = "application/x-www-form-urlencoded")
@PreAuthorize("hasRole('ADMIN')")
public RedirectView create(EmployeeDto employeeDto, RedirectAttributes redirectAttributes) {
    try {
        EmployeeDto createdEmp = employeeService.createEmployee(employeeDto);
        redirectAttributes.addFlashAttribute("message", "Employee created successfully!");
    } catch (IllegalArgumentException exception) {
        redirectAttributes.addFlashAttribute("error", "Failed to create employee.");
        return new RedirectView("/createEmployeeForm");
    }
    return new RedirectView("/viewEmployees"); // Redirect to the desired page
}

    @GetMapping(path = "/get")
    public ResponseEntity<?> get() {

        List<EmployeeDto> list_empDto = employeeService.getAllEmployee();

        return new ResponseEntity<>(list_empDto, HttpStatus.OK);
    }

    @GetMapping(path = "/get/{id}")
    public ResponseEntity<?> getById(@PathVariable String id) {
        try {
         return new ResponseEntity<>( employeeService.getEmpByID(id),HttpStatus.OK);
        }catch (IllegalArgumentException exception){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @DeleteMapping(path = "/delete/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> delById(@PathVariable String id) {
        try {

            employeeService.DeleteById(id);
        } catch (IllegalArgumentException ie) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("DELETED", HttpStatus.OK);
    }

    @PatchMapping("/patch/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> updateName(@PathVariable String id,@RequestBody EmployeeDto employeeDto) {

        try {
            employeeService.updateNameById(id, employeeDto);
        } catch (IllegalArgumentException exception) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>("UPDATED", HttpStatus.OK);
    }

}
