package dev.shoxruhjon.ekorxona.entity;

import dev.shoxruhjon.ekorxona.entity.enums.Department;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeEntity extends Auditable{

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private Integer age;

    @OneToOne
    @JoinColumn
    private PassportEntity passportEntity;

    @Column
    private BigDecimal salary;

    @Column
    private String address;

    @Column
    @Enumerated(EnumType.STRING)
    private Department department;

}
