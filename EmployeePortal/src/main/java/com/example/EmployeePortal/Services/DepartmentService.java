package com.example.EmployeePortal.Services;

import com.example.EmployeePortal.DTO.DepartementDto;
import com.example.EmployeePortal.Entities.DepartmentEntity;
import com.example.EmployeePortal.Repos.DepartmentRepo;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {

    final DepartmentRepo departmentRepo;
    final ModelMapper modelMapper;

    DepartmentService(DepartmentRepo departmentRepo) {
        this.departmentRepo = departmentRepo;
        this.modelMapper = new ModelMapper();
    }


    public DepartementDto create(DepartementDto departementDto) {

        DepartmentEntity created_entity = departmentRepo.save(modelMapper.map(departementDto, DepartmentEntity.class));
        return new ModelMapper().map(created_entity, DepartementDto.class);
    }

    public List<DepartementDto> get() {
        List<DepartmentEntity> list_deptEntity = departmentRepo.findAll();

        List<DepartementDto> res = new ArrayList<>();

        for (DepartmentEntity departmentEntity : list_deptEntity) {
            res.add(modelMapper.map(departmentEntity, DepartementDto.class));
        }


        return res;
    }

    public DepartementDto getById(String dId) {
        Optional<DepartmentEntity> departmentEntity = departmentRepo.findById(Long.valueOf(dId));

        if (!departmentEntity.isPresent()) {
            throw new IllegalArgumentException("Dept_doesnt_exist");
        }

        return modelMapper.map(departmentEntity, DepartementDto.class);
    }
}


