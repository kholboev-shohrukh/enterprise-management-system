package dev.shoxruhjon.ekorxona.controller;

import dev.shoxruhjon.ekorxona.dto.request.CustomerDto;
import dev.shoxruhjon.ekorxona.entity.CustomerEntity;
import dev.shoxruhjon.ekorxona.service.customer.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/customers")
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping("/{userId}/create")
    @PreAuthorize("hasRole('Xodim')")
    public ResponseEntity<CustomerEntity> createCustomer(@RequestBody CustomerDto dto,
                                                         @PathVariable Integer userId){
        return new ResponseEntity<>(customerService.createCustomer(dto, userId), HttpStatus.CREATED);
    }

    @PutMapping("/{userId}/update/{customerId}")
    @PreAuthorize("hasRole('Xodim')")
    public ResponseEntity<CustomerEntity> updateCustomer(@RequestBody CustomerDto dto,
                                                         @PathVariable Integer userId,
                                                         @PathVariable Integer customerId){
        return new ResponseEntity<>(customerService.updateCustomer(dto, userId, customerId), HttpStatus.OK);
    }

    @GetMapping("/{userId}/customer/{customerId}")
    @PreAuthorize("hasRole('Xodim')")
    public ResponseEntity<CustomerEntity> getCustomer(@PathVariable Integer userId, @PathVariable Integer customerId){
        return new ResponseEntity<>(customerService.getCustomer(userId, customerId), HttpStatus.OK);
    }

    @GetMapping("/{userId}")
    @PreAuthorize("hasRole('Xodim')")
    public ResponseEntity<List<CustomerEntity>> getCustomers(@PathVariable Integer userId){
        return new ResponseEntity<>(customerService.getAllCustomer(userId), HttpStatus.OK);
    }

    @PutMapping("/{userId}/achived/{customerId}")
    @PreAuthorize("hasRole('Xodim')")
    public ResponseEntity<Boolean> achiveCustomer(@PathVariable Integer userId, @PathVariable Integer customerId){
        return new ResponseEntity<>(customerService.achiveCustomer(userId, customerId), HttpStatus.OK);
    }
}
