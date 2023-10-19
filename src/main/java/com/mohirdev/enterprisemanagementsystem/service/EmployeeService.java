package com.mohirdev.enterprisemanagementsystem.service;

import com.mohirdev.enterprisemanagementsystem.entity.Employee;
import com.mohirdev.enterprisemanagementsystem.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee save(Employee employee){
        return employeeRepository.save(employee);
    }

    public List<Employee> findAll(){
        List<Employee> employees = employeeRepository.findAll();
        return employees;
    }

    public Employee findById(Long id){
        Optional<Employee> optional = employeeRepository.findById(id);
        if(optional.isPresent()){
            return optional.get();
        }
        return null;
    }

    public String delete(Long id){
        if(findById(id) == null){
            return "Not Found";
        }
        employeeRepository.deleteById(id);
        return "Deleted";
    }
}
