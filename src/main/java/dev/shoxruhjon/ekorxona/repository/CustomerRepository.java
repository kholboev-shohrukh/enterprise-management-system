package dev.shoxruhjon.ekorxona.repository;

import dev.shoxruhjon.ekorxona.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Integer> {
    @Query("select c from customer c where c.createdBy = ?1")
    Optional<CustomerEntity> findByCreatedBy(Integer createdBy);

    @Query("select c from customer c where c.createdBy = ?1 and c.isAchived = false")
    List<CustomerEntity> findAllCustomer(Integer createdBy);

    @Query("select c from customer c where c.id = ?1 and c.isAchived = false")
    Optional<CustomerEntity> findByIdCustomer(Integer id);
}