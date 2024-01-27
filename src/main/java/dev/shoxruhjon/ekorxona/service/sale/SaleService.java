package dev.shoxruhjon.ekorxona.service.sale;

import dev.shoxruhjon.ekorxona.dto.request.SaleCreateDto;
import dev.shoxruhjon.ekorxona.entity.SaleEntity;
import dev.shoxruhjon.ekorxona.dto.request.SaleUpdateDto;

import java.util.List;

public interface SaleService {

    SaleEntity createSale(Integer userId, SaleCreateDto dto);
    SaleEntity updateSale(Integer userId, Integer saleId,SaleUpdateDto dto);
    SaleEntity getSale(Integer userId, Integer saleId);
    List<SaleEntity> getAllSale(Integer page, Integer value, Integer userId);
}
