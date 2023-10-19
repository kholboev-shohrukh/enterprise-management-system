package com.mohirdev.enterprisemanagementsystem.web.rest;

import com.mohirdev.enterprisemanagementsystem.entity.Nation;
import com.mohirdev.enterprisemanagementsystem.service.NationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class NationResource {

    private final NationService nationService;

    public NationResource(NationService nationService) {
        this.nationService = nationService;
    }

    @PostMapping("/nations")
    public ResponseEntity create(@RequestBody Nation nation){
        Nation result = nationService.save(nation);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/nations")
    public ResponseEntity update(Nation nation){
        if(nation.getId() == null){
            return ResponseEntity.ok("Error");
        }
        Nation result = nationService.save(nation);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/nations")
    public ResponseEntity getAll(){
        List<Nation> nations = nationService.findAll();
        return ResponseEntity.ok(nations);
    }

    @GetMapping("/nations/{id}")
    public ResponseEntity findById(@PathVariable Long id){
        Nation nation = nationService.findById(id);
        return ResponseEntity.ok(nation);
    }

    @DeleteMapping("/nations/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        String result = nationService.delete(id);
        return ResponseEntity.ok(result);
    }
}
