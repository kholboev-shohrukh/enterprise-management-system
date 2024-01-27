package dev.shoxruhjon.ekorxona.dto.request;

import dev.shoxruhjon.ekorxona.entity.enums.Department;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Getter
@Setter

public class EmployeeUpdateDto implements Serializable {
    String firstName;
    String lastName;
    Integer age;
    PassportCreateDto passport;
    BigDecimal salary;
    String address;
    Department department;
}