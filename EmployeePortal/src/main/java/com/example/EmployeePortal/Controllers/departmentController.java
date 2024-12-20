package com.example.EmployeePortal.Controllers;

import com.example.EmployeePortal.DTO.DepartementDto;
import com.example.EmployeePortal.Services.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.List;

@RestController
@RequestMapping("/dept")
public class departmentController {

    final DepartmentService departmentService;

    departmentController( DepartmentService departmentService){
        this.departmentService = departmentService ;
    }



//    @PostMapping(path = "/create")
//    @PreAuthorize("hasRole('ADMIN')")
//   public   ResponseEntity<?> create(@RequestBody DepartementDto departementDto){
//      DepartementDto created_dept =    departmentService.create(departementDto);
//      return new ResponseEntity<>(departementDto, HttpStatus.OK);
//    }

    @PostMapping(path = "/create")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> create(@ModelAttribute DepartementDto departementDto) {
        DepartementDto created_dept = departmentService.create(departementDto);
        return new ResponseEntity<>(created_dept, HttpStatus.OK);
    }
    @GetMapping(path = "/get")
    public ResponseEntity<?> get(){
      List<DepartementDto> res = departmentService.get();
      return new ResponseEntity<>( res,HttpStatus.OK );
    }

    @GetMapping(path = "/get/{id}")
    public  ResponseEntity<?> getById(@PathVariable String id) {
        DepartementDto departementDto =  departmentService.getById(id);
        return new ResponseEntity<>(departementDto,HttpStatus.OK);
    }
}
