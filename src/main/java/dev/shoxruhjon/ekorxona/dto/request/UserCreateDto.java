package dev.shoxruhjon.ekorxona.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Getter
@Setter
public class UserCreateDto implements Serializable {
    @NotBlank
    String firstName;
    @NotBlank
    String lastName;
    @NotNull
    Integer age;
    @NotNull
    PassportCreateDto passport;
    BigDecimal salary;
    String address;
    @NotBlank
    String department;


}