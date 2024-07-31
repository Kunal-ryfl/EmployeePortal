package com.example.EmployeePortal.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "Departments")
@AllArgsConstructor
@NoArgsConstructor
 public class DepartmentEntity {

    @Id
    @Column(name="dId")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long dId;

    private String dName;
    private String dShort;

}
