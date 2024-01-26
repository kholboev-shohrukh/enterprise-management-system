package dev.shoxruhjon.ekorxona.dto.response;

import dev.shoxruhjon.ekorxona.entity.PassportEntity;
import dev.shoxruhjon.ekorxona.entity.enums.Role;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Getter
@Setter
public class UserResponse implements Serializable {
    Integer id;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;
    Integer createdBy;
    Integer updatedBy;
    String firstName;
    String lastName;
    Integer age;
    PassportEntity passportEntity;
    BigDecimal salary;
    String address;
    String department;
    Role role;
}