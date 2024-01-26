package dev.shoxruhjon.ekorxona.service.user;

import dev.shoxruhjon.ekorxona.dto.request.PassportCreateDto;
import dev.shoxruhjon.ekorxona.dto.request.UserCreateDto;
import dev.shoxruhjon.ekorxona.dto.request.UserUpdateDto;
import dev.shoxruhjon.ekorxona.dto.response.UserResponse;
import dev.shoxruhjon.ekorxona.entity.AuthEntity;
import dev.shoxruhjon.ekorxona.entity.AuthResponse;
import dev.shoxruhjon.ekorxona.entity.PassportEntity;
import dev.shoxruhjon.ekorxona.entity.UserEntity;
import lombok.NonNull;
import org.apache.catalina.User;

import java.util.List;

public interface UserService {

    AuthResponse createUser(@NonNull UserCreateDto dto, Integer userId);

    UserEntity updateUser(@NonNull UserUpdateDto dto, Integer id);

    List<UserEntity> findAll();

    UserEntity findUserById(@NonNull Integer userId);

    String deleteUserById(@NonNull Integer userId);

    PassportEntity createPassport(@NonNull PassportCreateDto dto);

    PassportEntity updatePassport(@NonNull PassportCreateDto dto, Integer id);
}
