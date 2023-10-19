package com.mohirdev.enterprisemanagementsystem.service;

import com.mohirdev.enterprisemanagementsystem.entity.Nation;
import com.mohirdev.enterprisemanagementsystem.repository.NationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NationService {

    private final NationRepository nationRepository;

    public NationService(NationRepository nationRepository) {
        this.nationRepository = nationRepository;
    }

    public Nation save(Nation nation){
        return nationRepository.save(nation);
    }

    public List<Nation> findAll(){
        List<Nation> nations = nationRepository.findAll();
        return nations;
    }

    public Nation findById(Long id){
        Optional<Nation> optional = nationRepository.findById(id);
        if(optional.isPresent()){
            return optional.get();
        }
        return null;
    }

    public String delete(Long id){
        if(findById(id) == null){
            return "Not Found";
        }
        nationRepository.deleteById(id);
        return "Deleted";
    }
}
