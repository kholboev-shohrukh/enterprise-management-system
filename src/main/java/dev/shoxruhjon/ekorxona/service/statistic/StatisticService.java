package dev.shoxruhjon.ekorxona.service.statistic;

import dev.shoxruhjon.ekorxona.dto.response.EmployeeByDepartmentResponse;
import dev.shoxruhjon.ekorxona.entity.EmployeeEntity;
import dev.shoxruhjon.ekorxona.dto.response.EmployeeResponse;
import dev.shoxruhjon.ekorxona.entity.enums.Department;
import org.springframework.data.domain.Page;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public interface StatisticService {
    List<EmployeeByDepartmentResponse> getEmployeesByDepartment();
    Page<EmployeeEntity> getEmployeesByAgeAsync(Integer page, Integer size);
    EmployeeByDepartmentResponse getCountDepartment(Department department);
    BigDecimal sumEmployeesSalary();
//    Long getCountDailyRegisteredCustomers();
    EmployeeResponse getEmployeeRegisteredWithMostCustomers();
    List<EmployeeResponse> getTop3Employees();
    Integer countCustomersRegisteredLastMonth();
    String getTypeWithHighestAdvertisingCosts();
    LocalDateTime getDayWithMostRegistrationsLastMonth();
    Integer getEmployeeWithMostAdvertisingExpenses();
    Integer countAdvertisementsLaunchedLastMonth();
}
