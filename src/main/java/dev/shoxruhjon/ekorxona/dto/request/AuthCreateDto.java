package dev.shoxruhjon.ekorxona.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.Value;

import java.io.Serializable;

@Data
@Getter
@Setter

public class AuthCreateDto implements Serializable {
    @Email
    @NotBlank
    String email;
    @NotBlank
    String password;
}