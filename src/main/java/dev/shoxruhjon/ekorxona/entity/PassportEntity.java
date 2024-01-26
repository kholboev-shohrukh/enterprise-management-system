package dev.shoxruhjon.ekorxona.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "passport")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PassportEntity extends Auditable{

    @Column
    private String serial;

    @Column
    private Long number;

    @Column
    private Long jshshir;

    @Column
    private String nation;
}
