package dev.shoxruhjon.ekorxona.entity;


import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SaleEntity extends Auditable{

    private String advertisement;
    private BigDecimal expense;
    private Integer lifetime;
    @CreatedBy
    private Integer createdBy;
}
