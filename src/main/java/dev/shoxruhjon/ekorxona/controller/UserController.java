package dev.shoxruhjon.ekorxona.controller;

import dev.shoxruhjon.ekorxona.dto.request.UserCreateDto;
import dev.shoxruhjon.ekorxona.dto.request.UserUpdateDto;
import dev.shoxruhjon.ekorxona.entity.AuthResponse;
import dev.shoxruhjon.ekorxona.entity.UserEntity;
import dev.shoxruhjon.ekorxona.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    @PostMapping("/{userId}")
    public ResponseEntity<AuthResponse> createUser(@RequestBody UserCreateDto dto, @PathVariable Integer userId){
        return new ResponseEntity<>(userService.createUser(dto, userId), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<UserEntity> updateUser(@RequestBody UserUpdateDto dto, @PathVariable Integer id){
        return new ResponseEntity<>(userService.updateUser(dto, id), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<UserEntity>> getAll(){
        return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserEntity> getUser(@PathVariable Integer userId){
        return new ResponseEntity<>(userService.findUserById(userId), HttpStatus.OK);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable Integer userId){
        return new ResponseEntity<>(userService.deleteUserById(userId), HttpStatus.NO_CONTENT);
    }
}
