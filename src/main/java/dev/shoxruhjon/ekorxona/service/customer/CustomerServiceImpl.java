package dev.shoxruhjon.ekorxona.service.customer;

import dev.shoxruhjon.ekorxona.dto.request.CustomerDto;
import dev.shoxruhjon.ekorxona.entity.CustomerEntity;
import dev.shoxruhjon.ekorxona.exception.DataNotFoundException;
import dev.shoxruhjon.ekorxona.repository.CustomerRepository;
import dev.shoxruhjon.ekorxona.service.user.EmployeeService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final ModelMapper modelMapper;
    private final EmployeeService employeeService;
    @Override
    public CustomerEntity createCustomer(@NonNull CustomerDto dto, Integer userId) {
        CustomerEntity customerEntity = modelMapper.map(dto, CustomerEntity.class);
        customerEntity.setCreatedBy(userId);
        customerEntity.setPassportEntity(employeeService.createPassport(dto.getPassport()));
        return customerRepository.save(customerEntity);
    }

    @Override
    public CustomerEntity updateCustomer(@NonNull CustomerDto dto, Integer userId, Integer customerId) {
        CustomerEntity customerEntity = customerRepository.findByIdCustomer(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
        if (customerRepository.findByCreatedBy(userId).isEmpty())
            throw new DataNotFoundException("Customer Not Found");
        if(dto.getFirstName() != null)
            customerEntity.setFirstName(dto.getFirstName());
        if(dto.getLastName() != null)
            customerEntity.setLastName(dto.getLastName());
        if(dto.getAddress() != null)
            customerEntity.setAddress(dto.getAddress());
        if(dto.getPassport() != null)
            customerEntity.setPassportEntity(
                    employeeService.updatePassport(dto.getPassport(),
                            customerEntity.getPassportEntity().getId()));
        return customerRepository.save(customerEntity);
    }

    @Override
    public CustomerEntity getCustomer(@NonNull Integer userId, @NonNull Integer customerId) {
        if (customerRepository.findByCreatedBy(userId).isEmpty())
            throw new DataNotFoundException("Customer not found");
        return customerRepository.findByIdCustomer(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
    }

    @Override
    public List<CustomerEntity> getAllCustomer(@NonNull Integer userId) {
        return customerRepository.findAllCustomer(userId);
    }

    @Override
    public Boolean achiveCustomer(@NonNull Integer userId, @NonNull Integer customerId) {
        if (customerRepository.findByCreatedBy(userId).isEmpty())
            throw new RuntimeException("Customer not found");
        CustomerEntity customerEntity = customerRepository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
        customerEntity.setIsAchived(!customerEntity.getIsAchived());
        customerRepository.save(customerEntity);
        return customerEntity.getIsAchived();
    }
}
