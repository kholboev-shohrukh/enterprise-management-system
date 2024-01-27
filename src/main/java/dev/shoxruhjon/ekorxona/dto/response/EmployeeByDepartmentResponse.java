package dev.shoxruhjon.ekorxona.dto.response;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.Value;

import java.io.Serializable;

@Data
@Getter
@Setter
public class EmployeeByDepartmentResponse implements Serializable {
    String department;
    Integer total;
}