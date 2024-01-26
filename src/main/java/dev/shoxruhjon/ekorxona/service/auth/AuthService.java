package dev.shoxruhjon.ekorxona.service.auth;

import dev.shoxruhjon.ekorxona.dto.request.AuthCreateDto;
import dev.shoxruhjon.ekorxona.dto.request.GenerateTokenRequest;
import dev.shoxruhjon.ekorxona.dto.request.VerifyDtoP;
import lombok.NonNull;

public interface AuthService {

    Integer signUp(@NonNull AuthCreateDto dto);

    String signin(@NonNull VerifyDtoP dto);
}
