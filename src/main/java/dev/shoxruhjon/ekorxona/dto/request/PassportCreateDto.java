package dev.shoxruhjon.ekorxona.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Data
@Getter
@Setter
public class PassportCreateDto implements Serializable {
    @NotBlank
    String serial;
    @NotNull
    Long number;
    @NotNull
    Long jshshir;
    @NotBlank
    String nation;
}