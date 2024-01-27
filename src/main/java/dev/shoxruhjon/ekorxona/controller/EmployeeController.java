package dev.shoxruhjon.ekorxona.controller;

import dev.shoxruhjon.ekorxona.dto.request.EmployeeCreateDto;
import dev.shoxruhjon.ekorxona.dto.request.EmployeeUpdateDto;
import dev.shoxruhjon.ekorxona.entity.AuthResponse;
import dev.shoxruhjon.ekorxona.entity.EmployeeEntity;
import dev.shoxruhjon.ekorxona.service.user.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;
    @PostMapping("/{userId}")
    public ResponseEntity<AuthResponse> createUser(@RequestBody EmployeeCreateDto dto, @PathVariable Integer userId){
        return new ResponseEntity<>(employeeService.createUser(dto, userId), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<EmployeeEntity> updateUser(@RequestBody EmployeeUpdateDto dto, @PathVariable Integer id){
        return new ResponseEntity<>(employeeService.updateUser(dto, id), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<EmployeeEntity>> getAll(){
        return new ResponseEntity<>(employeeService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<EmployeeEntity> getUser(@PathVariable Integer userId){
        return new ResponseEntity<>(employeeService.findUserById(userId), HttpStatus.OK);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable Integer userId){
        return new ResponseEntity<>(employeeService.deleteUserById(userId), HttpStatus.NO_CONTENT);
    }
}
