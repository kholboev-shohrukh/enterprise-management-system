package dev.shoxruhjon.ekorxona.service.statistic;

import dev.shoxruhjon.ekorxona.dto.response.EmployeeByDepartmentResponse;
import dev.shoxruhjon.ekorxona.entity.EmployeeEntity;
import dev.shoxruhjon.ekorxona.entity.EmployeeResponse;
import dev.shoxruhjon.ekorxona.entity.enums.Department;
import dev.shoxruhjon.ekorxona.repository.CustomerRepository;
import dev.shoxruhjon.ekorxona.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StatisticServiceImpl implements StatisticService {

    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;
    private final CustomerRepository customerRepository;

    @Override
    public List<EmployeeByDepartmentResponse> getEmployeesByDepartment() {
        List<EmployeeByDepartmentResponse> employees = new ArrayList<>();
        Department[] values = Department.values();
        for (Department value : values) {
            employees.add(getCountDepartment(value));
        }
        return employees;
    }

    @Override
    public Page<EmployeeEntity> getEmployeesByAgeAsync(Integer page, Integer size) {
        Sort sort = Sort.by(Sort.Order.asc("age"));
        Pageable pageable = PageRequest.of(page, size, sort);
        return employeeRepository.findAll(pageable);
    }

    @Override
    public EmployeeByDepartmentResponse getCountDepartment(Department department) {
        EmployeeByDepartmentResponse employee = new EmployeeByDepartmentResponse();
        employee.setTotal(employeeRepository.countByDepartment(department));
        employee.setDepartment(String.valueOf(department));
        return employee;
    }

    @Override
    public BigDecimal sumEmployeesSalary() {
        return employeeRepository.sumSalary();
    }

    @Override
    public Integer getCountDailyRegisteredCustomers() {
        return employeeRepository.getCountDailyRegisteredCustomers();
    }

    @Override
    public EmployeeResponse getEmployeeRegisteredWithMostCustomers() {
        EmployeeEntity employeeEntity = employeeRepository.findEmployeeWithMostCustomers();
        EmployeeResponse employeeResponse = modelMapper.map(employeeEntity, EmployeeResponse.class);
        employeeResponse.setTotalCustomers(employeeRepository.findEmployeeWithMostCustomersTotal(employeeResponse.getId()));
        return employeeResponse;
    }

    @Override
    public List<EmployeeResponse> getTop3Employees() {
        List<EmployeeEntity> top3Employees = employeeRepository.findTop3Employees();
        List<EmployeeResponse> employeeResponses = new ArrayList<>();
        int i = 0;
        for (EmployeeEntity top3Employee : top3Employees) {
            employeeResponses.add(modelMapper.map(top3Employee, EmployeeResponse.class));
            i++;
            if (i > 3)
                break;
        }
        return employeeResponses;
    }

    @Override
    public Integer countCustomersRegisteredLastMonth() {
        LocalDateTime startDate = LocalDateTime.now();
        LocalDateTime endDate = LocalDateTime.now().minusMonths(1);
        return customerRepository.countByRegistrationDateBetween(startDate, endDate);
    }
}
