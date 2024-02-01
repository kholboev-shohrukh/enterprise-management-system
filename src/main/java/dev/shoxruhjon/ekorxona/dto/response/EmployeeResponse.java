package dev.shoxruhjon.ekorxona.dto.response;

import dev.shoxruhjon.ekorxona.entity.PassportEntity;
import dev.shoxruhjon.ekorxona.entity.enums.Department;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.Value;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Getter
@Setter
public class EmployeeResponse implements Serializable {
    Integer id;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;
    String firstName;
    String lastName;
    Integer age;
    PassportEntity passportEntity;
    BigDecimal salary;
    String address;
    Department department;
    Integer totalCustomers;
}