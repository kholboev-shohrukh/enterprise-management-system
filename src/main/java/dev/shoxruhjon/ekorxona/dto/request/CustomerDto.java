package dev.shoxruhjon.ekorxona.dto.request;

import dev.shoxruhjon.ekorxona.entity.PassportEntity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto implements Serializable {
    @NotBlank
    String firstName;
    @NotBlank
    String lastName;
    @NotNull
    PassportCreateDto passport;
    @NotBlank
    String address;
}