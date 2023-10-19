package com.mohirdev.enterprisemanagementsystem.web.rest;

import com.mohirdev.enterprisemanagementsystem.entity.Department;
import com.mohirdev.enterprisemanagementsystem.service.DepartmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DepartmentResource {

    private final DepartmentService departmentService;

    public DepartmentResource(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping("/departments")
    public ResponseEntity create(@RequestBody Department department){
        Department result = departmentService.save(department);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/departments")
    public ResponseEntity update(Department department){
        if(department.getId() == null){
            return ResponseEntity.ok("Error");
        }
        Department result = departmentService.save(department);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/departments")
    public ResponseEntity findAll(){
        List<Department> departments = departmentService.getAll();
        return ResponseEntity.ok(departments);
    }

    @GetMapping("/departments/{id}")
    public ResponseEntity findById(@PathVariable Long id){
        Department department = departmentService.findById(id);
        return ResponseEntity.ok(department);
    }

    @DeleteMapping("/departments/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        String result = departmentService.delete(id);
        return ResponseEntity.ok(result);
    }
}
