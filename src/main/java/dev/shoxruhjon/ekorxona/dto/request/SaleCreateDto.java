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
public class SaleCreateDto implements Serializable {
    @NotBlank
    String advertisement;
    @NotNull
    BigDecimal expense;
    @NotNull
    Integer lifetime;
}