package dev.shoxruhjon.ekorxona.entity;

import dev.shoxruhjon.ekorxona.entity.enums.Role;
import jakarta.validation.constraints.Email;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Data
@Getter
@Setter
public class AuthResponse implements Serializable {
    Integer id;
    @Email
    String email;
    String password;
    EmployeeEntity employeeEntity;
    Role role;
}