package dev.shoxruhjon.ekorxona.controller;

import dev.shoxruhjon.ekorxona.dto.request.SaleCreateDto;
import dev.shoxruhjon.ekorxona.dto.request.SaleUpdateDto;
import dev.shoxruhjon.ekorxona.entity.SaleEntity;
import dev.shoxruhjon.ekorxona.service.sale.SaleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/sales")
@RequiredArgsConstructor
public class SaleController {

    private final SaleService saleService;

    @PostMapping("/{userId}")
    public ResponseEntity<SaleEntity> createSale(@PathVariable Integer userId, @RequestBody SaleCreateDto dto){
        return new ResponseEntity<>(saleService.createSale(userId, dto), HttpStatus.CREATED);
    }

    @PutMapping("/{userId}/update/{saleId}")
    public ResponseEntity<SaleEntity> updateSale(@PathVariable Integer userId,
                                                 @PathVariable Integer saleId,
                                                 @RequestBody SaleUpdateDto dto){
        return new ResponseEntity<>(saleService.updateSale(userId, saleId, dto), HttpStatus.OK);
    }

    @GetMapping("/{userId}/sale/{saleId}")
    public ResponseEntity<SaleEntity> getSale(@PathVariable Integer userId, @PathVariable Integer saleId){
        return new ResponseEntity<>(saleService.getSale(userId, saleId), HttpStatus.OK);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<SaleEntity>> getSales(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "size", defaultValue = "10") Integer size,
            @PathVariable Integer userId){
        return new ResponseEntity<>(saleService.getAllSale(page, size, userId), HttpStatus.OK);
    }
}
