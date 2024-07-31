package com.example.EmployeePortal.Entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@Entity
@Table(name = "employees")
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private long eId;
    private String eName;

@ManyToOne
@JoinColumn(name = "dId")
private  DepartmentEntity  departmentEntity;

}
