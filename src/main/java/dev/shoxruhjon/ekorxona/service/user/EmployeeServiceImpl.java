package dev.shoxruhjon.ekorxona.service.user;

import dev.shoxruhjon.ekorxona.dto.request.PassportCreateDto;
import dev.shoxruhjon.ekorxona.dto.request.EmployeeCreateDto;
import dev.shoxruhjon.ekorxona.dto.request.EmployeeUpdateDto;
import dev.shoxruhjon.ekorxona.entity.AuthEntity;
import dev.shoxruhjon.ekorxona.dto.response.AuthResponse;
import dev.shoxruhjon.ekorxona.entity.PassportEntity;
import dev.shoxruhjon.ekorxona.entity.EmployeeEntity;
import dev.shoxruhjon.ekorxona.entity.enums.Department;
import dev.shoxruhjon.ekorxona.repository.AuthRepository;
import dev.shoxruhjon.ekorxona.repository.PassportRepository;
import dev.shoxruhjon.ekorxona.repository.EmployeeRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;
    private final PassportRepository passportRepository;
    private final AuthRepository authRepository;

    @Override
    public AuthResponse createUser(@NonNull EmployeeCreateDto dto, Integer userId) {
        EmployeeEntity employeeEntity = modelMapper.map(dto, EmployeeEntity.class);
        AuthEntity authEntity = authRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        employeeEntity.setPassportEntity(createPassport(dto.getPassport()));
        authEntity.setEmployeeEntity(employeeRepository.save(employeeEntity));
        return modelMapper.map(authRepository.save(authEntity), AuthResponse.class);
    }

    @Override
    public List<EmployeeEntity> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public EmployeeEntity updateUser(@NonNull EmployeeUpdateDto dto, Integer id) {
        EmployeeEntity employeeEntity = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found."));
        if (dto.getFirstName() != null)
            employeeEntity.setFirstName(dto.getFirstName());
        if (dto.getLastName() != null)
            employeeEntity.setLastName(dto.getLastName());
        if (dto.getAge() != null)
            employeeEntity.setAge(dto.getAge());
        if (dto.getAddress() != null)
            employeeEntity.setAddress(dto.getAddress());
        if (dto.getDepartment() != null)
            employeeEntity.setDepartment(Department.valueOf(String.valueOf(dto.getDepartment())));
        if (dto.getSalary() != null)
            employeeEntity.setSalary(dto.getSalary());

        employeeEntity.setPassportEntity(updatePassport(dto.getPassport(), employeeEntity.getPassportEntity().getId()));

        return employeeRepository.save(employeeEntity);
    }

    @Override
    public EmployeeEntity findUserById(@NonNull Integer userId) {
        return employeeRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    @Override
    public String deleteUserById(@NonNull Integer userId) {
        employeeRepository.deleteById(userId);
        return "Deleted";
    }

    @Override
    public PassportEntity createPassport(@NonNull PassportCreateDto dto) {
        PassportEntity passportEntity = modelMapper.map(dto, PassportEntity.class);
        return passportRepository.save(passportEntity);
    }

    @Override
    public PassportEntity updatePassport(@NonNull PassportCreateDto dto, Integer id) {
        PassportEntity passportEntity = passportRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Passport not found"));
        if (dto.getSerial() != null)
            passportEntity.setSerial(dto.getSerial());
        if (dto.getNumber() != null)
            passportEntity.setNumber(dto.getNumber());
        if (dto.getJshshir() != null)
            passportEntity.setJshshir(dto.getJshshir());
        if (dto.getNation() != null)
            passportEntity.setNation(dto.getNation());
        return passportRepository.save(passportEntity);
    }
}
