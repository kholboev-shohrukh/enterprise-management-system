package dev.shoxruhjon.ekorxona.controller;

import dev.shoxruhjon.ekorxona.dto.response.EmployeeByDepartmentResponse;
import dev.shoxruhjon.ekorxona.entity.EmployeeEntity;
import dev.shoxruhjon.ekorxona.dto.response.EmployeeResponse;
import dev.shoxruhjon.ekorxona.service.statistic.StatisticService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/statistices")
@RequiredArgsConstructor
@PreAuthorize("hasRole('Director')")
public class StatisticController {

    private final StatisticService statisticService;

    @GetMapping("/employees/department")
    public ResponseEntity<List<EmployeeByDepartmentResponse>> getDepartment(){
        return new ResponseEntity<>(statisticService.getEmployeesByDepartment(), HttpStatus.OK);
    }

    @GetMapping("/employees")
    public ResponseEntity<Page<EmployeeEntity>> getEmployees(@RequestParam(name = "page", defaultValue = "0") Integer page,
                                                             @RequestParam(name = "size", defaultValue = "10") Integer size){
        return new ResponseEntity<>(statisticService.getEmployeesByAgeAsync(page, size), HttpStatus.OK);
    }

    @GetMapping("/employees/sum/salary")
    public ResponseEntity<BigDecimal> getEmployeesSumSalary(){
        return new ResponseEntity<>(statisticService.sumEmployeesSalary(), HttpStatus.OK);
    }

//    @GetMapping("/customers/daily")
//    public ResponseEntity<Long> getCountDailyRegisteredCustomers(){
//        return new ResponseEntity<>(statisticService.getCountDailyRegisteredCustomers(), HttpStatus.OK);
//    }

    @GetMapping("/customers/total/employee")
    public ResponseEntity<EmployeeResponse> getEmployeeRegisteredWithMostCustomers(){
        return new ResponseEntity<>(statisticService.getEmployeeRegisteredWithMostCustomers(), HttpStatus.OK);
    }

    @GetMapping("/customers/top/employees")
    public ResponseEntity<List<EmployeeResponse>> getTop3Employees(){
        return new ResponseEntity<>(statisticService.getTop3Employees(), HttpStatus.OK);
    }

    @GetMapping("/customers/month")
    public ResponseEntity<Integer> getCountCustomersRegisteredLastMonth(){
        return new ResponseEntity<>(statisticService.countCustomersRegisteredLastMonth(), HttpStatus.OK);
    }

    @GetMapping("/highest-advertising-cost")
    public ResponseEntity<String> getTypeWithHighestAdvertisingCosts(){
        return new ResponseEntity<>(statisticService.getTypeWithHighestAdvertisingCosts(), HttpStatus.OK);
    }

    @GetMapping("/most-registrations-last-month")
    public ResponseEntity<LocalDateTime> getDayWithMostRegistrationsLastMonth() {
        return new ResponseEntity<>(statisticService.getDayWithMostRegistrationsLastMonth(), HttpStatus.OK);
    }

    @GetMapping("/most-advertising-expenses")
    public ResponseEntity<Integer> getEmployeeWithMostAdvertisingExpenses() {
        return new ResponseEntity<>(statisticService.getEmployeeWithMostAdvertisingExpenses(), HttpStatus.OK);
    }

    @GetMapping("/advertisements-launched-last-month")
    public ResponseEntity<Integer> countAdvertisementsLaunchedLastMonth(){
        return new ResponseEntity<>(statisticService.countAdvertisementsLaunchedLastMonth(), HttpStatus.OK);
    }
}
