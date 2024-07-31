package com.example.EmployeePortal.Services;

import com.example.EmployeePortal.DTO.EmployeeDto;
import com.example.EmployeePortal.Entities.DepartmentEntity;
import com.example.EmployeePortal.Entities.EmployeeEntity;
import com.example.EmployeePortal.Repos.DepartmentRepo;
import com.example.EmployeePortal.Repos.EmployeeRepo;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    final EmployeeRepo employeeRepo;
    final DepartmentRepo departmentRepo;
    ModelMapper modelMapper;


    EmployeeService(EmployeeRepo employeeRepo, DepartmentRepo departmentRepo) {
        this.employeeRepo = employeeRepo;
        this.departmentRepo = departmentRepo;
        this.modelMapper = new ModelMapper();
    }


    public EmployeeDto createEmployee(EmployeeDto employeeDto) throws IllegalArgumentException {

        if (employeeDto.getDId().isEmpty()) {
            throw new IllegalArgumentException("Dept_id missing");
        }

        Optional<DepartmentEntity> departmentEntity = departmentRepo.findById(Long.valueOf(employeeDto.getDId()));
        if (departmentEntity.isPresent()) {

            EmployeeEntity save_employee = new EmployeeEntity();

            save_employee.setEId(employeeDto.getEId());
            save_employee.setEName(employeeDto.getEName());
            save_employee.setDepartmentEntity(departmentEntity.get());

            EmployeeEntity created_employee = employeeRepo.save(save_employee);

            EmployeeDto ed = modelMapper.map(created_employee, EmployeeDto.class);
            ed.setDId(employeeDto.getDId());
            return ed;

        } else {
            throw new IllegalArgumentException("Dept_id does'nt exist ");
        }


    }

    public List<EmployeeDto> getAllEmployee() {
        List<EmployeeEntity> list_employee = employeeRepo.findAll();

        List<EmployeeDto> res = new ArrayList<>();

        for (EmployeeEntity employee : list_employee) {
            EmployeeDto responseDto = modelMapper.map(employee, EmployeeDto.class);
            responseDto.setDId(String.valueOf(employee.getDepartmentEntity().getDId()));
            res.add(responseDto);
        }

        return res;
    }

    public EmployeeDto getEmpByID(String eId) throws IllegalArgumentException {

        EmployeeEntity find_emp;

        try {
            find_emp = checkEmpExistById(eId);
        } catch (IllegalArgumentException ignored) {
            throw new IllegalArgumentException();
        }


        EmployeeEntity employeeEntity = find_emp;
        return new EmployeeDto(employeeEntity.getEId(), employeeEntity.getEName(), "" + employeeEntity.getDepartmentEntity().getDId());

    }

    public void DeleteById(String eId) throws IllegalArgumentException {

        try {
            checkEmpExistById(eId);
        } catch (IllegalArgumentException ignored) {
            throw new IllegalArgumentException();
        }

        employeeRepo.deleteById(Long.valueOf(eId));
    }

    public void updateNameById(String eId, EmployeeDto employeeDto) {

        EmployeeEntity employeeEntity;

        try {
            employeeEntity = checkEmpExistById(eId);
        } catch (IllegalArgumentException exception) {
            throw new IllegalArgumentException();
        }

        employeeEntity.setEName(employeeDto.getEName());

        employeeRepo.save(employeeEntity);
    }

    public EmployeeEntity checkEmpExistById(String eId) throws IllegalArgumentException {
        Optional<EmployeeEntity> find_emp = employeeRepo.findById(Long.valueOf(eId));

        if (!find_emp.isPresent()) {
            throw new IllegalArgumentException("no_employee_exist");
        }

        return find_emp.get();
    }

}
