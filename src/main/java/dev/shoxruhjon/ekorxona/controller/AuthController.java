package dev.shoxruhjon.ekorxona.controller;

import dev.shoxruhjon.ekorxona.dto.request.AuthCreateDto;
import dev.shoxruhjon.ekorxona.dto.request.VerifyDtoP;
import dev.shoxruhjon.ekorxona.service.auth.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<Integer> register(@RequestBody AuthCreateDto dto){
        return new ResponseEntity<>(authService.signUp(dto), HttpStatus.CREATED);
    }

    @PostMapping("/signin")
    public ResponseEntity<String> signin(@RequestBody VerifyDtoP dtoP){
        return new ResponseEntity<>(authService.signin(dtoP), HttpStatus.OK);
    }
}
