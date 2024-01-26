package dev.shoxruhjon.ekorxona.service.customer;

import dev.shoxruhjon.ekorxona.dto.request.CustomerDto;
import dev.shoxruhjon.ekorxona.entity.CustomerEntity;
import lombok.NonNull;

import java.util.List;

public interface CustomerService {
    CustomerEntity createCustomer(@NonNull CustomerDto dto, Integer userId);
    CustomerEntity updateCustomer(@NonNull CustomerDto dto, Integer userId, Integer customerId);
    CustomerEntity getCustomer(@NonNull Integer userId, @NonNull Integer customerId);
    List<CustomerEntity> getAllCustomer(@NonNull Integer userId);
    Boolean achiveCustomer(@NonNull Integer userId, @NonNull Integer customerId);
}
