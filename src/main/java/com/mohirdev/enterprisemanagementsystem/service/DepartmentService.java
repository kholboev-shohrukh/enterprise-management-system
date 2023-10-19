package com.mohirdev.enterprisemanagementsystem.service;

import com.mohirdev.enterprisemanagementsystem.entity.Department;
import com.mohirdev.enterprisemanagementsystem.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {

    private final DepartmentRepository departmentService;

    public DepartmentService(DepartmentRepository departmentService) {
        this.departmentService = departmentService;
    }

    public Department save(Department department){
        Department result = departmentService.save(department);
        return result;
    }

    public List<Department> getAll(){
        List<Department> departments = departmentService.findAll();
        return departments;
    }

    public Department findById(Long id) {
        Optional<Department> optional = departmentService.findById(id);
        if(optional.isPresent()){
            return optional.get();
        }
        return null;
    }

    public String delete(Long id){
        if(findById(id) == null){
            return "Not Found";
        }
        departmentService.deleteById(id);
        return "Deleted";
    }
}
