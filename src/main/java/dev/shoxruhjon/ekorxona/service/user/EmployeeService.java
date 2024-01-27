package dev.shoxruhjon.ekorxona.service.user;

import dev.shoxruhjon.ekorxona.dto.request.PassportCreateDto;
import dev.shoxruhjon.ekorxona.dto.request.EmployeeCreateDto;
import dev.shoxruhjon.ekorxona.dto.request.EmployeeUpdateDto;
import dev.shoxruhjon.ekorxona.entity.AuthResponse;
import dev.shoxruhjon.ekorxona.entity.PassportEntity;
import dev.shoxruhjon.ekorxona.entity.EmployeeEntity;
import lombok.NonNull;

import java.util.List;

public interface EmployeeService {

    AuthResponse createUser(@NonNull EmployeeCreateDto dto, Integer userId);

    EmployeeEntity updateUser(@NonNull EmployeeUpdateDto dto, Integer id);

    List<EmployeeEntity> findAll();

    EmployeeEntity findUserById(@NonNull Integer userId);

    String deleteUserById(@NonNull Integer userId);

    PassportEntity createPassport(@NonNull PassportCreateDto dto);

    PassportEntity updatePassport(@NonNull PassportCreateDto dto, Integer id);
}
