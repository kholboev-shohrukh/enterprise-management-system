package dev.shoxruhjon.ekorxona.service.user;

import dev.shoxruhjon.ekorxona.dto.request.PassportCreateDto;
import dev.shoxruhjon.ekorxona.dto.request.UserCreateDto;
import dev.shoxruhjon.ekorxona.dto.request.UserUpdateDto;
import dev.shoxruhjon.ekorxona.entity.AuthEntity;
import dev.shoxruhjon.ekorxona.entity.AuthResponse;
import dev.shoxruhjon.ekorxona.entity.PassportEntity;
import dev.shoxruhjon.ekorxona.entity.UserEntity;
import dev.shoxruhjon.ekorxona.repository.AuthRepository;
import dev.shoxruhjon.ekorxona.repository.PassportRepository;
import dev.shoxruhjon.ekorxona.repository.UserRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final PassportRepository passportRepository;
    private final AuthRepository authRepository;

    @Override
    public AuthResponse createUser(@NonNull UserCreateDto dto, Integer userId) {
        UserEntity userEntity = modelMapper.map(dto, UserEntity.class);
        AuthEntity authEntity = authRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        userEntity.setPassportEntity(createPassport(dto.getPassport()));
        authEntity.setUserEntity(userRepository.save(userEntity));
        return modelMapper.map(authRepository.save(authEntity), AuthResponse.class);
    }

    @Override
    public List<UserEntity> findAll() {
        return userRepository.findAll();
    }

    @Override
    public UserEntity updateUser(@NonNull UserUpdateDto dto, Integer id) {
        UserEntity userEntity = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found."));
        if (dto.getFirstName() != null)
            userEntity.setFirstName(dto.getFirstName());
        if (dto.getLastName() != null)
            userEntity.setLastName(dto.getLastName());
        if (dto.getAge() != null)
            userEntity.setAge(dto.getAge());
        if (dto.getAddress() != null)
            userEntity.setAddress(dto.getAddress());
        if (dto.getDepartment() != null)
            userEntity.setDepartment(dto.getDepartment());
        if (dto.getSalary() != null)
            userEntity.setSalary(dto.getSalary());

        userEntity.setPassportEntity(updatePassport(dto.getPassport(), userEntity.getPassportEntity().getId()));

        return userRepository.save(userEntity);
    }

    @Override
    public UserEntity findUserById(@NonNull Integer userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    @Override
    public String deleteUserById(@NonNull Integer userId) {
        userRepository.deleteById(userId);
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
