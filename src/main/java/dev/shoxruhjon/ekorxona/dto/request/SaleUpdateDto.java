package dev.shoxruhjon.ekorxona.dto.request;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.Value;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Getter
@Setter
public class SaleUpdateDto implements Serializable {
    BigDecimal expense;
    Integer lifetime;
}