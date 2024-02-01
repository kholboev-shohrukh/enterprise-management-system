package dev.shoxruhjon.ekorxona.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;

@Entity(name = "customer")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerEntity extends Auditable{
    @Column
    private String firstName;

    @Column
    private String lastName;

    @OneToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    @JoinColumn
    private PassportEntity passportEntity;

    @Column
    private String address;

    private Boolean isAchived = false;

    @CreatedBy
    private Integer createdBy;
}
