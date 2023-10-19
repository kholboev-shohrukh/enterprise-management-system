package com.mohirdev.enterprisemanagementsystem.service;

import com.mohirdev.enterprisemanagementsystem.entity.Passport;
import com.mohirdev.enterprisemanagementsystem.repository.PassportRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PassportService {

    private final PassportRepository passportRepository;

    public PassportService(PassportRepository passportRepository) {
        this.passportRepository = passportRepository;
    }

    public Passport save(Passport passport){
        return passportRepository.save(passport);
    }

    public List<Passport> findAll(){
        List<Passport> passports = passportRepository.findAll();
        return passports;
    }

    public Passport findById(Long id){
        Optional<Passport> optional = passportRepository.findById(id);
        if(optional.isPresent()){
            return optional.get();
        }
        return null;
    }

    public String delete(Long id){
        if(findById(id) == null){
            return "Not Found";
        }
        passportRepository.deleteById(id);
        return "Deleted";
    }
}
