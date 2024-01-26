package dev.shoxruhjon.ekorxona.service.auth;

import dev.shoxruhjon.ekorxona.dto.request.AuthCreateDto;
import dev.shoxruhjon.ekorxona.dto.request.VerifyDtoP;
import dev.shoxruhjon.ekorxona.entity.AuthEntity;
import dev.shoxruhjon.ekorxona.entity.enums.Role;
import dev.shoxruhjon.ekorxona.exception.DataAlreadyExistsException;
import dev.shoxruhjon.ekorxona.exception.DataNotFoundException;
import dev.shoxruhjon.ekorxona.repository.AuthRepository;
import dev.shoxruhjon.ekorxona.service.jwt.JwtService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final ModelMapper modelMapper;
    private final AuthRepository authRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    @Override
    public Integer signUp(@NonNull AuthCreateDto dto) {
        if (authRepository.findByEmail(dto.getEmail()).isPresent())
            throw new DataAlreadyExistsException("Email already exists with email: " + dto.getEmail());
        AuthEntity authEntity = modelMapper.map(dto, AuthEntity.class);
        authEntity.setRole(Role.Xodim);
        authEntity.setUserEntity(null);
        authEntity.setPassword(passwordEncoder.encode(dto.getPassword()));
        return authRepository.save(authEntity).getId();
    }

    @Override
    public String signin(@NonNull VerifyDtoP dto) {
        AuthEntity authEntity = authRepository.findByEmail(dto.getEmail())
                .orElseThrow(() -> new DataNotFoundException("User not found with email: " + dto.getEmail()));
        return jwtService.generateAccessToken(authEntity);
    }
}
