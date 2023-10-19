package com.mohirdev.enterprisemanagementsystem.web.rest;

import com.mohirdev.enterprisemanagementsystem.entity.Passport;
import com.mohirdev.enterprisemanagementsystem.service.PassportService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PassportResource {

    private final PassportService passportService;

    public PassportResource(PassportService passportService) {
        this.passportService = passportService;
    }

    @PostMapping("/passports")
    public ResponseEntity create(@RequestBody Passport passport){
        Passport result = passportService.save(passport);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/passports")
    public ResponseEntity update(Passport passport){
        if (passport.getId() == null){
            return ResponseEntity.ok("Error");
        }
        Passport result = passportService.save(passport);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/passports")
    public ResponseEntity getAll(){
        List<Passport> passports = passportService.findAll();
        return ResponseEntity.ok(passports);
    }

    @GetMapping("/passports/{id}")
    public ResponseEntity findById(@PathVariable Long id){
        Passport passport = passportService.findById(id);
        return ResponseEntity.ok(passport);
    }

    @DeleteMapping("/passports/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        String result = passportService.delete(id);
        return ResponseEntity.ok(result);
    }
}
