package dev.shoxruhjon.ekorxona.service.sale;

import dev.shoxruhjon.ekorxona.dto.request.SaleCreateDto;
import dev.shoxruhjon.ekorxona.entity.SaleEntity;
import dev.shoxruhjon.ekorxona.dto.request.SaleUpdateDto;
import dev.shoxruhjon.ekorxona.exception.DataNotFoundException;
import dev.shoxruhjon.ekorxona.repository.SaleRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SaleServiceImpl implements SaleService {

    private final SaleRepository saleRepository;
    private final ModelMapper modelMapper;

    @Override
    public SaleEntity createSale(Integer userId, SaleCreateDto dto) {
        SaleEntity saleEntity = modelMapper.map(dto, SaleEntity.class);
        saleEntity.setCreatedBy(userId);
        return saleRepository.save(saleEntity);
    }

    @Override
    public SaleEntity updateSale(Integer userId, Integer saleId, SaleUpdateDto dto) {
        SaleEntity saleEntity = saleRepository.findByIdAndCreatedBy(saleId, userId)
                .orElseThrow(() -> new DataNotFoundException("Sale not found"));
        if(dto.getExpense() != null)
            saleEntity.setExpense(dto.getExpense());
        if(dto.getLifetime() != null)
            saleEntity.setLifetime(dto.getLifetime());
        return saleRepository.save(saleEntity);
    }

    @Override
    public SaleEntity getSale(Integer userId, Integer saleId) {
        return saleRepository.findByIdAndCreatedBy(saleId, userId)
                .orElseThrow(() -> new DataNotFoundException("Sale not found"));
    }

    @Override
    public List<SaleEntity> getAllSale(Integer page, Integer size, Integer userId) {
        Pageable pageable = PageRequest.of(page, size);
        return saleRepository.findByIdAndCreatedBySales(userId, pageable);
    }
}
